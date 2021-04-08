plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("convention.publication")
}

group = "io.github.softartdev"
version = "0.3"

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
