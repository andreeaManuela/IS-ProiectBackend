package com.backend.backend.Model;

import javax.persistence.*;

@Entity
@Table (name = "orders")
public class Orders {

    private String description;

    @Id
    //genereaza automat id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrder;


    public Orders() {

    }

    public Orders(String description) {
        this.description = description;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdProduct(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
