package com.database.stuff.Services;

import com.database.stuff.Model.Artwork;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.net.URI;

public class ArtworkService {

    private static final String API_BASE_URL = "https://api.artic.edu/api/v1/artworks/";
    private static final String API_SUFFIX = "?fields=id,title,image_id";
    private static final String API_PICTURE_SUFFIX = "/full/843,/0/default.jpg";
    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        ArtworkService aWS = new ArtworkService();
        aWS.run();
    }

    public void run()
    {
        Artwork aW = restTemplate.getForObject(API_BASE_URL + 4 + API_SUFFIX, Artwork.class);
        System.out.println(aW.toString());
    }

    public void getArtwork(String value)
    {
        Artwork aW = new Artwork();
        try{
            aW = restTemplate.getForObject(API_BASE_URL + value + API_SUFFIX, Artwork.class);

        }catch (Exception e)
        {
            System.out.println("Could not return that work of art, please try another.");
        }
        String urlBuilder = aW.getConfig().getIiifUrl();
        urlBuilder = urlBuilder + "/" + aW.getData().getImageId() + API_PICTURE_SUFFIX;
        displayArt(urlBuilder);
    }

    public void displayArt(String uRL)
    {
        Desktop desk = Desktop.getDesktop();
        try
        {
            desk.browse(new URI(uRL));
        }catch(Exception e)
        {
            System.out.println("Could not open website");
        }
    }

}
