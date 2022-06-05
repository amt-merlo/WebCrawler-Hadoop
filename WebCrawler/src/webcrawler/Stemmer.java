/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webcrawler;

import java.io.IOException;
import java.io.StringReader;
import java.lang.Runtime.Version;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.jsoup.select.QueryParser;

/**
 *
 * @author amtme
 */
public class Stemmer {/*
    public static void applyStemming(String word)
    {
        
        EnglishAnalyzer en_an = new EnglishAnalyzer();
        QueryParser parser = new QueryParser("your_field", en_an);
        String str = "amenities";
        System.out.println("result: " + parser.parse(str)); //amenit
    }
    
    
    public static String stem(String string) throws IOException {
        TokenStream tokenizer = new StandardTokenizer(Version.LUCENE_47, new StringReader(string));
        tokenizer = new StandardFilter(Version.LUCENE_47, tokenizer);
        tokenizer = new LowerCaseFilter(Version.LUCENE_47, tokenizer);
        tokenizer = new PorterStemFilter(tokenizer);

        CharTermAttribute token = tokenizer.getAttribute(CharTermAttribute.class);

        tokenizer.reset();

        StringBuilder stringBuilder = new StringBuilder();

        while(tokenizer.incrementToken()) {
            if(stringBuilder.length() > 0 ) {
                stringBuilder.append(" ");
            }

            stringBuilder.append(token.toString());
        }

        tokenizer.end();
        tokenizer.close();

        return stringBuilder.toString();
    }
    
    */
}

