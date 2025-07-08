package com.RESTful.WebService

import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getAllEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }

    fun getEmployeeByID(id: Long): Employee {
        return employeeRepository.findById(id).orElse(null)
    }

    fun createEmployee(employee: Employee): Boolean {
        try {
            employeeRepository.save(employee)
            return true
        } catch (e: Exception) {
            println("Error creating employee: ${e.message}")
            return false
        }
    }

    fun updateEmployeeById(employeeId: Long, employee: Employee): Boolean {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.save(
                Employee (
                    id = employee.id,
                    userName = employee.userName,
                    firstName = employee.firstName,
                    lastName = employee.lastName,
                    email = employee.email,
                    birthday = employee.birthday,
                )
            )
            return true
        }

        println("No matching employee was found with ID: $employeeId")
        return false
    }

    fun deleteEmployeeById(id: Long): Boolean {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id)
            return true
        }
        println("No matching employee was found with ID: $id")
        return false
    }

    fun deleteAllEmployees(): Boolean {
        if (employeeRepository.count() > 0) {
            employeeRepository.deleteAll()
            return true
        }
        println("No employees found to delete.")
        return false
    }
}