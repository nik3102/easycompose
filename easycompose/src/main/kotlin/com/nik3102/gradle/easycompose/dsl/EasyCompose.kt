package com.nik3102.gradle.easycompose.dsl

data class EasyCompose(
    /**
     * @see <a href="https://androidx.tech/artifacts/compose/compose-bom/">latestVersion</a>
     */
    var version: String? = null,
    /**
     * @see <a href="https://developer.android.com/jetpack/androidx/releases/compose-kotlin#declaring_dependencies">latestVersion</a>
     */
    var kotlinCompilerExtensionVersion: String? = null,
    /**
     * enable/disable androidx.compose.material:material implementation
     */
    var material2: Boolean? = null,
    /**
     * enable/disable androidx.compose.material3:material3 and androidx.compose.material3:material3-window-size-class implementation
     */
    var material3: Boolean? = null,
    /**
     * material-icons-core and material-icons-extended
     */
    var icons: Boolean? = null,
    /**
     * Integration with LiveData
     */
    var runtime_livedata: Boolean? = null,
    /**
     * Integration with RxJava
     */
    var runtime_rxjava2: Boolean? = null,
    var accompanist: Accompanist = Accompanist()
){
    fun accompanist(setup: Accompanist.() -> Unit){
        this.accompanist.apply(setup)
    }
}