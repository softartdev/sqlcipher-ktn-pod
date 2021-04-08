# sqlcipher-ktn-pod
![Maven Central](https://img.shields.io/maven-central/v/io.github.softartdev/sqlcipher-ktn-pod)
[![Build & Publish CI/CD](https://github.com/softartdev/sqlcipher-ktn-pod/actions/workflows/build_publish.yml/badge.svg)](https://github.com/softartdev/sqlcipher-ktn-pod/actions/workflows/build_publish.yml)

Kotlin Multiplatform library, wrap of [SQLCipher](https://www.zetetic.net/sqlcipher/) from Cocoapods to Kotlin Native targets

## Using in your projects
The latest release is available on [Maven Central](https://repo1.maven.org/maven2/io/github/softartdev/sqlcipher-ktn-pod/).
### Gradle
- Add the Maven Central repository if it is not already there:
```kotlin
repositories {
    mavenCentral()
}
```
- In multiplatform projects, add a dependency to the iosMain source set dependencies
```kotlin
kotlin {
    sourceSets {
        iosMain {
             dependencies {
                 implementation("io.github.softartdev:sqlcipher-ktn-pod:$latestVersion")
             }
        }
    }
}
```
## Implementation
Just [CocoaPods dependency of SQLDelight](https://cocoapods.org/pods/SQLCipher) using Kotlin Native plugin:
```kotlin
plugins {
    kotlin("native.cocoapods")
}
kotlin {
    ios()
    cocoapods {
        pod("SQLCipher", "~> 4.0")
    }
}
```
### Reason for existence
Workaround for ["module not found" error](https://youtrack.jetbrains.com/issue/KT-45608) of KMM plugin version "1.4.32".
