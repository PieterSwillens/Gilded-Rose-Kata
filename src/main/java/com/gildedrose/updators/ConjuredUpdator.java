package com.gildedrose.updators;

import com.gildedrose.Item;

public class ConjuredUpdator implements ItemUpdator{

	@Override
	public void updateItem(Item item) {
		item.sellIn -= 1;
		item.quality -= item.sellIn < 0 ? 4 : 2;
		item.quality = item.quality < 0? 0 : item.quality;		
	}

}
