package com.engine.wcode.domain.dto;

import com.wcode.annotations.Alias;

import javax.persistence.Table;

/**
 * @author Y-Aron
 * @version 1.0.0
 * @create 2019/10/8 9:23
 */
@Table(name = "hrmresource")
public class UserDTO {

    @Alias("xm")
    private String username;

    @Alias({"mm", "password"})

    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
