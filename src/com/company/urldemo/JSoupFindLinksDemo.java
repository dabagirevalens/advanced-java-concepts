package com.company.urldemo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class JSoupFindLinksDemo {
    public static void main(String[] args) throws IOException {

        final String url = "https://igihe.com/";
        URL newUrl = new URL(url);

        String folderName = newUrl.getHost();
        folderName = folderName.split("\\.", 3)[0];
        String path = "C:\\Users\\dabagire\\IdeaProjects\\advanced-java\\src\\com\\company\\urldemo\\" + folderName;

        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }

        for (String link : findLinks(url)) {
            if (!link.contains("https://") && !link.contains("http://") && !link.contains("#")) {
                URL linkUrl = new URL(url + link);
                URLConnection linkConn = linkUrl.openConnection();

                //read page content
                BufferedReader reader = new BufferedReader(new InputStreamReader(linkConn.getInputStream()));

                //create a new file to store the page content
                String fileName = "/" + linkUrl.getPath().split("/", 5)[1] + ".html";
                File my_file = new File("C:\\Users\\dabagire\\IdeaProjects\\advanced-java\\src\\com\\company\\urldemo\\" + folderName + fileName);
                if (!my_file.exists()) {
                    my_file.createNewFile();
                }

                FileWriter myFile = new FileWriter(my_file);

                String line;

                while ((line = reader.readLine()) != null) {
                    myFile.write(line);
                }

                myFile.close();
            }
        }

    }

    private static Set<String> findLinks(String url) throws IOException {

        Set<String> links = new HashSet<>();

        Document doc = Jsoup.connect(url)
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();

        Elements elements = doc.select("a[href]");
        for (Element element : elements) {
            links.add(element.attr("href"));
        }

        return links;

    }
}