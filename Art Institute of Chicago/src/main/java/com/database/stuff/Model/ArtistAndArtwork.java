package com.database.stuff.Model;

public class ArtistAndArtwork {

    private String artist;
    private String artwork;

    public ArtistAndArtwork(String artist, String artwork) {
        this.artist = artist;
        this.artwork = artwork;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }
}

