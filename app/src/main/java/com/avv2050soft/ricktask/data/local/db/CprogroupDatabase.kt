package com.avv2050soft.ricktask.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.avv2050soft.ricktask.data.local.db_model.CameraItemDb
import com.avv2050soft.ricktask.data.local.db_model.DoorItemDb

@Database(
    entities = [CameraItemDb::class, DoorItemDb::class],
    version = 1,
    exportSchema = false
)
abstract class CprogroupDatabase: RoomDatabase() {

    abstract fun camerasDao(): CamerasDao
    abstract fun doorsDao(): DoorsDao

    companion object{
        private const val databaseName = "my_house"

        @Volatile
        private var INSTANCE: CprogroupDatabase? = null

        fun getInstance(context: Context): CprogroupDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CprogroupDatabase::class.java,
                    databaseName
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}