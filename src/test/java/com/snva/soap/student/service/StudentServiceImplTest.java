package com.snva.soap.student.service;

import com.snva.soap.student.model.StudentEntity;
import com.snva.soap.student.repository.StudentRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;
    private StudentEntity studentEntity;

    @BeforeEach
    void setUp() {
        studentEntity = StudentEntity.builder()
                .name("Jack")
                .dob("10-10-2002")
                .course("Java Full-stack")
                .address("some address")
                .email("jack@gmail.com")
                .contact("123456")
                .ip("127.1.1.1")
                .build();
    }

    @Test
    void getStudentById() {
    }

    @Test
    void getStudentByName() {
    }

    @Test
    void getAllStudents() {
    }

    @Test
    @DisplayName("Soap for save method test")
    void addStudent() {
        given(studentRepository.findStudentByName(studentEntity.getName())).willReturn(Optional.empty());
        given(studentRepository.save(studentEntity)).willReturn(studentEntity);
        System.out.println("Student Repository: " + studentRepository);
        System.out.println("Student Service: " + studentService);
        StudentEntity student = studentService.addStudent(studentEntity);
        System.out.println("Student: " + student);
        assertThat(studentEntity).isNotNull();
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudentById() {
    }
}