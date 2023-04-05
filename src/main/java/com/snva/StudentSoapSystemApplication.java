package com.snva;

import com.snva.soap.student.model.StudentEntity;
import com.snva.soap.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentSoapSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSoapSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StudentRepository studentRepository) {
        return args -> {

            if (false) {
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setName("Jack");
                studentEntity.setDob("12-10-2000");
                studentEntity.setCourse("Java Full-stack");
                studentEntity.setContact("123456789");
                studentEntity.setAddress("some address");
                studentEntity.setEmail("jack@gmail.com");
                studentEntity.setIp("127.0.0.1");
                studentRepository.save(studentEntity);
                System.out.println("Student table created!!!");
            }
        };
    }
}
