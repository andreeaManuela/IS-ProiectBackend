package com.backend.backend.Repository;

import com.backend.backend.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public  AppUser findByUsername(String username);
    public AppUser  findByEmail(String email);
    public AppUser findUserByIdClient(Long id);


}
