package com.example.jdbcdemo.service;

import java.util.List;

import com.example.jdbcdemo.domain.Drink;

public interface DrinkManager {
	
	public int addDrink(Drink drink);
	public List<Drink> getAllDrinks();

}
