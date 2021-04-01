plugins {
    kotlin("multiplatform") version "1.4.32"
    kotlin("native.cocoapods") version "1.4.32"
    id("convention.publication")
}

group = "io.github.softartdev"
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
