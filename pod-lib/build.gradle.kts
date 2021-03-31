plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

group = "com.softartdev"
version = "1.0"

repositories {
    mavenCentral()
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlinx.html/") }
}

kotlin {
//    ios()
    iosX64("ios")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
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
