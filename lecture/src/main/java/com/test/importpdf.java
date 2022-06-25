package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class importpdf {


    public static void main(String[] args) {
        File newFile = new File("productCatalog.pdf");
        Path path = Paths.get("productCatalog.pdf");
        try
        {
            System.out.println(Files.size(path));
        }
        catch(IOException e)
        {

        }
        try (Scanner scanner = new Scanner(newFile)) {
            for(int i = 0; i < 100; i++)
            {
                if(scanner.hasNextLine())
                {
                    System.out.println(scanner.nextLine());
                }
                else
                {
                    System.out.println(i);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not open file");
        }
    }
}
