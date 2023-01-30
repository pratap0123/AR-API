package com.pd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pd.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

}
