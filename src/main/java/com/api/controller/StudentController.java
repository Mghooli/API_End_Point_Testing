package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.Entity.Student;
import com.api.repository.StudentRepositort;


@RestController
public class StudentController {
	
	@Autowired
	StudentRepositort repo;
	//get all students
	//localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		List<Student> students = repo.findAll();
		
		return students;
		
	}
	//localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		 Optional<Student> student = repo.findById(id);
		 if(student.isPresent()) {
			 return student.get(); 
		 }else {
			 throw new RuntimeException("Student with Id:"+id+" not present in System");
		 }
		 
		
		
	}
	
	@PostMapping("/student/add")
	//to handle respons in postman response code
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		repo.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
		 
		
	}
	@PutMapping("/student/update/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	
	public Student updateStudent(@PathVariable int id) {
		Student student = repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not Found"));
		student.setBranch("EEE");
		student.setName("Manu");
		student.setPercentage(20.0f);
		return repo.save(student);
		
		
	
	}
	
	@DeleteMapping("/student/delete/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable int id) {
	Student	student = repo.findById(id).get();
	repo.delete(student);
		
	}
	 @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
	 @ResponseStatus(code=HttpStatus.NOT_FOUND)
	public String runtimeExceptionHandler(Exception ex) {
		
		return ex.getMessage();
	}
	
	
	
	
	

}
