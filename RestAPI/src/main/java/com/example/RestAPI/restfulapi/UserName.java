package com.example.RestAPI.restfulapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 6/16/2019
 * Github: https://github.com/loda-kun
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UserType type;
    private String name;
    public enum UserType {
        NORMAL, VIP;
    }
}