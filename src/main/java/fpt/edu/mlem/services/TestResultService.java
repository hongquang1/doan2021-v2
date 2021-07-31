package fpt.edu.mlem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.TestResults;
import fpt.edu.mlem.repositories.TestResultRepository;

@Service
public class TestResultService {

	@Autowired
	private TestResultRepository testResultRepository;

	public  void save(TestResults testResults) {
		testResultRepository.save(testResults);

	}
}
