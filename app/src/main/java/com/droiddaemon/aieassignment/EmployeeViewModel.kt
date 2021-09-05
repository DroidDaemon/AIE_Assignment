package com.droiddaemon.aieassignment

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddaemon.aieassignment.data.Department
import com.droiddaemon.aieassignment.data.Employee
import com.droiddaemon.aieassignment.data.EmployeeRepository
import kotlinx.coroutines.launch
import java.util.*

class EmployeeViewModel(private val repository: EmployeeRepository)  : ViewModel(), Observable {


    val employee = repository.employee

    private var isUpdateOrDelete = false
    private lateinit var subscribeToUpdateORDelete  :Employee

    @Bindable
    val departmentName = MutableLiveData<String>()

    @Bindable
    val employeeName  = MutableLiveData<String>()

    @Bindable
    val joiningDate  = MutableLiveData<String>()

    @Bindable
    val managerId  = MutableLiveData<String>()

    @Bindable
    val departmentId  = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message: LiveData<Event<String>>
            get() = statusMessage




    fun saveOrUpdateEmployee(){

        val employeename = employeeName.value!!
        val joiningdate = joiningDate.value!!
        val managerid = managerId.value!!
        val departmentid = departmentId.value!!
        insert(Employee(0,employeename,joiningdate,managerid.toInt(),departmentid.toInt()))
    }


    fun saveOrUpdateDepartment(){
        val departmentName = departmentName.value!!
        insertDepartment(Department(0,departmentName))
    }

    fun insert(employee: Employee) = viewModelScope.launch {
        val newRowId = repository.insert(employee)
        if(newRowId > -1){
            statusMessage.value  = Event("Employee Inserted Successfully $newRowId")
        }else{
            statusMessage.value = Event("Error Occured")
        }
    }


    fun insertDepartment(department: Department) = viewModelScope.launch {
        val newRowId = repository.insertDepartment(department)
        if(newRowId > -1){
            statusMessage.value  =Event("Department Inserted Successfully $newRowId")
        }else{
            statusMessage.value = Event("Error Occured")
        }
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}