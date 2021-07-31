package fpt.edu.mlem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.edu.mlem.entities.Chapter;
import fpt.edu.mlem.requests.CreateChapterRequest;
import fpt.edu.mlem.services.ChapterService;



@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	ChapterService chapterservice;
	
	@RequestMapping(value = "/chapter/create", method = RequestMethod.POST)
	@ResponseBody
	public Chapter createChapter(@RequestBody CreateChapterRequest request) {
		return chapterservice.createChapter(request.getChapter(), request.getGeneralCourseId());
	}
}
