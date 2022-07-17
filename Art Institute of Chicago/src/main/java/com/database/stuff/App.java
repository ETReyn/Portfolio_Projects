package com.database.stuff;

import com.database.stuff.DAO.ArtFilesDao;
import com.database.stuff.DAO.ArtFilesDaoJdbc;
import com.database.stuff.Model.ArtistAndArtwork;
import com.database.stuff.Model.Artwork;
import com.database.stuff.Services.ArtworkService;
import com.database.stuff.Services.ConsoleService;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    private ArtFilesDaoJdbc artFilesDaoJdbc;
    private static ConsoleService consoleService;
    private ArtworkService artworkService = new ArtworkService();

    public static void main(String[] args) {
        System.out.println();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/artwork");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        App app = new App(dataSource);

        app.consoleService.run();
    }

    App(DataSource dataSource) {
        artFilesDaoJdbc = new ArtFilesDaoJdbc(dataSource);
        consoleService = new ConsoleService(new Scanner(System.in), artFilesDaoJdbc , artworkService);

    }


}
