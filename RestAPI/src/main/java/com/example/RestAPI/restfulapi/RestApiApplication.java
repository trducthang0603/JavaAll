package com.example.RestAPI.restfulapi;


//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//
//@RequiredArgsConstructor
//@SpringBootApplication
//public class RestApiApplication implements CommandLineRunner {
//	public static void main(String[] args) {
//		SpringApplication.run(RestApiApplication.class, args);
//	}
//	private final PersonRepository personRepository;
//	private final AddressRepository addressRepository;
//	private final UserRepository userRepository;
//
//	@Transactional
//	@Override
//	public void run(String... args) throws Exception {
//		// Tạo ra đối tượng person
////		Person person = Person.builder()
////				.name("loda")
////				.build();
////		// Lưu vào db
////		personRepository.save(person);
////
////		// Tạo ra đối tượng Address có tham chiếu tới person
////		Address address = Address.builder()
////				.city("Hanoi")
////				.person(person)
////				.build();
////
////		// Lưu vào db
////		addressRepository.save(address);
////		Address address = new Address();
////		address.setCity("Hanoi");
////		Person person = new Person();
////		person.setName("loda");
////		person.setAddress(address);
////		address.setPersons(Collections.singleton(person));
////		addressRepository.saveAndFlush(address);
////		personRepository.findAll().forEach(p -> {
////			System.out.println(p.getId());
////			System.out.println(p.getName());
////			System.out.println(p.getAddress());
////		});
////		Address hanoi = Address.builder()
////				.city("hanoi")
////				.build();
////		Address hatay = Address.builder()
////				.city("hatay")
////				.build();
////
////		// Tạo ra đối tượng person
////		Person person1 = Person.builder()
////				.name("loda1")
////				.build();
////		Person person2 = Person.builder()
////				.name("loda2")
////				.build();
////
////		// set Persons vào address
////		hanoi.setPersons(Arrays.asList(person1, person2));
////		hatay.setPersons(Arrays.asList(person1, person2));
//////
//////		// Lưu vào db
//////		// Chúng ta chỉ cần lưu address, vì cascade = CascadeType.ALL nên nó sẽ lưu luôn Person.
////		addressRepository.saveAndFlush(hanoi);
////		addressRepository.saveAndFlush(hatay);
////		Address queryResult = addressRepository.findById(1L).get();
////		System.out.println(queryResult.getCity());
////		System.out.println(queryResult.getPersons());
////		Page<User> page = userRepository.findAll(PageRequest.of(0, 5));
////		// In ra 5 user đầu tiên
////		System.out.println("In ra 5 user đầu tiên: ");
////		page.forEach(System.out::println);
////		// Lấy ra 5 user tiếp theo
////		page = userRepository.findAll(page.nextPageable());
////
////		System.out.println("In ra 5 user tiếp theo: ");
////		page.forEach(System.out::println);
////
////		System.out.println("In ra số lượng user ở page hiện tại: " + page.getSize());
////		System.out.println("In ra tổng số lượng user: " + page.getTotalElements());
////		System.out.println("In ra tổng số page: " + page.getTotalPages());
////
////		// Lấy ra 5 user ở page 1, sort theo tên
////		page = userRepository.findAll(PageRequest.of(1, 5, Sort.by("name").descending()));
////		System.out.println("In ra 5 user page 1, sắp xếp theo name descending:");
////		page.forEach(System.out::println);
//
//		// Custom method
//		List<UserNew> list = userRepository.findAllByNameLike("name-%", PageRequest.of(0, 5));
//		System.out.println(list);
//
//	}
//}
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import lombok.RequiredArgsConstructor;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 6/16/2019
 * Github: https://github.com/loda-kun
 */
@SpringBootApplication
@RequiredArgsConstructor
public class RestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	private final UserRepository userRepository;
	private final CustomUserRepository customUserRepository;
	@Bean
	CommandLineRunner run() {
		return args -> {
			// Lấy ra 5 user đầu tiên
			// PageRequest.of(0,5) tương đương với lấy ra page đầu tiên, và mỗi page sẽ có 5 phần tử
//			Page<UserName> page = userRepository.findAll(PageRequest.of(0, 5));
//			// In ra 5 user đầu tiên
//			System.out.println("In ra 5 user đầu tiên: ");
//			page.forEach(System.out::println);
//			// Lấy ra 5 user tiếp theo
//			page = userRepository.findAll(page.nextPageable());
//
//			System.out.println("In ra 5 user tiếp theo: ");
//			page.forEach(System.out::println);
//
//			System.out.println("In ra số lượng user ở page hiện tại: " + page.getSize());
//			System.out.println("In ra tổng số lượng user: " + page.getTotalElements());
//			System.out.println("In ra tổng số page: " + page.getTotalPages());
//
//			// Lấy ra 5 user ở page 1, sort theo tên
//			page = userRepository.findAll(PageRequest.of(1, 5, Sort.by("name").descending()));
//			System.out.println("In ra 5 user page 1, sắp xếp theo name descending:");
//			page.forEach(System.out::println);
//
//			// Custom method
//			List<UserName> list = userRepository.findAllByNameLike("name-%", PageRequest.of(0, 5));
//			System.out.println(list);
			System.out.println(customUserRepository.getUserById(10L));
			System.out.println("=======");

			// Get User by Name Like and Type
			System.out.println(customUserRepository.getUserByComplexConditions("name-%", UserName.UserType.NORMAL));
			System.out.println("=======");
		};
	}

}