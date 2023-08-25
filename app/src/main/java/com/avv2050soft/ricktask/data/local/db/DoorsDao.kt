package com.avv2050soft.ricktask.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avv2050soft.ricktask.data.local.db_model.DoorItemDb

@Dao
interface DoorsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(doorItemDb: DoorItemDb)

    @Query("SELECT * FROM door_items")
    suspend fun getAllDoorItems(): List<DoorItemDb>
}