package com.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.model.Student;
import com.management.repository.StudentRepository;
import com.management.exception.StudentNotFound;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository ;
	
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	public List<Student> getStudent(){
		
		return studentRepository.findAll();
	}

	public boolean delete(Long id) {
		
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return true ;
			
		}else {
			return false ;
			
		}
	}

	public Student updateStudent(Long id, Student student) throws StudentNotFound {
		
		Optional<Student> estudent = studentRepository.findById(id);
		if(estudent.isPresent()) {
			Student stud = estudent.get() ;
			stud.setName(student.getName());
			stud.setAge(student.getAge());
			stud.setAddress(stud.getAddress());
			
			return studentRepository.save(stud);
		}else {
		throw new StudentNotFound("Student with ID: "+id+" Not Found");
		}
		
	}
}
