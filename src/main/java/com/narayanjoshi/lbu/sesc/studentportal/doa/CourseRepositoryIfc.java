package com.narayanjoshi.lbu.sesc.studentportal.doa;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.narayanjoshi.lbu.sesc.studentportal.domain.Course;

@Repository
public interface CourseRepositoryIfc extends MongoRepository<Course, String> {

	@Query("{'title':'?0'}")
	List<Course> searchByTitleKeyword(@NotNull @NotEmpty String title);

	@Query("{'courseId':'?0'}")
	Course findByCourseId(@NotNull @NotEmpty String courseId);

}
