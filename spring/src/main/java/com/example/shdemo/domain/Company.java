package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "company.all", query = "select c from Company c"),
    @NamedQuery(name = "company.removeAll", query = "delete from Company")
})
public class Company {
  private long id;
  private String name;
  private String country;

  public Company() {
    super();
  }

  public Company(String name, String country) {
    this.name = name;
    this.country = country;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
