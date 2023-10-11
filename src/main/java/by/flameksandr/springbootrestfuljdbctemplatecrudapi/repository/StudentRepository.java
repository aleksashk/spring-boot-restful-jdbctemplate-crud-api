package by.flameksandr.springbootrestfuljdbctemplatecrudapi.repository;

import by.flameksandr.springbootrestfuljdbctemplatecrudapi.model.Student;

import java.util.List;

public interface StudentRepository {
    int addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    int updateStudent(Student student);

    int deleteStudentById(int id);
}
