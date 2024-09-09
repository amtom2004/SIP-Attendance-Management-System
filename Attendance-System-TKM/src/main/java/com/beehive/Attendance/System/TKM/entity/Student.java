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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "admission_no")
    private String admissionNo;

    @Column(name = "attendance_percentage")
    private Double attendancePercentage;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = true)
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = true)
    private Advisor advisor;
}
