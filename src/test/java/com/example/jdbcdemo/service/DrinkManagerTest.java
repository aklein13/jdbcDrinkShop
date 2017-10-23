package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import com.example.jdbcdemo.domain.Drink;
import org.junit.Test;

public class DrinkManagerTest {
	
	
	DrinkManagerJDBC personManager = new DrinkManagerJDBC();
	
	private final static String NAME_1 = "Zenek";
	private final static int YOB_1 = 1945;
	
	@Test
	public void checkConnection(){
		assertNotNull(personManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Drink drink = new Drink(NAME_1, YOB_1);
		
		personManager.clearPersons();
		assertEquals(1,personManager.addDrink(drink));
		
		List<Drink> drinks = personManager.getAllDrinks();
		Drink drinkRetrieved = drinks.get(0);
		
		assertEquals(NAME_1, drinkRetrieved.getName());
		assertEquals(YOB_1, drinkRetrieved.getPrice());
		
	}

}
