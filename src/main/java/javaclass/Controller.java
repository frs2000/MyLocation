package javaclass;

import org.apache.log4j.Logger;

public class Controller {
    private static final Logger log = Logger.getLogger(Controller.class);

    private String userName;
    private Double longitude ;
    private Double latitude;

    public void setUserName(String userName){
        this.userName = userName;
        //log.info(this.userName);
    }

    public void setCoordinates(Double longitude, Double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void controlLogic(){

    }







}
