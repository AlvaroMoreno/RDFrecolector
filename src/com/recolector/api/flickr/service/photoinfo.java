package com.recolector.api.flickr.service;

/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:This class supports Json Parse for Photo resource in Flickr api.
 * This class contains photo fields need to describe the RDF resource.
 * The Json is located at api.flickr.com
 * Only getter methods are use to manage data, no modifications are needed
 * All fields are not included
 * History:
 * Last modified:28/04/2015 
 */
public class photoinfo {
	private photo photo = new photo();;


	public photo getPhoto() {
		return photo;
	}

}


