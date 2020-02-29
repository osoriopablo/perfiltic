package com.perfiltic.test.persistence.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// import org.jboss.aerogear.security.otp.api.Base32;

/**
 * Users
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"username"})})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false )
    private String username;

    @Column(nullable = false )
    private String password;

    @OneToMany(cascade= CascadeType.ALL  , targetEntity = Category.class, mappedBy = "users")
    @JsonManagedReference
    private List<Category> categories;

    @OneToMany(cascade= CascadeType.ALL  , targetEntity = Product.class, mappedBy = "users")
    @JsonManagedReference
    private List<Product> products;




    public Users() {
    }

    public Users(long id, String username, String password, List<Category> categories, List<Product> products) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.categories = categories;
        this.products = products;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Users id(long id) {
        this.id = id;
        return this;
    }

    public Users username(String username) {
        this.username = username;
        return this;
    }

    public Users password(String password) {
        this.password = password;
        return this;
    }

    public Users categories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Users products(List<Product> products) {
        this.products = products;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", categories='" + getCategories() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }
    
    

}