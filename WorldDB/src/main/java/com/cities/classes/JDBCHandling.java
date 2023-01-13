package com.cities.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.cedarsoftware.util.io.JsonWriter;

public class JDBCHandling {
    public String getDistrict() {
    	ArrayList<String> districts = null;
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connector = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "Hari", "H@ri_005");
            Statement statementObj = connector.createStatement();
            ResultSet resSet = statementObj.executeQuery("SELECT DISTINCT(District) FROM city WHERE District LIKE '__%';");

            districts = new ArrayList<String>();
            while(resSet.next()){
                districts.add(resSet.getString(1));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    	String[] temp = new String[districts.size()];
    	temp = districts.toArray(temp);
    	String cntries = JsonWriter.objectToJson(temp);
    	
    	return cntries;
    }
    
    public String[] getCorrespondingCities(String district) {
    	ArrayList<String> cities = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connector = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "Hari", "H@ri_005");
    		Statement stmtObj = connector.createStatement();
    		ResultSet resultSet = stmtObj.executeQuery("SELECT Name FROM city WHERE District = '" + district + "';");
    		
    		cities = new ArrayList<String>();
    		while(resultSet.next()) {
    			cities.add(resultSet.getString(1));
    		}
    	}
    	catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	String[] citiesArray = new String[cities.size()];
    	citiesArray = cities.toArray(citiesArray);
    	
    	return citiesArray;
    }
}
