package com.example.librarymanagementsystem.Repository;

import com.example.librarymanagementsystem.Enum.Gender;
import com.example.librarymanagementsystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByGender(Gender gender);
}
