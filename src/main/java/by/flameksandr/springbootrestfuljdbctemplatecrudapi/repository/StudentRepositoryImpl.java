package by.flameksandr.springbootrestfuljdbctemplatecrudapi.repository;

import by.flameksandr.springbootrestfuljdbctemplatecrudapi.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addStudent(Student student) {
        String query = "insert into student(id, name, contact_number, address)" +
                " values(?,?,?,?)";
        return jdbcTemplate.update(query,
                student.getId(),
                student.getName(),
                student.getContactNumber(),
                student.getAddress());
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select id, name, contact_number, address from student";
        List<Student> allStudentsList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
        return allStudentsList;
    }

    @Override
    public Student getStudentById(int id) {
        String query = "select id, name, contact_number, address from student where id=?";
        Student student = jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Student.class), id);
        return student;
    }

    @Override
    public int updateStudent(Student student) {
        String query = "update student set id=?, name=?, contact_number=?, address=? where id=?";
        return jdbcTemplate.update(query, student.getId(), student.getName(), student.getContactNumber(), student.getAddress(), student.getId());
    }

    @Override
    public int deleteStudentById(int id) {

        String query = "delete from student where id=?";

        return jdbcTemplate.update(query, id);
    }
}
