import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("convention.publication")
}

group = project.property("GROUP").toString()
version = project.property("VERSION_NAME").toString()

repositories {
    mavenCentral()
}

kotlin {
    val knTargets = listOf(
        macosX64(),
        iosX64(),
        iosSimulatorArm64(),
        iosArm64(),
        iosArm32(),
        watchosArm32(),
        watchosArm64(),
        watchosX86(),
        watchosX64(),
        tvosArm64(),
        tvosX64()
    )
    knTargets.forEach(action = ::configInterop)

    sourceSets {
        val appleMain = sourceSets.maybeCreate("appleMain")
        val appleTest = sourceSets.maybeCreate("appleTest")

        knTargets.forEach { target ->
            target.compilations.getByName("main").source(appleMain)
            target.compilations.getByName("test").source(appleTest)
        }
    }
}

fun configInterop(target: KotlinNativeTarget) {
    val main by target.compilations.getting
    val sqlite3 by main.cinterops.creating {
        includeDirs("$projectDir/src/include")
    }
    val test by target.compilations.getting
    test.kotlinOptions.freeCompilerArgs += listOf("-linker-options", "-lsqlite3")
}