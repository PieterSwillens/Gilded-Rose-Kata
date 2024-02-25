package com.gildedrose.updators;

import com.gildedrose.Item;

public class ItemUpdateFactory implements ItemUpdator{

	@Override
	public void updateItem(Item item) {
		switch(ItemType.getItemType(item)) {
		case AGED_BRIE: new AgedBrieUpdator().updateItem(item);
			break;
		case BACKSTAGE_PASS: new BackstagePassUpdator().updateItem(item);
			break;
		case CONJURED: new ConjuredUpdator().updateItem(item);
			break;
		case NORMAL_ITEM: new NormalUpdator().updateItem(item);
			break;
		case SULFURAS: break;
		}
	}

}
