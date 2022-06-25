package com.sortingalgorithms;

import java.util.Scanner;

public class UserInput {

    private int typeOfSort;

    public UserInput()
    {
        typeOfSort = 0;
    }

    public int getTypeOfSort() {
        return typeOfSort;
    }

    public int userSortMethod()
    {
        Scanner keyboard = new Scanner(System.in);
        boolean dataValidation = false;
        while(!dataValidation)
        {
            System.out.print("Enter the data type for your sort: 1 - Integers, 2 - Doubles, 3 - Characters 4 - Strings: ");
            String userInput = keyboard.nextLine();
            try {
                typeOfSort = Integer.parseInt(userInput);
                if(typeOfSort < 1 || typeOfSort > 4)
                {
                    Exception e = new Exception();
                    throw e;
                }
                dataValidation = true;
            }catch (Exception e)
            {
                System.out.println("Try again");
            }
        }
        return typeOfSort;
    }
}
