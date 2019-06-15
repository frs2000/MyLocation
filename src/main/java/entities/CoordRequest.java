package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoordRequest {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private Double longitude;
    private Double latitude;
    private String confirmStatus; //that person is in the right place! Yes or No


    private String placeName;
    private String placeType;

    public CoordRequest() {
    }

    public CoordRequest(String userName){
        this.userName = userName;
    }

    public CoordRequest(String userName, Double longitude, Double latitude) {
        this.userName = userName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceType() {
        return placeType;
    }

}
