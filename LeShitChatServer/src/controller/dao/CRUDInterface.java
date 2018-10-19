package controller.dao;

import java.util.List;

import model.ValueObject;

/**
 * CRUD Interface, bezeichnet die CRUD Methoden f�r die DAOs
 * DatenObjekte m�ssen von ValueObject erben.
 * @author ldonker
 *
 * @param <T> extends ValueObject
 */
public interface CRUDInterface<T extends ValueObject> {

	/**
	 * Create per SQL 
	 * "Insert into..."
	 * @param valueObject
	 * @return anzahl ge�nderter spalten
	 */
	public int create(T valueObject);
	
	/**
	 * Read per SQL
	 * "Select * From ... WHERE..."
	 * @param valueObject
	 * @return T extends Valueobject
	 */
	public T read(long id);
	
	/**
	 * Not yet implemented
	 * Wird nicht ben�tigt
	 * @param valueObject
	 * @return anzahl ge�nderter Spalten
	 */
	public int update(T valueObject);
	
	/**
	 * Not yet implemented 
	 * Wird nicht ben�tigt
	 * @param valueObject
	 * @return anzahl ge�nderter Spalten
	 */
	public int delete(T valueObject);
	
	/**
	 * Read all per SQL
	 * "Select * From ..."
	 * @param valueObject
	 * @return List T extends Valueobject
	 */
	public List<T> readList(T valueObject);
	
}
