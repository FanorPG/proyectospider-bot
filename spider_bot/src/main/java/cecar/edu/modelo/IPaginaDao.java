/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecar.edu.modelo;

import java.util.List;


/**
 *
 * @author ProFanor
 */
public interface IPaginaDao {
        public List<Pagina> obtenerPagina();
	public Pagina obtenerPagina(String url);
	public void actualizarPagina(Pagina pagina);
	public void eliminarPagina(Pagina pagina);
    
}
