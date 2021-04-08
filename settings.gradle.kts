pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
}
include("pod-project")
includeBuild("convention-plugins")
rootProject.name = "sqlcipher-ktn-pod"