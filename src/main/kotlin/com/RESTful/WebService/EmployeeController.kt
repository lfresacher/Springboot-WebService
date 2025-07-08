package com.RESTful.WebService

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> {
        return employeeService.getAllEmployees()
    }

    @GetMapping("/employees/{id}")
    fun getEmployeeById(@PathVariable id: Long): Employee? {
        return employeeService.getEmployeeByID(id)
    }

    @PostMapping("/employees")
    fun createEmployee(@RequestBody employee: Employee): Boolean {
        return employeeService.createEmployee(employee)
    }

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable id: Long, @RequestBody employee: Employee): Boolean {
        return employeeService.updateEmployeeById(id, employee)
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeeById(@PathVariable id: Long): Boolean {
        return employeeService.deleteEmployeeById(id)
    }

    @DeleteMapping("/employees/all")
    fun deleteAllEmployees(): Boolean {
        return employeeService.deleteAllEmployees()
    }
}