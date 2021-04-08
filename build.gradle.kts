plugins {
    kotlin("multiplatform")
    id("convention.publication")
}

group = "io.github.softartdev"
version = "0.4"

repositories {
    mavenCentral()
}

kotlin {
    ios()
    sourceSets {
        val iosMain by getting {
            dependencies {
                implementation(project(":pod-project"))
            }
        }
    }
}
