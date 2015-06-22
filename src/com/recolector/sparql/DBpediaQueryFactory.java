package com.recolector.sparql;

public class DBpediaQueryFactory extends StringQueryFactory {
	/* Author: Alvaro Moreno Garcia
	 * UPM student number:080129
	 * Description:This class generates DBpedia formated query
	 * History:
	 * Last modified:13/06/2015 
	 */


	public void addQuery(String PropWhere, String Filter, String limit){
		this.query = this.query +
				DefaultQuery.SELECT + 
				DefaultQuery.LATLON_SELECT + 
				DefaultQuery.WHERE +
				"{" +
				DefaultQuery.LOCALITY_WHERE +
				PropWhere +
				DefaultQuery.LATLON_WHERE +
				DefaultQuery.FILTER +
				Filter +
				"}" +
				DefaultQuery.LIMIT + 
				limit;
	}


}
