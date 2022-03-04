package com.example.mqtest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String username;

    private String password;

    private Integer id;

    private Boolean enabled;
}
