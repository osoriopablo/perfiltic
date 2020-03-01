package com.perfiltic.test.persistence.models;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Product
 */
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"id"})})
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double weigth;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private Users users;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category categories;

    @ElementCollection
    @CollectionTable(name = "productImages",joinColumns = @JoinColumn(name = "productId"))
    @Column
    private List<String> productImages;


    public Product() {
    }

    public Product(long id, String name, String description, Double weigth, Double price, Users users, Category categories, List<String> productImages) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weigth = weigth;
        this.price = price;
        this.users = users;
        this.categories = categories;
        this.productImages = productImages;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeigth() {
        return this.weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Category getCategories() {
        return this.categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public List<String> getProductImages() {
        return this.productImages;
    }

    public void setProductImages(List<String> productImages) {
        this.productImages = productImages;
    }

    public Product id(long id) {
        this.id = id;
        return this;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public Product weigth(Double weigth) {
        this.weigth = weigth;
        return this;
    }

    public Product price(Double price) {
        this.price = price;
        return this;
    }

    public Product users(Users users) {
        this.users = users;
        return this;
    }

    public Product categories(Category categories) {
        this.categories = categories;
        return this;
    }

    public Product productImages(List<String> productImages) {
        this.productImages = productImages;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", weigth='" + getWeigth() + "'" +
            ", price='" + getPrice() + "'" +
            ", users='" + getUsers() + "'" +
            ", categories='" + getCategories() + "'" +
            ", productImages='" + getProductImages() + "'" +
            "}";
    }


    
}