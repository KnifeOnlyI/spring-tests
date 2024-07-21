package fr.koi.tests.springtests.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@AllArgsConstructor
public class AppUserDetails implements UserDetails {

    private String username;

    private String password;

    private Set<GrantedAuthority> roles;

    @Override
    public Set<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

}
