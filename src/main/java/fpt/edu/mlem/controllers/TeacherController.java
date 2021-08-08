package fpt.edu.mlem.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fpt.edu.mlem.entities.Chapter;
import fpt.edu.mlem.entities.Question;
import fpt.edu.mlem.entities.Test;
import fpt.edu.mlem.requests.CreateChapterRequest;
import fpt.edu.mlem.requests.CreateTestRequest;
import fpt.edu.mlem.services.ChapterService;
import fpt.edu.mlem.services.ImportExecelTestService;



@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	ChapterService chapterservice;
	@Autowired
	ImportExecelTestService importExecelTestService;
	
	@RequestMapping(value = "/chapter/create", method = RequestMethod.POST)
	@ResponseBody
	public Chapter createChapter(@RequestBody CreateChapterRequest request) {
		return chapterservice.createChapter(request.getChapter(), request.getGeneralCourseId());
	}
	@RequestMapping(value = "/test/create", method = RequestMethod.GET)
	public String createTestPage(Model model,@RequestParam int courseId){
		model.addAttribute("courseId", courseId);
		return "test_import";
	}
	
	@RequestMapping(value = "/test/create", method = RequestMethod.POST)
	@ResponseBody
	public String createTest(CreateTestRequest formData) throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println(formData.getCourseId());
		return importExecelTestService.ReadDataFromExcel(formData);
		
	}
}
