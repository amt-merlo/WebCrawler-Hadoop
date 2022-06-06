/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package webcrawler;
// import classes available in jsoup  
import java.io.FileWriter;
import DataBase.Connections;
import org.jsoup.Jsoup;   
import org.jsoup.nodes.Document;   
import org.jsoup.nodes.Element;   
import org.jsoup.select.Elements;   
// import exception and collection classes    
import java.io.IOException;   
import java.util.HashSet;   
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import webcrawler.WebCrawler;
import webcrawler.WebScrapper;
import webcrawler.PorterStemmer;
/**
 *
 * @author amtme
 */
public class main {
public static int quantity=0;
    /**
     * @param args the command line arguments
     */
    
    public static void scrappy(HashSet urlLinks)
    {
        int index = 0;
        JSONArray finalJSON = new JSONArray(); //JSON where we're going to save all the page's info
        
        
        Iterator<String> i = urlLinks.iterator();  
        while(i.hasNext())  
        {  
            JSONObject json = WebScrapper.getDocument(i.next());
            JSONObject pagina = new JSONObject();
            
            pagina.put("Pagina", json);
            finalJSON.add(pagina);
            index++;
        }
        try 
        {
            FileWriter file = new FileWriter("jsonFinal.json");
            file.write(finalJSON.toJSONString());
            file.close();
            
        } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
            System.out.println("Aquí se cae");
      }
    }
    
    
    public static void main(String[] args) {   
        /*
        WebCrawler obj = new WebCrawler();
        HashSet<String>urlLinks; 
       
        // pick a URL from the frontier and call the getPageLinks()method to get all the links related
        urlLinks = obj.getPageLinks("https://es.wikipedia.org/wiki/María_Pretiz", 0); 
        System.out.println("Crawl Ready");
        
        //scrapping all the pages that the crawler found and save the result in a JSON structure
        scrappy(urlLinks);
        System.out.println("Scrappy Ready"); //JSON doc is generated and saved
        
        //This is just a test
        PorterStemmer stemmer = new PorterStemmer();
        String word = stemmer.stemWord("technique");
        System.out.println(word);
        */
        
        //Trying the connection with the database 
        Connections connection = new Connections(); 
        connection.connect(); //Connecting to the database
        
        //Executing inserts
        //conection.createPagina(2, "Tim Burton's Best Movies", "www.wikipedia.org/wiki/timburtonmovies", 7, 250, 4, 7);
        //conection.createSubtitulo("Biografia", 2, 1);
        //conection.createImagen("upload/wiki/timBurtonBirthday.png", "Tim Burton's Birthday Party", 4, 2);
        //conection.createReferencia("Mejores directores del mundo", "www.mejoresTop10.es", true, 2);
        connection.createPopulares(1, "peliculas", 47, 2);
    }  
    
}
