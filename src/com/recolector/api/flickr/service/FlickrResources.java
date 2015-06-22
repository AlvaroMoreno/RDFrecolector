package com.recolector.api.flickr.service;

import com.recolector.api.flickr.facade.ApiFlickr;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:It provides the main photo values. It helps RDF conversion 
 * History:
 * Last modified:13/06/2015 
 */

public class FlickrResources {
	private ApiFlickr apiHandler;
	private photoinfo photoInfo;
	private photoExif photoExif;


	public FlickrResources (String rootResource){
		this.apiHandler = new ApiFlickr();
		this.photoInfo = apiHandler.getInfo(rootResource);
		this.photoExif = apiHandler.getExif(rootResource);
	}

	public String getFlickrURL(){
		return photoInfo.getPhoto().getUrls().getUrl().get_content();
	}
	public String getDate(){
		return photoExif.getPhoto().getDate();		
	}
	public String getViews(){
		return photoInfo.getPhoto().getViews();
	}
	public String getPlaceId(){
		return photoInfo.getPhoto().getLocation().getCounty().getPlace_id();
	}
	public String getCameraId(){
		return photoExif.getPhoto().getcamera();
	}
	public String getSoftware(){
		return photoExif.getPhoto().getSotware();
	}
	public String getNickname(){
		return photoInfo.getPhoto().getOwner().getUsername();
	}
	public String getUserId(){
		return photoInfo.getPhoto().getOwner().getpPath_alias();
	}
	public String getFotoId(){
		return photoInfo.getPhoto().getId();
	}
	public String getPlaceName(){
		return photoInfo.getPhoto().getLocation().getCounty().get_content();
	}

	public String getBrand(){
		return photoExif.getPhoto().getBrand();
	}

}
