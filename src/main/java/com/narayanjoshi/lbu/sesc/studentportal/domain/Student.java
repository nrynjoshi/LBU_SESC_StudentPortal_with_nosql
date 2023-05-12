package com.narayanjoshi.lbu.sesc.studentportal.domain;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_DEFAULT)
//@Table(name = "student")
@Document(collection = "student")
public class Student {

	@JsonIgnore
	@Id
	private String id;
	@JsonProperty("fullname")
	@NotNull
	@NotBlank
	private String fullname;

	@JsonProperty("mobile_number")
	@NotNull
	@NotBlank
	private String mobileNumber;

	@JsonProperty("home_address")
	private String homeAddress;

	@JsonProperty("email_address")
	@NotNull
	@NotBlank
	@Email
	private String email;

	@JsonProperty("username")
	@NotNull()
	@NotBlank(message = "Username can not be empty")
	@Size(min = 4, max = 100, message = "${username.size}")
	@Pattern(regexp = "[A-Za-z0-9]*", message = "${username.format}")
	private String username;

	@JsonProperty("password")
	@NotNull
	@NotBlank
	private String password;

	@JsonProperty("student_id")
	@NotNull
	private long studentId;

}
