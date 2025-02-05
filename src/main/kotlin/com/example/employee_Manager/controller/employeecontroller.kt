package com.example.employee_Manager.controller

import com.example.employee_Manager.model.employeemodel
import com.example.employee_Manager.service.employeeservice
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/employees")
class employeecontroller(private val employeeService: employeeservice) {
    @GetMapping
    fun getAllEmployees(): List<employeemodel> {
        return employeeService.getAllEmployees()
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): ResponseEntity<employeemodel> {
        val employee = employeeService.getEmployeeById(id)
        return if (employee != null) {
            ResponseEntity.ok(employee)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @PostMapping
    fun createEmployee(@RequestBody employee: employeemodel): ResponseEntity<Unit> {
        employeeService.createEmployee(employee)
        return ResponseEntity.created(URI.create("/api/employees/${employee.id}")).build()
    }

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: Long, @RequestBody employee: employeemodel): ResponseEntity<Unit> {
        employee.id = id
        employeeService.updateEmployee(employee)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Unit> {
        employeeService.deleteEmployee(id)
        return ResponseEntity.noContent().build()
    }
}
