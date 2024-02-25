package com.gildedrose.updators;

import com.gildedrose.Item;

public enum ItemType {

	NORMAL_ITEM, AGED_BRIE, BACKSTAGE_PASS, SULFURAS, CONJURED;
	
	public static ItemType getItemType(Item item) {
		if (item.name.equals("Aged Brie")) return AGED_BRIE;
		else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) return BACKSTAGE_PASS;
		else if (item.name.equals("Sulfuras, Hand of Ragnaros")) return SULFURAS;
		else if (item.name.toLowerCase().contains("conjured")) return CONJURED;
		return NORMAL_ITEM;
	}
	
	public static String getItemString(ItemType type) {
		if (type == ItemType.AGED_BRIE) return "Aged Brie";
		else if (type == ItemType.BACKSTAGE_PASS) return "Backstage passes to a TAFKAL80ETC concert";
		else if (type == ItemType.SULFURAS) return "Sulfuras, Hand of Ragnaros";
		else if (type == ItemType.CONJURED) return "Conjured item";
		return "Normal item";
	}
}
