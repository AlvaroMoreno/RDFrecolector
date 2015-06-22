package com.recolector.facade;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.hpl.jena.query.ResultSet;
import com.recolector.sparql.QueryHandler;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:Main class. It handles the queries among layers.
 * History:
 * Last modified:13/06/2015 
 */
public class MainHandler {

	DBpediaHandler  DBpedia;
	FlickrHandler Flickr;
	QueryHandler qHandler;

	public MainHandler(){
		DBpedia =new DBpediaHandler();
		Flickr = new FlickrHandler();
		qHandler = new QueryHandler();
	}

	public ArrayList<String[]> SearchDBpediaFlickr(String DBpediaQuery, String FlickrQuery){
		ResultSet DBpediaResult;
		ResultSet FlickrResult;
		/*Query to DBpedia endpoint*/
		DBpediaResult = qHandler.queryService("http://dbpedia.org/sparql",DBpediaQuery);
		ArrayList<String[]> ListDBpedia = DBpedia.getResults(DBpediaResult);
		Iterator<String[]> it = ListDBpedia.iterator();
		while(it.hasNext()){
			String[] result = it.next();
			/*From the DBpedia results the RDF model is filled*/
			Flickr.fromLatLonToRDF(result[0], result[1]);
		}
		/*Query RDF flickr model*/
		FlickrResult = qHandler.queryModel(Flickr.getModel(), FlickrQuery);
		return Flickr.getResults(FlickrResult);

	}

}
