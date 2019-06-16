package com.example.security.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
