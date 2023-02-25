package com.drdaza.login_spring_security.users.domain.payloads;

public class UserPayLoad {
    
    private String username;
    private String password;
    
    public UserPayLoad() {
    }
    public UserPayLoad(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
