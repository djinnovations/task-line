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

rootProject.name = "Task Line"
include(":base")
include(":app")
include(":composeui")
include(":domainmodel")

include(":feature:login")
include(":feature:dashboard")
include(":feature:projectdetails")
include(":feature:viewtimesheet")

include(":data:utils")
include(":data:login-data")
include(":data:roomdb")
include(":data:projecttask-data")
