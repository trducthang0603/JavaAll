package com.example.ComponenAtutowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Nake implements Outfit{
    @Override
    public void wear(){
        System.out.println("Không mặc gì");
    }
}
