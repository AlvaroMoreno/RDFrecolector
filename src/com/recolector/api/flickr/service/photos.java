package com.recolector.api.flickr.service;

public class photos {


	private int page;
	private int perpage;
	private String total;
	private photo[] photo;
	public photo[] getPhoto() {
		return photo;
	}

	public String getTotal() {
		return total;
	}

	public int getPage() {
		return page;
	}
	public int getPerpage() {
		return perpage;
	}

	public void setPerpage(int perpage) {
		this.perpage = perpage;
	}
	public class photo{
		private String id;
		private int ispublic;
		private String owner;



		public String getId() {
			return id;
		}
		public String getOwner() {
			return owner;
		}
		public int isIspublic() {
			return ispublic;
		}

	}

}
