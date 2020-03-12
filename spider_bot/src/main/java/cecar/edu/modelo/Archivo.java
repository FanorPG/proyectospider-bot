/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecar.edu.modelo;

/**
 *
 * @author Fanorpro
 */
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
