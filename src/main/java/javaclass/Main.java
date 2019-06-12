package javaclass;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.setUserName("nic");
        controller.setCoordinates(-38.487467,27.564564);
        log.info("Ok");
    }
}
