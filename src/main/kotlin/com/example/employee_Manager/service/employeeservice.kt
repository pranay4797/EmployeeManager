package com.example.employee_Manager.service

import org.springframework.stereotype.Service
import com.example.employee_Manager.mapper.employeemapper
import com.example.employee_Manager.model.employeemodel
@Service
class employeeservice (private val employeeMapper:employeemapper){

    fun getAllEmployees(): List<employeemodel> {
        return employeeMapper.findAll()
    }

    fun getEmployeeById(id: Long): employeemodel? {
        return employeeMapper.findById(id)
    }

    fun createEmployee(employee:employeemodel) {
        employeeMapper.insert(employee)
    }

    fun updateEmployee(employee: employeemodel) {
        employeeMapper.update(employee)
    }

    fun deleteEmployee(id: Long) {
        employeeMapper.deleteById(id)
    }
}


