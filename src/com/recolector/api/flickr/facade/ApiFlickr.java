package com.recolector.api.flickr.facade;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.recolector.api.flickr.service.findbylatlon;
import com.recolector.api.flickr.service.photoExif;
import com.recolector.api.flickr.service.photoSearch;
import com.recolector.api.flickr.service.photoinfo;

/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:This class handles the get methods on api.flickr.com services
 */
public class ApiFlickr {

	private String api_key;
	private String NameSpace = "https://api.flickr.com/services/rest/?method=";
	private String format = "&format=json&nojsoncallback=1";
	/*The constructor get the photo id */
	public ApiFlickr(){
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("src/com/recolector/api/flickr/facade/flickr.properties");
			properties.load(input);
			this.api_key = properties.getProperty("apiKey");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*It obtains through api.flickr.com a json with the photo data and it converts into java object */
	public photoinfo getInfo(String id){
		Object photoinfo = new photoinfo();
		String service = "flickr.photos.getInfo";
		String urlString = this.NameSpace + service + "&photo_id="+ id + "&api_key=" + this.api_key + this.format ;
		URL url = generateURL(urlString);
		return (com.recolector.api.flickr.service.photoinfo) ConnectionReader(photoinfo,url);
	}

	public photoExif getExif(String id){
		Object photoExif = new photoExif();
		String service = "flickr.photos.getExif";
		String urlString = this.NameSpace + service + "&photo_id="+ id + "&api_key=" + this.api_key + this.format ;
		URL url = generateURL(urlString);
		return (com.recolector.api.flickr.service.photoExif) ConnectionReader(photoExif,url);
	}

	public photoSearch getSearch(String criteria, String localitation){//Criteria fix to "place_id=tbbWAcFQULxlR.kpfA", it should be a criteria array 
		Object photoSearch = new photoSearch();
		String service = "flickr.photos.search";
		String urlString = this.NameSpace + service + "&" + criteria + "=" + localitation + "&api_key=" + this.api_key + this.format ;
		URL url = generateURL(urlString);
		return (com.recolector.api.flickr.service.photoSearch) ConnectionReader(photoSearch,url);
	}

	public findbylatlon getFindByLatLon(String lat, String lon){
		Object findbylatlon = new findbylatlon();
		String service = "flickr.places.findByLatLon";
		String urlString = this.NameSpace + service + "&lat="+ lat + "&lon="+ lon + "&api_key=" + this.api_key + this.format ;
		URL url = generateURL(urlString);
		return (com.recolector.api.flickr.service.findbylatlon) ConnectionReader(findbylatlon,url);
	}
	private static URL generateURL(String urlString){
		URL url = null;
		try {
			//URL concatenated, It uses metric system to get the data 
			url = new URL(urlString);
		} catch (MalformedURLException e3) {
			System.out.println("There was an error generating the url"); 
		}
		return url;
	}

	private static Object ConnectionReader(Object parse,URL url){
		/*Connection to api.flickr.com */
		HttpURLConnection httpConn = getConexion(url);
		BufferedReader reader = null;

		/*If the connection is ok it gets data*/
		if(httpConn != null){
			try {
				reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("There was an error reading the data"); 

			}
			/*It manages json to java objects through gson api and it creates a photo object*/
			Gson gson = new GsonBuilder().create(); 
			parse = gson.fromJson(reader, parse.getClass());

			httpConn.disconnect();
		}

		return parse;

	}
	/*It manages the connection and its errors */
	private static HttpURLConnection getConexion(URL url){
		HttpURLConnection httpConn = null;
		try {
			httpConn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			System.out.println("There was an error connection to the service"); 
			return null;
		}

		int responseCode = 0;
		try {
			responseCode = httpConn.getResponseCode();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			System.out.println("Server does not respond");
			httpConn.disconnect();
			return null;
		}/*Only return the connection is ok(200)*/
		if (responseCode != 200) {
			System.out.println("Server does not respond correctly");
			httpConn.disconnect();
			httpConn = null;
		}
		return httpConn;
	}
}


