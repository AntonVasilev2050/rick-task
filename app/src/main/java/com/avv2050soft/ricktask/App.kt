package com.avv2050soft.ricktask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.RealmConfiguration

@HiltAndroidApp
class App: Application() {
private var config: RealmConfiguration? = null
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        config =RealmConfiguration.Builder()
            .name("my_house_realm_db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .allowWritesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .build()
        config.let { Realm.setDefaultConfiguration(it) }
    }
}