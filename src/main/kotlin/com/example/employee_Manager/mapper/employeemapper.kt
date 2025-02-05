package com.example.employee_Manager.mapper
import com.example.employee_Manager.model.employeemodel
import org.apache.ibatis.annotations.*

@Mapper
interface employeemapper {
    @Select("SELECT * FROM employee WHERE id =#{id}")
    fun findById(id: Long): employeemodel?
    @Select("SELECT * FROM employee")
    fun findAll(): List<employeemodel>

    @Insert("INSERT INTO employee(first_name, last_name, department, salary) " +
            "VALUES(#{first_name}, #{last_name}, #{department}, #{salary})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(employee: employeemodel)

    @Update("UPDATE employee SET first_name = #{firstName}, last_name = #{lastName}, " +
            "department = #{department}, salary = #{salary} WHERE id = #{id}")
    fun update(employee:employeemodel)

    @Delete("DELETE FROM employee WHERE id=#{id}")
    fun deleteById(id: Long)
}