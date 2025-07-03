import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    id("maven-publish")
}

kotlin {
    jvmToolchain(17)
    androidTarget {
        publishAllLibraryVariants()
    }

    val xcf = XCFramework() // ✅ Create XCFramework

    iosX64 {
        binaries.framework {
            baseName = "CrossPlatformSDK"
            xcf.add(this)
        }
    }
    iosArm64 {
        binaries.framework {
            baseName = "CrossPlatformSDK"
            xcf.add(this)
        }
    }
    iosSimulatorArm64 {
        binaries.framework {
            baseName = "CrossPlatformSDK"
            xcf.add(this)
        }
    }

    cocoapods {
        version = "1.0.0"
        summary = "BoxPayBridge Shared SDK"
        homepage = "https://boxpay.com"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "CrossPlatformSDK"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            }
        }
        val androidMain by getting
        val iosMain by creating {
            dependsOn(commonMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}

android {
    namespace = "com.boxpaybridge.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}


// ✅ Publishing block

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.BoxPay-SDKs"
                artifactId = "BoxPayBridge"
                version = "1.0.0-beta5"

                val androidComponent = components.findByName("release")
                if (androidComponent != null) {
                    from(androidComponent)
                }
            }
        }
    }
}
