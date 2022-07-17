package com.database.stuff.Services;

import com.database.stuff.DAO.ArtFilesDaoJdbc;
import com.database.stuff.Model.ArtistAndArtwork;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private Scanner scanner;
    private ArtworkService artworkService;
    private ArtFilesDaoJdbc artFilesDaoJdbc;

    public ConsoleService(Scanner scanner, ArtFilesDaoJdbc artFilesDaoJdbc, ArtworkService artworkService) {
        this.scanner = scanner;
        this.artFilesDaoJdbc = artFilesDaoJdbc;
        this.artworkService = artworkService;
    }


    public void run() {
        int userInt = 1;
        while (userInt != 0) {
            userInt = printMenu();
            if (userInt == 1) {
                String artist = getArtists();
                String art = "";
                if (!artist.equalsIgnoreCase("break")) {
                    art = getArt(artist);
                    if (art.equalsIgnoreCase("break")) {
                        continue;
                    }
                } else {
                    continue;
                }
                artworkService.getArtwork(artFilesDaoJdbc.getArtwork(artist, art));
            }
            if (userInt == 3) {
                String artist = searchArtist();
                if (!artist.equalsIgnoreCase("break")) {
                    String art = getArt(artist);
                    if (!art.equalsIgnoreCase("break")) {
                        artworkService.getArtwork(artFilesDaoJdbc.getArtwork(artist, art));
                    }
                }
            }
            if (userInt == 2) {
                String artist = searchArtistByFirstLetter();
                if (!artist.equalsIgnoreCase("break")) {
                    String art = getArt(artist);
                    if (!art.equalsIgnoreCase("break")) {

                        artworkService.getArtwork(artFilesDaoJdbc.getArtwork(artist, art));
                    }
                }
            }
            if(userInt == 4)
            {
                ArtistAndArtwork art = searchForArt();
                if(art != null)
                {
                    artworkService.getArtwork(artFilesDaoJdbc.getArtwork(art.getArtist(), art.getArtwork()));
                }
            }
            if(userInt == 5)
            {
                ArtistAndArtwork randomWork = randomWork();
                System.out.println(randomWork.getArtist());
                System.out.println(randomWork.getArtwork());
                artworkService.getArtwork(artFilesDaoJdbc.getArtwork(randomWork.getArtist(), randomWork.getArtwork()));
            }
        }
    }

    //UNCOUPLE THESE TWO METHODS
    public String getArtists() {
        int result = 1;
        int index = 0;
        String singularArtist = "break";
        while (result > 0) {
            List<String> artist;
            artist = artFilesDaoJdbc.getArtistName(index);
            result = printArtists(artist, index);
            if (result == 51) {
                index++;
            }
            if (result == 52) {
                break;
            }
            if (result == -1) {
                result = 1;
                continue;
            }
            if (result < artist.size() && result > -1) {
                singularArtist = artist.get(result);
                result = -1;
            }
        }
        return singularArtist;
    }

    public ArtistAndArtwork randomWork()
    {
        return artFilesDaoJdbc.count();
    }


    public ArtistAndArtwork searchForArt()
    {
        System.out.print("Enter the name of a piece of artwork: ");
        String artwork = scanner.nextLine();
        int index = 0;
        int result = 0;
        ArtistAndArtwork aAW = null;
        List<ArtistAndArtwork> searchList = artFilesDaoJdbc.getArtworkByTitle(index*50, artwork);
        if(searchList.size() == 0)
        {
            invalidSearchArt(artwork);
            return aAW;
        }
        while(true)
        {
            result = printWork(searchList, index);
            if (result == 51 && artFilesDaoJdbc.getArtworkByTitle((index+1)*50, artwork).size() > 0) {
                index++;
                searchList = artFilesDaoJdbc.getArtworkByTitle(index*50, artwork);

            }
            if (result == 52) {
                break;
            }
            if (result == -1) {
                result = 1;
                continue;
            }
            if(result > -1 && result < searchList.size())
            {
                aAW = new ArtistAndArtwork(searchList.get(result).getArtist(), searchList.get(result).getArtwork());
                break;
            }
        }
        return aAW;
    }

    public String getArt(String singularArtist) {
        int index = 0;
        int result1 = 1;
        String artName = "break";
        while (result1 > 0) {
            List<String> works = artFilesDaoJdbc.getArtworkByArtistName(singularArtist, (50*index));
            result1 = printWorks(works, index, singularArtist);
            if (result1 == 51 && artFilesDaoJdbc.getArtworkByArtistName(singularArtist, (index+1)*50).size() > 0) {
                index++;
            }
            if (result1 == 52) {
                break;
            }
            if (result1 == -1) {
                result1 = 1;
                continue;
            }
            if (result1 > -1 && result1 < works.size()) {
                artName = works.get(result1);
                result1 = -1;
            }
        }
        return artName;
    }

    public String searchArt()
    {
        String art = "";
        int index = 0;
        int result = 0;
        System.out.print("Enter the name of a piece of artwork: ");
        String search = scanner.nextLine();
        List<String> similarPieces = artFilesDaoJdbc.getSimilarArtworkByTitle(search, index);
        if (similarPieces.size() == 0)
        {
            invalidSearch(search);
            return "break";
        }
        while(true)
        {
            int artID = printWorks(similarPieces, index);
            if(artID == 52)
            {
                return "break";
            }
            if(artID == 51 && artFilesDaoJdbc.getSimilarArtworkByTitle(search, (index+1)*50).size() > 0)
            {
                index++;
            }
            if(artID > -1 && artID < similarPieces.size())
            {
                return similarPieces.get(artID);
            }
        }

    }

    public String searchArtist() {
        String artist = "";
        int index = 0;
        int result = 0;
        String search = searchForArtistFirst();
        List<String> similarArtistName = artFilesDaoJdbc.getSimilarArtworkByName(search, index);
        if (similarArtistName.size() == 0) {
            invalidSearch(search);
            return "break";
        }
        while (result >= 0) {
            int artistID = printArtists(similarArtistName, index);
            if (artistID == 52) {
                return "break";
            }
            if (artistID > -1 && artistID < similarArtistName.size()) {
                return similarArtistName.get(artistID);
            }
            if(artistID == 51)
            {
                index++;
                similarArtistName = artFilesDaoJdbc.getSimilarArtworkByName(search, index);
            }
        }
        return artist;
    }

    public String searchArtistByFirstLetter() {
        String artist = "";
        int index = 0;
        int result = 0;
        String search = searchForArtistLastName();
        List<String> similarArtistName = artFilesDaoJdbc.getArtistByFirstLetter(search, index);
        if (similarArtistName.size() == 0) {
            invalidSearch(search);
            return "break";
        }
        while (result >= 0) {
            int artistID = printArtists(similarArtistName, index);
            if (artistID == 52) {
                return "break";
            }
            if (artistID > -1 && artistID < similarArtistName.size()) {
                return similarArtistName.get(artistID);
            }
            if(artistID == 51)
            {
                index++;
                similarArtistName = artFilesDaoJdbc.getArtistByFirstLetter(search, index);
            }
        }
        return artist;
    }

    public int dataValidatorMenu(String userString)
    {
        int userStringAsInt;
        try{
            return Integer.parseInt(userString);
        }catch (Exception e)
        {
            System.out.println("Enter a number between 0 - 5");
            return -1;
        }
    }

    public int dataValidatorSelectArtistsBranch(String input)
    {
        if(input.equalsIgnoreCase("x") )
        {
            return 52;
        }
        else if(input.equalsIgnoreCase("c"))
        {
            return 51;
        }
        else
        {
            try
            {
                return Integer.parseInt(input);
            }catch (Exception e)
            {
                return -1;
            }
        }
    }

    public int printMenu()
    {
        int userInput = -1;
        while(userInput == -1)
        {
        System.out.println("==============================================");
        System.out.println("Chicago Art Institute Menu:");
        System.out.println("==============================================");

        System.out.println("1: Get List of Artists");
        System.out.println("2: Get Artist by First Letter of Their Name");
        System.out.println("3: Search for Artist's Name");
        System.out.println("4: Search for Artwork Title");
        System.out.println("5: Artwork Randomizer");
        System.out.println("0: Exit");
        System.out.println();
        System.out.print("Select an option: ");
        String userString = scanner.nextLine();
        userInput = dataValidatorMenu(userString);

        }
        return userInput;
    }

    public int printArtists(List<String> artists, int page)
    {
        int index = 0;
        System.out.println("==============================================");
        System.out.println("Page Number " + page+ " of Artists:");
        System.out.println("==============================================");

        for(String artist : artists)
        {
            System.out.println(index + ": "+artist);
            index++;
        }
        System.out.println();
        if(artists.size() == 50)
        {
        System.out.println("Type X to exit to menu, C to continue to the next page, or the artist number to view their artwork: ");
        }
        else
        {
            System.out.println("Type X to exit to menu or the artist number to view their artwork: ");
        }
        return dataValidatorSelectArtistsBranch(scanner.nextLine());
    }

    public String searchForArtistFirst()
    {
        System.out.print("Enter the name of an Artist: ");
        return scanner.nextLine();
    }


    public String searchForArtistLastName()
    {
        System.out.print("Enter a letter between A-Z: ");
        return scanner.nextLine();
    }

    public void invalidSearch(String search)
    {
        System.out.println("The database does not have an artist named: "+search);
    }

    public void invalidSearchArt(String search)
    {
        System.out.println("The database does not have a piece of art named: "+search);
    }

    public int printWorks(List<String> works, int page, String artistName)
    {
        int index = 0;
        System.out.println("====================================================================");
        System.out.println("Page Number " + page+ " of "+artistName+"'s Works:");
        System.out.println("====================================================================");

        for(String work : works)
        {
            System.out.println(index + ": "+work);
            index++;
        }
        System.out.println();
        if(works.size() == 50) {
            System.out.println("Type X to exit to menu, C to continue to the next page, or the work number to view that piece of artwork: ");
        }
        else if(works.size() > 0)
        {
            System.out.println("Type X to exit to menu or the work number to view that piece of artwork: ");
        }
        else
        {
            return 52;
        }
        return dataValidatorSelectArtistsBranch(scanner.nextLine());
    }

    public int printWorks(List<String> works, int page)
    {
        int index = 0;
        System.out.println("====================================================================");
        System.out.println("Page Number " + page+ " of Works:");
        System.out.println("====================================================================");

        for(String work : works)
        {
            System.out.println(index + ": "+work);
            index++;
        }
        System.out.println();
        if(works.size() == 50) {
            System.out.println("Type X to exit to menu, C to continue to the next page, or the work number to view that piece of artwork: ");
        }
        else if(works.size() > 0)
        {
            System.out.println("Type X to exit to menu or the work number to view that piece of artwork: ");
        }
        else
        {
            return 52;
        }
        return dataValidatorSelectArtistsBranch(scanner.nextLine());
    }

    public int printWork(List<ArtistAndArtwork> works, int page)
    {
        int index = 0;
        System.out.println("====================================================================");
        System.out.println("Page Number " + page+ " of Works:");
        System.out.println("====================================================================");

        for(ArtistAndArtwork work : works)
        {
            System.out.println(index + ": Title: "+work.getArtwork()+"- Artist: "+work.getArtist());
            index++;
        }
        System.out.println();
        if(works.size() == 50) {
            System.out.println("Type X to exit to menu, C to continue to the next page, or the work number to view that piece of artwork: ");
        }
        else if(works.size() > 0)
        {
            System.out.println("Type X to exit to menu or the work number to view that piece of artwork: ");
        }
        else
        {
            return 52;
        }
        return dataValidatorSelectArtistsBranch(scanner.nextLine());
    }
}
