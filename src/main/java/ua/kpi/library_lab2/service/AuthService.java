package ua.kpi.library_lab2.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean authenticate(String username, String password) {
        return "adminlibrary".equals(username) && "7777".equals(password);
    }
}