package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Drink;
import org.junit.Test;

public class DrinkManagerTest {


    private DrinkManagerJDBC drinkManager = new DrinkManagerJDBC();

    private final static String NAME_1 = "Cola";
    private final static String NAME_2 = "Fanta";
    private final static String NAME_3 = "Sprite";
    private final static double PRICE_1 = 5.5;
    private final static double PRICE_2 = 4.5;
    private final static double PRICE_3 = 3.5;

    @Test
    public void checkConnection() {
        assertNotNull(drinkManager.getConnection());
    }

    @Test
    public void checkAdding() {
        Drink drink = new Drink(NAME_1, PRICE_1);
        drinkManager.clearDrinks();
        assertEquals(1, drinkManager.addDrink(drink));
        List<Drink> drinks = drinkManager.getAllDrinks();
        Drink drinkRetrieved = drinks.get(0);
        assertEquals(NAME_1, drinkRetrieved.getName());
        assertEquals(PRICE_1, drinkRetrieved.getPrice(), 0.01);
    }

    @Test
    public void checkAddingListSuccess() {
        drinkManager.clearDrinks();
        List<Drink> listToAdd = new ArrayList<>();
        Drink drink1 = new Drink(NAME_1, PRICE_1);
        // Names should be unique
        Drink drink2 = new Drink(NAME_1, PRICE_2);
        Drink drink3 = new Drink(NAME_3, PRICE_3);
        listToAdd.add(drink1);
        listToAdd.add(drink2);
        listToAdd.add(drink3);
        drinkManager.addAllDrinks(listToAdd);
        List<Drink> drinks = drinkManager.getAllDrinks();
        // Should rollback
        assertEquals(0,drinks.size());
        drinkManager.clearDrinks();
        listToAdd.clear();
        // Fix drink name
        drink2.setName(NAME_2);
        listToAdd.add(drink1);
        listToAdd.add(drink2);
        listToAdd.add(drink3);
        drinkManager.addAllDrinks(listToAdd);
        drinks = drinkManager.getAllDrinks();
        // Should add all drinks
        assertEquals(3,drinks.size());
    }

    @Test
    public void checkDeleting() {
        Drink drink1 = new Drink(NAME_1, PRICE_1);
        drinkManager.clearDrinks();
        drinkManager.addDrink(drink1);
        drinkManager.removeDrink(NAME_1);
        List<Drink> drinks = drinkManager.getAllDrinks();
        assertEquals(0, drinks.size());
    }

    @Test
    public void checkDeletingSelected() {
        Drink drink1 = new Drink(NAME_1, PRICE_1);
        Drink drink2 = new Drink(NAME_2, PRICE_2);
        Drink drink3 = new Drink(NAME_3, PRICE_3);
        drinkManager.clearDrinks();
        List<Drink> drinkList = new ArrayList<>();
        drinkList.add(drink1);
        drinkList.add(drink2);
        drinkList.add(drink3);
        drinkManager.addAllDrinks(drinkList);
        drinkList.remove(drink1);
        drinkManager.removeSelectedDrinks(drinkList);
        List<Drink> drinks = drinkManager.getAllDrinks();
        // Should remove selected drinks except for one
        assertEquals(1,drinks.size());
        drinkManager.removeSelectedDrinks(drinkList);
        drinks = drinkManager.getAllDrinks();
        // Trying to remove already removed drinks
        assertEquals(1,drinks.size());
    }
}
