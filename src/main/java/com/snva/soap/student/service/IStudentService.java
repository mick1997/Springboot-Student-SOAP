package com.snva.soap.student.service;

import com.snva.soap.student.model.StudentEntity;

import java.util.List;

public interface IStudentService {

    StudentEntity getStudentById(long id);
    StudentEntity getStudentByName(String name);
    List<StudentEntity> getAllStudents();
    StudentEntity addStudent(StudentEntity studentEntity);
    boolean updateStudent(StudentEntity studentEntity);
    boolean deleteStudentById(long id);
}
