package com.backend.backend.Model;

public class ForgotPasswordUser {
    private String email, username;
    private String newPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public ForgotPasswordUser(String username, String email, String newPassword){
        this.email=email;
        this.username=username;
        this.newPassword=newPassword;
    }


}
