package com.academik.mvc.dao;

import com.academik.mvc.utils.CustomConnection;
import java.util.List;

/**
 *
 * @author esvux
 */
public interface GeneralDAO<T> {
    
    /**
     * Propiedades o atributos que pueden utilizar todas las clases
     * que implementen GeneralDAO.
     */
    CustomConnection conn = CustomConnection.getInstance();
    
    // Métodos pendientes de implementar
    List<T> queryAll();
    
    T findById(long id);
    
    void create(T element);
    
    void edit(long id, T element);
    
}
