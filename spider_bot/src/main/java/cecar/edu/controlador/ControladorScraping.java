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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import org.jsoup.Connection.Response;
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

    private static Pagina pagina = new Pagina();
    private static Archivo archivo = new Archivo();
    
    public static byte[] descargarImg(String url) throws IOException{
        byte[] a=Jsoup.connect(url).ignoreContentType(true).execute().bodyAsBytes();
        return a;
    }

    public static void getPagina(String link) throws SQLException {

        String url = "";

        File arc;
        //Se inicia el proceso de Scraping
        try {
            Document document = Jsoup.connect(link).get();

            ControladorPaginaDAO guardarPagina = new ControladorPaginaDAO();
            pagina.setUrl(link);
            pagina.setFecha(capturarFachaHora());
            String s= guardarPagina.guardar(pagina);
            if(s.equals("OK")){
            Elements elementsArchi = document.getElementsByTag("img");
            for (Element file : elementsArchi) {
                //se lee el formato de archivo
                String urlA = file.attr("abs:src");
                System.out.println("Link img: " + urlA);
                int i = urlA.lastIndexOf(".");
                String sf = urlA.substring(i);

                archivo.setArchivoDesc(descargarImg(urlA));
                archivo.setTipoArchivo(sf);
                guardarPagina.guardarArchivo(archivo, link);
                sf = "";

            }
            }

            
            Elements elements = document.select("a[href]");

            //traer todas las url que contiene la pagina
            for (Element fila : elements) {

                url = fila.attr("href");

                //valida si es una pagina web difernte de la que se esta validando, luego se gurda en un array
                if (urlValidator(url)) {
                    System.out.println("Link paginas: " + url);
                    System.out.println("texto link: " + fila.text());
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
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        data = anio + "/" + mes + "/" + dia + " " + hora + ":" + minutos + ":" + segundos;
        System.out.println(data);
        return data;
    }
}
