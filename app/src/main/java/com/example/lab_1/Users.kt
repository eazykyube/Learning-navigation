package com.example.lab_1

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.collections.ArrayList

class Users(){

    private var users: MutableList<User> = ArrayList()

    fun addUser(name: String, age: String, pwd: String) {
        var user = User(name, age, pwd)
        if (!findUser(name)) {
            users.add(user)
        }
    }

    fun findUser(name: String): Boolean {
        var iterator = users.iterator()
        for (user in iterator) {
            if (user.name == name) {
                return true
            }
        }
        return false
    }

    fun getName(name: String): String {
        var iterator = users.iterator()
        for (user in iterator) {
            if (user.name == name) {
                return user.name
            }
        }
        return "0"
    }

    fun getAge(name: String): String {
        var iterator = users.iterator()
        for (user in iterator) {
            if (user.name == name) {
                return user.age
            }
        }
        return "0"
    }

    fun getPwd(name: String): String {
        var iterator = users.iterator()
        for (user in iterator) {
            if (user.name == name) {
                return user.pwd
            }
        }
        return "0"
    }

    fun size(): Int {
        return users.size
    }

    fun removeUsers() {
        users.clear()
    }
}