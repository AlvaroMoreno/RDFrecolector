package com.recolector.api.flickr.facade;

import java.util.Iterator;

import com.recolector.api.flickr.service.photoSearch;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:It provides a iterator from the photoList results
 * History:
 * Last modified:13/06/2015 
 */

public class FlickrSearch implements Iterator<String> {
	private ApiFlickr apiHandler;
	private photoSearch photoSearch;
	private int iterator;
	private int iteratorRange;
	//private int pages; All pages search

	public FlickrSearch(String paramater, String value){
		apiHandler = new ApiFlickr();
		photoSearch = apiHandler.getSearch(paramater, value);
		iteratorRange = 8;//photoSearch.getPhotos().getPerpage();
		iterator = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		boolean hasNext = false;
		while(!hasNext && iteratorRange > iterator){
			if(photoSearch.getPhotos().getPhoto() == null){
				iterator++;
			}
			else{	
				if(photoSearch.getPhotos().getPhoto()[iterator].isIspublic()!=1){//SOMETIMES IT CRASHES
					iterator++;
				}				
				else{
					hasNext = true;
				}
			}
		}
		return hasNext;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		String id = photoSearch.getPhotos().getPhoto()[iterator].getId();
		iterator++;
		return id;
	}
}


