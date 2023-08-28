package com.example.RestAPI.restfulapi;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 4/5/2019
 * Github: https://github.com/loda-kun
 */
// Kế thừa JpaRepository để giao tiếp với database
public interface AddressRepository extends JpaRepository<Address,Long> {
}
