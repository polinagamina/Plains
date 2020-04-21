package com.example.gamina.tableObjects;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ADMIN, USER, MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }
}
