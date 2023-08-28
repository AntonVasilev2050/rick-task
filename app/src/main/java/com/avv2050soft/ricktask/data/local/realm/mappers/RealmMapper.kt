package com.avv2050soft.ricktask.data.local.realm.mappers

import com.avv2050soft.ricktask.data.local.realm.db_model_realm.CameraItemRealm
import com.avv2050soft.ricktask.data.local.realm.db_model_realm.DoorItemRealm
import com.avv2050soft.ricktask.domain.models.cameras.CameraItem
import com.avv2050soft.ricktask.domain.models.doors.DoorItem

class RealmMapper {

    fun mapCameraItemToCameraItemRealm(cameraItem: CameraItem): CameraItemRealm {
        val cameraItemRealm = CameraItemRealm()
        cameraItemRealm.id = cameraItem.id
        cameraItemRealm.favorites = cameraItem.favorites
        cameraItemRealm.name = cameraItem.name
        cameraItemRealm.rec = cameraItem.rec
        cameraItemRealm.room = if (cameraItem.room.isNullOrEmpty()) {
            "Unknown Room"
        } else {
            cameraItem.room
        }
        cameraItemRealm.snapshot = cameraItem.snapshot
        return cameraItemRealm
    }

    fun mapDoorItemToRoomItemRealm(doorItem: DoorItem): DoorItemRealm {
        val doorItemRealm = DoorItemRealm()
        doorItemRealm.id = doorItem.id
        doorItemRealm.favorites = doorItem.favorites
        when (doorItem.name) {
            "Door Door" -> doorItemRealm.name = "Подъезд 1"
            "Door 45" -> doorItemRealm.name = "Выход на пожарную лестницу"
            "Door Door Door Door" -> doorItemRealm.name = "Подъезд 2"
            "Door Door, Door Door" -> doorItemRealm.name = "Домофон"
            else -> {
                doorItemRealm.name = doorItem.name
            }
        }
        doorItemRealm.room = doorItem.room
        doorItemRealm.snapshot = doorItem.snapshot
        return doorItemRealm
    }

    fun mapCameraItemRealmListToCameraItemList(cameraItemRealmList: List<CameraItemRealm>): List<CameraItem> {
        val cameraItemList = mutableListOf<CameraItem>()
        cameraItemRealmList.forEach {
            val cameraItem = CameraItem(
                favorites = it.favorites,
                id = it.id,
                name = it.name,
                rec = it.rec,
                room = it.room,
                snapshot = it.snapshot
            )
            cameraItemList.add(cameraItem)
        }
        return cameraItemList
    }

    fun mapDoorItemRealmListToDoorItemList(doorItemRealmList: List<DoorItemRealm>): List<DoorItem> {
        val doorItemList = mutableListOf<DoorItem>()
        doorItemRealmList.forEach {
            val doorItem = DoorItem(
                favorites = it.favorites,
                id = it.id,
                name = it.name,
                room = it.room,
                snapshot = it.snapshot
            )
            doorItemList.add(doorItem)
        }
        return doorItemList
    }
}