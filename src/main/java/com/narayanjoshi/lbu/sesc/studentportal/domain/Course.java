package com.narayanjoshi.lbu.sesc.studentportal.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@Document(collection = "course")
public class Course {

	@JsonIgnore
	@Id
	private String id;
	@JsonProperty("course_id")
	@NotNull
	@NotBlank
	private String courseId;

	@JsonProperty("title")
	@NotNull
	@NotBlank
	private String title;

	@JsonProperty("description")
	@NotNull
	private String description;

	@JsonProperty("fee")
	@NotNull
	private BigDecimal fee;

}
