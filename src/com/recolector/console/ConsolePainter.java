package com.recolector.console;
import java.util.Scanner;

import com.recolector.sparql.Prefix;
/* Author: Alvaro Moreno Garcia
 * UPM student number:080129
 * Description:Methods displays messages and reads inputs on the console
 * History:
 * Last modified:13/06/2015 
 */

public class ConsolePainter {
	Scanner in;

	public ConsolePainter(){
		in =new Scanner(System.in);
	}

	public void paintWelcomeInterface(){
		System.out.println(ConsoleMessages.WELCOME);
		System.out.println(ConsoleMessages.VERSION);
		System.out.println(ConsoleMessages.INTRODUCTION);
		System.out.println(ConsoleMessages.HELP);
	}

	public String paintDBpediaproperty(){
		String property;
		System.out.println(ConsoleMessages.DBPEDIA_WELCOME);
		System.out.println(ConsoleMessages.PREFIX);
		System.out.println(Prefix.getAllPrefix());
		property = in.nextLine();
		return property;
	}

	public String paintfilter(){
		String filter;
		System.out.println(ConsoleMessages.FILTER);
		filter = in.nextLine();
		return filter;
	}

	public String paintLimit(){
		String limit;
		System.out.println(ConsoleMessages.LIMIT);
		limit = in.nextLine();
		return limit;
	}

	public String paintFlickrproperty(){
		String property;
		System.out.println(ConsoleMessages.FLICKR_WELCOME);
		System.out.println(ConsoleMessages.PREFIX);
		System.out.println(Prefix.getAllPrefix());
		property = in.nextLine();
		return property;
	}
	public void paintResults(){
		//To implement
	}
}
