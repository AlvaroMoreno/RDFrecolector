package com.recolector.facade;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.recolector.api.flickr.facade.FlickrPlaces;
import com.recolector.api.flickr.facade.FlickrSearch;
import com.recolector.api.flickr.service.FlickrResources;
import com.recolector.rdf.RDFObject;
import com.recolector.sparql.DefaultQuery;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:It handles the RDF creation from the DBpedia latitude and longitude vaules.
 * It also manages the results from the query
 * History:
 * Last modified:13/06/2015 
 */
public class FlickrHandler {
	private Model model =ModelFactory.createDefaultModel();
	private RDFObject converter;
	public FlickrHandler(){
		converter = new RDFObject(model);
	}
	public ArrayList<String[]> getResults(ResultSet results) {	
		ArrayList<String[]> resultList = new ArrayList<String[]>();
		while (results.hasNext()) {
			QuerySolution row=results.nextSolution();
			String[] result = new String[2];
			/*Only resources and their appearance number */
			result[0] = row.getLiteral(DefaultQuery.COUNT_VAR).toString();
			result[1] = row.getLiteral(DefaultQuery.SELECT_VAR).toString();
			resultList.add(result);
		}
		return resultList;
	}

	public void fromLatLonToRDF(String Lat, String Lon){
		this.convertPlaceIDToRDF(this.searchPlaceIDByLatLon(Lat, Lon));
	}

	public String searchPlaceIDByLatLon(String Lat, String Lon){
		/*It gets the placeID from the coordinates*/
		FlickrPlaces places = new FlickrPlaces(Lat, Lon); 
		return places.getPlaceId();
	}

	public void convertPlaceIDToRDF(String place_id) {
		/*FlickrSearch gets a list of photos*/
		Iterator<String> it = new FlickrSearch("place_id", place_id);
		while(it.hasNext()){
			/*Every photo it is converted to RDF, first FlickrResources gathers photo information*/
			FlickrResources resources = new FlickrResources(it.next());
			converter.convertPhotoToRDF(resources);
		}
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}
}
