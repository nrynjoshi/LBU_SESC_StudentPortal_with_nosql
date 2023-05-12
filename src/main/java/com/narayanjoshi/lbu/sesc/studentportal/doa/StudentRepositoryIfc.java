package com.narayanjoshi.lbu.sesc.studentportal.doa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.narayanjoshi.lbu.sesc.studentportal.domain.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.narayanjoshi.lbu.sesc.studentportal.domain.Student;

@Repository
public interface StudentRepositoryIfc extends MongoRepository<Student, String> {

	@Query("{'studentId':?0}")
	Student findByStudentId(@NotNull @NotEmpty long studentId);

	@Query("{'username':'?0'}")
	Student findByUsername(@NotNull @NotEmpty String username);

}
