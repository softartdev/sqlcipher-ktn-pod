plugins {
    kotlin("multiplatform") version "1.4.32"
    kotlin("native.cocoapods") version "1.4.32"
}

group = "com.softartdev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    ios()
    sourceSets {
        val iosMain by getting
        val iosTest by getting
    }
    cocoapods {
        frameworkName = "SQLCipher pod on Kotlin Native"
        summary = "Wrap SQLCipher lib from Cocoapods to Kotlin Native"
        homepage = "https://github.com/softartdev/sqlcipher-ktn-pod"
        ios.deploymentTarget = "13.5"
        pod("SQLCipher", "~> 4.0")
    }
}
