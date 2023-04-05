package com.snva.soap.student.repository;

import com.snva.soap.student.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity findStudentByName(String name);
}
