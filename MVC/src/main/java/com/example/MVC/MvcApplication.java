package com.example.MVC;

import com.example.MVC.others.OtherGirl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.example.MVC.others")
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "com.example.MVC.others")
public class MvcApplication {

	public static void main(String[] args) {

		ApplicationContext context	= SpringApplication.run(MvcApplication.class, args);

//	GirlService girlService = context.getBean(GirlService.class);
//	// Lấu ra random một cô gái từ tầng service
//	Girl girl = girlService.getRamdomGirl();
//	// In ra màn hình
//        System.out.println(girl);
		try {
			Girl girl = context.getBean(Girl.class);
			System.out.println("Bean: " + girl.toString());
		} catch (Exception e) {
			System.out.println("Bean Girl không ton tai");
		}

		try {
			OtherGirl otherGirl = context.getBean(OtherGirl.class);
			if (otherGirl != null) {
				System.out.println("Bean: " + otherGirl.toString());
			}
		} catch (Exception e) {
			System.out.println("Bean Girl không tồn tại");
		}
		// Lấy ra bean SimpleBean trong Context
//		SimpleBean simpleBean = context.getBean(SimpleBean.class);
//		// In ra màn hình
//		System.out.println("Simple Bean Example: " + simpleBean.toString());
		DatabaseConnector mysql = (DatabaseConnector) context.getBean("mysqlConnector");
		mysql.connect();

		DatabaseConnector mongodb = (DatabaseConnector) context.getBean("mongodbConnector");
		mongodb.connect();

		DatabaseConnector postgresql = (DatabaseConnector) context.getBean("postgresqlConnector");
		postgresql.connect();
	}
}
