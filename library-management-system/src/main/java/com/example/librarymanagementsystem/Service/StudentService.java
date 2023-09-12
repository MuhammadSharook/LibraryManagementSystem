package com.example.librarymanagementsystem.Service;

import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.Enum.Gender;
import com.example.librarymanagementsystem.Model.LibraryCard;
import com.example.librarymanagementsystem.Model.Student;
import com.example.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {

        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.Active);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);
        Student savedStudent = studentRepository.save(student);
        return "Student saved successfully !";
    }

    public  Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }


    public String deleteStudent(int regNo) {
        Student student = getStudent(regNo);
        if(student != null)
        {
            studentRepository.deleteById(regNo);
            return "Success!";
        }
        return null;
    }

    public Student updateAge(int regNo, int age) {
        Student student = getStudent(regNo);
        if(student != null)
        {
            student.setAge(age);
            studentRepository.save(student);
            return student;
        }
        return null;
    }

    public List<Student> getListOfStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getAllMaleStudents() {
        return studentRepository.findByGender(Gender.MALE);
    }
}
