plugins {
    kotlin("multiplatform") version "1.4.31"
}

group = "com.softartdev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    iosX64 {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    iosArm64 {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    iosArm32 {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    macosX64()
    sourceSets {
        val iosX64Main by getting
        val iosX64Test by getting
        val iosArm64Main by getting
        val iosArm64Test by getting
        val iosArm32Main by getting
        val iosArm32Test by getting
        val macosX64Main by getting
        val macosX64Test by getting
    }
}
