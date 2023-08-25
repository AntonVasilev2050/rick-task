package com.avv2050soft.ricktask.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avv2050soft.ricktask.data.local.db_model.CameraItemDb

@Dao
interface CamerasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cameraItemDb: CameraItemDb)

    @Query("SELECT * FROM camera_items")
    suspend fun getAllCamerasItems(): List<CameraItemDb>
}