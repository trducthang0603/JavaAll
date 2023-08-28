package com.example.MVC;

public class MongoDbConnector extends DatabaseConnector{
    @Override
    public void connect() {
        System.out.println("Đã kết nối tới Mongodb: " + getUrl());
    }
}
