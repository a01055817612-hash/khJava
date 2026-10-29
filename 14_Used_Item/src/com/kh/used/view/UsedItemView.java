package com.kh.used.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.used.controller.UsedItemController;
import com.kh.used.model.dto.UsedItem;

public class UsedItemView {
	Scanner sc = new Scanner(System.in);
	private UsedItemController ctrl = new UsedItemController();
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println(" 중고매물 관리서버입니다. ");
			System.out.println();
			System.out.println(" 1. 매물 전체 조회하기 ");
			System.out.println(" 2. 매물 추가하기 ");
			System.out.println(" 3. 매물 삭제하기 ");
			System.out.println(" 4. 매물 검색하기 ");
			System.out.println(" 5. 매물 수정하기 ");
			System.out.println(" 0. 프로그램 종료하기 ");
			System.out.println();
			System.out.println(" 사용하실 메뉴를 입력해주세요 > ");
			
			int menu = 0;
			
			try {
				menu = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println(" 숫자만 입력하세요. ");
				continue;
			} finally {
				sc.nextLine();
			}
			
			switch(menu) {
			
			case 1 : readUsedItems(); break;
			
			case 2 : System.out.println(" 2. 추가중 "); break;
			
			case 3 : System.out.println(" 3. 삭제중 "); break;
			
			case 4 : System.out.println(" 4. 검색중 "); break;
			
			case 5 : System.out.println(" 5. 수정중 "); break;
			
			case 0 : System.out.println(" 프로그램을 종료합니다. "); sc.close(); return;
			
			default : System.out.println(" 없는 메뉴를 선택하셨습니다. ");
			}
		}
	}
	private void readUsedItems() {
		List<UsedItem> list = ctrl.readUsedItems();		
	}

}
