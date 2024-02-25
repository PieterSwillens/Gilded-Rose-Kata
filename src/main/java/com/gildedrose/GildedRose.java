package com.gildedrose;

import com.gildedrose.updators.ItemUpdateFactory;

class GildedRose {
    Item[] items;
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	ItemUpdateFactory iuf = new ItemUpdateFactory();
    	for (Item item : items)
    		iuf.updateItem(item);
    }
}
