package com.backend.backend.Service;

import com.backend.backend.Model.AppUser;
import com.backend.backend.Model.Orders;
import com.backend.backend.Model.Product;
import com.backend.backend.Repository.AppUserRepository;

import com.backend.backend.Repository.OrdersRepository;
import com.backend.backend.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccounServiceImpl implements AccountService {

    @Autowired
    private  AppUserRepository appUserRepo;
    @Autowired
    private ProductsRepository productsRepo;

    @Autowired
    private OrdersRepository ordersRepo;

    @Override
    public AppUser registerUser(AppUser appUser) {
       appUserRepo.save(appUser);
        return appUser;
    }

    @Override
    public Product UpdateProduct(Product product) {
        productsRepo.save(product);
        return product;
    }


    @Override
    public List<AppUser> getAllUsers() {

        return appUserRepo.findAll();
    }

    @Override
    public AppUser getUserByUsername(String username) {
       return  appUserRepo.findByUsername(username);
    }

    @Override
    public  boolean loginValidation (String username,String password)
    {
         AppUser user=appUserRepo.findByUsername(username);
         if(user!=null)
         {
             if(user.getPassword().equals(password)) return true;
             else return false;
         }
         return  false;
    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepo.findAll();
    }

    @Override
    public Product getProductsByName(String name) {
        return productsRepo.getProductsByName(name);
    }

    @Override
    public Product getProductsByDescription(String description) {
        return productsRepo.getProductsByDescription(description);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    @Override
    public Orders addNewOrder(Orders order) {
        ordersRepo.save(order);
        return order;
    }


}
