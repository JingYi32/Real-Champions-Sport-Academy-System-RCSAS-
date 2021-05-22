package rcsas;

public class Admin extends Role{
   
    public Admin(String id, String name, int pin) {
        this.id = id;
        this.name = name;
        this.pin = pin;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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