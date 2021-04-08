plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

group = "io.github.softartdev"
version = "1.0"

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
