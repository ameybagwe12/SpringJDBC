package com.amey.SpringJDBC;

import com.amey.SpringJDBC.model.Student;
import com.amey.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.*;
@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student s = context.getBean(Student.class);
		s.setRollNo(9180);
		s.setName("Amey");
		s.setMarks(100);

		// FROM SERVICE PACKAGE TO ADD STUDENT TO REPO (MIDDLE LAYER)
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
