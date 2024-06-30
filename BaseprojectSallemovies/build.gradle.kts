// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

plugins {
    id("com.android.application") version "8.2.2" apply false
    // If you are using the library module, add the following line
    // id("com.android.library") version "8.2.2" apply false
}

allprojects {
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
