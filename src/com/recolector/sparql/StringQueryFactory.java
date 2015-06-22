package com.recolector.sparql;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:This abstract class generate a query with a pefrix list.
 * History:
 * Last modified:13/06/2015 
 */


public abstract class StringQueryFactory {
	String query;

	public StringQueryFactory(){
		this.query = Prefix.getAllPrefix();
	}
	public void addQuery(String query){
		this.query = this.query + query;
	}
	public String getQuery(){
		return this.query;
	}
}
