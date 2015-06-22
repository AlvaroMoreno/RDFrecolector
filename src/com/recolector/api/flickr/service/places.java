package com.recolector.api.flickr.service;

public class places {
	private place[] place;



	public place[] getPlace() {
		return place;
	}

	public class place{
		private String place_id;

		public String getPlace_id() {
			return place_id;
		}
	}
}
