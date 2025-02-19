package com.stprogramming.restapi.controller;
import com.stprogramming.restapi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.stprogramming.restapi.entity.Student;


import java.util.List;
import java.util.ListIterator;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;


    // get all the students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }

    // localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();

        return student;
    }

    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudents(@RequestBody Student student ){

        repo.save(student);
//        return student;

    }

    @PutMapping("/students/update/{id}")
    public Student updateStudents(@PathVariable int id){
        Student student=repo.findById(id).get();
        student.setName("kajala");
        student.setBranch("eee");
        repo.save(student);
        return student;
    }
    @DeleteMapping("/students/delete/{id}")
    public Student deleteStudents(@PathVariable int id){
       Student student =  repo.findById(id).get();
        repo.delete(student);
        return student;

    }


}
