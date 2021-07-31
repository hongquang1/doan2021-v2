package fpt.edu.mlem.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "test_result")
public class TestResults {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resultid", nullable = false)
	private Integer resultid;

//	@Column(name = "socaudung")
	private int numberCorrectAnswers;

//	@Column(name = "socausai")
	private int numberWrongAnswers;

	@Column(name = "time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
	private Date testDay;

	@Column(name = "correctQuestion")
	private int correctreading;

//	@Column(name = "correctlisten")
//	private int correctlisten;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Account account;

	@ManyToOne
	@JoinColumn(name = "testId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Test test;

}
