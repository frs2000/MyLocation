package javaclass;


import org.apache.log4j.Logger;

public class Controller {
    private String userName;
    private Double longitude ;
    private Double latitude;
    private static final Logger log = Logger.getLogger(Controller.class);

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setCoordinates(Double latitude, Double longitude){
        this.longitude = latitude;
        this.latitude = longitude;
    }

    public void controlLogic() {
        Database database = new Database();
        if (database.containsUserName(userName) == true){
            database.addNameAndCoord(userName, longitude, latitude);
        }
        if (database.userEnteredCoordinates(userName, longitude, latitude) == false){
            if (database.placeNameAndTypeNull(userName, longitude, latitude) == true) {
            } else {
                if (database.anybodyEnteredCoordinates(longitude, latitude) == false){
                    if (database.placeNaATyNull(longitude, latitude) == true){
                    } else {
                        getParamFromJSON();
                    }
                }
            }
        }
    }

    void getParamFromJSON(){
        Parser parser = new Parser(longitude, latitude);

        log.info(parser.recPlaceName());
        log.info(parser.recPlaceType());
    }

    void workWithScanner(){

    }
}
