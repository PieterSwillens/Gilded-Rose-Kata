package com.gildedrose.updators;

import com.gildedrose.Item;

public class BackstagePassUpdator implements ItemUpdator{

	@Override
	public void updateItem(Item item) {
		item.sellIn -= 1;
		
		if (item.sellIn >= 0) {
    		item.quality += item.sellIn < 11 ? (3-((int) Math.floor((item.sellIn)/5))) : 1;
    		item.quality = item.quality > 50 ? 50 : item.quality;
		}
    	else
    		item.quality = 0;
	}

}
