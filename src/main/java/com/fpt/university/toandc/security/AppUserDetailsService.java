package com.fpt.university.toandc.security;

import com.fpt.university.toandc.model.Role;
import com.fpt.university.toandc.model.User;
import com.fpt.university.toandc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ToanQri on 9/20/2016.
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("userService null: " + (userService == null));
        User user = userService.findByUsername(username);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        System.out.println("User Role : " + user.getRole().getRoleName());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
