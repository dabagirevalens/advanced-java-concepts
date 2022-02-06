package com.company.urldemo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://igihe.com/");

        URLConnection conn = url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line;
        FileWriter myFile = new FileWriter("C:\\Users\\dabagire\\IdeaProjects\\advanced-java\\src\\com\\company\\urldemo\\output.html");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            myFile.write(line);
        }

        myFile.close();
    }
}
