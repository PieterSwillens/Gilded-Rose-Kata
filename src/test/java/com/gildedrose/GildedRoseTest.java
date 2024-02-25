package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.ItemSelectable;

class GildedRoseTest {

	private GildedRose app;
	private Item item;

	private void makeAppAndUpdate(Item[] items) {
		app = new GildedRose(items);
		app.updateQuality();
		this.item = app.items[0];
	}

	@Test
	void NormalItem_SellInPositive_QualityReducedByOne() {
		Item[] items = new Item[] {new Item("Normal Item", 10, 10)};
		makeAppAndUpdate(items);
		assertEquals(9, item.sellIn);
		assertEquals(9, item.quality);
	}

	@ParameterizedTest
	@ValueSource (ints = {0, -7})
	void NormalItem_SellInNegativeOrZero_QualityReducedByTwo(int sellIn) {
		Item[] items = new Item[] {new Item("Normal Item", sellIn, 10)};
		makeAppAndUpdate(items);
		assertEquals(sellIn-1, item.sellIn);
		assertEquals(8, item.quality);
	}

	@Test
	void NormalItem_QualityZeroBeforeUpdateQuality_QualityRemainsZero() {
		Item[] items = new Item[] {new Item("Normal Item", 5, 0)};
		makeAppAndUpdate(items);
		assertEquals(4, item.sellIn);
		assertEquals(0, item.quality);
	}

	@Test
	void NormalItem_SellInNegativeAndQualityOne_QualityReducedByOne() {
		Item[] items = new Item[] {new Item("Normal Item", -1, 1)};
		makeAppAndUpdate(items);
		assertEquals(-2, item.sellIn);
		assertEquals(0, item.quality);
	}

	@Test
	void AgedBrie_IncreasesValueByOne() {
		Item[] items = new Item[] {new Item(GildedRose.AGED_BRIE, 10, 10)};
		makeAppAndUpdate(items);
		assertEquals(9, item.sellIn);
		assertEquals(11, item.quality);
	}

	@Test
	void AgedBrie_QualityEqualsFifty_QualityDoesNotIncrease() {
		Item[] items = new Item[] {new Item(GildedRose.AGED_BRIE, 10, 50)};
		makeAppAndUpdate(items);
		assertEquals(9, item.sellIn);
		assertEquals(50, item.quality);
	}

	@Test
	void AgedBrie_SellInNegative_QualityIncreasesByTwo() {
		Item[] items = new Item[] {new Item(GildedRose.AGED_BRIE, 0, 36)};
		makeAppAndUpdate(items);
		assertEquals(-1, item.sellIn);
		assertEquals(38, item.quality);
	}

	@Test
	void AgedBrie_SellInNegativeAndQualityFortyNine_QualityIncreasesByOne() {
		Item[] items = new Item[] {new Item(GildedRose.AGED_BRIE, 0, 49)};
		makeAppAndUpdate(items);
		assertEquals(-1, item.sellIn);
		assertEquals(50, item.quality);
	}

	@Test
	void BackstagePass_SellInGreaterThanTen_QualityIncreasedByOne() {
		Item[] items = new Item[] {new Item(GildedRose.BACKSTAGE_PASS, 15,15)};
		makeAppAndUpdate(items);
		assertEquals(14, item.sellIn);
		assertEquals(16, item.quality);
	}

	@ParameterizedTest
	@ValueSource (ints = {10, 8, 6})
	void BackstagePass_SellInGreaterThanFiveLowerThanEleven_QualityIncreasesByTwo(int sellIn) {
		Item[] items = new Item[] {new Item(GildedRose.BACKSTAGE_PASS, sellIn, 15)};
		makeAppAndUpdate(items);
		assertEquals(sellIn-1, item.sellIn);
		assertEquals(17, item.quality);
	}

	@ParameterizedTest
	@ValueSource (ints = {5, 3, 1})
	void BackstagePass_SellInPositiveAndLessThanSix_QualityIncreasesByThree(int sellIn) {
		Item[] items = new Item[] {new Item(GildedRose.BACKSTAGE_PASS, sellIn, 15)};
		makeAppAndUpdate(items);
		assertEquals(sellIn-1, item.sellIn);
		assertEquals(18, item.quality);
	}

	@ParameterizedTest
	@ValueSource (ints = {3,7,12})
	void BackstagePass_SellInPositiveAndQualityFortyNine_QualityIsFifty(int sellIn) {
		Item[] items = new Item[] {new Item(GildedRose.BACKSTAGE_PASS, sellIn, 49)};
		makeAppAndUpdate(items);
		assertEquals(sellIn-1, item.sellIn);
		assertEquals(50, item.quality);
	}

	@Test
	void BackstagePass_SellInZero_QualityEqualsZero() {
		Item[] items = new Item[] {new Item(GildedRose.BACKSTAGE_PASS, 0, 15)};
		makeAppAndUpdate(items);
		assertEquals(-1, item.sellIn);
		assertEquals(0, item.quality);
	}

	@Test
	void Sulfuras_QualityStaysConstant() {
		Item[] items = new Item[] {new Item(GildedRose.SULFURAS, 0, 65)};
		makeAppAndUpdate(items);
		assertEquals(0, item.sellIn);
		assertEquals(65, item.quality);
	}

	@Test
	void Conjured_SellInPositive_QualityReducedByTwo() {
		Item[] items = new Item[] {new Item("Conjured Item", 10, 10)};
		makeAppAndUpdate(items);
		assertEquals(9, item.sellIn);
		assertEquals(8, item.quality);
	}

	@ParameterizedTest
	@ValueSource (ints = {0, -7})
	void ConjuredItem_SellInNegativeOrZero_QualityReducedByFour(int sellIn) {
		Item[] items = new Item[] {new Item("Conjured Item", sellIn, 10)};
		makeAppAndUpdate(items);
		assertEquals(sellIn-1, item.sellIn);
		assertEquals(6, item.quality);
	}

	@Test
	void ConjuredItem_QualityZeroBeforeUpdateQuality_QualityRemainsZero() {
		Item[] items = new Item[] {new Item("Conjured Item", 10, 0)};
		makeAppAndUpdate(items);
		assertEquals(9, item.sellIn);
		assertEquals(0, item.quality);
	}

	@ParameterizedTest
	@ValueSource (ints = {1,2,3})
	void ConjuredItem_SellInNegativeAndQualityLessThanFour_QualityIsZero(int quality) {
		Item[] items = new Item[] {new Item("Conjured Item", 0, quality)};
		makeAppAndUpdate(items);
		assertEquals(-1, item.sellIn);
		assertEquals(0, item.quality);
	}
}
