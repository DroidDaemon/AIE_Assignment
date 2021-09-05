package com.droiddaemon.aieassignment.data

class EmployeeRepository(private val dao: EmployeeDao) {

    val employee = dao.getAllEmployees()

    suspend fun insert(employee: Employee): Long {
        return dao.insertEmployee(employee)
    }

    suspend fun update(employee: Employee): Int {
        return dao.updateEmployee(employee)
    }

    suspend fun delete(employee: Employee): Int {
        return dao.deleteEmployee(employee)
    }

    suspend fun insertDepartment(department : Department): Long
    {
        return dao.insertDepartment(department)
    }
}