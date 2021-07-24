package fpt.edu.mlem.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.edu.mlem.entities.Chapter;
import fpt.edu.mlem.entities.Question;
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
	
	@RequestMapping(value = "/test/create", method = RequestMethod.POST)
	@ResponseBody
	public List<Question> createTest(@RequestBody CreateTestRequest createTestRequest) throws EncryptedDocumentException, InvalidFormatException, IOException {
		return importExecelTestService.ReadDataFromExcel(createTestRequest.getPath(),createTestRequest.getTestId());
		
	}
}
