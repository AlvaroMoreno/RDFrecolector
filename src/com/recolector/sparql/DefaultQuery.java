package com.recolector.sparql;

public class DefaultQuery {
	/* Author: Alvaro Moreno Garcia
	 * UPM student number:080129
	 * Description:This class contains SPARQL constant
	 * History:
	 * Last modified:13/06/2015 
	 */


	//SPARQL
	public static final String SELECT = " SELECT ";
	public static final String WHERE = " WHERE ";
	public static final String GROUP_BY = " GROUP BY ";
	public static final String LIMIT = " LIMIT ";
	public static final String FILTER = " FILTER ";

	//DBpedia SPARQL
	public static final String LATVAL = "latVal";
	public static final String LONVAL = "lonVal";
	public static final String LATLON_SELECT = " (str(?lat) AS ?"+LATVAL+ ") (str(?lon) AS ?"+ LONVAL+") ";
	public static final String LATLON_WHERE = " ?locality geo:lat ?lat ."	+ " ?locality geo:long ?lon .";
	public static final String LOCALITY_WHERE = " ?locality a dbo:Settlement .";


	//FLICKR SPARQL	
	public static final String COUNT_VAR = "CountVar";
	public static final String SELECT_VAR = "selection";
	public static final String COUNT = " ?"+SELECT_VAR+" (COUNT(*) AS ?count) (str(?count) AS ?"+COUNT_VAR + ") ";



}
