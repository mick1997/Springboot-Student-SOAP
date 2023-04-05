package com.snva.soap.student.service;

import com.snva.soap.student.model.StudentEntity;
import com.snva.soap.student.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentEntity getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public StudentEntity getStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentRepository.findAll().forEach(s -> studentEntityList.add(s));
        return studentEntityList;
    }

    @Override
    public StudentEntity addStudent(StudentEntity studentEntity) {
        try {
            return studentRepository.save(studentEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
//        StudentEntity studentEntityRes = new StudentEntity();
//        if (studentEntity.getName().isEmpty()) {
//            studentEntityRes.setName(studentEntity.getName());
//            studentEntityRes.setDob(studentEntity.getDob());
//            studentEntityRes.setCourse(studentEntity.getCourse());
//            studentEntityRes.setContact(studentEntity.getContact());
//            studentEntityRes.setEmail(studentEntity.getEmail());
//            studentEntityRes.setAddress(studentEntity.getAddress());
//            studentEntityRes.setIp(studentEntity.getIp());
//            studentRepository.save(studentEntityRes);
//        }
//        else {
//            System.out.println("Student has already exists!!!");
//        }
//        return studentEntityRes;
    }

    @Override
    public boolean updateStudent(StudentEntity studentEntity) {
        try {
            studentRepository.save(studentEntity);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
//        StudentEntity stu = studentRepository.findStudentByName(studentEntity.getName());
//        if (stu != null) {
//            StudentEntity studentEntityRes = new StudentEntity();
//            studentEntityRes.setName(studentEntity.getName());
//            studentEntityRes.setDob(studentEntity.getDob());
//            studentEntityRes.setCourse(studentEntity.getCourse());
//            studentEntityRes.setContact(studentEntity.getContact());
//            studentEntityRes.setEmail(studentEntity.getEmail());
//            studentEntityRes.setAddress(studentEntity.getAddress());
//            studentEntityRes.setIp(studentEntity.getIp());
//            studentRepository.save(studentEntityRes);
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean deleteStudentById(long id) {

        try {
            studentRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
