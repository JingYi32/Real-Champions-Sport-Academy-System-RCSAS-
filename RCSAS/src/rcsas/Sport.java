
package rcsas;

public class Sport {
    private String id;
    private String name;
    private SportCentre Location;
    private String venue;
    private int no_hall;
    private int price;

    public Sport(String id, String name, SportCentre Location, String venue, int no_hall, int price) {
        this.id = id;
        this.name = name;
        this.Location = Location;
        this.venue = venue;
        this.no_hall = no_hall;
        this.price = price;
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

    public SportCentre getLocation() {
        return Location;
    }

    public void setLocation(SportCentre Location) {
        this.Location = Location;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getNo_hall() {
        return no_hall;
    }

    public void setNo_hall(int no_hall) {
        this.no_hall = no_hall;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
