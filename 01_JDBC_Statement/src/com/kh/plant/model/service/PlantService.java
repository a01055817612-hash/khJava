package com.kh.plant.model.service;

import java.util.List;

import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantService {
	
	public int save(HousePlantDto hpd) {
		
		//if(hpd.getPlantName().length() > 40) {
		//	throw new RuntimeException(" 글자 수가 너무 깁니다");
		
		//}
		return new PlantDao().save(hpd);
	}
	
	public List<HousePlantDto> view() {
		return new PlantDao().view();
	}
	public int edit(HousePlantDto hpd) {
		return new PlantDao().edit(hpd);
	}

}
