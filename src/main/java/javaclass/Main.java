package javaclass;

//import org.apache.log4j.Logger;

public class Main {
    //private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.setUserName("lim");
        controller.setCoordinates(39.750307,-104.999472);
        controller.controlLogic();
    }
}
