@file:JvmName("EasyComposeKt")

package com.nik3102.gradle.easycompose.dsl

import com.nik3102.gradle.easycompose.EasyComposeExtension
import com.nik3102.gradle.easycompose.EasyComposePlugin
import com.nik3102.gradle.easycompose.ext.configureAndroid
import org.gradle.api.Project

fun Project.easyCompose(setup: EasyCompose.() -> Unit) {
    val config = EasyCompose().apply(setup)
    this.extensions.getByType(EasyComposeExtension::class.java).apply {
        version.set(config.version)
        config.kotlinCompilerExtensionVersion?.let {
            kotlinCompilerExtensionVersion.set(it)
        }
        accompanist.set(config.accompanist.map())
        config.material2?.let {
            material2.set(it)
        }
        config.material3?.let {
            material3.set(it)
        }
        config.icons?.let {
            icons.set(it)
        }
        config.runtime_livedata?.let {
            runtime_livedata.set(it)
        }
        config.runtime_rxjava2?.let {
            runtime_rxjava2.set(it)
        }
    }
    project.plugins.getPlugin(EasyComposePlugin::class.java).apply {
        configureAndroid(project)
        configureComposeDependencies(project)
    }
}