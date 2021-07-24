package fpt.edu.mlem.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Category;
import fpt.edu.mlem.entities.Course;
import fpt.edu.mlem.entities.Level;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.requests.CreateGeneralCourseRequest;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.CategoryService;
import fpt.edu.mlem.services.CourseService;
import fpt.edu.mlem.services.LevelService;
import fpt.edu.mlem.services.ListStudentService;


@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private LevelService levelService;
	@Autowired
	private CourseService generalCourseService;
	@Autowired
	AccountService accountService;
	@Autowired
	ListStudentService studentService;
	@RequestMapping(value = "/generalCourse/create", method = RequestMethod.GET)
	public String createPage(
			@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie, Model model) {
		ArrayList<Category> cateName = (ArrayList<Category>) categoryService.getAllCategories();
		ArrayList<Level> levelName = (ArrayList<Level>) levelService.getAllLevelCourse();
		model.addAttribute("levelName",levelName);
		model.addAttribute("cateName",cateName);
		model.addAttribute("user", accountService.getAccount(userCookie));
		return "create_new_course";
	}
	@RequestMapping(value = "/generalCourse/create", method = RequestMethod.POST)
	@ResponseBody
	public Course create(@RequestBody CreateGeneralCourseRequest request,
			@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie) {
		
		// get cateId Array
		int[] cateIdArray = request.getCateIdArray();
		//get GeneralCourse
		Course gc = request.getGeneralCourse();
		// get level course by id
		Level levelCourse = levelService.findLevelCourseById(request.getLvId());
		
		//get account
		Account manager = accountService.getAccount(userCookie);
		
		return generalCourseService.saveGeneralCourse(gc,cateIdArray,levelCourse,manager);
		//request.setGeneralCourse(generalCourseService.saveGeneralCourse(request.getGeneralCourse()));
		
	}

	
}
