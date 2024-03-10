package com.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "student_data")
public class StudentEntity {

	@Id
	@GeneratedValue(generator = "student_id", strategy = GenerationType.SEQUENCE)
	private Long studentId;

	@Column(name = "student_name", nullable = false)
	private String studentName; // student_name

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "mobile_number", nullable = false, length = 13, unique = true)

	private Long mobileNumber;

	@Column(name = "student_address", nullable = false)
	private String studentAddress;

}
