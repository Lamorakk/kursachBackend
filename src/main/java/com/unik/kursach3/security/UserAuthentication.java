//package com.unik.kursach3.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
//public class UserAuthentication implements Authentication {
//    private final String email;
//    private final Collection<? extends GrantedAuthority> authorities;
//    private final Object details;
//    private boolean authenticated;
//
//    public UserAuthentication(String email, Collection<? extends GrantedAuthority> authorities, Object details) {
//        this.email = email;
//        this.authorities = authorities;
//        this.details = details;
//        this.authenticated = true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null; // Replace with actual credentials if necessary
//    }
//
//    @Override
//    public Object getDetails() {
//        return details;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return email;
//    }
//
//    @Override
//    public boolean isAuthenticated() {
//        return authenticated;
//    }
//
//    @Override
//    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
//        this.authenticated = isAuthenticated;
//    }
//
//    @Override
//    public String getName() {
//        return email;
//    }
//}
