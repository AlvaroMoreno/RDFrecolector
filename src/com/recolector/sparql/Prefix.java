package com.recolector.sparql;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:A list of Prefixes
 * History:
 * Last modified:13/06/2015 
 */


public class Prefix {

	public static final String PREFIX = "PREFIX ";

	private static final String DBO_URL = "<http://dbpedia.org/ontology/>";

	public static final String DBO =  PREFIX + "dbo:" +DBO_URL ;

	private static final String DB_URL = "<http://dbpedia.org/resource/>";

	public static final String DB =  PREFIX + "db:" +DB_URL ;

	private static final String RDF_URL = "<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>";

	public static final String RDF =  PREFIX + "rdf:" +RDF_URL ;

	private static final String GEO_URL = "<http://www.w3.org/2003/01/geo/wgs84_pos#>";

	public static final String GEO =  PREFIX + "geo:" +GEO_URL ;

	private static final String XSD_URL = "<http://www.w3.org/2001/XMLSchema#>";

	public static final String XSD =  PREFIX + "xsd:" + XSD_URL ;

	private static final String FOAF_URL = "<http://xmlns.com/foaf/0.1/>";

	public static final String FOAF =  PREFIX + "foaf:" + FOAF_URL ;

	private static final String EXIF_URL = "<http://www.kanzaki.com/ns/exif#>";

	public static final String EXIF =  PREFIX + "exif:" + EXIF_URL ;

	private static final String BASE_URL = "<http://www.myflickr.org/>";

	public static final String BASE =  PREFIX + "base:" + BASE_URL ;


	public static String getAllPrefix(){
		return DBO + DB + RDF + GEO + XSD + FOAF + EXIF + BASE;
	}


	/**
	 * @return the prefix
	 */
	public static String getPrefix() {
		return PREFIX;
	}


	/**
	 * @return the dbourl
	 */
	public static String getDbourl() {
		return DBO_URL;
	}


	/**
	 * @return the dbo
	 */
	public static String getDbo() {
		return DBO;
	}


	/**
	 * @return the dburl
	 */
	public static String getDburl() {
		return DB_URL;
	}


	/**
	 * @return the db
	 */
	public static String getDb() {
		return DB;
	}


	/**
	 * @return the rdfurl
	 */
	public static String getRdfurl() {
		return RDF_URL;
	}


	/**
	 * @return the rdf
	 */
	public static String getRdf() {
		return RDF;
	}


	/**
	 * @return the geourl
	 */
	public static String getGeourl() {
		return GEO_URL;
	}


	/**
	 * @return the geo
	 */
	public static String getGeo() {
		return GEO;
	}


	/**
	 * @return the xsdurl
	 */
	public static String getXsdurl() {
		return XSD_URL;
	}


	/**
	 * @return the xsd
	 */
	public static String getXsd() {
		return XSD;
	}


	/**
	 * @return the foafurl
	 */
	public static String getFoafurl() {
		return FOAF_URL;
	}


	/**
	 * @return the foaf
	 */
	public static String getFoaf() {
		return FOAF;
	}


	/**
	 * @return the exifurl
	 */
	public static String getExifurl() {
		return EXIF_URL;
	}


	/**
	 * @return the exif
	 */
	public static String getExif() {
		return EXIF;
	}


	/**
	 * @return the baseurl
	 */
	public static String getBaseurl() {
		return BASE_URL;
	}


	/**
	 * @return the base
	 */
	public static String getBase() {
		return BASE;
	}


}
