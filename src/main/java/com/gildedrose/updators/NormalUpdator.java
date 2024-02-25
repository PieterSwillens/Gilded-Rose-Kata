package com.gildedrose.updators;

import com.gildedrose.Item;

public class NormalUpdator implements ItemUpdator{

	@Override
	public void updateItem(Item item) {
		item.sellIn -= 1;
		item.quality -= item.sellIn < 0 ? 2 : 1;
		item.quality = item.quality < 0? 0 : item.quality;
	}

}
