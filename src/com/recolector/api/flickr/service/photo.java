package com.recolector.api.flickr.service;


/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:This class supports Json Parse for Photo resource in Flickr api.
 * This class contains photo fields need to describe the RDF resource.
 * The Json is located at api.flickr.com
 * Only getter methods are use to manage data, no modifications are needed
 * All fields are not included
 * History:
 * Last modified:30/05/2015 
 */
class photo {
	private String id = null;//Sometimes there are no information. 
	private owner owner ;
	private String views = null;//Sometimes there are no information
	private String camera = null;//Sometimes there are no information
	private location location;
	private exif[] exif = new exif[0];
	private urls urls;



	String getId() {
		return id;
	}
	owner getOwner() {
		return owner;
	}

	String getcamera() {
		return camera;
	}

	exif[] getExif() {
		return exif;
	}

	location getLocation() {
		return location;
	}

	urls getUrls() {
		return urls;
	}
	String getViews() {
		return views;
	}

	private exif tagequals(String equ){
		exif exifEq = null;
		for(int i=0;exif.length>i && exifEq == null;i++){
			if (exif[i].getTag().equals(equ)){
				exifEq= exif[i];

			}
		}
		return exifEq;
	}
	//PELIGRO SOLO SE PUEDE LLAMAR DESDE PHOTOEXIF
	String getDate(){
		exif exifEq = this.tagequals("DateCreated");
		if (exifEq!= null){
			return exifEq.getRaw().get_content();
		}
		else{
			return "";
		}
	}

	String getSotware(){
		exif exifEq = this.tagequals("Software");
		if (exifEq!= null){
			return exifEq.getRaw().get_content();
		}
		else{
			return "";
		}
	}

	String getBrand(){
		exif exifEq = this.tagequals("Make");
		if (exifEq!= null){
			return exifEq.getRaw().get_content();
		}
		else{
			return "";
		}
	}
	class location {
		private String latitude;
		private String longitude;
		private county county;
		county getCounty() {
			return county;
		}

		String getLongitude() {
			return longitude;
		}

		String getLatitude() {
			return latitude;
		}

		class county {
			private String _content;
			private String place_id;

			String get_content() {
				return _content;
			}

			String getPlace_id() {
				return place_id;
			}

		}	
	}

	class owner {
		private String username;
		private String path_alias;

		String getUsername() {
			return username;
		}

		String getpPath_alias() {
			return path_alias;
		}
	}

	class urls {
		private url[] url;

		url getUrl() {
			return url[0];//Peligroso pero es como funciona la API 
		}

		class url{
			private String _content;

			String get_content() {
				return _content;
			}

		}

	}

	class exif {
		private raw raw;
		private String tag = null;

		raw getRaw() {
			return raw;
		}

		String getTag() {
			return tag;
		}
		class raw {
			private String _content;


			String get_content() {
				return _content;
			}
		}

	}
}
