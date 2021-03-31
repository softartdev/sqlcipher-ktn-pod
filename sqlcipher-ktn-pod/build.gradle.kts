plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("maven-publish")
}

group = "com.softartdev"
version = "0.1"

repositories {
    mavenCentral()
}

kotlin {
    ios()
    cocoapods {
        frameworkName = "SQLCipher pod on Kotlin Native"
        summary = "Wrap SQLCipher lib from Cocoapods to Kotlin Native"
        homepage = "https://github.com/softartdev/sqlcipher-ktn-pod"
        ios.deploymentTarget = "13.5"
        pod("SQLCipher", "~> 4.0")
    }
}
