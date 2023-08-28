package com.example.RestAPI.restfulapi;

import java.util.List;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 6/16/2019
 * Github: https://github.com/loda-kun
 */

public interface UserRepository extends JpaRepository<UserName, Long>, JpaSpecificationExecutor<UserName> {
    List<UserName> findAllByNameLike(String name, Pageable pageable);
}