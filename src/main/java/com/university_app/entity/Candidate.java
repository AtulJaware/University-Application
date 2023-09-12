package com.university_app.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Candidate {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidateId;
	
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Email
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Course is mandatory")
	private String course;
	
	private double score=0;
	
	@NotBlank(message = "UserName is mandatory")
	private String userName;
	
	@NotBlank(message = "Password is mandatory")
	@Size(min = 6, max = 12,message="Password must be at least 6 characters long, max 12 characters")
	private String password;

	public Candidate(@NotBlank(message = "Name is mandatory") String name,
			@Email @NotBlank(message = "Email is mandatory") String email,
			@NotBlank(message = "Course is mandatory") String course,
			@NotBlank(message = "UserName is mandatory") String userName,
			@NotBlank(message = "Password is mandatory") @Size(min = 6, max = 12, message = "Password must be at least 6 characters long, max 12 characters") String password) {
		super();
		this.name = name;
		this.email = email;
		this.course = course;
		this.userName = userName;
		this.password = password;
	}
	
	
}
