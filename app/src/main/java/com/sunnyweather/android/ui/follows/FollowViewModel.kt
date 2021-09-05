package com.sunnyweather.android.ui.follows

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.RoomInfo

class FollowViewModel : ViewModel(){
    private val uidLiveData = MutableLiveData<String>()
    val roomListOn = ArrayList<RoomInfo>()
    val roomListOff = ArrayList<RoomInfo>()
    val userRoomListLiveDate = Transformations.switchMap(uidLiveData) {
            uid -> Repository.getRoomsOn(uid)
    }
    fun getRoomsOn(uid: String) {
        uidLiveData.value = uid
    }
    fun clearRoomList() {
        roomListOn.clear()
        roomListOff.clear()
    }
}