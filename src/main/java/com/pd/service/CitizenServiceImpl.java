package com.pd.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.pd.binding.CitizenBinding;
import com.pd.entity.Citizen;
import com.pd.repo.CitizenRepo;

@Service
public class CitizenServiceImpl implements CitizenService {
//ssawebapi-env.eba-k88bsahp.ap-south-1.elasticbeanstalk.com/ssn/567654(valid)
	@Autowired
	private CitizenRepo citizenRepo;
	@Autowired
	private WebClient webClient;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String createCitizen(CitizenBinding citizenBinding) {
		String ssn2= webClient.get().uri("ssawebapi-env.eba-k88bsahp.ap-south-1.elasticbeanstalk.com/ssn/"+567654)
				.retrieve().bodyToMono(String.class).block();
		System.out.println("SSN::" + ssn2);

		String ssn = restTemplate.getForObject(
				"http://ssawebapi-env.eba-k88bsahp.ap-south-1.elasticbeanstalk.com/ssn/567654", String.class);
		System.out.println(ssn);

//		String state = "Rhode Island";
		Citizen citizen = new Citizen();
		BeanUtils.copyProperties(citizenBinding, citizen);
		if (ssn2.equals("Rhode Island")) {
			Citizen save = citizenRepo.save(citizen);
			if (save != null) {
				return "Your Appliaction is created";
			} else {
				return "Your Appliaction is not created Due to some issues";
			}

		}
		System.out.println(citizenBinding);
		return "Your are not from Rhode Island";
	}

}
