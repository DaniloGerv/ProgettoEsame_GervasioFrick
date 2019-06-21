package interfaces;

import java.util.List;

/**
 * Interfaccia generica di una repository di elementi di tipo generico T, contenente dei metodi elementari.
 * @author danilogervasio
 *
 * @param <T>
 */

public interface IRepository<T> {
	
	
	    void add(T item);
	    void update(T item);
	    void remove(T item);
	    List<T> query(String filter);
	    List<T> getAll();
	    
	}

