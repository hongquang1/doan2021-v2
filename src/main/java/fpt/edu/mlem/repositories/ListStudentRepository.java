package fpt.edu.mlem.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.ListStudent;


@Repository
public interface ListStudentRepository extends JpaRepository<ListStudent, Integer> {
	@Query("SELECT u FROM ListStudent u WHERE u.student = :student_id")
	public List<ListStudent> getCoursebyStudent(@Param("student_id") Account idStudent);
	@Query("SELECT l FROM ListStudent l WHERE year(l.joinDate) = ?1 and month(l.joinDate) = ?2")
	public List<ListStudent> getStudentbyDate(int year,int month);
	@Query("SELECT l FROM ListStudent l WHERE year(l.joinDate) = ?1 and month(l.joinDate) = ?2 and day(l.joinDate)=?3")
	public List<ListStudent> getStudentbyDay(int year,int month,int day);
}
