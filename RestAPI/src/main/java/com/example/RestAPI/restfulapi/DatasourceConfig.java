package com.example.RestAPI.restfulapi;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;


/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 6/16/2019
 * Github: https://github.com/loda-kun
 */
@Configuration
@RequiredArgsConstructor
public class DatasourceConfig {
    // inject bởi RequiredArgsConstructor
    private final UserRepository userRepository;

    @PostConstruct
    public void initData() {
        // Insert 100 User vào H2 Database sau khi
        // DatasourceConfig được khởi tạo
        final Random r = new Random();
        userRepository.saveAll(IntStream.range(0, 100)
                .mapToObj(i -> UserName.builder()
                        .name("name-" + i)
                        .type(r.nextDouble() >= 0.5 ? UserName.UserType.VIP : UserName.UserType.NORMAL)
                        .build())
                .collect(Collectors.toList())
        );
    }
}