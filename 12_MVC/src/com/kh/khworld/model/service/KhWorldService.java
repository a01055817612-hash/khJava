package com.kh.khworld.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.khworld.exception.DuplicateNameException;
import com.kh.khworld.model.dto.Attraction;

public class KhWorldService {
	
	private List<Attraction> attractions = new ArrayList<>();
	
	{
		System.out.println("초기화 블럭");
								
	}
	
	static {
		System.out.println("스태틱 블럭");
	}
	
	
	
	
	public KhWorldService() {
		attractions.add(new Attraction("콩X고질라라이드", "110cm~195cm 탑승가능", "3층 게임빌리지/스낵바 옆"));
        attractions.add(new Attraction("귀담", "제한없음", "매직아일랜드 매직캐슬 뒷편"));
        attractions.add(new Attraction("회전바구니", "110cm이상 탑승가능", "후룸라이드 좌측"));
        System.out.println("생성자 블럭");
	}
	
	public List<Attraction> readAttractions() {
		return attractions;
	}
	
	/**
	 * @param a
	 */
	public void save(Attraction a) {
		
		//for(Attraction att : attractions) {
			
		
		//if(attractions.get(0).getName().equals(a.getName())) {
			
			//throw new DuplicateNameException(" 중복된 이름입니다 "); 
		 // }
	   //}
		nameCheck(a.getName());
		attractions.add(a);
	}
	
    private void nameCheck(String name) {
    	for(Attraction att : attractions) {
    		if(att.getName().equals(name)) {
    			throw new DuplicateNameException(" 있잖아 바보얌. ");
    		}
    	}
    	
    }
	
	public void deleteAttraction(String name) {
		
		/*
		if(attractions.get(0).getName().equals(name)) {
			attractions.remove(0);
		}
		if(attractions.get(1).getName().equals(name)) {
			attractions.remove(1);
		}
		if(attractions.get(2).getName().equals(name)) {
			attractions.remove(2);
		}
		*/
		for(int i = 0; i < attractions.size(); i++) {
			if(attractions.get(i).getName().equals(name)) {
				attractions.remove(i);
				break;			
			} 
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
















