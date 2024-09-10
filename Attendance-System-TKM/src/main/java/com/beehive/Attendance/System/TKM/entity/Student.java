package com.beehive.Attendance.System.TKM.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String Name;
    @Column(name = "admission_no")
    private String admissionNo;

    private Double attendancePercentage;

    @Column(name="student_group")
    private String group;

    private String department;
}
