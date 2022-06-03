/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webcrawler;

import java.io.IOException;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author amtme
 */

/*Code based on the online example by: https://www.javatpoint.com/web-crawler-java*/

public class WebCrawler {
    // initialize MAX_DEPTH variable with final value  
    private static final int MAX_DEPTH = 2;  
    // create set that will store links  
    private HashSet<String>urlLinks;    
        
        // initialize set using constructor  
        public WebCrawler() {   
            urlLinks = new HashSet<String>();   
        }   
        
         
    // create method that finds all the page link in the given URL   
    public HashSet getPageLinks(String URL, int depth) {   

        //we use the conditional statement to check whether we have already crawled the URL or not.  
        // we also check whether the depth reaches to MAX_DEPTH or not  
        if ((!urlLinks.contains(URL) && (depth <MAX_DEPTH))) {   
             System.out.println(">> Depth: " + depth + " [" + URL + "]");   
            // use try catch block for recursive process  
            try {   
                // if the URL is not present in the set, we add it to the set  
                urlLinks.add(URL);   
                // fetch the HTML code of the given URL by using the connect() and get() method and store the result in Document  
                Document doc = Jsoup.connect(URL).get();   

                // we use the select() method to parse the HTML code for extracting links of other URLs and store them into Elements  
                Elements availableLinksOnPage = doc.select("a[href]");   
                // increase depth  
                depth++;   
                // for each extracted URL, we repeat above process  
                for (Element page : availableLinksOnPage) {   

                    //here is the recursion
                    // call getPageLinks() method and pass the extracted URL to it as an argument  
                    getPageLinks(page.attr("abs:href"), depth);   
                }   
            }   
            // handle exception  
            catch (IOException e) {   
                // print exception messages  
                System.err.println("For '" + URL + "': " + e.getMessage());   
            }   
        } 
        return urlLinks;
    }   
}
