package org.lind.devops.main;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.lind.devops.domain.Animal;
import org.lind.devops.domain.Lion;
import org.lind.devops.domain.Monkey;

public class TestMain {

	static List<Animal> animals;

	public static void main(String[] args) {
		// Init animals
		animals = new ArrayList<Animal>();
		animals.add(new Monkey("Cheeta"));
		animals.add(new Lion("Mufasa"));
		animals.add(new Lion("Nala"));
		animals.add(new Lion("Simba"));
		animals.add(new Monkey("Tuco"));

		List<String> users = getUsers();
		int foodPerUser = Integer.valueOf(args[0]);
		for (String user : users) {
			feedAnimals(user, foodPerUser);
		}

	}

	private static void feedAnimals(String user, int foodUnits) {

	}

	private static List<String> getUsers() {
		List<String> users = new ArrayList<String>();
		String urls = "http://jsonplaceholder.typicode.com/users";
		

		try
		{
			URL url = new URL(urls);
			//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			//Use the connect method to create the connection bridge
			conn.connect();
			//Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			String inline =null;
			//Iterating condition to if response code is not 200 then throw a runtime exception
			//else continue the actual process of getting the JSON data
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				//Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					inline+=sc.nextLine();
				}
				System.out.println("\nJSON Response in String format"); 
				System.out.println(inline);
				//Close the stream when reading the data has been finished
				sc.close();
			}
			
			//JSONParser reads the data from string object and break each data into key value pairs
			JSONParser parse = new JSONParser();
			//Type caste the parsed json data in json object
			JSONObject jobj = (JSONObject)parse.parse(inline);
			System.out.println(jobj);
			//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return users;

	}
}
