/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webcrawler;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author amtme
 */
public class WebScrapper {
    public static JSONObject getDocument(String url) {
        
        //First, we connect to the page by the given url
        Connection conn = Jsoup.connect(url);
        Document document = null;
        try {
            document = conn.get();
        } catch (IOException e) { // handle error
            System.out.println("Error controlado en el scrapping");
        
        }
        
        //Then, we create a JSONObject object
        JSONObject jsonObject = new JSONObject();
        
        //We extract all the p tags
        try
        {
            Elements paragraphs = document.select("p");
            String text = "";
            for (Element p : paragraphs.select("p"))
            {
                text += p.text();
            }

            jsonObject.put("Content", text); //We add it to the json structure
        }catch(Exception h){
            System.out.println("Controlada HttpStatusException");
        }
       
        
        try
        {
            //We extract all the subtitles under the h2 tag
            Elements h2 = document.select("h2");
            //We make a JSONArray to put all the subtitles together
            JSONArray array = new JSONArray();

            //Adding the subtitles to the JSONArray
            for (Element e : h2.select("h2"))
            {   
                array.add(e.text().replace("[editar]", ""));
            }

            jsonObject.put("Subtitles", array); //we add them to the json structure
            
            //We get the page title
            String title = document.select("h1").text();
        
        jsonObject.put("Title", title); //we add it to the json structure
        }catch(Exception e){
            
        }
        
        
        
        
        
        
        return jsonObject;
        
    }
    
    
}
