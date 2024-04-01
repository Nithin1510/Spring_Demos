package com.insuranceapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insuranceapp.model.Insurance;

@Service
public class InsuranceServiceImpl implements IInsuranceService{

	@Override
	public List<Insurance> getAll() {
		return getAllIinsurances();
	}

	@Override
	public Insurance getById(int insuranceId) {
		List<Insurance>  insurances = getAllIinsurances();
		for(Insurance insurance: insurances) {
			if(insurance.getInsuranceId() == insuranceId)
				return insurance;
		}
		return null;
	}

	private List<Insurance> getAllIinsurances(){
		return Arrays.asList(
				new Insurance(101, "V0-H001", "Voya", "Health", 10, 10000),
				new Insurance(102, "BJ-M01", "Bajaj", "Motor", 10, 5000),
				new Insurance(103, "FI-LIFE", "Fidelity", "Life", 15, 8000),
				new Insurance(104, "V0-Mx01", "Voya", "Motor", 12, 3000),
				new Insurance(105, "V0-S002", "Fidelity", "Motor", 10, 10000));
		
	}
}
