package com.fthbsr.phonebook.Data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val id: Int, var name: String, var number: Int) : Parcelable {

}