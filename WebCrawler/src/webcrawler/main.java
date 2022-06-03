/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package webcrawler;
// import classes available in jsoup  
import java.io.FileWriter;
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
/**
 *
 * @author amtme
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void scrappy(HashSet urlLinks)
    {
        int index = 0;
        JSONObject finalJSON = new JSONObject(); //JSON where we're going to save all the page's info
        
        Iterator<String> i = urlLinks.iterator();  
        while(i.hasNext())  
        {  
            JSONObject json = WebScrapper.getDocument(i.next());
            System.out.println(json.toString());
            finalJSON.put("Page "+index ,json);
            index++;
        }
        try 
        {
            FileWriter file = new FileWriter("jsonWiki.json");
            file.write(finalJSON.toJSONString());
            file.close();
            System.out.println(finalJSON.toString());
        } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
            System.out.println("Aquí se cae");
      }
    }
    
    
    public static void main(String[] args) {   
        WebCrawler obj = new WebCrawler();
        HashSet<String>urlLinks; 
       
        // pick a URL from the frontier and call the getPageLinks()method  
        urlLinks = obj.getPageLinks("https://es.wikipedia.org/wiki/María_Pretiz", 0);  
        scrappy(urlLinks);
        
        }  
    
}
