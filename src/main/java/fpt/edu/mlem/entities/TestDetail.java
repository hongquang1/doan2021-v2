package fpt.edu.mlem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class TestDetail {
//	user answers
	private String answersAnUser;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer testQuestionsId;
	
//	@Column(name = "number")
	private Integer number;
	
//	@Column(name = "image")
	private String image;

//	@Column(columnDefinition = "TEXT")
	private String paragraph;
	
//	@Column(name = "question")
	private String question;
	
//	@Column(name = "option1")
	private String option1;
	
//	@Column(name = "option2")
	private String option2;
	
//	@Column(name = "option3")
	private String option3;
	
//	@Column(name = "option4")
	private String option4;

//	@Column(name = "correctanswer")
	private String correctanswer;
	
	@ManyToOne
	@JoinColumn(name="testId",nullable= false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Test test;

}
