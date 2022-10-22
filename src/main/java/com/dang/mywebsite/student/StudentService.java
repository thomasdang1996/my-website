package com.dang.mywebsite.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//or use @Component (practically same) to connect to StudentController with autowired annotation.
public class StudentService {
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email " + student.getEmail() + " is taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void removeStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Student with id " + id + " does not exist.");
        }

        studentRepository.deleteStudentById(id);

    }
}
