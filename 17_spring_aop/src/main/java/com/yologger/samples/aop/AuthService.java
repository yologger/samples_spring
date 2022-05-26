package com.yologger.samples.aop;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public void logout() {
        System.out.println("logout()");
    }

    public void join(String email, String password) {
        System.out.println("join()");
    }
    public void login(String email, String password) {
        System.out.println("login()");
    }
}
