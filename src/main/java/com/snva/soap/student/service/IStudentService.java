package com.snva.soap.student.service;

import com.snva.soap.student.model.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    StudentEntity getStudentById(long id);
    Optional<StudentEntity> getStudentByName(String name);
    List<StudentEntity> getAllStudents();
    StudentEntity addStudent(StudentEntity studentEntity);
    boolean updateStudent(Optional<StudentEntity> studentEntity);
    boolean deleteStudentById(long id);
}
