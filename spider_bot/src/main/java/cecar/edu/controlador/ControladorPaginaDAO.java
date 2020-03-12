/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecar.edu.controlador;

import cecar.edu.modelo.Pagina;
import java.util.List;
import ccecar.edu.interfaces.InterfazPaginaDAO;
import cecar.edu.componentesReutilizable.ConectarMySQL;
import cecar.edu.modelo.Archivo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sun.misc.IOUtils;

/**
 *
 * @author ProFanor
 */
public class ControladorPaginaDAO implements InterfazPaginaDAO<Pagina> {

    private String pagiTab = "pagina";
    private String archiTab = "archivos";

    
    public void guardarArchivo(Archivo at,String url) throws SQLException{

                PreparedStatement preparedStatement2 = ConectarMySQL.getConexion().
                        prepareStatement("insert into " + archiTab + " values (?,?,?)");
                preparedStatement2.setString(1, url);
                preparedStatement2.setString(2, at.getTipoArchivo());

                //guardar archivo en la base de datos
                // 
                preparedStatement2.setBytes(3, at.getArchivoDesc());

                preparedStatement2.execute();
    }
    
    @Override
    public String guardar(Pagina t) {
        String resultado = "OK";

        try {
            System.out.println("Insertando datos a BD...");

            PreparedStatement preparedStatement = ConectarMySQL.getConexion().
                    prepareStatement("insert into " + pagiTab + " values (?,?)");

            preparedStatement.setString(1, t.getUrl());
            preparedStatement.setString(2, t.getFecha());
            preparedStatement.execute();

        } catch (SQLException e) {

            resultado = e.getMessage();
            System.out.println("Error 1: " + e);
            JOptionPane.showMessageDialog(null, "URL ya registrada");

        }

        return resultado;
    }
    

    @Override
    public String actualizar(Pagina t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }

    public Pagina consultar(String criteriosBusqueda, int i) throws IOException {
        Archivo archivo = null;
        Pagina pagina = null;

        byte[] bFile = readBytesFromFile(criteriosBusqueda);

        try {

            PreparedStatement preparedStatement
                    = ConectarMySQL.getConexion().
                            prepareStatement("Select * from  " + archiTab
                                    + " where archivo = ?");

            System.out.println("buscando: " + criteriosBusqueda + " en la BD "+ bFile);

            preparedStatement.setBytes(i, bFile);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Buscano img ...");
            if (resultSet.next()) {
                System.out.println("Encontrada ...");
                Blob blob = resultSet.getBlob("archivo");
                InputStream is = blob.getBinaryStream();
                byte[] bytes = IOUtils.readFully(is, -1, false);

                archivo = new Archivo(resultSet.getString("tipoarchvo"), bytes);

                PreparedStatement preparedStatement2
                        = ConectarMySQL.getConexion().
                                prepareStatement("Select * from  " + pagiTab
                                        + " where url = ?");

                preparedStatement2.setString(1, resultSet.getString("url"));
                ResultSet resultSet2 = preparedStatement2.executeQuery();

                pagina = new Pagina();
                if (resultSet2.next()) {
                    pagina.setUrl(resultSet2.getString("url"));
                    pagina.setFecha(resultSet2.getString("fecha"));
                    pagina.getArchivos().add(archivo);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return pagina;
    }

    @Override
    public String eliminar(String... criteriosBusqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pagina> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagina consultar(String... criteriosBusqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
