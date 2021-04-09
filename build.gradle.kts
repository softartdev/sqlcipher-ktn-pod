plugins {
    kotlin("multiplatform")
    id("convention.publication")
}

group = project.property("GROUP").toString()
version = project.property("VERSION_NAME").toString()

repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {
    ios()
    sourceSets {
        val iosMain by getting {
            dependencies {
                api("io.github.softartdev:pod-project:0.4")
                //TODO remove mock maven local dep when pods bug will be fixed
                //implementation(project(":pod-project"))
            }
        }
    }
}
