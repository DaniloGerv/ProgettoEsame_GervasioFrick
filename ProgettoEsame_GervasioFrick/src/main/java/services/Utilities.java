package services;
/*
 * 
 */

/**
 * Classe statica contenente costanti e metodi di utilità del programma.
 * Sono definiti valori standard per i tipi string, int e double
 * utilizzati per i costruttori di default delle varie entità.
 * @author danilogervasio
 *
 */

public class Utilities {
	
	public static final int NULLINT=-1;
	public static final String NULLSTRING="";
	public static final double NULLDOUBLE=0.0;
	
	/**
	 * Metodo che controlla se l'operatore inserito è corretto
	 * @param operator, operatore inserito "(<,>,<=,>=,==)"
	 * @return 
	 */
	
	public static boolean checkOperators(String operator)	//Method that checks if the user has written a correct operator
	{

		if (operator.equals("==") || operator.equals(">")|| operator.equals(">=")|| operator.equals("<")|| operator.equals("<="))
		return true;
		else	
		return false;
	}
	
}
