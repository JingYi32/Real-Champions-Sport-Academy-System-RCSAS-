package rcsas;

import java.util.ArrayList;

public class Admin {
    private String name;
    private int pin;    
   
    public Admin(String name, int pin) {
        this.name = name;
        this.pin = pin;
    }    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
}