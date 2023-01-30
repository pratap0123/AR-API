package com.pd.binding;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CitizenBinding {
	private String citizenName;
	private String citizenEmail;
	private Long phonNumber;
	private String gender;
	private LocalDateTime dob;
	private Integer ssn;
}
