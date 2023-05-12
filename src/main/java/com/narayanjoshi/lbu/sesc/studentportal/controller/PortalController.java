package com.narayanjoshi.lbu.sesc.studentportal.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.narayanjoshi.lbu.sesc.studentportal.constant.KeyConstant;
import com.narayanjoshi.lbu.sesc.studentportal.domain.Enroll;
import com.narayanjoshi.lbu.sesc.studentportal.domain.Student;
import com.narayanjoshi.lbu.sesc.studentportal.exception.CourseNotFoundException;
import com.narayanjoshi.lbu.sesc.studentportal.exception.UserAlreadyEnrollIntoCourseException;
import com.narayanjoshi.lbu.sesc.studentportal.service.CourseServiceIfc;
import com.narayanjoshi.lbu.sesc.studentportal.service.EnrollServiceIfc;
import com.narayanjoshi.lbu.sesc.studentportal.service.StudentServiceIfc;
import com.narayanjoshi.lbu.sesc.studentportal.utils.AuthenticateUtil;

@Controller
@RequestMapping("")
public class PortalController {

	private CourseServiceIfc courseServiceIfc;

	private EnrollServiceIfc enrollServiceIfc;

	private StudentServiceIfc studentServiceIfc;

	PortalController(CourseServiceIfc courseServiceIfc, EnrollServiceIfc enrollServiceIfc,
			StudentServiceIfc studentServiceIfc) {
		this.courseServiceIfc = courseServiceIfc;
		this.enrollServiceIfc = enrollServiceIfc;
		this.studentServiceIfc = studentServiceIfc;
	}

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}

	@GetMapping({ "login" })
	public String login(Model model) {
		if (AuthenticateUtil.isAuthenticate()) {
			return "redirect:/dashboard";
		}
		model.addAttribute("student", new Student());
		return "index";
	}

	@GetMapping({ "/dashboard" })
	public String dashboardPortalPage(Model model) {
		model.addAttribute("student", new Student());
		return "dashboard";
	}

	@GetMapping({ "/register" })
	public String registerPortalPage(Model model) {
		model.addAttribute("student", new Student());
		return "/register";
	}

	@PostMapping({ "/register" })
	public String registerPortalSubmit(@ModelAttribute Student student, BindingResult result, RedirectAttributes redirectAttributes) {

		studentServiceIfc.createStudent(student);
		redirectAttributes.addFlashAttribute("message", "success");
		return "redirect:/login?registered=true";
	}

	@GetMapping({ "/courses" })
	public String viewCourse(Model model) {
		model.addAttribute("courses", courseServiceIfc.findAllCourse());
		return "view-courses-and-enrol";
	}

	@GetMapping({ "/profile" })
	public String profilePortalPage(Model model) {
		long studentId = AuthenticateUtil.getStudentId();
		model.addAttribute("student", studentServiceIfc.getStudentByIdWithoutPassword(Long.valueOf(studentId)));
		return "/view-profile";
	}
	
	@GetMapping({ "/profile/update" })
	public String profileUpdatePortalPage(Model model) {
		long studentId = AuthenticateUtil.getStudentId();
		model.addAttribute("student", studentServiceIfc.getStudentByIdWithoutPassword(Long.valueOf(studentId)));
		return "/update-profile";
	}

	@PostMapping({ "/profile" })
	public String profilePortalSubmit(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
		studentServiceIfc.updateStudent(student);
		return "redirect:/profile?success=true";
	}

	@GetMapping({ "/graduation" })
	public String graduationPortalPage(Model model) {
		model.addAttribute("is_eligible_graduated", studentServiceIfc.isEligibleGraduation());
		return "/graduation";
	}

	@GetMapping({ "/logout" })
	public String logout(Model model) {
		return "redirect:/login?logout=true";
	}

	@GetMapping({ "/enrol/{course_id}" })
	public String enrollIntoCourse(@PathVariable(KeyConstant.COURSE_ID) String course_id, RedirectAttributes redirectAttributes) throws CourseNotFoundException, UserAlreadyEnrollIntoCourseException {
		enrollServiceIfc.enrolIntoCourse(course_id);
		redirectAttributes.addFlashAttribute("success_msg", "You have successfully enrol into this course "+course_id);
		return "redirect:/courses";
	}

	@GetMapping({ "/enrollments" })
	public String enrollments(Model model) {
		List<Enroll> enrolCourses = enrollServiceIfc.getEnrolCourses();
		model.addAttribute("enrollments", enrolCourses);
		return "view-enrollments";
	}
}
