package interfaces;

import java.util.List;

import entities.MetaData;

public interface IRepository<T> {
	
	
	    void add(T item);
	    void update(T item);
	    void remove(T item);
	    List<T> query(String filter);
	    List<T> getAll();
	    
	}

