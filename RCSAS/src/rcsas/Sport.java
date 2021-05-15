package rcsas;
public enum Sport {
    Swimming ("001", "Puchong", "Lane", 10), 
    Badminton ("002", "Damansara", "Court", 8), 
    Football ("003", "Subang", "Field", 1), 
    Archery ("004", "Puchong", "Lane", 10), 
    Gymnastics ("005", "Puchong", "", 5), 
    Volleyball ("006", "Subang", "Court", 3), 
    Basketball ("007", "Damansara", "Court", 2), 
    Cricket ("008", "Subang", "Pitch", 1), 
    Tennis ("009", "Subang", "Court", 3), 
    TableTennis ("010", "Damansara", "Table", 8);
    
    private final String sport_id;
    private final String sport_centre;
    private final String venue;
    private final int no_hall;
    
    Sport(String sport_id, String sport_centre,String venue, int no_hall){
        this.sport_id = sport_id;
        this.sport_centre = sport_centre;
        this.venue = venue;
        this.no_hall = no_hall;
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
    
    
}
