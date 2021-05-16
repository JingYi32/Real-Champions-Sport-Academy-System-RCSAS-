package rcsas;
public enum Sport {
    Swimming ("001", "Puchong", "Lane", 10, 145), 
    Badminton ("002", "Damansara", "Court", 8, 145), 
    Football ("003", "Subang", "Field", 1, 125), 
    Archery ("004", "Puchong", "Lane", 10, 150), 
    Gymnastics ("005", "Puchong", "", 5, 115), 
    Volleyball ("006", "Subang", "Court", 3, 135), 
    Basketball ("007", "Damansara", "Court", 2, 145), 
    Cricket ("008", "Subang", "Pitch", 1, 135), 
    Tennis ("009", "Subang", "Court", 3, 135), 
    TableTennis ("010", "Damansara", "Table", 8, 120);
    
    private final String sport_id;
    private final String sport_centre;
    private final String venue;
    private final int no_hall;
    private final int price;
    
    Sport(String sport_id, String sport_centre,String venue, int no_hall, int price){
        this.sport_id = sport_id;
        this.sport_centre = sport_centre;
        this.venue = venue;
        this.no_hall = no_hall;
        this.price = price;
    }

    public String getSport_id() {
        return sport_id;
    }

    public String getSport_centre() {
        return sport_centre;
    }

    public String getVenue() {
        return venue;
    }

    public int getNo_hall() {
        return no_hall;
    }

    public int getPrice() {
        return price;
    }
    
    
}
