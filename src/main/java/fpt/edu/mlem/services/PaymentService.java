package fpt.edu.mlem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Payment;
import fpt.edu.mlem.repositories.PaymentRepository;





@Service
public class PaymentService {
	@Autowired
	private  PaymentRepository repo;
	  public void save(Payment Payment) {
	       repo.save(Payment);
	   }

}