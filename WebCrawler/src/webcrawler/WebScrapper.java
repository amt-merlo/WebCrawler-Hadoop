/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webcrawler;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
import java.util.Locale;
/**
 *
 * @author amtme
 */
public class WebScrapper {
    public static JSONObject getDocument(String url) {
        PorterStemmer stemmer = new PorterStemmer();
        
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
        /*jsonObject.put("Page",main.quantity);
        main.quantity++;*/
        
          
        /*=====Extracting all the <p> tags=====*/
        try
        {
            jsonObject.put("URL", url);
            
            /*=====Extracting the page title=====*/
            String title = document.select("h1").text();
            title = stemmer.stem(title);
        
            jsonObject.put("Title", title); //we add it to the json structure
            
            Elements paragraphs = document.select("p");
            String text = "";
            for (Element p : paragraphs.select("p"))
            {
                
                text += p.text();
            }

            String cleanedText = removerStopWords(text); //Removing stopwords 
            cleanedText = cleanText(cleanedText); //Removing symbols
            
            cleanedText = stemmer.stem(cleanedText); //Stemming the text
            
            
            jsonObject.put("Content", cleanedText); //We add it to the json structure
        }catch(Exception h){
            System.out.println("Controlada HttpStatusException");
        }
       
        
        /*=====Extracting all the subtitles under the h2 tag=====*/
        try
        {
            Elements h2 = document.select("h2");
            //We make a JSONArray to put all the subtitles together
            JSONArray array = new JSONArray();

            //Adding the subtitles to the JSONArray
            for (Element e : h2.select("h2"))
            {   
                String subtitle = e.text().replace("[editar]", "");
                subtitle = e.text().replace("[edit]", "");
                subtitle = stemmer.stem(subtitle); //Stemming the words
                array.add(subtitle);
            }

            jsonObject.put("Subtitles", array); //we add them to the json structure
            
           
            /*=====Extracting the page images src and alt=====*/
            
            JSONObject imagesArray = new JSONObject(); //We have a json to put all the single image's information together
            int index=0;
            
            Elements images = document.getElementsByTag("img");
            for(Element image : images)
            {
                JSONObject singleImage = new JSONObject(); //We have a json to put [image scr, image alt]
                
                String cleanedText = removerStopWords(image.attr("alt")); //Removing stopwords 
                cleanedText = cleanText(cleanedText); //Removing symbols
                cleanedText = stemmer.stem(cleanedText); //Stemming the text
                
                singleImage.put("url", image.attr("src"));
                singleImage.put("alt", cleanedText);
                imagesArray.put("Image: "+index, singleImage);
                index++;
            }
            
           jsonObject.put("Images", imagesArray); //we add the images array to the json structure 
        }catch(Exception e){
            
        }
        
        
        return jsonObject;
        
    }
    
    public static String removerStopWords(String texto){
        try{
            String archivo = "C:\\Users\\amtme\\Documents\\NetBeansProjects\\WebCrawler\\stopwords.txt";
            List<String> stopwords = Files.readAllLines(Paths.get(archivo));
            String[] nuevo = texto.toLowerCase().split(" ");
            StringBuilder builder = new StringBuilder();
            for (String palabra: nuevo){
                
                if(!stopwords.contains(palabra)) { //removemos stopwords
                    builder.append(palabra);
                    builder.append(' ');
                }
            }
            String result = builder.toString().trim();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }
    
  public static String cleanText(String text){
      String cleaned = text.replaceAll("[*:;().=?¿¡!,]", "");
     
      return cleaned;
  }
}
