package com.droiddaemon.aieassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.droiddaemon.aieassignment.data.EmployeeRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: EmployeeRepository): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if(modelClass.isAssignableFrom(EmployeeViewModel::class.java)){
        return EmployeeViewModel(repository) as T
    }
        throw IllegalArgumentException("Unknown View Model Class")
    }


}