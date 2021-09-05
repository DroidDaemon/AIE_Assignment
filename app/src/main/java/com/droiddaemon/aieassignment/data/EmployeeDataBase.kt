package com.droiddaemon.aieassignment.data

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.RoomDatabase
import java.time.Instant

@Database(entities = [Employee::class, Department::class ] ,version = 1)
abstract class EmployeeDataBase : RoomDatabase(){


    abstract val employeeDao : EmployeeDao

    companion object {

        @Volatile
        private var INSTANCE  : EmployeeDataBase? = null
        fun getInstance(context : Context) : EmployeeDataBase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = androidx.room.Room.databaseBuilder(
                        context.applicationContext,
                        com.droiddaemon.aieassignment.data.EmployeeDataBase::class.java,
                        "employee_data_base"
                    ).build()
                }
                return instance


            }
        }
    }
}


