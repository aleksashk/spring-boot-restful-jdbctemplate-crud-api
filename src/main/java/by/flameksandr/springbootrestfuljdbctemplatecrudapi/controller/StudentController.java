package by.flameksandr.springbootrestfuljdbctemplatecrudapi.controller;

import by.flameksandr.springbootrestfuljdbctemplatecrudapi.model.Student;
import by.flameksandr.springbootrestfuljdbctemplatecrudapi.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/student")
    public int addStudent(@RequestBody Student student) {
        return studentRepository.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentRepository.getStudentById(id);
    }

    @PutMapping("/student")
    public int updateStudent(@RequestBody Student student) {
        return studentRepository.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public int deleteStudentById(@PathVariable("id") int id) {
        return studentRepository.deleteStudentById(id);
    }
}
