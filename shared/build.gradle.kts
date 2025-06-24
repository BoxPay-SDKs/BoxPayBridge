plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    id("maven-publish")
}

kotlin {
    androidTarget {
        publishAllLibraryVariants()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "BoxPayBridge Shared SDK"
        homepage = "https://boxpay.com"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "BoxPayBridge"
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
}

// ✅ Publishing block
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.BoxPay-SDKs"
                artifactId = "BoxPayBridge"
                version = "1.0.0-beta5"
                from(components.findByName("release"))
            }
        }
    }
}
