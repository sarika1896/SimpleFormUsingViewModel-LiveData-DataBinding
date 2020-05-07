package com.example.livedataviewmodel.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedataviewmodel.model.UserData


class UserViewModel : ViewModel() {

    var firstName = MutableLiveData<String>()
    var lastaNme = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var education = MutableLiveData<String>()

    public var resultData = MutableLiveData<UserData>()


    public fun getResult(): MutableLiveData<UserData> {
        if (resultData == null) {
            resultData = MutableLiveData()
        }
        return resultData
    }


    fun onClick(view: View) {
        val loginUser =
            UserData(firstName.value!!, lastaNme.value!!, email.value!!, education.value!!)

        resultData.setValue(loginUser)
    }

}