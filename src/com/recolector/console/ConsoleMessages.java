package com.recolector.console;

public class ConsoleMessages {
	/* Author: Alvaro Moreno Garcia
	 * UPM student number:080129
	 * Description:This class contains every message is displayed on the console
	 * History:
	 * Last modified:13/06/2015 
	 */
	/*General Messages*/
	public static final String WELCOME = " Bienvenido a la herramienta Recolector de RDF ";
	public static final String VERSION = " Versión 1 - 13.06.2015 ";
	public static final String INTRODUCTION = " El software, en su versión por defecto, permite realizar búsquedas combinadas entre dos fuentes de datos distintas la DBpedia y Flickr "; 
	public static final String HELP = " Primero se deberá seleccionar el criterio de búsqueda para elegir poblaciones en la DBpedia. Posteriormente se elegirá el criterio de Flickr para seleccionar una propiedad de las fotos geolocalizadas en las poblaciones resultado de la primera búsqueda ";

	/*General Search*/
	public static final String PREFIX = " Lista de prefijos disponibles ";
	public static final String LIMIT = " Establezca un limite en el número de resultados. Introducir un valor numérico ";
	public static final String FILTER = "Introduzca un filtro de criterio para la propiedad anterior EJ: (?population > 1000000 && ?population < 1100000) .";

	/*DBpedia Search*/
	public static final String DBPEDIA_WELCOME = " Para realizar una búsqueda se deberá seleccionar una propiedad que contenga un recurso de tipo seattlement en la DBpedia EJ: ?locality dbo:populationTotal ?population .  Si no se añade ?locality puede producir errores";

	/*Flickr Search*/
	public static final String FLICKR_WELCOME =" Introduzca la propiedad que desea seleccionar de la DBpedia. Se mostrará el número de ocurrencias. EJ: exif:model ";


}
