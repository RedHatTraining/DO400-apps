package com.redhat.shipping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingCalculatorTest {

    // @todo: add tests

@Test
public void canCalculateTheCostForARegion() {
	ShippingCalculator calculator = new ShippingCalculator();

	assertEquals(0, calculator.costForRegion("A Region"));
}

@Test
public void onNARegionTheCostIs100() {
	// Given a shipping calculator
	ShippingCalculator calculator = new ShippingCalculator();
	
	//When NA is the country region
	int calculatedCost = calculator.costForRegion("NA");
	
	//Then the shipping cost is 100
	assertEquals(100, calculatedCost);
}

@Test
public void onLATAMRegionTheCostis200() {
	// Given a shipping calculator
	ShippingCalculator calculator = new ShippingCalculator();

	// When LATAM is the country region
	int calculatedCost = calculator.costForRegion("LATAM");

	// Then the shipping cost is 200
	assertEquals(200, calculatedCost);
}

@Test
public void onEMEARegionTheCostIs300() {
	// Given a shipping calculator
	ShippingCalculator calculator = new ShippingCalculator();

	// When EMEA is the country region
	int calculatedCost = calculator.costForRegion("EMEA");

	// Then the shipping cost is 300
	assertEquals(300, calculatedCost);
}
}
