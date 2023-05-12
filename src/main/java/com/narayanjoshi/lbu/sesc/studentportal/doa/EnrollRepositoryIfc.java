package com.narayanjoshi.lbu.sesc.studentportal.doa;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.narayanjoshi.lbu.sesc.studentportal.domain.Course;
import com.narayanjoshi.lbu.sesc.studentportal.domain.Enroll;

@Repository
public interface EnrollRepositoryIfc extends MongoRepository<Enroll, String> {

	@Query("{'studentId':'?0'}")
	List<Enroll> findByStudentId(@NotNull @NotEmpty Long studentId);

	@Query("{'studentId':'?0'}")
	Enroll findByStudentIdAndCourse(@NotNull @NotEmpty Long studentId,@NotNull Course course);

}
