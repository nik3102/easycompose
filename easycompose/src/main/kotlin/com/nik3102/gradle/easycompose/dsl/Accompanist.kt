package com.nik3102.gradle.easycompose.dsl

import com.nik3102.gradle.easycompose.Const
import org.gradle.api.GradleException

data class Accompanist(

    var version: String = Const.accomponistVersion,
    /**
     * A library that provides easy-to-use utilities for recoloring the Android system bars from Jetpack Compose.
     * @see <a href="https://google.github.io/accompanist/systemuicontroller">System UI Controller</a>
     */
    var systemUiController: Boolean = false,
    /**
     * A library that provides Android runtime permissions support for Jetpack Compose.
     * @see <a href="https://google.github.io/accompanist/permissions">Permissions</a>
     */
    var permissions: Boolean = false,

    /**
     * A library that provides easy-to-use modifiers for displaying a placeholder UI while content is loading.
     * If you're using Material, use placeholder-material
     * @see <a href="https://google.github.io/accompanist/placeholder">Placeholder</a>
     */
    var placeholder: Boolean = false,
    /**
     * A library that provides easy-to-use modifiers for displaying a placeholder UI while content is loading.
     * @see <a href="https://google.github.io/accompanist/placeholder">Placeholder</a>
     */
    var placeholder_material: Boolean = false,

    /**
     * A library which provides Compose Animation support for Jetpack Navigation Compose.
     * @see <a href="https://google.github.io/accompanist/navigation-animation">Navigation-Animation</a>
     */
    var navigation_animation: Boolean = false,

    /**
     * A library which provides Compose Material support, such as modal bottom sheets, for Jetpack Navigation Compose.
     * @see <a href="https://google.github.io/accompanist/navigation-material">Navigation-Material</a>
     */
    var navigation_material: Boolean = false,

    /**
     * A library which provides a way to use Android Drawables as Jetpack Compose Painters.
     * @see <a href="https://google.github.io/accompanist/drawablepainter">Drawable Painter</a>
     */
    var drawable_painter: Boolean = false,

    /**
     * A wrapper around WebView for basic WebView support in Jetpack Compose.
     * @see <a href="https://google.github.io/accompanist/web/">Web</a>
     */
    var web: Boolean = false,

    /**
     * A library providing a collection of utilities for adaptive layouts.
     * @see <a href="https://google.github.io/accompanist/adaptive">Adaptive</a>
     */
    var adaptive: Boolean = false,

    /**
     * Utilities for testing Compose layouts.
     * @see <a href="https://google.github.io/accompanist/testharness">Test Harness</a>
     */
    var test_harness: Boolean = false,



    ) {
    fun map(): Array<String> {
        val list = mutableListOf<String>()
        if (version.isBlank()){
            throw GradleException("Accompanist version is empty")
        }
        if (systemUiController)list.add("accompanist-systemuicontroller")
        if (permissions) list.add("accompanist-permissions")
        if (placeholder) list.add("accompanist-placeholder")
        if (placeholder_material) list.add("accompanist-placeholder-material")
        if (navigation_animation) list.add("accompanist-navigation-animation")
        if (navigation_material) list.add("accompanist-navigation-material")
        if (drawable_painter) list.add("accompanist-drawablepainter")
        if (web) list.add("accompanist-webview")
        if (adaptive) list.add("accompanist-adaptive")
        if (test_harness) list.add("accompanist-testharness")

        return list.map { "com.google.accompanist:$it:$version" }.toTypedArray()
    }
}