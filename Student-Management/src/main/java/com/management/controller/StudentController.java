package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.exception.StudentNotFound;
import com.management.model.Student;
import com.management.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	private ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		Student stud = studentService.addStudent(student);
		
		return new ResponseEntity<Student>(stud, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Student>> getMethodName() throws StudentNotFound {
		
		List<Student> stud = studentService.getStudent();
		if(stud != null) {
			return new ResponseEntity<List<Student>>(stud, HttpStatus.OK);
		}
		else {
			throw new StudentNotFound("Not Students In Data");
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deleteStudent(@PathVariable Long id) throws StudentNotFound{
		
		boolean del = studentService.delete(id);
		
		if(del) {
			return new ResponseEntity<String>("Record Deleted SuccessFully", HttpStatus.OK);
		}
		else {
			throw new StudentNotFound("Student With ID :"+ id +" Not Found");
		}
		
	}
	
	@PutMapping("/update/{id}")
	private ResponseEntity<Student> updateStudent(@PathVariable Long id , @RequestBody Student student) throws StudentNotFound {
		
		Student stud = studentService.updateStudent(id , student);
		
		if(stud != null) {
			return new ResponseEntity<Student>(stud, HttpStatus.OK);
		}
		else {
			throw new StudentNotFound("Student With ID :"+ id +" Not Found");
		}
		
	}
	
	
	
	
}
