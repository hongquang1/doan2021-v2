package fpt.edu.mlem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.Level;
import fpt.edu.mlem.entities.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
//	@Query("SELECT u FROM Course u WHERE u.level.l = :lc_id")
//	public List<Course> getCoursebyLevel(@Param("lc_id") int lvid);

}
