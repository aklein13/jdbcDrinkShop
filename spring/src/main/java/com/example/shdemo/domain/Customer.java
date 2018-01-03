package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "customer.all", query = "Select c from Customer c")
})
public class Customer {
  private long id;
  private int age;
  private String firstName;
  private String lastName;

  public Customer(String firstName, String lastName, int age) {
    this.age = age;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Customer() {
    super();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
