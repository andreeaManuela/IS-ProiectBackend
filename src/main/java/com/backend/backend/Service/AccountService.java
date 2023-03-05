package com.backend.backend.Service;

import com.backend.backend.Model.AppUser;
import com.backend.backend.Model.Orders;
import com.backend.backend.Model.Product;

import java.util.List;

public interface AccountService {
    public AppUser registerUser(AppUser appUser);

    Product UpdateProduct(Product product);

    public List<AppUser> getAllUsers();

    public AppUser getUserByUsername(String username);
    public  boolean loginValidation (String username,String password);

    public List<Product> getAllProducts();

    public Product getProductsByName(String name);
    public Product getProductsByDescription(String description);

    public List<Orders> getAllOrders();

    public Orders addNewOrder(Orders order);

}
