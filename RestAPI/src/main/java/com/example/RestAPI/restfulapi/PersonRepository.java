package com.example.RestAPI.restfulapi;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 4/5/2019
 * Github: https://github.com/loda-kun
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}