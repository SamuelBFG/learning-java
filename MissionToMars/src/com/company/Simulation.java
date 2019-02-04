package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;



public class Simulation{

    public ArrayList loadItems(String fileName) throws Exception{

        ArrayList<Item> itensArray = new ArrayList<Item>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine().trim();
            int equalsIndex = line.indexOf("=");
            Item item = new Item();
            item.name = line.substring(0,equalsIndex);
            item.weight = Integer.parseInt(line.substring(equalsIndex+1));
            itensArray.add(item);
        }

        scanner.close();
        return itensArray;
    }

    public ArrayList loadU1(ArrayList<Item> items){

        ArrayList<U1> fleetU1 = new ArrayList<U1>();

        

    }

}
