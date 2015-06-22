package com.recolector.rdf.properties;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;

public class Myproperties {

	protected static final String URI ="http://www.myflickr.org/";

	public static String getURI() {
		return URI;
	}

	private static Model m = ModelFactory.createDefaultModel();

	public static final Property VIEWS = m.createProperty(URI, "views" );

}
