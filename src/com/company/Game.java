package com.company;
import java.util.Random;
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

    private static String randomMovie() throws Exception {
        Scanner scanner = new Scanner(file);
        int i = 0;
        String[] movies = new String[lineCounter()];
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
            movies[i] = line;
            i++;
        }
        int rnd = new Random().nextInt(lineCounter());
        System.out.println("The chosen movie was: ");
        System.out.println(movies[rnd]);
        return movies[rnd];

    }

    public void underScore() throws Exception {

        String underscoreMovie = "_".repeat(randomMovie().length());
        System.out.println(underscoreMovie);

    }




}
