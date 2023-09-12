package com.example.librarymanagementsystem.Controller;

import com.example.librarymanagementsystem.Model.Student;
import com.example.librarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student)
    {
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo)
    {
        Student student = studentService.getStudent(regNo);
        if(student!=null){
            return new ResponseEntity(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id!!",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int regNo)
    {
        String s = studentService.deleteStudent(regNo);
        if(s != null)
        {
            return new ResponseEntity(s,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id!",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateage")
    public ResponseEntity updateAge(@RequestParam("id") int regNo,int age)
    {
        Student student = studentService.updateAge(regNo,age);
        if(student != null)
        {
            return new ResponseEntity(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id!",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallstudents")
    public ResponseEntity getListOfStudents()
    {
        List<Student> ans = studentService.getListOfStudents();
        return new ResponseEntity(ans,HttpStatus.FOUND);
    }

    @GetMapping("/getallMalestudents")
    public ResponseEntity getAllMaleStudents()
    {
        List<Student> ans = studentService.getAllMaleStudents();
        return new ResponseEntity(ans,HttpStatus.FOUND);
    }
}
