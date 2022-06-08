/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analysis;
import DataBase.Connections;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author amtme
 */
public class Statistic {
    ArrayList palabras = new ArrayList<String>();
    
    public static void readJSON(){
        
        JSONParser parser = new JSONParser();

        try{
            //We open the json file
            Object obj = parser.parse(new FileReader("jsonFinalIngles.json"));
            
            //This action gets the entire JSON
            JSONArray paginas = (JSONArray) obj;
            
            //we loop through the jsonArray page by page
            for(int i = 0; i < paginas.size(); i++ ){
                
                //This action gets one page at a time
                JSONObject pagina = (JSONObject) paginas.get(i);
                crearPagina(pagina, i);
                //int result = countSubtitle(pagina);
                //int differentSubTitles = wordsInTitle(pagina);
                //int differentContent = wordsInContent(pagina);
                //System.out.println("Cantidad de Subtitulos: " + result);  
                //System.out.println("Subtitulos distintos: " + differentSubTitles); 
                //System.out.println("Contenido distintos: " + differentContent); 
               // System.out.println("----------------------------------------------");
            }

        }catch(FileNotFoundException e ){}
        catch(IOException e){}
        catch(ParseException e){}
    }
     public static int countSubtitle(JSONObject pagina, int ID){
        int count = 0;
        //Se agarra el contenido de la pagina
        JSONObject contenido =  (JSONObject) pagina.get("Pagina");
        if(contenido.size()>0 && contenido!=null){
            //Se agarra los subtitulos del contenido
            JSONArray subtitulos = (JSONArray) contenido.get("Subtitles");
            if(subtitulos!=null){
                System.out.println("Titulos " + contenido.get("Subtitles"));
                //System.out.println("Titulos Size " + subtitulos.size());
                count = subtitulos.size();
                 //Verifica que no venga vacio el array con subtitulos
                if(count>0){
                    subtitulos.forEach(subtitulo -> {
                   
                    });
                }     
            }
           
        }
        return count;
    }
    //Counts the amount of words per subtitble
    public static int wordsInSubTitle(JSONObject pagina, int ID, Connections connection) {
        int count = 0;
        //Se almacena todas las palabras distintas
        ArrayList words = new ArrayList<String>();
        //Se agarra el contenido de la pagina
        JSONObject contenido = (JSONObject) pagina.get("Pagina");
        if (!contenido.isEmpty()) {
            //Se agarra el contenido de los subtitulos
            JSONArray subtitulos = (JSONArray) contenido.get("Subtitles");
            //Verifica que no venga vacio el array con subtitulos
            if (subtitulos != null) {
                if (!subtitulos.isEmpty()) {
                    subtitulos.forEach(subtitulo -> { //for each subtitle
                        //Aqui se separan las palabras por espacios
                        String[] contentDetail = subtitulo.toString().split("\\ ");
                        //Aqui se convierte el array en un arrayList
                        ArrayList<String> sublist = new ArrayList<String>(Arrays.asList(contentDetail));
                        sublist.forEach(contentIndi -> {
                            boolean existe = words.contains(contentIndi);
                            if(existe){
                            }
                            else{
                                words.add(contentIndi);
                            }
                        });
                        //We add the subtitle to the database
                        //Trying the connection with the database 
                        
                        
                        
                        int cantidad = words.size();
                        connection.createSubtitulo(subtitulo.toString(), ID, cantidad);
                        words.clear();
                        
                    });
                }
            }
        }
        count = words.size();
        
        return count;
    }
    
    //counts the amount of different words in the page title
    public static int wordsInTitleRaro(JSONObject pagina){
        int count = 0;
        //Se almacena todas las palabras distintas
        ArrayList words = new ArrayList<String>();
        //Se agarra el contenido de la pagina
        JSONObject contenido =  (JSONObject) pagina.get("Pagina");
        if(contenido.size()>0){
            //Se agarra el contenido de los subtitulos
            JSONArray subtitulos = (JSONArray) contenido.get("Subtitles");
            //Verifica que no venga vacio el array con subtitulos
            if(subtitulos.size()>0){
                subtitulos.forEach(subtitulo -> {
                    boolean existe = words.contains(subtitulo);
                    if(existe){
                        System.out.println("Ya se encuentra en la lista");
                    }
                    else{
                        words.add(subtitulo);
                    }
                });
            }     
        }
        count = words.size();
        return count;
    }
    
    //Counts the amount of words of the title
    public static int wordsInTitle(JSONObject pagina){
    int count = 0;
    String title = "";
    //Se almacena todas las palabras distintas
    ArrayList words = new ArrayList<String>();
    //Se agarra el contenido de la pagina
    JSONObject contenido =  (JSONObject) pagina.get("Pagina");
    if(contenido.size()>0){
        //Se agarra el contenido del content
        title = (String)contenido.get("Title");
        //Aqui se separan las palabras por espacios
        String[] contentDetail = title.split("\\ ");
        //Aqui se convierte el array en un arrayList
        ArrayList<String> sublist = new ArrayList<String>(Arrays.asList(contentDetail));
        sublist.forEach(contentIndi -> {
            boolean existe = words.contains(contentIndi);
            if(existe){
            }
            else{
                words.add(contentIndi);
            }
        });

    }
    count = words.size();
    return count;
}
    
    //counts the amount of words per content
    public static int wordsInContent(JSONObject pagina){
        int count = 0;
        String content = "";
        //Se almacena todas las palabras distintas
        ArrayList words = new ArrayList<String>();
        //Se agarra el contenido de la pagina
        JSONObject contenido =  (JSONObject) pagina.get("Pagina");
        if(contenido.size()>0){
            //Se agarra el contenido del content
            content = (String)contenido.get("Content");
            if(content!=null){
                //Aqui se separan las palabras por espacios
                String[] contentDetail = content.split("\\ ");
                //Aqui se convierte el array en un arrayList
                ArrayList<String> sublist = new ArrayList<String>(Arrays.asList(contentDetail));
                sublist.forEach(contentIndi -> {
                    boolean existe = words.contains(contentIndi);
                    if(existe){
                    }
                    else{
                        words.add(contentIndi);
                    }
                });
            }
            
            
        }
        count = words.size();
        return count;
    }
    
    //counts occurrences per word
    public static void wordCount(JSONObject pagina){
        Map<String, Integer> map = new HashMap<String, Integer>();
        String content = "";
        //Aqui es para saber cual es el valor mas alto 
        int valorMax = -1;
        //Se almacena todas las palabras distintas
        ArrayList words = new ArrayList<String>();
        //Se agarra el contenido de la pagina
        JSONObject contenido =  (JSONObject) pagina.get("Pagina");
        if(contenido.size()>0){
        //Se agarra el contenido del content
        content = (String)contenido.get("Content");
        //Aqui se separan las palabras por espacios
        String[] contentDetail = content.split("\\ ");
        //Aqui se convierte el array en un arrayList
        ArrayList<String> sublist = new ArrayList<String>(Arrays.asList(contentDetail));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            final int valorActual = entry.getValue();
            if (valorActual > valorMax)
                valorMax = valorActual;
        }
        sublist.forEach(contentIndi -> {
            boolean existe = words.contains(contentIndi);
            int existencia = 1;
            if(existe){
                int changeValue = map.get(contentIndi);
                changeValue += 1;
                map.put(contentIndi,changeValue);
            }
            else{
                map.put(contentIndi, existencia);
                words.add(contentIndi);
            }
        });            
        }  

        map.entrySet().forEach((entry) -> {
           
           System.out.println(entry.getKey() + " aparece " + entry.getValue() + " veces");
        });   
    }
    
    public static void crearPagina(JSONObject pagina, int ID){
        int totalPalabras, cantPalabrasTitulo=0, cantSubtitulos;
        String URL, titulo = "";
        
        //Se agarra el contenido de la pagina
        JSONObject contenido =  (JSONObject) pagina.get("Pagina");
        if(contenido.size()>0){
            
            //we get the url
            URL = contenido.get("URL").toString();
            
            //Se agarra el contenido del titulo
            if(contenido.get("Title")!=null){
                titulo = contenido.get("Title").toString();
                cantPalabrasTitulo = wordsInTitle(pagina);
            }
            
            
            totalPalabras = wordsInContent(pagina);
            cantSubtitulos = countSubtitle(pagina, ID);
            
            System.out.println(ID+" URL:  "+URL+" Titulo:  "+titulo);
            //Trying the connection with the database 
            Connections connection = new Connections(); 
            connection.connect(); //Connecting to the database
            
            //We insert the pafe info into the database
            connection.createPagina(ID, titulo, URL, cantSubtitulos, totalPalabras, cantPalabrasTitulo, 0);
            
            //We insert all the subtitles in the database
            wordsInSubTitle(pagina, ID, connection);
            
        }
        
    }
}
