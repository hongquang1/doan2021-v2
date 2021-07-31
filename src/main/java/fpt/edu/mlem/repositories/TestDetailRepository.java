package fpt.edu.mlem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Test;
import fpt.edu.mlem.entities.TestDetail;

@Repository
public interface TestDetailRepository extends JpaRepository<TestDetail,Integer> {
	
	List<TestDetail> findByTest(Test test);

}
