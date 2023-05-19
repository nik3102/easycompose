buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven { setUrl("https://jitpack.io") }
    }
}

plugins {
    kotlin("jvm") version "1.8.0"
}

repositories {
    mavenCentral()
}

allprojects {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven { setUrl("https://jitpack.io") }
    }
}




