package com.gildedrose;

class GildedRose {
    Item[] items;
    
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";  

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	
    	for (Item item : items) {
    		item.sellIn -= item.name.equals(SULFURAS) ? 0 : 1;
    		
    		switch(item.name) {
    		case AGED_BRIE : {
    			item.quality += item.sellIn < 0 ? 2 : 1;
    			item.quality = item.quality > 50 ? 50 : item.quality;
    			break;
    		}
    		case BACKSTAGE_PASS : {
    			switch((int) Math.floor((item.sellIn) / 5)) {
    			case 0 : {
    				item.quality += 3;
    				break;
    			}
    			case 1 : {
    				item.quality += 2;
    				break;
    			}
    			case 2 : {
    				item.quality += 1;
    				break;
    			}
    			}
    			
    			item.quality = item.sellIn < 0 ? 0 : item.quality;
    			item.quality = item.quality > 50 ? 50 : item.quality;
    			break;
    		}
    		case SULFURAS : break;
    		default : {
    			item.quality -= item.sellIn < 0 ? 2 : 1;
    			item.quality = item.quality < 0 ? 0 : item.quality;
    			break;
    		}
    		}
    	} 
    }
}
