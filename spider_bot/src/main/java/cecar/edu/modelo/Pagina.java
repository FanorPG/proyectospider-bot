/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecar.edu.modelo;

import java.util.ArrayList;

/**
 *
 * @author ProFanor
 */
public class Pagina {
    
    private String url;
    private String fecha;
    ArrayList<Archivo> archivos=new ArrayList<>();

    public Pagina() {
    }

    public Pagina(String url, String fecha) {
        this.url = url;
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }

   

    

  
}
