/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecar.edu.modelo;

import java.io.File;
import java.util.Date;

/**
 *
 * @author ProFanor
 */
public class Pagina {
    
    private String url;
    private Date fecha;
    private String tipoArchivo;
    private File archivo;

    public Pagina() {
        super();
    }

    public Pagina(String url, Date fecha, String tipoArchivo, File archivo) {
        this.url = url;
        this.fecha = fecha;
        this.tipoArchivo = tipoArchivo;
        this.archivo = archivo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
}
