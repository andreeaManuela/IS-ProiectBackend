package com.backend.backend.Control;

import com.backend.backend.Login.LoginUser;
import com.backend.backend.Model.AppUser;
import com.backend.backend.Model.ForgotPasswordUser;
import com.backend.backend.Model.Orders;
import com.backend.backend.Model.Product;
import com.backend.backend.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {

    public Integer currentClientId;

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUser user) {

        return accountService.registerUser(user);
    }

    @GetMapping("/users")
    public List<AppUser> getUsers() {
        return accountService.getAllUsers();

    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return accountService.getAllProducts();
    }

    @PostMapping("/login")
    public AppUser getUser(@RequestBody LoginUser user) {
        boolean flag = false;//la inceput variabila este falsa deoarece nu stim daca clientul exista in baza de date
        // AppUser userFormDatabase = null;
        flag = accountService.loginValidation(user.getUsername(), user.getPassword());//functia care returneaza un user daca este gasit in baza de date
        AppUser userFormDatabase=null;
        if (flag == true) {
            userFormDatabase = accountService.getUserByUsername(user.getUsername());//daca flag=true am gasit clientul in baza de date
            currentClientId = userFormDatabase.getIdClient();
        }
        return userFormDatabase;//returnez user
    }

    @PostMapping("/forgot")
    public void changePass(@RequestBody ForgotPasswordUser userFromFrontend) {
        AppUser userFormDatabase;
        userFormDatabase=accountService.getUserByUsername(userFromFrontend.getUsername());
        if(userFromFrontend!=null)
        {
            String parolaCurenta=userFormDatabase.getPassword();
            String parolaNoua=userFromFrontend.getNewPassword();
            userFormDatabase.setPassword(parolaNoua);
            accountService.registerUser(userFormDatabase);
        }
    }

    @PostMapping("/items")
    public void getProduct(@RequestBody Product[] product) {
        Product productSelected=null;
        for(Product i:product)
        {
            productSelected=accountService.getProductsByName(i.getName());
            if(productSelected.getQuantity()>0) {
                productSelected.setQuantity(productSelected.getQuantity() - 1);
                accountService.UpdateProduct(productSelected);
            }
        }
    }

    @PostMapping("/orders")
    public Orders addNewOrder(@RequestBody List<Product> products)
    {
        String msg="Client ID" + Integer.toString(currentClientId) + "; ";
        System.out.println(products);
        for(Product item: products){
            msg=msg+ "ID Product: " + item.getIdProduct()+", Name: " +item.getName()+", Price: " +item.getPrice()+"; ";
        }
        Orders order =new Orders(msg);
        return accountService.addNewOrder(order);
    }

}
