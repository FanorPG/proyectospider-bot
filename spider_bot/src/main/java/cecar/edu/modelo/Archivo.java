/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecar.edu.modelo;

import java.io.File;

/**
 *
 * @author Fanorpro
 */
public class Archivo {
    private String tipoArchivo;
    private File archivoDesc;

    public Archivo() {
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public File getArchivoDesc() {
        return archivoDesc;
    }

    public void setArchivoDesc(File archivoDesc) {
        this.archivoDesc = archivoDesc;
    }

    
}
