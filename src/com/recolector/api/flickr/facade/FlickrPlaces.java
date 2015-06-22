package com.recolector.api.flickr.facade;

import com.recolector.api.flickr.service.findbylatlon;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:It provides a iterator from the placesId results
 * History:
 * Last modified:13/06/2015 
 */

public class FlickrPlaces {
	private ApiFlickr apiHandler;
	private findbylatlon findbylatlon;



	public FlickrPlaces (String lat, String lon){
		this.apiHandler = new ApiFlickr();
		this.findbylatlon = apiHandler.getFindByLatLon(lat, lon);

	}

	public String getPlaceId(){
		return findbylatlon.getPlaces().getPlace()[0].getPlace_id();
	}



}
