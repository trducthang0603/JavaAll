package com.example.MVC;

import org.springframework.stereotype.Component;

@Component
public class Girl {
    String name;
    Girl(String Name){
        this.name = Name;
    }
    Girl(){
        this.name = "";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "Girl ("+this.name+ ")";
    }
}
