import java.net.*;

import org.jsoup.nodes.Attribute;
import org.jsoup.*;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

       //simpleSearch();
       usingJsoup();

    }

public static void simpleSearch() throws Exception{
   URL oracle = new URL("https://www.bing.com/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        System.out.println("Testing the program");
        while ((inputLine = in.readLine()) != null)
            if(inputLine.contains("<meta"))
            {
               System.out.println(inputLine);
            }
        in.close();
}
    // Jsoup package was added
    public static void usingJsoup() throws Exception
    {
      String url = "https://www.bing.com/";
      Document doc = Jsoup.connect(url).get();
      Elements metaTags = doc.select("meta");
      int i = 0;
      for (Element meta : metaTags) {
          for(Attribute attr : meta.attributes()) {
            if(attr.getKey().contains("content")){
              System.out.format("%s = %s\n", attr.getKey(), attr.getValue());
            }
          }
      }
    }
}