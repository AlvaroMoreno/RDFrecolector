package com.recolector.sparql;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:This class handles the queries to a service or model
 * History:
 * Last modified:13/06/2015 
 */


public class QueryHandler {

	public ResultSet queryService(String service,String query){
		QueryExecution qe=QueryExecutionFactory.sparqlService(service, query);
		ResultSet result=qe.execSelect();
		return result;
	}

	public ResultSet queryModel(Model m, String query ){
		ResultSet result=QueryExecutionFactory.create(query,m).execSelect();
		return result;

	}
}
