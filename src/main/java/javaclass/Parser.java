package javaclass;

//https://github.com/nudlesoup/Little-to-Middle-Indian-Conversion-of-UUID/commit/d0b34e2bc5ed1dbc9f2c1ac8f4466cb8ebddec22
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;


public class Parser {
    private String key = "SbahmMbplizqQrhsuAmGlB1EI2iVZv0L";
    private String myURL;
    private String jsStr;
    private static final Logger log = Logger.getLogger(Parser.class);


    Parser( Double latitude, Double longitude){
        createURL (latitude, longitude);
        recJsonString();
    }

    void createURL(Double latitude,  Double longitude){
        myURL = "http://www.mapquestapi.com/search/v2/radius?key="+key+"&maxMatches=4&origin="+latitude+","+longitude+"";
        log.info(myURL);
    }

    void recJsonString() {
        InputStream inpStr;
        BufferedReader bufRead;
        try {
            inpStr = new URL(myURL).openStream();
            bufRead = new BufferedReader(new InputStreamReader(inpStr, Charset.forName("UTF-8")));
            jsStr = bufRead.readLine();
            System.out.println("jsonString =" + jsStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String recPlaceName(){
        String placeName = "";
        try {
            JSONObject jsObj = new JSONObject(jsStr);
            JSONArray jsArr_searchResults = jsObj.getJSONArray("searchResults");
            JSONObject jsObj_get_name = new JSONObject(jsArr_searchResults.get(1).toString());
            placeName = jsObj_get_name.get("name").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return placeName;
    }


    String recPlaceType(){
        String placeType = "";
        try {
            JSONObject jsObj = new JSONObject(jsStr);
            JSONArray jsArr_searchResults = jsObj.getJSONArray("searchResults");
            JSONObject jsObj_fields  = new JSONObject(jsArr_searchResults.get(1).toString());

            //it is a String already (not [])
            String tempString = jsObj_fields.get("fields").toString();
            JSONObject jsObj333 = new JSONObject(tempString);
            placeType = jsObj333.getString("group_sic_code_name");
            //System.out.println("jsObj333 = " + jsObj333.getString("disp_lng"));
            //System.out.println("jsObj333 = " + jsObj333.getString("disp_lat"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return placeType;
    }



}
