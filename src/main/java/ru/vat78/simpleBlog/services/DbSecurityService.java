package ru.vat78.simpleBlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vat78.simpleBlog.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DbSecurityService implements UserDetailsService {

    @Autowired
    UsersRepository users;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserDetails user;

        try {
            User client = users.findByUsername(userName);
            if (client.isAdmin()) {
                user = new org.springframework.security.core.userdetails.User(client.getName(),
                        client.getPassword(), AdminAuthority.getAuth());
            } else {
                user = new org.springframework.security.core.userdetails.User(client.getName(),
                        client.getPassword(), DummyAuthority.getAuth());
            }

        } catch (Exception problem) {
            throw new UsernameNotFoundException(problem.getMessage(),problem);
        }

        return user;
    }

    static class DummyAuthority implements GrantedAuthority {

        static Collection<GrantedAuthority> getAuth()
        {
            List<GrantedAuthority> res = new ArrayList(1);
            res.add(new DummyAuthority());
            return res;
        }

        public String getAuthority() {
            return "USER";
        }
    }

    static class AdminAuthority implements GrantedAuthority {

        static Collection<GrantedAuthority> getAuth()
        {
            List<GrantedAuthority> res = new ArrayList(1);
            res.add(new DummyAuthority());
            return res;
        }

        public String getAuthority() {
            return "ADMIN";
        }
    }
}
