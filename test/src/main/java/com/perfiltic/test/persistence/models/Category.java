package com.perfiltic.test.persistence.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Category
 */
@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String image;

    @Column
    private String name;

    @Column
    private long parentCategory;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private Users users;



    public Category() {
    }

    public Category(long id, String image, String name, long parentCategory, Users users) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.parentCategory = parentCategory;
        this.users = users;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentCategory() {
        return this.parentCategory;
    }

    public void setParentCategory(long parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Category id(long id) {
        this.id = id;
        return this;
    }

    public Category image(String image) {
        this.image = image;
        return this;
    }

    public Category name(String name) {
        this.name = name;
        return this;
    }

    public Category parentCategory(long parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }

    public Category users(Users users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", image='" + getImage() + "'" +
            ", name='" + getName() + "'" +
            ", parentCategory='" + getParentCategory() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }
    


    
}