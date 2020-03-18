/**
 * Clase: Pagina.java
 *
 * @version: 0.1
 *
 * Fecha de Creación: 29/02/2020
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
package cecar.edu.modelo;


public class Pagina {
    
    private String url;
    private String fecha;

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

   

    

  
}
