package fpt.edu.mlem.controllers;

import java.util.List;

import javax.persistence.Index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.edu.mlem.entities.TestDetail;
import fpt.edu.mlem.services.TestDetailService;
import fpt.edu.mlem.services.TestService;


@Controller
public class TestController {
	
	@Autowired
	TestService TestService;
	
	@Autowired
	TestDetailService testDetailService;
	
	@GetMapping("/doExam")
	public String DetailQuestion(Model model,@RequestParam("idExam") int id) {
		
		try {
				List<TestDetail> list = testDetailService.getListQuestion(TestService.getTest(id).get(0));
				System.out.println(list.size());
				model.addAttribute("listQuestion",list);
				return "fullTestListen";
				
		}catch(Exception e) {
			System.out.println("error:"+e);
			return "error";
		}
		
		
	}

}
