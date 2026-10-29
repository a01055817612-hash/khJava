package com.kh.khworld.run;

import com.kh.khworld.model.service.KhWorldService;
import com.kh.khworld.view.KhWorldView;

public class KhWorldRun {

	public static void main(String[] args) {
		
		KhWorldView kwv = new KhWorldView();
		KhWorldService kws = new KhWorldService();
		kws.readAttractions();
		
		new KhWorldView().mainMenu();
	}

}
