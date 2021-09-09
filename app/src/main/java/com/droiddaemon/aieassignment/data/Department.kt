package com.droiddaemon.aieassignment.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "department_table")
data class Department(

    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name = "department_name")
    var name : String

)
