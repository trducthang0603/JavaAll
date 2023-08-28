package com.example.MVC;
//@Configuration là một Annotation đánh dấu trên một Class cho phép Spring Boot
// biết được đây là nơi định nghĩa ra các Bean.
//
//@Bean là một Annotation được đánh dấu trên các method cho phép Spring Boot
// biết được đây là Bean và sẽ thực hiện đưa Bean này vào Context.
//
//@Bean sẽ nằm trong các class có đánh dấu @Configuration.
public class SimpleBean {
    private String username;

    public SimpleBean(String username) {
        setUsername(username);
    }

    @Override
    public String toString() {
        return "This is a simple bean, name: " + username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
