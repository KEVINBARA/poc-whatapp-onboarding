package cashxix.customeronboarding.service;


import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class DownloadMedia {

    public void fetch(String imageUrl) throws IOException {
         // URL of the image to download
        String savePath = "C:\\Users\\baran\\Downloads\\FINTECH"+ File.separator +"image.jpeg"; // Path to save the downloaded image

        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            OutputStream outputStream = new FileOutputStream(savePath);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("Image downloaded successfully.");
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}
