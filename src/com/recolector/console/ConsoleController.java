package com.recolector.console;

import java.util.ArrayList;
import java.util.Iterator;

import com.recolector.facade.MainHandler;
import com.recolector.sparql.DBpediaQueryFactory;
import com.recolector.sparql.FlickrQueryFactory;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:This class handles the client interface. A new recolector facade is created
 * with the data gathered from ConsolePainter
 * History:
 * Last modified:13/06/2015 
 */
public class ConsoleController {
	ConsolePainter console;
	MainHandler main;
	DBpediaQueryFactory qDBpedia;
	FlickrQueryFactory qFlickr;

	public void main(){
		console = new ConsolePainter();
		/*Query input variable*/
		String DBProperty;
		String filter;
		String limit;
		String flickrProperty;

		console.paintWelcomeInterface();

		//DBpedia
		DBProperty = console.paintDBpediaproperty();
		filter = console.paintfilter();
		limit = console.paintLimit();

		//Flickr
		flickrProperty = console.paintFlickrproperty();

		/*Query generation*/
		MainHandler main = new MainHandler();
		DBpediaQueryFactory qDBpedia = new DBpediaQueryFactory();

		qDBpedia.addQuery(DBProperty, filter, limit);
		String DBpediaQuery= qDBpedia.getQuery();

		FlickrQueryFactory qFlickr = new FlickrQueryFactory();
		qFlickr.addQuery(flickrProperty);
		String FlickrQuery=qFlickr.getQuery();

		/*Results painter*/
		ArrayList<String[]> resultList = new ArrayList<String[]>();
		resultList = main.SearchDBpediaFlickr(DBpediaQuery, FlickrQuery);
		Iterator<String[]> it = resultList.iterator();
		while(it.hasNext()){
			String[] result = it.next();
			System.out.println(result[0]+" " + result[1]);
		}
	}
}
