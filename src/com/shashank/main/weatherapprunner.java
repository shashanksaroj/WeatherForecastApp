package com.shashank.main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class weatherapprunner {

    public static Map<String,Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(str, new
                TypeToken<HashMap<String, Object>>() {
                }.getType());
        return map;
    }
        public static void api(String location) {

        String API_KEY = "key";
        String LOCATION = location;
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+ LOCATION +"&appid=" + API_KEY + "&units=imperial";


        try {

            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());


           Info.temp="Temperature: " + mainMap.get("temp");
            Info.hum= "Humidity: " + mainMap.get("humidity");
           Info.ws= "Wind Speed: " + windMap.get("speed");
           Info.wa ="Wind Angle: " + windMap.get("deg");


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    }
