package com.recolector.rdf;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.recolector.api.flickr.service.FlickrResources;
import com.recolector.rdf.properties.Exif;
import com.recolector.rdf.properties.Myproperties;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:From a resourceProvider it creates the RDF triples.
 * History:
 * Last modified:13/06/2015 
 */
public class RDFObject {
	private Model RDFmodel;

	public RDFObject(Model RDFmodel){
		this.RDFmodel = RDFmodel;
	}
	
	public void convertPhotoToRDF(FlickrResources resourceProvider){
		String namespace = "http://www.myflickr.org/";

		Resource source = RDFmodel.createResource(namespace + resourceProvider.getFotoId(), FOAF.Image);

		RDFmodel.add(source,RDFS.seeAlso,resourceProvider.getFlickrURL());
		if(resourceProvider.getDate() != null){
			RDFmodel.add(source, DC.date, resourceProvider.getDate(), XSDDatatype.XSD);
		}
		RDFmodel.add(source, Myproperties.VIEWS, resourceProvider.getViews(), XSDDatatype.XSDint);

		//NOT EVERY PHOTO IS GEOLOCATED

		Resource source2 = RDFmodel.createResource(namespace + resourceProvider.getPlaceId());
		RDFmodel.add(source2,FOAF.name,resourceProvider.getPlaceName());
		RDFmodel.add(source,FOAF.depicts,source2);

		if(resourceProvider.getCameraId() != null){
			RDFmodel.add(source,Exif.MODEL, resourceProvider.getCameraId());
		}

		if(resourceProvider.getSoftware() != null){
			RDFmodel.add(source, Exif.SOFTWARE,resourceProvider.getSoftware());
		}
		if(resourceProvider.getUserId() != null){
			Resource source3 = RDFmodel.createResource(namespace + resourceProvider.getUserId());
			RDFmodel.add(source3,FOAF.name,resourceProvider.getNickname());
			RDFmodel.add(source,DC.creator,source3);
		}
		
	}
}
