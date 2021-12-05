package djh.learn.springRest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import djh.learn.springRest.pojo.Student;
import djh.learn.springRest.pojo.StudentErrorResponse;

@RestController
@RequestMapping("/api")
public class StudentController {

	private List<Student> students;

	@PostConstruct
	public void loadData() {
		System.out.println("Loading the data................");
		students = new ArrayList<Student>();
		students.add(new Student("deepak", "jangra"));
		students.add(new Student("sunil", "kumar"));
		students.add(new Student("daman", "jangra"));
	}

	@GetMapping("/students/{studentId}")
	public Student student(@PathVariable("studentId") int studentId) {
		if (studentId >= students.size() || studentId<0) {
			throw new StudentNotFoundException("Student not found with id " + studentId);
		}
		Student std = students.get(studentId);
		return std;
	}

	@GetMapping("/students")
	public List<Student> students() {

		return students;
	}
	


}
