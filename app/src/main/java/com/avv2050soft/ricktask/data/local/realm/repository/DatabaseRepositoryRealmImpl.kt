package com.avv2050soft.ricktask.data.local.realm.repository

import com.avv2050soft.ricktask.data.local.realm.db_model_realm.CameraItemRealm
import com.avv2050soft.ricktask.data.local.realm.db_model_realm.DoorItemRealm
import com.avv2050soft.ricktask.data.local.realm.mappers.RealmMapper
import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.models.doors.DoorItem
import com.avv2050soft.ricktask.domain.repository.DatabaseRepository
import io.realm.Realm
import javax.inject.Inject

class DatabaseRepositoryRealmImpl @Inject constructor(
    private val mapper: RealmMapper
) : DatabaseRepository {

    private var realm = Realm.getDefaultInstance()

    override suspend fun insertCameraItem(cameraItem: CameraItem) {
        realm.executeTransaction {
            val cameraItemRealm = mapper.mapCameraItemToCameraItemRealm(cameraItem)
            realm.insertOrUpdate(cameraItemRealm)
        }
    }

    override suspend fun insertDoorItem(doorItem: DoorItem) {
        realm.executeTransaction {
            val doorItemRealm = mapper.mapDoorItemToDoorItemRealm(doorItem)
            realm.insertOrUpdate(doorItemRealm)
        }
    }

    override suspend fun getAllCameraItems(): List<CameraItem> {
        val cameraItemRealmList = realm.where(CameraItemRealm::class.java).findAll()
        val cameraItems = mapper.mapCameraItemRealmListToCameraItemList(cameraItemRealmList)
        return cameraItems
    }

    override suspend fun getAllDoorItems(): List<DoorItem> {
        val doorItemsRealmList = realm.where(DoorItemRealm::class.java).findAll()
        val doorItems = mapper.mapDoorItemRealmListToDoorItemList(doorItemsRealmList)
        return doorItems
    }
}