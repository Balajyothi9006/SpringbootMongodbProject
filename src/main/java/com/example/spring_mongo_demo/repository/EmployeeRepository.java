package com.example.spring_mongo_demo.repository;

import com.example.spring_mongo_demo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
