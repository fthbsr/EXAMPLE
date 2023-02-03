package com.fthbsr.phonebook.ui.ViewModel

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.fthbsr.phonebook.Data.Person
import com.fthbsr.phonebook.Data.Repository
import com.fthbsr.phonebook.Data.myList

class MainViewModel() : ViewModel() {
    var repo =  Repository(myList())
    var list = MutableLiveData<MutableList<Person>>()

    init {
        Log.e("hasan" , repo.currentList.value.toString())
        list.value = repo.currentList.value
    }

    fun addNewUser(context: Context, name: String, number: Int) {
       repo.createNewUsers(context,name,number)
    }

    fun deletePerson(context: Context, user: Person) {
        repo.removeUsers(context,user)
        Log.e("deneme" , list.value.toString())
    }

    fun updateUserInfo(context: Context,id:Int ,name: String ,number: Int ,it: View) {
        repo.changeUserInfo(context,id,name,number,it)
    }
}


