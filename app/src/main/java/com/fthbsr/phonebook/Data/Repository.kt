package com.fthbsr.phonebook.Data

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

class Repository(){

    var newUserId = MutableLiveData<Int>(5)
    var currentList  =  MutableLiveData<MutableList<Person>>()
    var firstList = mutableListOf<Person>(
        Person(1, "Ahmet", 123),
        Person(2, "Ayse", 323223),
        Person(3, "Asli", 1453),
        Person(4, "Okan", 133),
    )

    init {
        currentList.value =firstList
    }

    fun createNewUsers(context: Context, name: String, number: Int) {
        if (name.isNotEmpty() && number.toString().isNotEmpty()) {
            var newUsers = Person(newUserId.value!!, name, number)
            currentList.value!!.add(newUsers)
            Toast.makeText(context, "New Person Created!", Toast.LENGTH_LONG).show()
        }
    }

    fun removeUsers(context: Context, user: Person) {
        currentList.value!!.remove(user)
        Toast.makeText(context, "Person is deleted...", Toast.LENGTH_SHORT).show()
    }

    fun changeUserInfo(context: Context,id: Int,name: String,number: Int,it: View){
        var selectedUser = currentList.value!!.filter {
            it.id == id
        }
        if(name.isNotEmpty() && number.toString().isNotEmpty()){
            selectedUser[0].number = number
            selectedUser[0].name = name
        }
    }
}