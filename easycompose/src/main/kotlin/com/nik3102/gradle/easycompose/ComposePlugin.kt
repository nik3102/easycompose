package com.nik3102.gradle.easycompose

import com.nik3102.gradle.easycompose.ext.androidTestImplementation
import com.nik3102.gradle.easycompose.ext.debugImplementation
import com.nik3102.gradle.easycompose.ext.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency

class EasyComposePlugin: Plugin<Project> {
    private val plugin_ext_id = "easy-compose-ext"

    override fun apply(project: Project) {
        project.extensions.create(plugin_ext_id, EasyComposeExtension::class.java).apply {
            version.set(Const.bomVersion)
            kotlinCompilerExtensionVersion.set(Const.kotlinCompilerExtensionVersion)
            accompanist.set(emptyArray())
            material2.set(true)
            material3.set(false)
            icons.set(true)
            runtime_livedata.set(false)
            runtime_rxjava2.set(false)
        }
    }

    fun configureComposeDependencies(project: Project){
        with(project) {
            val extension = extensions.getByName(plugin_ext_id) as EasyComposeExtension
            dependenciesConf(
                version = extension.version.get(),
                material2 = extension.material2.get(),
                material3 = extension.material3.get(),
                icons = extension.icons.get(),
                livedata = extension.runtime_livedata.get(),
                rxjava2 = extension.runtime_rxjava2.get()
            )
            accompanistDependenciesConf(extension.accompanist.get())
        }
    }

    private fun Project.dependenciesConf(
        version: String,
        material2: Boolean,
        material3: Boolean,
        icons: Boolean,
        livedata: Boolean,
        rxjava2: Boolean
    ) {
        dependencies.apply {
            val composeBom: Dependency = platform("androidx.compose:compose-bom:$version")
            implementation(composeBom)
            androidTestImplementation(composeBom)

            if(material2){
                // Material Design 2
                implementation("androidx.compose.material:material")
            }

            if(material3){
                // Material Design 3
                implementation("androidx.compose.material3:material3")
                implementation("androidx.compose.material3:material3-window-size-class")
            }

            implementation("androidx.activity:activity-compose:1.6.1")
            implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
            implementation("androidx.compose.foundation:foundation")
            implementation("androidx.compose.ui:ui")
            implementation("androidx.compose.ui:ui-tooling-preview")
            debugImplementation("androidx.compose.ui:ui-tooling")

            // UI Tests
            androidTestImplementation("androidx.compose.ui:ui-test-junit4")
            debugImplementation("androidx.compose.ui:ui-test-manifest")

            if (icons){
                implementation("androidx.compose.material:material-icons-core")
                implementation("androidx.compose.material:material-icons-extended")
            }

            if (livedata){
                implementation("androidx.compose.runtime:runtime-livedata")
            }

            if (rxjava2){
                implementation("androidx.compose.runtime:runtime-rxjava2")
            }
        }
    }

    private fun Project.accompanistDependenciesConf(dep: Array<String>){
        dependencies.apply{
            dep.forEach {
                implementation(it)
            }
        }
    }
}
