plugins {
    kotlin("multiplatform") version "1.4.31"
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
}
