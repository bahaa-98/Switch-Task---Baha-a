package com.example.demo.security;

import com.example.demo.domain.Driver;
import com.example.demo.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DriverRepo driverRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserByEmail(String email){
        Driver driver = driverRepo.findByEmail(email);

        return UserDetailsImpl.build(driver);
    }
}
