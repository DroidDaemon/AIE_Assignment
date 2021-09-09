package com.droiddaemon.aieassignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droiddaemon.aieassignment.R
import com.droiddaemon.aieassignment.data.Employee
import com.droiddaemon.aieassignment.data.EmployeeResultData
import com.droiddaemon.aieassignment.databinding.ListItemBinding

class EmployeeAdapter(private val clickListener: (EmployeeResultData) -> Unit) :
    RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {
    private val employeeList = ArrayList<EmployeeResultData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(employeeList[position], clickListener)

    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    fun setList(employees: List<EmployeeResultData>) {
        employeeList.clear()
        employeeList.addAll(employees)
    }


    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(employee: EmployeeResultData, clickListener: (EmployeeResultData) -> Unit) {
            binding.employeeName.text = "Name : " + employee.name
            binding.joiningDate.text = "JoiningDate : " + employee.joining_date
            binding.managerId.text = "ManagerId : " + employee.manager_id.toString()
            binding.departmentId.text = "DepartmentId : " + employee.department_name.toString()
//
//            binding.listItemLayout.setOnClickListener {
//
//                clickListener(employee)
//            }


        }
    }
}