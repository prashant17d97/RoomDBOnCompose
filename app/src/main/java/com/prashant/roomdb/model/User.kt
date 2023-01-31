package com.prashant.roomdb.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "userId")
    var userId: String,

    @ColumnInfo(name = "userName")
    var userName: String,

    /*@ColumnInfo(name = "designation")
    var userDesignation: String,

    @ColumnInfo(name = "experience")
    var userExperience: Float,

    @ColumnInfo(name = "email")
    var userEmail: String,

    @ColumnInfo(name = "phoneNo")
    var userPhoneNo: Long*/
) : Parcelable