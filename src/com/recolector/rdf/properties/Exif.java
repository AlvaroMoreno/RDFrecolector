package com.recolector.rdf.properties;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;

public class Exif {



	protected static final String URI ="http://www.kanzaki.com/ns/exif#";

	public static String getURI() {
		return URI;
	}

	private static Model m = ModelFactory.createDefaultModel();

	public static final Property SOFTWARE = m.createProperty(URI, "software" );
	public static final Property MODEL = m.createProperty(URI, "model" );

}
