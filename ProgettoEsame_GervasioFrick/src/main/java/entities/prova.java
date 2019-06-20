package entities;
import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

//
import interfaces.Struttura;
import services.Utilities;

public class prova implements Struttura{

	@Trim
	@NullString(nulls = { "?", "-","" })
    @Parsed(field="Codice",defaultNullRead = Utilities.NULLSTRING)
	private String codice;
	
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="categoria",defaultNullRead = Utilities.NULLINT+"")
	private int categoria;
	
	public String ToString()
	{
		return codice+" "+categoria;
	}

}