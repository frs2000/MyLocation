package javaclass;

//http://java-online.ru/hibernate-hql.xhtml
import entities.CoordRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Database {

    //try - if yes (== 0 - not exist), false - if no (!= 0 - exist)
    boolean containsParameters(String requestHQL){
        Configuration config = new Configuration().configure();
        ServiceRegistry servRegis = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sesFact = config.buildSessionFactory(servRegis);
        Session session = sesFact.openSession();
        String reqHQL = requestHQL;
        List<CoordRequest> requestList = (List<CoordRequest>) session.createQuery(reqHQL).list();
        session.close();
        sesFact.close();
        return requestList.size() == 0;
    }

    boolean containsUserName(String userName){
        String requestHQL = "from CoordRequest where userNAme = '"+userName+"'";
        return containsParameters(requestHQL);
    }

    //specific use entered specific coordinates (100% match)
    boolean userEnteredCoordinates(String userName, Double longitude, Double latitude){
        String requestHQL = "from CoordRequest where userNAme = '"+userName+"' and longitude = '"+longitude+"' and latitude = '"+latitude+"'";
        return containsParameters(requestHQL);
    }

    boolean anybodyEnteredCoordinates(Double longitude, Double latitude){
        String requestHQL = "from CoordRequest where longitude = '"+longitude+"'and latitude = '"+latitude+"'";
        return containsParameters(requestHQL);
    }

    List<CoordRequest> containsParametersList(String requestHQL){
        Configuration config = new Configuration().configure();
        ServiceRegistry servRegis = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sesFact = config.buildSessionFactory(servRegis);
        Session session = sesFact.openSession();
        String reqHQL = requestHQL;
        List<CoordRequest> requestList = (List<CoordRequest>) session.createQuery(reqHQL).list();
        session.close();
        sesFact.close();
        return requestList;
    }

    //for specific user
    boolean placeNameAndTypeNull (String userName, Double longitude, Double latitude){
        String requestHQL = "from CoordRequest where userNAme = '"+userName+"' and longitude = '"+longitude+"' and latitude = '"+latitude+"'";
        List<CoordRequest> requestList = containsParametersList(requestHQL);
        for(int i  = 0 ; i<requestList.size(); i++){
            CoordRequest tempCoordRec = requestList.get(i);
            if (tempCoordRec.getPlaceName() != null && tempCoordRec.getPlaceType() != null ){
                return true; //we  have data and get this data from our database
            }
        }
        return false;
    }

    //for any users
    boolean placeNaATyNull (Double longitude, Double latitude){
        String requestHQL = "from CoordRequest where longitude = '"+longitude+"' and latitude = '"+latitude+"'";
        List<CoordRequest> requestList = containsParametersList(requestHQL);
        for(int i  = 0 ; i<requestList.size(); i++){
            CoordRequest tempCoordRec = requestList.get(i);
            if (tempCoordRec.getPlaceName() != null && tempCoordRec.getPlaceType() != null ){
                return true; //we  have data and get this data from our database
            }
        }
        return false;
    }


    void createdRecords(CoordRequest request){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExample1");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("--------------------------------");
        CoordRequest req = request;
        em.persist(req);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    //request just with userName
    void addUserName(String userName){
        CoordRequest request = new CoordRequest(userName);
        createdRecords(request);
    }

    void addNameAndCoord(String userName, Double longitude, Double latitude){
        CoordRequest request = new CoordRequest(userName, longitude, latitude);
        createdRecords(request);
    }








}
