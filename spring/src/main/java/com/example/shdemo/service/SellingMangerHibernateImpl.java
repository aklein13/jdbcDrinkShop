package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.shdemo.domain.Company;
import com.example.shdemo.domain.Drink;


@Component
@Transactional
public class SellingMangerHibernateImpl implements SellingManager {

  @Autowired
  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void addDrink(Drink drink) {
    sessionFactory.getCurrentSession().clear();
    sessionFactory.getCurrentSession().persist(drink);
  }

  @Override
  public void deleteDrink(Drink drink) {
    sessionFactory.getCurrentSession().delete(drink);
  }

  @Override
  public Drink findDrink(Long id) {
    return (Drink) sessionFactory.getCurrentSession().get(Drink.class, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Drink> getAllDrinks() {
    return sessionFactory.getCurrentSession().getNamedQuery("drink.all").list();
  }

  @Override
  public void addCompany(Company comp) {
    sessionFactory.getCurrentSession().persist(comp);
  }

  @Override
  public void deleteCompany(Company comp) {
    sessionFactory.getCurrentSession().delete(comp);
  }

  @Override
  public Company findCompany(Long id) {
    return (Company) sessionFactory.getCurrentSession().get(Company.class, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Company> getAllCompanies() {
    return sessionFactory.getCurrentSession().getNamedQuery("company.all").list();
  }

  @Override
  public void addCustomer(Customer customer) {
    sessionFactory.getCurrentSession().persist(customer);
  }

  @Override
  public void deleteCustomer(Customer customer) {
    sessionFactory.getCurrentSession().delete(customer);
  }

  @Override
  public Customer findCustomer(Long id) {
    return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Customer> getAllCustomers() {
    return sessionFactory.getCurrentSession().getNamedQuery("customer.all").list();
  }

}
