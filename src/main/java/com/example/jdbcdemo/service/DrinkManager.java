package com.example.jdbcdemo.service;

import java.sql.SQLException;
import java.util.List;

import com.example.jdbcdemo.domain.Drink;

public interface DrinkManager {
	
	public int addDrink(Drink drink);
	public List<Drink> getAllDrinks();
	public void addAllDrinks(List<Drink> list);
	public void removeDrink(String name);
	public void removeSelectedDrinks(List<Drink> list);
}
