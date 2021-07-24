package fpt.edu.mlem.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TestResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private Date testDate;
	private int numberCorrectAnwser;
	private int numberWrongAnwser;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Test test;
	
	@ManyToMany
	Set<Account> accountSet = new HashSet<>();
}
