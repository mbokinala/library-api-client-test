package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import objects.Book;

public class Main {
	public static void main(String args[]) {
		try {
			sendingGetRequest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 private static void sendingGetRequest() throws Exception {
		 
		  String urlString = "http://localhost:3000/books/111111111";
		  
		  URL url = new URL(urlString);
		  HttpURLConnection con = (HttpURLConnection) url.openConnection();
		 
		  // By default it is GET request
		  con.setRequestMethod("GET");
		 
		  //add request header
		  con.setRequestProperty("User-Agent", "Mozilla/5.0");
		 
		  int responseCode = con.getResponseCode();
		  System.out.println("Sending get request : "+ url);
		  System.out.println("Response code : "+ responseCode);
		 
		  // Reading response from input Stream
		  BufferedReader in = new BufferedReader(
		          new InputStreamReader(con.getInputStream()));
		  String output;
		  StringBuffer response = new StringBuffer();
		 
		  while ((output = in.readLine()) != null) {
		   response.append(output);
		  }
		  in.close();
		 
		  //printing result from response
		  
		  Book data = new Gson().fromJson(response.toString(), Book.class);
		  
		  System.out.println(data.author.last);
		  
		 
		 }
}
