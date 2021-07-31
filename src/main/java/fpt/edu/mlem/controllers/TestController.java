package fpt.edu.mlem.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fpt.edu.mlem.entities.Question;
import fpt.edu.mlem.entities.Test;
import fpt.edu.mlem.repositories.QuestionRepository;
import fpt.edu.mlem.repositories.TestRepository;
import fpt.edu.mlem.response.QuestionRes;
import fpt.edu.mlem.response.TestRes;
import fpt.edu.mlem.utils.TestUtil;

@Controller
public class TestController {
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping("/doExam")
	public String DetailQuestion(Model model,@RequestParam("idExam") int id) {
		Test test = testRepository.getById(id);
		List<Question> questionList = questionRepository.findByTest(test);
		TestRes testRes = TestUtil.TestQuestionFormat(questionList);
		model.addAttribute("test",testRes);
		return "fullTestListen";
	}
//quang
}
