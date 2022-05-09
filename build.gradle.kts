plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("convention.publication")
}

group = project.property("GROUP").toString()
version = project.property("VERSION_NAME").toString()

repositories {
    mavenCentral()
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    cocoapods {
        framework {
            baseName = "SQLCipher pod on Kotlin Native"
        }
        summary = "Wrap SQLCipher lib from Cocoapods to Kotlin Native"
        homepage = "https://github.com/softartdev/sqlcipher-ktn-pod"
        ios.deploymentTarget = "13.5"
        pod("SQLCipher", "~> 4.5")
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val appleMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val appleTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}
