package fpt.edu.mlem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
