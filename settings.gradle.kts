rootProject.name = "OasisPALM-JetBrains"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

include("oasispalm-idea")
project(":oasispalm-idea").projectDir = file("OasisPALM-IDEA")