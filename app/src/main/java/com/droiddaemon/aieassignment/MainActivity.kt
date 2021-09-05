package com.droiddaemon.aieassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.droiddaemon.aieassignment.data.Employee
import com.droiddaemon.aieassignment.data.EmployeeDao
import com.droiddaemon.aieassignment.data.EmployeeDataBase
import com.droiddaemon.aieassignment.data.EmployeeRepository
import com.droiddaemon.aieassignment.databinding.ActivityMainBinding
import com.droiddaemon.aieassignment.ui.EmployeeAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var employeeViewModel : EmployeeViewModel
    private lateinit var adapter : EmployeeAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dao = EmployeeDataBase.getInstance(application).employeeDao

        val repository  = EmployeeRepository(dao)

        val factory = ViewModelFactory(repository)
        employeeViewModel = ViewModelProvider(this,factory).get(EmployeeViewModel::class.java)
        binding.myViewModel = employeeViewModel
        binding.lifecycleOwner = this
        initRecyclerView()

        employeeViewModel.message.observe(this , Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
                displayEmployees()
            }

        })



    }

    private fun initRecyclerView() {

        binding.employeeRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EmployeeAdapter { ({selectedItem :Employee->listItemClicked(selectedItem)})
        binding.employeeRecyclerView.adapter = adapter
        }
    }

    private fun displayEmployees() {

        employeeViewModel.employee.observe(this,Observer {
            Log.d("MYTAG",it.toString())
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }


    private fun listItemClicked(employee: Employee){

    }
}