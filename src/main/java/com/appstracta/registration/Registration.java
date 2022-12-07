package com.appstracta.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "registrations")
@AllArgsConstructor
@NoArgsConstructor
public class Registration implements Serializable {

	private static final long serialVersionUID = 3178679025482526449L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idCustomer;

	private Long idAccount;

	private Long idCredit;

	private LocalDate createAt;

	@PrePersist
	private void prePersistNum(){
		this.createAt = LocalDate.now();
	}
	@PreUpdate
	public void preUpdateFunction(){
		this.createAt = LocalDate.now();
	}

}
