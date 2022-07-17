package com.database.stuff.DAO;

import com.database.stuff.Model.ArtFiles;
import com.database.stuff.Model.ArtistAndArtwork;
import com.database.stuff.Model.Artwork;

import java.time.LocalDateTime;
import java.util.List;

public interface ArtFilesDao {

    public List<String> getArtworkByArtistName(String name, int pageNum);

    public List<ArtistAndArtwork> getArtworkByTitle(int pageNum, String search);

    public List<String> getArtistName(int pageNum);

    public String getArtwork(String name, String title);

    public List<String> getSimilarArtworkByTitle(String name, int pageNum);

    public List<String> getSimilarArtworkByName(String name, int pageNum);

    public List<String> getArtistByFirstLetter(String letter, int pageNum);




}
