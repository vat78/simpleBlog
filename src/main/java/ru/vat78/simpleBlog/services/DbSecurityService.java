package ru.vat78.simpleBlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vat78.simpleBlog.dao.UsersDao;
import ru.vat78.simpleBlog.model.User;


import java.util.List;

@Service
public class DbSecurityService implements UserDetailsService {

    @Autowired
    UsersDao users;

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        UserDetails user;
        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
        auths.add(new SimpleGrantedAuthority("ROLE_USER"));

        try {
            User client = users.findByUsername(name);
            if (client.isAdmin()) {
                auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                user = new org.springframework.security.core.userdetails.User(client.getName(),
                        client.getPassword(), auths);
            } else {
                user = new org.springframework.security.core.userdetails.User(client.getName(),
                        client.getPassword(), auths);
            }

        } catch (Exception problem) {
            throw new InternalAuthenticationServiceException(problem.getMessage(),problem);
        }

        return user;
    }
}
