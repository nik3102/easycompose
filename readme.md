# Easy Compose plugin

This plugin adds dependencies for Compose and Accompanist to your module and configures the android section in Gradle.


## NOT FOR PRODUCTION!!! GOOD FOR PET PROJECT OR EXPERIMENTS

---


## Setup:

#### Main method

Add the following code to your **settings.gradle.kts**

```kotlin
pluginManagement {
    repositories {
        maven { setUrl("") }
    }
}
```

Add the following code to your module's  **build.gradle.kts**

```kotlin
plugins {
    id("com.nik3102.gradle.easycompose") version "1.1.1" apply false
}
```

#### Old method

Add the following code to your project's **build.gradle.kts**

```kotlin
buildscript {
    repositories {
        maven { setUrl("") }
    }
    dependencies {
        classpath("com.nik3102.gradle:easycompose:1.1.1")
    }
}
```

Add the following code to your module's **build.gradle.kts**

```kotlin
plugins {   
    id("com.nik3102.gradle.easycompose")
}
```

---

## Usage:

In the root **build.gradle.kts** file of your module, add the following code:

```kotlin
easyCompose {} //with default params
android { ... }
```

Customize the configuration by adding the following code:

```kotlin
import com.nik.gradle.easycompose.dsl.easyCompose

easyCompose {
    version = "2023.05.01" //BOM version
    kotlinCompilerExtensionVersion = "1.4.7"
    material2 = true
    material3 = false
    icons = true
    runtime_livedata = false
    runtime_rxjava2 = false
    accompanist {
        version = "0.30.1"
        navigation_material = true
        navigation_animation = true
        placeholder_material = false
        systemUiController = true
        permissions = false
    }
}
```

**version**: By default, it is set to ***2023.05.01***,  You can check for a newer version [here](https://androidx.tech/artifacts/compose/compose-bom/).
The list of libraries is taken from [here](https://developer.android.com/jetpack/compose/setup)

---

**accompanist - version**: By default, it is set to **0.30.1**. 

You can find updates and version compatibility [here](https://github.com/google/accompanist).

---

###### Available Accompanist libraries for inclusion:

- ### 🍫 [systemUiController](https://google.github.io/accompanist/systemuicontroller)

- ### 📫 [permissions](https://google.github.io/accompanist/permissions/)

- ### ⏳ [placeholder](https://google.github.io/accompanist/placeholder)

- ### ⏳ [placeholder_material](https://google.github.io/accompanist/placeholder)

- ### 🧭✨ [navigation_animation](https://google.github.io/accompanist/navigation-animation)

- ### 🧭🎨️[navigation_material](https://google.github.io/accompanist/navigation-material)

- ### 🖌️ [drawable_painter](https://google.github.io/accompanist/drawablepainter)

- ### 🌏 [web](https://google.github.io/accompanist/web/)

- ### 📜 [adaptive](https://google.github.io/accompanist/adaptive)

- ### 🗜 [test_harness](https://google.github.io/accompanist/testharness)
