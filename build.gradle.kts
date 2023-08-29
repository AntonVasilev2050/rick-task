// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    dependencies{
        classpath("io.realm:realm-gradle-plugin:10.16.1")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.8.10")
    }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id ("com.google.dagger.hilt.android") version "2.44.2" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    id ("io.realm.kotlin") version "1.10.0" apply false
}