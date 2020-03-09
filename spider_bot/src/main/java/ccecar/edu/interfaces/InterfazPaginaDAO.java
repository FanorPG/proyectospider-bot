/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
