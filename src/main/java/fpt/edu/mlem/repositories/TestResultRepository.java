package fpt.edu.mlem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.TestResult;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Integer> {

}
