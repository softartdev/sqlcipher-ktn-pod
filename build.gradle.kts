plugins {
    kotlin("multiplatform")
    id("convention.publication")
}

group = project.property("GROUP").toString()
version = project.property("VERSION_NAME").toString()

repositories {
    mavenCentral()
}

fun configInterop(target: org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget) {
    val main by target.compilations.getting
    val sqlite3 by main.cinterops.creating {
        includeDirs("$projectDir/src/include")
    }
}

kotlin {
//    ios()//TODO use both x64 & arm targets
    val knTarget = iosX64("ios")

    configInterop(knTarget)

    knTarget.let { target ->
        val test by target.compilations.getting
        test.kotlinOptions.freeCompilerArgs += listOf("-linker-options", "-lsqlite3")
    }
}