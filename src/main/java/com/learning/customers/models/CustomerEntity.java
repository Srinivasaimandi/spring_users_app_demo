package com.learning.customers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerEntity {

    @Id
    private int id;
    private String name;
    private String username;
    private String email;
    @JsonIgnore
    private String password = "$test123#";
//    @OneToMany
//    private List<CustomerOrder> customerOrders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

//    public List<CustomerOrder> getCustomerOrders() {
//        return customerOrders;
//    }
//
//    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
//        this.customerOrders = customerOrders;
//    }

    public CustomerEntity(int id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public CustomerEntity(int id, String name, String username, String email, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public CustomerEntity(int id) {
        Faker faker = new Faker();
        this.id = id;
        this.name = faker.name().fullName().replace("'", "");
        this.username = this.name.replaceAll(" ", "").toLowerCase();
        this.email = this.username+"@example.com";
    }

    public CustomerEntity() {
        Faker faker = new Faker();
        this.id = faker.number().numberBetween(10, 100);
        this.name = faker.name().fullName().replace("'", "");
        this.username = this.name.replaceAll(" ", "").toLowerCase();
        this.email = this.username+"@example.com";
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                //", password='" + password + '\'' +
                //", customerOrders=" + customerOrders +
                '}';
    }
}
