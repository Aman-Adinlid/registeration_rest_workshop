package se.lexicon.registeration_workshop.controller;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.registeration_workshop.entity.Student;
import se.lexicon.registeration_workshop.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/api/student/")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(studentList::add);
        return ResponseEntity.ok(studentList);

    }

    @GetMapping("/api/student/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") String id) {
        System.out.println("ID: " + id);
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
            return ResponseEntity.ok(optionalStudent.get());
        else
            return ResponseEntity.noContent().build();
    }


}
