package com.database.stuff.DAO;

import com.database.stuff.Model.ArtFiles;
import com.database.stuff.Model.ArtistAndArtwork;
import com.database.stuff.Model.Artwork;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArtFilesDaoJdbc implements ArtFilesDao{

    private final JdbcTemplate jdbcTemplate;

    public ArtFilesDaoJdbc(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    // Gets a list of 50 artists
    public List<String> getArtistName( int pageNum) {
        List<String> artist = new ArrayList<>();
        int rows = pageNum * 50;
        String sql = "Select artist_title " +
                "From artwork " +
                "Where artist_title > 'A' " +
                "Group By artist_title " +
                "Order By artist_title " +
                "Offset ? Rows Fetch Next 50 Rows Only;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,rows);
        while(result.next())
        {
            artist.add(result.getString("artist_title"));
        }
        return artist;
    }

    //Gets an piece of artwork given the title and artist name
    public String getArtwork(String name, String title)
    {
        String artworkID = "";
        String sql = "Select aic_id " +
                "From artwork " +
                "Where title = ? And artist_title = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, title, name);
        if(result.next()) {
            artworkID = result.getString("aic_id");
        }
        return artworkID;
    }

    @Override
    public List<String> getSimilarArtworkByTitle(String name, int pageNum) {
        List<String> titles = new ArrayList<>();
        int rows = pageNum * 50;
        String sql = "Select title " +
                "From artwork " +
                "Where title ILike ? " +
                "Group By title " +
                "Order By title " +
                "Offset ? Rows Fetch Next 50 Rows Only;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,"%"+name+"%", rows);
        while(result.next())
        {
            titles.add(result.getString("title"));
        }
        return titles;
    }



    @Override
    public List<String> getSimilarArtworkByName(String name, int pageNum) {
        List<String> artist = new ArrayList<>();
        int rows = pageNum * 50;
        String sql = "Select artist_title " +
                "From artwork " +
                "Where artist_title ILike ? " +
                "Group By artist_title " +
                "Order By artist_title " +
                "Offset ? Rows Fetch Next 50 Rows Only;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,"%"+name+"%", rows);
        while(result.next())
        {
            artist.add(result.getString("artist_title"));
        }
        return artist;
    }

    @Override
    public List<String> getArtistByFirstLetter(String letter, int pageNum) {
        List<String> artist = new ArrayList<>();
        int rows = pageNum * 50;
        String sql = "Select artist_title " +
                "From artwork " +
                "Where artist_title > ? " +
                "Group By artist_title " +
                "Order By artist_title " +
                "Offset ? Rows Fetch Next 50 Rows Only;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,letter, rows);
        while(result.next())
        {
            artist.add(result.getString("artist_title"));
        }
        return artist;
    }

    @Override
    //Gives a list of art pieces from a particular artist
    public List<String> getArtworkByArtistName(String name, int pageNum) {
        List<String> aF = new ArrayList<>();
        String sql = "Select * " +
                "From artwork " +
                "Where artist_title = ? " +
                "Order By title " +
                "Offset ? Rows Fetch Next 50 Rows Only;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name, pageNum);
        while(result.next())
        {
            aF.add(result.getString("title"));
        }
        return aF;
    }

    @Override
    public List<ArtistAndArtwork> getArtworkByTitle(int pageNum, String search) {
        List<ArtistAndArtwork> title = new ArrayList<>();
        int rows = pageNum * 50;
        String sql = "Select title, artist_title " +
                "From artwork " +
                "Where title ILike ? " +
                "Group By title, artist_title " +
                "Order By title " +
                "Offset ? Rows Fetch Next 50 Rows Only;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,"%"+search+"%",rows);
        while(result.next())
        {
            String artist = result.getString("artist_title");
            String art = result.getString("title");
            ArtistAndArtwork aAW = new ArtistAndArtwork(artist, art);
            title.add(aAW);
        }
        return title;
    }

    public ArtistAndArtwork count()
    {
        Random rand = new Random();
        int count = 0;
        ArtistAndArtwork random = null;
        String sql = "Select count(*) " +
                "From artwork;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next())
        {
            count = result.getInt("count");
        }
        sql = "Select title, artist_title " +
                "From artwork " +
                "Where database_id = ?;";
        result = jdbcTemplate.queryForRowSet(sql, rand.nextInt(count));
        if(result.next())
        {
            String artist = result.getString("artist_title");
            String artwork = result.getString("title");
            random = new ArtistAndArtwork(artist, artwork);
        }
        return random;
    }

}
