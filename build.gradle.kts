// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register<Copy>("copyXCFrameworkToReactNativeModule") {
    dependsOn(":shared:assembleSharedReleaseXCFramework")

    val sourceDir = file("shared/build/XCFrameworks/release/shared.xcframework")
    val destinationDir = file("react_native_module/ios")

    from(sourceDir.parent) {
        include("shared.xcframework/**")
    }

    into(destinationDir)

    doFirst {
        val existing = file("${destinationDir}/shared.xcframework")
        if (existing.exists()) {
            existing.deleteRecursively()
        }
        println("📦 Replacing old shared.xcframework in react_native_module/ios/")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}


