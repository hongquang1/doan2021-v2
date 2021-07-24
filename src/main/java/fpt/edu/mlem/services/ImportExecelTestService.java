package fpt.edu.mlem.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Question;
import fpt.edu.mlem.entities.QuestionAnswer;
import fpt.edu.mlem.entities.Test;
import fpt.edu.mlem.repositories.QuestionRepository;
import fpt.edu.mlem.repositories.TestRepository;

@Service
public class ImportExecelTestService {
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Transactional
	public List<Question> ReadDataFromExcel(String excelPath,int testId)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\Admin\\Documents\\TEST.xlsx"));
		List<Question> questionList = new ArrayList<>();
		int indexSheet = 0;
		Test test = testRepository.getById(testId);
		for (Sheet sheet : workbook) {
			System.out.println("=> " + sheet.getSheetName());
			for (Row row : sheet) {
				if (indexSheet != 0) {
					Set<QuestionAnswer> answerSet = new HashSet<>();
					String content = row.getCell(0).getStringCellValue();
					String imageUrl = row.getCell(1).getStringCellValue();
					
					Question question = new Question(0,content,imageUrl,null,test);
					question = questionRepository.save(question);
					try {
						int correctAnswerIndex = (int) row.getCell(6).getNumericCellValue();
						for (int i = 2; i <= 5; i++) {
							String answer = row.getCell(i).getStringCellValue();
							if (i == correctAnswerIndex+1) {
								questionRepository.insertAnswer(answer, true, question.getId());
							}else {
								questionRepository.insertAnswer(answer, false, question.getId());
							}
							
						}
						question.setAnwserSet(answerSet);
						questionList.add(question);
					} catch (Exception e) {
						// TODO: handle exception	
						System.out.println(e.getMessage());
					}
				} else if (indexSheet == 0) {
					indexSheet++;
				}

			}
		}
		return questionRepository.saveAll(questionList);
	}

}
