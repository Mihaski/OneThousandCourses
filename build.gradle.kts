// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    //Added
    alias(libs.plugins.room.plugin) apply false
    alias(libs.plugins.ksp.plugin) apply false
    alias(libs.plugins.hilt.plugin) apply false
}
buildscript{
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
    }
}