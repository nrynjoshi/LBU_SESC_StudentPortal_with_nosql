package com.narayanjoshi.lbu.sesc.studentportal.domain;

import java.time.LocalDateTime;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.narayanjoshi.lbu.sesc.studentportal.constant.IntakeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_DEFAULT)
@Document(collection = "enroll")
public class Enroll  {

	@JsonIgnore
	@Id
	private String id;
	@JsonProperty("student_id")
	@NotNull
	private long studentId;

	@JsonProperty("intake")
	@NotNull
	private IntakeEnum intake;

	@JsonProperty("enroll_date")
	@NotNull
	private LocalDateTime date;

	@JsonProperty("course")
	@NotNull
	private Course course = new Course();

}
