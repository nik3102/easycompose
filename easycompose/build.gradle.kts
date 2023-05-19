import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kotlin")
    id("java-gradle-plugin")
    id("maven-publish")
}

version = "0.1.6"
group = "com.nik3102.gradle"

val gradleVersion = project.gradle.gradleVersion
dependencies {
    implementation("com.android.tools.build:gradle:$gradleVersion")
}

gradlePlugin {
    plugins {
        create("easycompose") {
            id = "com.github.nik3102.easycompose"
            implementationClass = "com.github.nik3102.easycompose.EasyComposePlugin"
            description = "implement compose BOM and all need dependencies"
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs = listOf("-source", "11", "-target", "11")
}


