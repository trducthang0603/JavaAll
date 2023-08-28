package com.example.RestAPI.restfulapi;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

//
//import javax.persistence.*;
//
//import lombok.*;
//
//import java.util.Collection;
//
///**
// * Copyright 2019 {@author Loda} (https://loda.me).
// * This project is licensed under the MIT license.
// *
// * @since 4/5/2019
// * Github: https://github.com/loda-kun
// */
//@Entity
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class Person {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String name;
////    @ManyToOne
////    @JoinColumn(name = "address_id") // thông qua khóa ngoại address_id
////    @EqualsAndHashCode.Exclude
////    @ToString.Exclude
////    private Address address;
//// mappedBy trỏ tới tên biến persons ở trong Address.
//    @ManyToMany(mappedBy = "persons")
//    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
//    @EqualsAndHashCode.Exclude
//    //@Exclude
//    private Collection<Address> addresses;
//
//}
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


    // mappedBy trỏ tới tên biến persons ở trong Address.
    @ManyToMany(mappedBy = "persons")
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Address> addresses;
}