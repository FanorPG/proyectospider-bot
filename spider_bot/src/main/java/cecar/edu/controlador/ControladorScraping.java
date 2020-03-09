/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecar.edu.controlador;

import cecar.edu.modelo.Archivo;
import cecar.edu.modelo.Pagina;
import static cecar.edu.vista.GUI_Usuario.urlValidator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Fanorpro
 */
public class ControladorScraping {

    public static ArrayList<String> paginasEncontradas = new ArrayList<>();
    
    public static void getpaises(String link) {

        String url="";
        Pagina pagina = new Pagina();
        Archivo archivo=new Archivo();
        File arc;
        //Se inicia el proceso de Scraping
        try {
            Document document = Jsoup.connect(link).get();

            pagina.setUrl(link);
            pagina.setFecha(capturarFachaHora());
            
            Elements elementsArchi=document.select("img[src]");
            for(Element file: elementsArchi){
                
                System.out.println("Link img: " + file.attr("src"));
                System.out.println("texto img: " + file.text());
                //arc=new File(file.attr("src"));
                //archivo.setArchivoDesc(arc);
                
                archivo.setTipoArchivo("hh");
                pagina.getArchivos().add(archivo);
                
            }
            ControladorPaginaDAO guardarPagina=new ControladorPaginaDAO();
            guardarPagina.guardar(pagina);
            
            Elements elements = document.select("a[href]");
                      
            //traer todas las url que contiene la pagina
            for (Element fila : elements) {

                url = fila.attr("href");
                System.out.println("Link: " + url);
                System.out.println("texto: " + fila.text());

                //valida si es una pagina web difernte de la que se esta validando, luego se gurda en un array
                if (urlValidator(url)) {
                    paginasEncontradas.add(url);
                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String capturarFachaHora() {
        String data = "";
        Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos, anio, mes, dia;

        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        anio = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MARCH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        data = anio + "/" + mes + "/" + dia + " " + hora + ":" + minutos + ":" + segundos;
        System.out.println(data);
        return data;
    }
}
