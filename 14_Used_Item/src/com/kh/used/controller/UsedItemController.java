package com.kh.used.controller;

import java.util.List;

import com.kh.used.model.dto.UsedItem;
import com.kh.used.model.service.UsedItemService;

public class UsedItemController {
	
	private UsedItemService uis = new UsedItemService();
	
	public List<UsedItem> readUsedItems() {
		return uis.readUsedItems();
	}

}
