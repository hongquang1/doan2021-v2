package fpt.edu.mlem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Test;
import fpt.edu.mlem.entities.TestDetail;
import fpt.edu.mlem.repositories.TestDetailRepository;

@Service
public class TestDetailService {
	
	@Autowired
	private TestDetailRepository testDetailRepository;
	

	public void  save(TestDetail testDetail) {
		testDetailRepository.save(testDetail);
	}
	
	public  List<TestDetail> getListQuestion(Test test){
		return testDetailRepository.findByTest(test);
	}

//	void save(TestDetail testDetail);
}
