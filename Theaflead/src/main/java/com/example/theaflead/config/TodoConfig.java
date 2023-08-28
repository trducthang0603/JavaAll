package com.example.theaflead.config;


import com.example.theaflead.model.TodoValidator;



public class TodoConfig {

    public TodoValidator validator() {
        return new TodoValidator();
    }
}
