package interfaces;

import java.util.Collection;

/**
 * Interfaccia generica di un filtro applicato su un campo fieldName comprato mediante un operator con un value
 * di tipo generico T. Il filtro restituisce una collezione di oggetti di tipo generico E.
 * @author danilogervasio
 *
 * @param <E>
 * @param <T>
 */

public interface Filter<E,T> {
	abstract Collection<E> filterField(String fieldName, String operator, T value);
}
