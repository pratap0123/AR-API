package com.pd.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CITIZEN")
@Data
public class Citizen  {
	@Id
	@GeneratedValue
	private Integer citizenId;
	private String citizenName;
	private String citizenEmail;
	private Long phonNumber;
	private String gender;
	private LocalDateTime dob;
	private Integer ssn;
}
