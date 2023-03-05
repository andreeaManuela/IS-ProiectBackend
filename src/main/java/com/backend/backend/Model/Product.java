package com.backend.backend.Model;

        import javax.persistence.*;
        import java.util.Date;
        import java.util.HashSet;
        import java.util.Set;

@Entity
@Table(schema = "Product")
public class Product {

    private int price;
    private String category;
    private String description;
    private int quantity;

    //arata ca id este primary key
    @Id
    //genereaza automat id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduct;

    @Column(unique = true)
    private String name;
    private String image;


    public Product() {

    }
    public Product(String name, int price, String category, String image, Integer idProduct, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.idProduct = idProduct;
        this.image=image;
        this.description=description;
        this.quantity=quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() { return quantity;   }

    public void setQuantity(int quantity) { this.quantity = quantity;    }

    public String toString(){
        return "Produse: "+ getName() + " " + " Suma Totala: "+ getPrice();
    }
}


