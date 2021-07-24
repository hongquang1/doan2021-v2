package fpt.edu.mlem.entities;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date paymentDate;
	
	@ManyToOne
	private Account account;
}

