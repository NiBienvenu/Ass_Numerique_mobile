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
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        }

    }
    plugins {
        id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10" // Remplacez par votre version
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Ma Vie"
include(":app")
 