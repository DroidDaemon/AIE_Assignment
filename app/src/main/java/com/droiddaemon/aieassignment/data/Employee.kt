package com.droiddaemon.aieassignment.data

import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "employee_data_table")
data class Employee(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name :String,

    @ColumnInfo(name = "joining_date")
    var joiningDate :String,



    @ColumnInfo (name = "manager_id")
    var manger_id : Int,

    @ColumnInfo(name = "department_id")
    var department_id : Int

    )