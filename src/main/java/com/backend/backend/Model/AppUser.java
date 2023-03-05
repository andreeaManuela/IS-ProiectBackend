package com.backend.backend.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "AppUser")
public class AppUser {


    private String firstname;
    private String lastname;
    private  String email;
    private String phone;


    //arata ca id este primary key
    @Id
    //genereaza automat id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idClient;

    @Column(unique = true)
    private String username;
    private String password;



    public AppUser() {

    }
    public AppUser(String firstname, String lastname, String email, String phone, Integer idClient, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.idClient = idClient;
        this.username = username;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "ID Client:" +getIdClient();
    }



}


