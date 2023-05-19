package com.nik3102.gradle.easycompose

import org.gradle.api.provider.Property

interface EasyComposeExtension {
    val version: Property<String>
    val kotlinCompilerExtensionVersion: Property<String>
    val material2: Property<Boolean>
    val material3: Property<Boolean>
    val icons: Property<Boolean>
    val runtime_livedata: Property<Boolean>
    val runtime_rxjava2: Property<Boolean>
    val accompanist: Property<Array<String>>
}