package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import com.example.jdbcdemo.domain.Drink;
import org.junit.Test;

public class DrinkManagerTest {


	private DrinkManagerJDBC drinkManager = new DrinkManagerJDBC();
	
	private final static String NAME_1 = "Cola";
	private final static double PRICE_1 = 5.5;
	
	@Test
	public void checkConnection(){
		assertNotNull(drinkManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Drink drink = new Drink(NAME_1, PRICE_1);
		drinkManager.clearDrinks();
		assertEquals(1, drinkManager.addDrink(drink));
		
		List<Drink> drinks = drinkManager.getAllDrinks();
		Drink drinkRetrieved = drinks.get(0);
		assertEquals(NAME_1, drinkRetrieved.getName());
		assertEquals(PRICE_1, drinkRetrieved.getPrice(), 0.01);
		
	}

}
