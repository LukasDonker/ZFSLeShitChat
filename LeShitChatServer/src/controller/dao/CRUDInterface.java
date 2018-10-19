package controller.dao;

import java.util.List;

import model.ValueObject;

/**
 * CRUD Interface, bezeichnet die CRUD Methoden für die DAOs
 * DatenObjekte müssen von ValueObject erben.
 * @author ldonker
 *
 * @param <T> extends ValueObject
 */
public interface CRUDInterface<T extends ValueObject> {

	/**
	 * Create per SQL 
	 * "Insert into..."
	 * @param valueObject
	 * @return anzahl geänderter spalten
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
	 * Wird nicht benötigt
	 * @param valueObject
	 * @return anzahl geänderter Spalten
	 */
	public int update(T valueObject);
	
	/**
	 * Not yet implemented 
	 * Wird nicht benötigt
	 * @param valueObject
	 * @return anzahl geänderter Spalten
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
