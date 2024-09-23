package com.amey.SpringJDBC.service;
import java.util.*;
import com.amey.SpringJDBC.model.Student;
import com.amey.SpringJDBC.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // SINCE IT'S AN SERVICE CLASS (MIDDLE LAYER)
public class StudentService {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s){
        repo.save(s);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
