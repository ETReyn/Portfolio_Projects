package com.database.stuff.Importing;

import com.database.stuff.Model.ArtFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportData {

    File fileName = new File("C:\\Users\\Student\\workspace\\Art Institute of Chicago\\api-data\\getting-started\\allArtworks.jsonl");
    ArtFiles artFiles = new ArtFiles();
    public List<ArtFiles> readData()
    {
        List<ArtFiles> aF = new ArrayList<>();
       try(Scanner scanner = new Scanner(fileName))
       {
           while(scanner.hasNextLine())
           {
               aF.add(parseData(scanner.nextLine()));
           }
       }catch (FileNotFoundException e)
       {
           System.out.println("Could not open file");
       }
       return aF;
    }

    public ArtFiles parseData(String line)
    {
        ArtFiles art = new ArtFiles();
        line = line.replaceAll("\"", "");
        int index = 0;
        while(line != null)
        {
            line = line.substring(line.indexOf(":")+1);
            line = switchCase(art, line, index);
            index++;
        }
        //System.out.println(artFiles.toString());
        return art;
    }

    public String switchCase(ArtFiles artFiles, String line, int index)
    {
        switch (index)
        {
            case(0):
                artFiles.setId(line.substring(0, line.indexOf(",")));
                line = line.substring(line.indexOf(",")+1);
                break;
            case(1):
                artFiles.setTitle(line.substring(0, line.indexOf(",")));
                line = line.substring(line.indexOf(",")+1);
                break;
            case(2):
                artFiles.setMainReferenceNumber(line.substring(0, line.indexOf(",")));
                line = line.substring(line.indexOf(",")+1);
                break;
            case(4):
                artFiles.setArtistTitle(line.substring(0, line.length()-1));
                line = null;
                break;
            case(3):
                artFiles.setDepartmentTitle(line.substring(0, line.indexOf(",")));
                line = line.substring(line.indexOf(",")+1);
                break;
        }
        return line;
    }
}
