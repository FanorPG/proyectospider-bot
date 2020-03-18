/**
 * Clase: Archivo.java
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

public class Archivo {
    private String tipoArchivo;
    private byte[] archivoDesc;

    public Archivo() {
    }

    public Archivo(String tipoArchivo, byte[] archivoDesc) {
        this.tipoArchivo = tipoArchivo;
        this.archivoDesc = archivoDesc;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public byte[] getArchivoDesc() {
        return archivoDesc;
    }

    public void setArchivoDesc(byte[] archivoDesc) {
        this.archivoDesc = archivoDesc;
    }

    

   

    
}
