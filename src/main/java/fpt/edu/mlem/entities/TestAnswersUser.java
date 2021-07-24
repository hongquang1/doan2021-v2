package fpt.edu.mlem.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
public class TestAnswersUser {
	
	@EmbeddedId
	private QuestionAccountKey id;

//	câu trả lời của người dùng
	private String answersUser;
	
	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	private Account student;
	
	@ManyToOne
	@MapsId("question_id")
	@JoinColumn(name = "question_id")
	private Question teacher;

}
