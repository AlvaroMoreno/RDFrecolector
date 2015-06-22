package com.recolector.facade;

import java.util.ArrayList;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.recolector.sparql.DefaultQuery;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:It manages the results from the query
 * History:
 * Last modified:13/06/2015 
 */
public class DBpediaHandler {

	public ArrayList<String[]> getResults(ResultSet results){
		ArrayList<String[]> coordList = new ArrayList<String[]>();
		int limit = 0;
		while (results.hasNext() && limit<8){ //MAX 8 LOCALITY 
			QuerySolution s=results.nextSolution();
			String[] coord = new String[2];
			/*Flickr only needs the latitude and longitude values*/
			coord[0] = s.getLiteral(DefaultQuery.LATVAL).toString();
			coord[1] = s.getLiteral(DefaultQuery.LONVAL).toString();
			coordList.add(coord);
			limit++;
		}	
		return coordList;
	}
}
