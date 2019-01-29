package com.company;
import java.util.Scanner;
import java.io.File;

public class Game {

    static File file = new File ("movies.txt");

    private static int lineCounter() throws Exception {
        int lines = 0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            lines ++;
        }
        return lines;
    }

    public void underScore() throws Exception {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }
        System.out.println(lineCounter());


    }


}
