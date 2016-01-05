package com.som;

/**
 * Created by mobidick on 2016. 1. 5..
 */
final public class Configuration {
	static public final String databaseLocation = "./default.txt";
	static public final String commandDelimiter = " ";
	static public final String argumentDelimiter = ",";
	static public final String commandCharacter=">>" ;
	static public final String helpMessage="Simple Order Manipulator\n"
		+ "===============\n"
		+ "show: show all orders in database\n"
		+ "delivery: proceed all orders in job queue\n"
		+ "find <ID>: show order corresponding to given ID in database\n"
		+ "add ORDERID,OWNERID,PROUDCTID: add new order to job queue\n"
		+ "exit: exit SOM\n"
		+ "help: display this\n";
}
