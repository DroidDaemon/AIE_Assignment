package com.droiddaemon.aieassignment.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface EmployeeDao {


    @Insert
    suspend fun insertEmployee(employee : Employee) : Long

    @Insert
    suspend fun insertDepartment(department: Department) : Long



    @Update
    suspend fun updateEmployee(employee: Employee) : Int

    @Delete
    suspend fun deleteEmployee(employee: Employee) : Int


//    @Query("SELECT * FROM employee_data_table")
//    fun getAllEmployees() : LiveData<List<Employee>>


    @Query("SELECT name,joining_date,manager_id,department_name FROM department_table   INNER JOIN employee_data_table ON department_table.id = employee_data_table.department_id")
    fun getAllEmployees() : LiveData<List<EmployeeResultData>>


}