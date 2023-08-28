package com.avv2050soft.ricktask.data.local.room.db_model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "door_items")
data class DoorItemDb(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "favorites")
    val favorites: Boolean,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "room")
    val room: String,
    @ColumnInfo(name = "snapshot")
    val snapshot: String?
)
