package com.kh.plant.view;

import java.util.List;
import java.util.Scanner;

import com.kh.plant.controller.PlantController;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantView {
	private Scanner sc = new Scanner(System.in);	
	private PlantController pc = new PlantController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 화초 관리 프로그램 ===");
			System.out.println(" 1. 화초 추가하기 ");
			System.out.println(" 2. 전체 조회하기 ");
			System.out.println(" 3. 화초 수정하기 ");
			System.out.println(" 0. 프로그램 종료하기 ");
			System.out.println(" 메뉴를 선택하세요 >");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : save(); break;
			case "2" : view(); break;
			case "3" : edit(); break;
			case "0" : sc.close(); return;
			default : System.out.println(" 존재하지 않는 메뉴입니다. ");		
			}
		}				
	}
	
	private void save() {
		System.out.println(" \n화초 추가하기 서비스입니다. ");
		System.out.println(" 화초 이름을 입력하세요 > ");
		String plantName = sc.nextLine();
		System.out.println(" 화초 종류를 입력하세요. ");
		String plantType = sc.nextLine();

		int result = pc.save(plantName, plantType);
		
		if(result > 0) {
			System.out.println(" 화초 추가에 성공했습니다. ");
		} else {
			System.out.println(" 화초 추가에 실패했습니다");
		}
	}
	
	private void view() {
		System.out.println(" 화초 목록입니다. ");
		// 화초데이터?
		
		// Controller에게 전체 데이터 요청
		List<HousePlantDto> plants = pc.view();
		
		// 조회결과가 앖을 수도 있음
		// 조회결과가 있을 수도 있음 
		if(plants.isEmpty()) {
			System.out.println(" 조회 결과가 존재하지 않습니다. ");
		} else {
			System.out.println("\n조회된 화초는 총 " + plants.size() + "개");
			for(HousePlantDto h : plants) {
				System.out.println("==============================");
				System.out.print(" 식물번호 : " + h.getPlantNo() + ", ");
				System.out.print(" 식물이름 : " + h.getPlantName() + ", ");
				System.out.print(" 식물종류 : " + h.getPlantType() + ",");
				System.out.println();
			}
		}
	}
	
	private void edit() {
		// PLANT_NO를 입력받아서
		// PLANT_NAME과 PLANT_TYPE을 수정하는 기능
		System.out.println(" 화초 수정 기능입니다. ");
		System.out.println(" 수정할 화초의 번호를 입력하세요 > ");
		int plantNo = sc.nextInt();
		sc.nextLine();
		System.out.print(" 새로운 화초의 분류를 입력하세요 > ");
		String plantType = sc.nextLine();
		System.out.print(" 새로운 화초의 이름을 입력하세요 > ");
		String plantName = sc.nextLine();
		
		int result = pc.edit(plantNo, plantType, plantName);
		
		// 성공 / 실패 여부를 판단하여 결과를 출력
		if(result > 0) {
			System.out.println(" 화초 정보 변경에 성공했습니다. ");
		} else {
			System.out.println(" 화초 정보 변경에 실패했습니다. ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
