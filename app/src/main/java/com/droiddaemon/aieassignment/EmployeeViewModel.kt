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

//        val employeename = employeeName.value!!
//        val joiningdate = joiningDate.value!!
//        val managerid = managerId.value!!
//        val departmentid = departmentId.value!!
        insert(Employee(0,"Alisha J.","22-Feb-13",2,2))
        insert(Employee(0,"John Mathew","13-Sep-14",0,4))
        insert(Employee(0,"Syed Ali","26-Jun-16",2,3))
        insert(Employee(0,"Ramesh G.","01-Nov-17",2,1))
    }


    fun saveOrUpdateDepartment(){
//        val departmentName = departmentName.value!!
        insertDepartment(Department(1,"Operations"))
        insertDepartment(Department(2,"Finance"))
        insertDepartment(Department(3,"HR"))
        insertDepartment(Department(4,"Managing Director"))
    }

    fun insert(employee: Employee) = viewModelScope.launch {
        val newRowId = repository.insert(employee)
        if(newRowId > -1){
            statusMessage.value  = Event("Employee Inserted Successfully $newRowId")
        }else{
            statusMessage.value = Event("Error Occurred")
        }
    }


    fun insertDepartment(department: Department) = viewModelScope.launch {
        val newRowId = repository.insertDepartment(department)
        if(newRowId > -1){
            statusMessage.value  =Event("Department Inserted Successfully $newRowId")
        }else{
            statusMessage.value = Event("Error Occurred")
        }
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}