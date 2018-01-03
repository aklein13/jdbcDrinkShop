package com.example.shdemo.service;

import java.util.List;


import com.example.shdemo.domain.Company;
import com.example.shdemo.domain.Drink;
import com.example.shdemo.domain.Customer;

public interface SellingManager {

  void addDrink(Drink drink);

  void deleteDrink(Drink drink);

  Drink findDrink(Long id);

  List<Drink> getAllDrinks();

  void addCompany(Company comp);

  void deleteCompany(Company comp);

  Company findCompany(Long id);

  List getAllCompanies();

  void addCustomer(Customer customer);

  void deleteCustomer(Customer customer);

  Customer findCustomer(Long id);

  List<Customer> getAllCustomers();
}
