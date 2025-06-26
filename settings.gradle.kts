pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "boxpaybridge"

include(":shared")
project(":shared").projectDir = file("shared")

// ✅ Include the React Native module
include(":react_native_module")
project(":react_native_module").projectDir = file("react_native_module")

// ✅ (Optional) If you use the Flutter plugin module as well:
include(":flutter_plugin")
project(":flutter_plugin").projectDir = file("flutter_plugin")
