/**
 * Clase: ControladorScraping.java
 *
 * @version: 0.1
 *
 * Fecha de Creación: 10/03/2020
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
package cecar.edu.controlador;

import cecar.edu.modelo.Archivo;
import cecar.edu.modelo.Pagina;
import static cecar.edu.vista.GUI_Usuario.urlValidator;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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

    private static Pagina pagina = new Pagina();
    private static Archivo archivo = new Archivo();

    public static byte[] descargarImg(String url) throws IOException {
        byte[] a = Jsoup.connect(url).ignoreContentType(true).execute().bodyAsBytes();
        return a;
    }

    //metodo para no repetir url para escrapear
    public static boolean bscarUrl(String url) {
        for (int a = 0; a < paginasEncontradas.size(); a++) {
            if (url.equals(paginasEncontradas.get(a))) {
                return false;

            }
        }

        return true;
    }

    public static void getPagina(String link) throws SQLException {

        String url = "";

        //Se inicia el proceso de Scraping
        try {
            Document document = Jsoup.connect(link).get();

            ControladorPaginaDAO guardarPagina = new ControladorPaginaDAO();
            pagina.setUrl(link);
            pagina.setFecha(capturarFachaHora());
            String s = guardarPagina.guardar(pagina);
            if (s.equals("OK")) {
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
                //descargar archivos multimedia
                Elements elementsArchiV = document.getElementsByTag("source");
                for (Element file : elementsArchiV) {
                    //se lee el formato de archivo
                    String urlA = file.attr("abs:src");
                    System.out.println("Link video: " + urlA);
                    int i = urlA.lastIndexOf(".");
                    String sf = urlA.substring(i);

                    archivo.setArchivoDesc(descargarImg(urlA));
                    archivo.setTipoArchivo(sf);
                    guardarPagina.guardarArchivo(archivo, link);
                    sf = "";

                }
                

                //saca las url de otros sitios 
                Elements elements = document.select("a[href]");

                System.out.println("URL href---------------------------");
                //traer todas las url que contiene la pagina
                for (Element fila : elements) {

                    //valida si es una pagina web difernte de la que se esta validando, zaluego se gurda en un array
                    url = fila.attr("href");

                    //valida si es una pagina web difernte de la que se esta validando, luego se gurda en un array
                    if (urlValidator(url)) {
                        System.out.println("Link paginas: " + url);
                        System.out.println("texto link: " + fila.text());
                        
                        //valida si la url ya esta registrada
                        if (bscarUrl(url)){
                            //si no esta la agrega 
                         paginasEncontradas.add(url);   
                        }

                    }

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
