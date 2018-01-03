package com.example.shdemo.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Company;
import com.example.shdemo.domain.Drink;
import com.example.shdemo.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class SellingManagerTest {

  @Autowired
  SellingManager sellingManager;

  @Test
  public void addDrinkCheck() {
    Drink drink = new Drink();
    drink.setPrice(2.3);
    drink.setName("Woda");
    Company company = new Company("Wody", "Polska");
    drink.setCompany(company);
    Customer customer1 = new Customer("Marek", "Piła", 7);
    Customer customer2 = new Customer("Marian", "Lipa", 13);
    List<Customer> orders = new ArrayList<Customer>();
    orders.add(customer1);
    orders.add(customer2);
    drink.setCustomers(orders);
    List<Drink> stateBefore = sellingManager.getAllDrinks();
    sellingManager.addDrink(drink);
    List<Drink> stateAfter = sellingManager.getAllDrinks();
    assertEquals(stateBefore.size() + 1, stateAfter.size());
  }

  @Test
  public void deleteDrinkCheck() {
    Drink drink = new Drink();
    drink.setPrice(6.66);
    drink.setName("Fanta");
    sellingManager.addDrink(drink);
    List<Drink> stateBefore = sellingManager.getAllDrinks();
    sellingManager.deleteDrink(drink);
    List<Drink> stateAfter = sellingManager.getAllDrinks();
    assertEquals(stateBefore.size(), stateAfter.size() + 1);
  }

  @Test
  public void findDrinkCheck() {
    Drink drink = new Drink();
    drink.setPrice(13.3);
    drink.setName("Jan");
    sellingManager.addDrink(drink);
    Drink found = sellingManager.findDrink(drink.getId());
    assertEquals(drink.getPrice(), found.getPrice(), 0.01);
    assertEquals(drink.getName(), found.getName());
  }

  @Test
  public void addCompanyCheck() {
    Company company = new Company("Pepsi", "USA");
    List stateBefore = sellingManager.getAllCompanies();
    sellingManager.addCompany(company);
    List stateAfter = sellingManager.getAllCompanies();
    assertEquals(stateBefore.size() + 1, stateAfter.size());
  }

  @Test
  public void deleteCompanyCheck() {
    Company company = new Company("NewCompany", "Niemcy");
    sellingManager.addCompany(company);
    List stateBefore = sellingManager.getAllCompanies();
    sellingManager.deleteCompany(company);
    List stateAfter = sellingManager.getAllCompanies();
    assertEquals(stateBefore.size(), stateAfter.size() + 1);
  }

  @Test
  public void findCompanyCheck() {
    Company company = new Company("Coke", "Kanada");
    sellingManager.addCompany(company);
    Company found = sellingManager.findCompany(company.getId());
    assertEquals(company.getName(), found.getName());
    assertEquals(company.getCountry(), found.getCountry());
  }

  @Test
  public void addCustomerCheck() {
    Customer customer = new Customer("Maria", "Nowa", 70);
    List<Customer> stateBefore = sellingManager.getAllCustomers();
    sellingManager.addCustomer(customer);
    List<Customer> stateAfter = sellingManager.getAllCustomers();
    assertEquals(stateBefore.size() + 1, stateAfter.size());
  }

  @Test
  public void deleteCustomerCheck() {
    Customer customer = new Customer("Krzysztof", "Nowak", 24);
    sellingManager.addCustomer(customer);
    List<Customer> stateBefore = sellingManager.getAllCustomers();
    sellingManager.deleteCustomer(customer);
    List<Customer> stateAfter = sellingManager.getAllCustomers();
    assertEquals(stateBefore.size(), stateAfter.size() + 1);
  }

  @Test
  public void findCustomerCheck() {
    Customer customer = new Customer("Michał", "Białek", 69);
    sellingManager.addCustomer(customer);
    Customer found = sellingManager.findCustomer(customer.getId());
    assertEquals(customer.getFirstName(), found.getFirstName());
    assertEquals(customer.getLastName(), found.getLastName());
    assertEquals(customer.getAge(), found.getAge());
  }

  @Test
  public void LazyExceptionTest() {
    Drink drink = new Drink();
    drink.setPrice(5.5);
    drink.setName("Cola");
    Company company = new Company("CocaCola", "USA");
    drink.setCompany(company);
    Customer customer1 = new Customer("Jan", "Kowalski", 23);
    Customer customer2 = new Customer("Stefan", "Pietrzyk", 16);
    List<Customer> orders = new ArrayList<Customer>();
    orders.add(customer1);
    orders.add(customer2);
    drink.setCustomers(orders);
    sellingManager.addDrink(drink);
    List<Customer> owners = drink.getCustomers();
    try {
      System.out.println(owners.get(0).getFirstName());
      System.out.println(owners.get(1).getFirstName());
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
