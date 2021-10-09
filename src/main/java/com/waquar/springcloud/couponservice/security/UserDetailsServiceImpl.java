package com.waquar.springcloud.couponservice.security;

import com.waquar.springcloud.couponservice.repository.UserRepository;
import com.waquar.springcloud.couponservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(s);
        if(user == null){
            throw new UsernameNotFoundException("Can not find user " + s);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
    }
}
