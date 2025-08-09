package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.Entity.Student;

public interface StudentRepositort extends JpaRepository<Student, Integer >{

}
