package services;
/*
 * classe in cui sono definiti i valori standard per i tipi string, int e double
 * sarà utile per i costruttori di default delle classi
 */
public class Utilities {
	
	public static final int NULLINT=-1;
	public static final String NULLSTRING="";
	public static final double NULLDOUBLE=0.0;
	
	public static boolean checkOperators(String operator)	//Method that checks if the user has written a correct operator
	{

		if (operator.equals("==") || operator.equals(">")|| operator.equals(">=")|| operator.equals("<")|| operator.equals("<="))
		return true;
		else	
		return false;
	}
	
}
