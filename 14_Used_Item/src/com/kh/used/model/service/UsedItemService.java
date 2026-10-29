package com.kh.used.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.used.model.dto.UsedItem;

public class UsedItemService {
	
	private List<UsedItem> usedItems = new ArrayList<>(); {
	
	usedItems.add(new UsedItem("자전거", 80000, "중상", "하남"));
	usedItems.add(new UsedItem("리코더", 230000, "최상", "성남"));
	usedItems.add(new UsedItem("장수풍뎅이", 3000000, "허약", "낙원"));

	}
	public List<UsedItem> readUsedItems() {
		return usedItems;
	}
}