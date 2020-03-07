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
public class PaginaDaoImp implements IPaginaDao {

    List<Pagina> paginas;
    
    public Pagina buscarPagina(String url){
        Pagina pg=null;
        for(int i=0; i<paginas.size();i++){
            if(url.equals(paginas.get(i).getUrl())){
                pg=paginas.get(i);
                break;
            }
        }
        return pg;
        
    }
    public int buscarPosiconP(String url){
        int pg=0;
        for(int i=0; i<paginas.size();i++){
            if(url.equals(paginas.get(i).getUrl())){
                pg=i;
                break;
            }
        }
        return pg;
        
    }

    @Override
    public List<Pagina> obtenerPagina() {
        return paginas;
    }

    @Override
    public Pagina obtenerPagina(String url) {
        return buscarPagina(url);
    }

    @Override
    public void actualizarPagina(Pagina pagina) {
        int posicion=buscarPosiconP(pagina.getUrl());
        paginas.get(posicion).setTipoArchivo(pagina.getTipoArchivo());
        paginas.get(posicion).setFecha(pagina.getFecha());
        paginas.get(posicion).setArchivo(pagina.getArchivo());
        System.out.println("modificado");
    }

    @Override
    public void eliminarPagina(Pagina pagina) {
        int posicion = buscarPosiconP(pagina.getUrl());
        paginas.remove(posicion);
    }

}
