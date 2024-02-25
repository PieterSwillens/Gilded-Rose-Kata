package com.gildedrose;

class GildedRose {
    Item[] items;
    
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";  
    
    public static final int MAX_QUALITY_BOUNDARY = 50;
    public static final int MIN_QUALITY_BOUNDARY = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	
    	for (Item item : items) {
    		if(item.name.equals(SULFURAS)) continue;
    		
    		item.sellIn -= 1;
    		
    		if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASS)) {
    			updateIncreasingQualityProduct(item);
    		} else {
    			updateDecreasingQualityProduct(item);
    		}
    	}
    }
    
    private void updateIncreasingQualityProduct(Item item) {
    	if (item.name.equals(AGED_BRIE)) updateAgedBrie(item);
    	else updateBackstagePass(item);
    	
    	item.quality = checkMaxBoundaryNotExceeded(item.quality) ? item.quality : MAX_QUALITY_BOUNDARY;
    }
    
    private void updateDecreasingQualityProduct(Item item) {
    	if (item.name.toLowerCase().contains("conjured")) updateConjuredItem(item);
    	else updateNormalItem(item);
    	
    	item.quality = checkMinBoundaryNotExceeded(item.quality) ? item.quality : MIN_QUALITY_BOUNDARY;
    }
    
    private void updateNormalItem(Item item) {
    	item.quality -= item.sellIn < 0 ? 2 : 1;
    }
    
    private void updateAgedBrie(Item item) {
    	item.quality += item.sellIn < 0 ? 2 : 1;
    }
    
    private void updateBackstagePass(Item item) {
    	if (item.sellIn >= 0)
    		item.quality += item.sellIn < 11 ? (3-((int) Math.floor((item.sellIn)/5))) : 1;
    	else
    		item.quality = 0;
    	
    }
    
    private void updateConjuredItem(Item item) {
    	updateNormalItem(item);
    	updateNormalItem(item);
    }
    
    private boolean checkMinBoundaryNotExceeded(int quality) {			// Returns true if quality is greater than 0
    	return quality > MIN_QUALITY_BOUNDARY;
    }
    
    private boolean checkMaxBoundaryNotExceeded(int quality) {			// Returns true if quality is less than 50
    	return quality < MAX_QUALITY_BOUNDARY;
    }
}
