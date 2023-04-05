package com.snva.soap.student.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long studentId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String ip;
}
