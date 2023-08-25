package com.avv2050soft.ricktask.data.local.db_model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "camera_items")
data class CameraItemDb (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "favorites")
    val favorites: Boolean,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "rec")
    val rec: Boolean,
    @ColumnInfo(name = "room")
    val room: String?,
    @ColumnInfo(name = "snapshot")
    val snapshot: String
)