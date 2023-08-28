package com.example.MVC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    SimpleBean simpleBeanConfigure(){
        // Khởi tạo một instance của SimpleBean và trả ra ngoài
        return new SimpleBean("lodadaaa");
    }
    @Bean("mysqlConnector")
    DatabaseConnector mysqlConfigure(SimpleBean simpleBean) { // SimpleBean được tự động inject vào.
        DatabaseConnector mySqlConnector = new MySqlConnector();
        mySqlConnector.setUrl("jdbc:mysql://host1:33060/" + simpleBean.getUsername());
        // Set username, password, format, v.v...
        return mySqlConnector;
    }
    @Bean("mysqlConnector")
    DatabaseConnector mysqlConfigure() {
        DatabaseConnector mySqlConnector = new MySqlConnector();
        mySqlConnector.setUrl("jdbc:mysql://host1:33060/loda1");
        // Set username, password, format, v.v...
        return mySqlConnector;
    }

    @Bean("mongodbConnector")
    DatabaseConnector mongodbConfigure() {
        DatabaseConnector mongoDbConnector = new MongoDbConnector();
        mongoDbConnector.setUrl("mongodb://mongodb0.example.com:27017/loda");
        // Set username, password, format, v.v...
        return mongoDbConnector;
    }

    @Bean("postgresqlConnector")
    DatabaseConnector postgresqlConfigure(){
        DatabaseConnector postgreSqlConnector = new PostgreSqlConnector();
        postgreSqlConnector.setUrl("postgresql://localhost/loda");
        // Set username, password, format, v.v...
        return postgreSqlConnector;
    }

    //Trong thực tế, việc sử dụng @Configuration là hết sức cần thiết,
    // và nó đóng vai trò là nơi cấu hình cho toàn bộ ứng dụng của bạn.
    // Một Ứng dụng sẽ có nhiều class chứa @Configuration và
    // mỗi class sẽ đảm nhận cấu hình một bộ phận gì đó trong ứng dụng.
}
//Đằng sau chương trình, Spring Boot lần đầu khởi chạy, ngoài việc đi tìm các @Component thì nó còn làm một nhiệm vụ nữa là tìm các class @Configuration.
//
//Đi tìm class có đánh dấu @Configuration
//Tạo ra đối tượng từ class có đánh dấu @Configuration
//tìm các method có đánh dấu @Bean trong đối tượng vừa tạo
//Thực hiện gọi các method có đánh dấu @Bean để lấy ra các Bean và đưa vào `Context.
//Ngoài ra, về bản chất, @Configuration cũng là @Component. Nó chỉ khác ở ý nghĩa sử dụng. (Giống với việc class được đánh dấu @Service chỉ nên phục vụ logic vậy).
//
//Copy
//@Target({ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Component // Nó được đánh dấu là Component
//public @interface Configuration {
//    @AliasFor(
//        annotation = Component.class
//    )
//    String value() default "";
//}
