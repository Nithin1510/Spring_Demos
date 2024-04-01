package com.insuranceapp.service;

import java.util.List;

import com.insuranceapp.exceptions.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;

public interface IInsuranceService {
	
	void addInsurance(Insurance insurance);
	void updateInsurance(int insuranceId, double premium);
	void deleteInsurance(int insuranceId);
	
	List<Insurance> getAll();
	Insurance getById(int insuranceId) throws InsuranceNotFoundException;
	List<Insurance> getByBrand(String brand) throws InsuranceNotFoundException;
	List<Insurance> getByBrandAndType(String insurance, String type) throws InsuranceNotFoundException;
	List<Insurance> getByTypeAndLesserPremium(String type, double premium) throws InsuranceNotFoundException;

}
