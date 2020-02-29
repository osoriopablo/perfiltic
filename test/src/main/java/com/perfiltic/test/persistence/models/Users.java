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



    public Users() {
    }

    public Users(long id, String username, String password, boolean isUsing2FA, String secret) {
        this.id = id;
        this.username = username;
        this.password = password;
        // this.isUsing2FA = isUsing2FA;
        // this.secret = Base32.random();
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

    // public boolean isIsUsing2FA() {
    //     return this.isUsing2FA;
    // }

    // public boolean getIsUsing2FA() {
    //     return this.isUsing2FA;
    // }

    // public void setIsUsing2FA(boolean isUsing2FA) {
    //     this.isUsing2FA = isUsing2FA;
    // }

    // public String getSecret() {
    //     return this.secret;
    // }

    // public void setSecret(String secret) {
    //     this.secret = secret;
    // }

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

    // public Users isUsing2FA(boolean isUsing2FA) {
    //     this.isUsing2FA = isUsing2FA;
    //     return this;
    // }

    // public Users secret(String secret) {
    //     this.secret = secret;
    //     return this;
    // }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            // ", isUsing2FA='" + isIsUsing2FA() + "'" +
            // ", secret='" + getSecret() + "'" +
            "}";
    }
    

}