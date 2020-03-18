/**
 * Interfaz: InterfazPagina.java
 *
 * @version: 0.1
 *
 * Fecha de Creación: 9/03/2020
 *
 * Fecha de modificación: 
 *
 * @author: Fanor Pertuz Galvan
 * 
 * @author: Ariel Torres Jimenez
 *
 * Copyright: CECAR
 *
 */
package ccecar.edu.interfaces;

import cecar.edu.modelo.Pagina;
import java.util.List;


/**
 *
 * @author ProFanor
 */
public interface InterfazPaginaDAO<T> {
    
    String guardar(T t);
    String actualizar(T t);
    T consultar(String ... criteriosBusqueda);
    String eliminar(String ... criteriosBusqueda);
    List<T> listar();
    
}
