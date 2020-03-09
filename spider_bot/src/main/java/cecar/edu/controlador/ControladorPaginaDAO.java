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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ProFanor
 */
public class ControladorPaginaDAO implements InterfazPaginaDAO<Pagina> {

    private String pagiTab = "pagina";
    private String archiTab = "archivos";

    @Override
    public String guardar(Pagina t) {
        String resultado = "OK";

        try {

            PreparedStatement preparedStatement = ConectarMySQL.getConexion().
                    prepareStatement("insert into " + pagiTab + " values (?,?)");

            preparedStatement.setString(1, t.getUrl());
            preparedStatement.setString(2, t.getFecha());
            preparedStatement.execute();
          
            //ciclo para guardar la coleción de archivos en la base de datos
            
            for (int i = 0; i < t.getArchivos().size(); i++) {
            
                System.out.println("cantidad: "+t.getArchivos().size());
                
                PreparedStatement preparedStatement2 = ConectarMySQL.getConexion().
                        prepareStatement("insert into " + archiTab + " values (?,?,?)");
                preparedStatement2.setString(1, t.getUrl());
                preparedStatement2.setString(2, t.getArchivos().get(i).getTipoArchivo());

                //guardar archivo en la base de datos
                FileInputStream fi = new FileInputStream(t.getArchivos().get(i).getArchivoDesc());
                preparedStatement2.setBlob(3, fi);

                preparedStatement2.execute();
            }

        } catch (SQLException e) {

            resultado = e.getMessage();
            System.out.println("Error 1: "+e);
            JOptionPane.showMessageDialog(null, "URL ya registrada");
            
        } catch (FileNotFoundException ex) { 
            System.out.println("Error: "+ ex);
            Logger.getLogger(ControladorPaginaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        

        return resultado;
    }

    @Override
    public String actualizar(Pagina t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagina consultar(String... criteriosBusqueda) {
        Pagina pagina=new Pagina();
       
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

}
