rootProject.name = "kotlin-spring-boot-sample"

include(
    "apps:api-server",
    "apps:worker",
    "modules:clients",
    "modules:domain",
    "modules:kafka",
    "modules:redis",
    "modules:support:logging",
    "modules:support:util",
)

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val ktlintVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.kapt" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.jlleitschuh.gradle.ktlint" -> useVersion(ktlintVersion)
            }
        }
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
include("apps:api-server")
findProject(":apps:api-server")?.name = "api-server"
include("modules:clients")
findProject(":modules:clients")?.name = "clients"
