package com.github.nik3102.easycompose.ext

import com.android.build.gradle.BaseExtension
import com.github.nik3102.easycompose.EasyComposeExtension
import org.gradle.api.GradleException
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun Project.configureAndroid(project: Project){
    val compiler = project.extensions.getByType(EasyComposeExtension::class.java).kotlinCompilerExtensionVersion.get()
    android().apply {
        buildFeatures.compose = true
        composeOptions.kotlinCompilerExtensionVersion = compiler
    }
}

private fun Project.android(): BaseExtension {
    val android = project.extensions.findByType(BaseExtension::class.java)
    if (android != null) {
        return android
    } else {
        throw GradleException("Project $name is not an Android project")
    }
}

