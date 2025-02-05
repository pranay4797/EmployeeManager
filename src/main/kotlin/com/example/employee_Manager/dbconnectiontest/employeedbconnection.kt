package com.example.employee_Manager.dbconnectiontest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.sql.DataSource
@Component
    class DatabaseConnectionTest @Autowired constructor(private val dataSource: DataSource) : CommandLineRunner {

        override fun run(vararg args: String?) {
            try {
                val connection = dataSource.connection
                println("Database connection successful!")
                println("Database URL: ${connection.metaData.url}")
                println("Database User: ${connection.metaData.userName}")
                connection.close()
            } catch (e: Exception) {
                println("Database connection failed: ${e.message}")
            }
        }
    }
