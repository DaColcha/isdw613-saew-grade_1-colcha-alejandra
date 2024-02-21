package com.saew.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saew.dto.Student;

@RestController
@RequestMapping("/students")
public class StudentsController {

    Student student1 = new Student(1, "Alejandra Colcha", "dacol@email.com", 8.56f);
    Student student2 = new Student(2, "Carlos Perez", "carlos@email.com", 9.56f);
    Student student3 = new Student(3, "Melisa Cobos", "melisa@email.com", 8.80f);

    List<Student> studentsList = new ArrayList<Student>() {
        {
            add(student1);
            add(student2);
            add(student3);
        }
    };

    @GetMapping
    public List<Student> getAllStudents() {
        return studentsList;
    }

    @GetMapping("/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentsList.stream().filter(student -> student.getNombre().toLowerCase().contains(name)).toList();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> student = studentsList.stream().filter(s -> s.getId() == (Integer.parseInt(id))).findFirst();

        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentsList.add(student);
        return ResponseEntity.ok(student);
    }

    @PatchMapping
    public ResponseEntity<Student> updateProduct(@RequestBody Student student) {
        boolean studentExist = studentsList.stream()
                .filter(s -> s.getId() == student.getId())
                .findFirst().isPresent();
        if (studentExist) {
            studentsList.remove(studentsList.stream()
                    .filter(s -> s.getId() == student.getId())
                    .findFirst().get());

            studentsList.add(student);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String id) {
        boolean studentExist = studentsList.stream()
                .filter(s -> s.getId() == (Integer.parseInt(id)))
                .findFirst().isPresent();
        if (studentExist) {
            studentsList
                    .remove(studentsList.stream().filter(s -> s.getId() == (Integer.parseInt(id))).findFirst().get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
