package com.university_app.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Admin {

	public Admin(@NotBlank String userName,
			@NotBlank(message = "Password is mandatory") @Size(min = 6, max = 12, message = "Password must be at least 6 characters long, max 12 characters") String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AdminId;
	
	@NotBlank
	private String userName;
	
	@NotBlank(message = "Password is mandatory")
	@Size(min = 6, max = 12,message="Password must be at least 6 characters long, max 12 characters")
	private String password;
}
