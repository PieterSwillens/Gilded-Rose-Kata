package com.gildedrose.updators;

import com.gildedrose.Item;

public class AgedBrieUpdator implements ItemUpdator{

	@Override
	public void updateItem(Item item) {
		item.sellIn -= 1;
		item.quality += item.sellIn < 0 ? 2 : 1;
		item.quality = item.quality > 50 ? 50 : item.quality;
	}

}
