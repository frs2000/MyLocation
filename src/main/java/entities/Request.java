package entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Request {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private Double longitude;
    private Double latitude;
    private String confirmStatus; //that person in the right place! Yes or No
    private String placeName;
    private String placeType;

    public Request() {
    }

    public Request(String userName){
        this.userName = userName;
    }

    public Request(String userName, Double longitude, Double latitude) {
        this.userName = userName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Request(String userName, Double longitude, Double latitude, String confirmStatus, String placeName, String placeType) {
        this.userName = userName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.confirmStatus = confirmStatus;
        this.placeName = placeName;
        this.placeType = placeType;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getConfirmStatus() {
        return confirmStatus;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }
}
