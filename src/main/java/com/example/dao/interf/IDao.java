package com.example.dao.interf;
import java.util.Set;

/**
 * Main interface for DAO.
 */
public interface IDao<T>  {
    /**
     * Adds row in table if input entity is not already exist.
     * @param entity to add
     * @return true if was added
     */
    boolean addInDataBase(T entity);

    /**
     * Updates the data for an entity in a table.
     * @param entity to be updated
     * @return true if the table has been updated
     */
    boolean updateDataBase(T entity);

    /**
     * Removes an object by it's id.
     * @param id object to delete
     * @return true, if object was delete
     */
    boolean deleteFromDataBase(Long id);

    /**
     * Finds all data from table.
     * @return list of all data in table
     */
    Set<T> findAllFromDataBase();

}