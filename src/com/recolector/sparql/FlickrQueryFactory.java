package com.recolector.sparql;

public class FlickrQueryFactory extends StringQueryFactory{
	/* Author: Alvaro Moreno Garcia
	 * UPM student number:080129
	 * Description:This class generates Flickr formated query
	 * History:
	 * Last modified:13/06/2015 
	 */


	public void addQuery(String PropWhere/*, String Filter, String limit*/){
		this.query = this.query +
				DefaultQuery.SELECT + 
				DefaultQuery.COUNT + 
				DefaultQuery.WHERE +
				" { " +
				"?photo "+ PropWhere +" ?"+ DefaultQuery.SELECT_VAR + " . " +
				//DefaultQuery.Filter +
				//Filter +
				" } " +
				DefaultQuery.GROUP_BY + 
				" ?"+ DefaultQuery.SELECT_VAR ;
	}

}
