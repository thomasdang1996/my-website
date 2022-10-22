package com.dang.mywebsite.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository
        extends JpaRepository<Student, Long> {

// SELECT * FROM student ...
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);
    @Query("Delete * FROM Student WHERE id=?1")
    void deleteStudentById(Long id);
}
