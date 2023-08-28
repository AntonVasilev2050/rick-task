package com.avv2050soft.ricktask.data.local.realm.db_model_realm

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class CameraItemRealm : RealmModel {
    @PrimaryKey
    var id: Int = 0

    var favorites: Boolean = false

    var name: String = ""

    var rec: Boolean = false

    var room: String? = null

    var snapshot: String = ""
}