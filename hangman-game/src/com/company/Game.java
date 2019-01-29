package com.company;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Game {

    static File file = new File ("movies.txt");

    //Method used to count how many movies are in the .txt file.
    private static int lineCounter() throws Exception {
        int lines = 0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            lines ++;
        }
        return lines;
    }

    //Method used to select randomly a movie from the list.
    private static String randomMovie() throws Exception {
        Scanner scanner = new Scanner(file);
        int i = 0;
        String[] movies = new String[lineCounter()];
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            //System.out.println(line);
            movies[i] = line;
            i++;
        }
        int rnd = new Random().nextInt(lineCounter());
        //System.out.println("The chosen movie was: ");
        System.out.println(movies[rnd]);
        return movies[rnd];

    }

    //Method used to switch every movie's char to underscore '_'.
    private static String underScore(String movie) throws Exception {

        movie = "_".repeat(movie.length());
        //System.out.println(underscoreMovie);
        return movie;

    }

    //Method to test if a specific char VAL can be found on arr.
    private static boolean contains(char [] arr, char val){
        boolean result = false;
        for(int i : arr){
            if(i == val){
                result = true;
            }
        }
        return result;
    }

    //Method that interact with the user
    public void gameManager() throws Exception {
        String selectedMovie = randomMovie(); //String movie
        char[] movie = selectedMovie.toCharArray(); //Char movie
        char[] movieUnderscored = underScore(selectedMovie).toCharArray(); //Chosen movie UNDERSCORED!
        int guessing = 0;

        System.out.print("You are guessing: ");
        System.out.println(movieUnderscored);
        System.out.println("You have guessed ("+guessing+") wrong letters:");

        while(guessing != 10){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Guess a letter:");
            char guess = scanner.nextLine().charAt(0);
            boolean flag = true; //Flag to check if the user guess right or wrong.
            //System.out.println(guess);
            for(int i = 0; i < movie.length; i++){
                if(movie[i] == guess){
                    movieUnderscored[i] = guess;
                    flag = false;
                }
            }
            if(flag){
                guessing++;
            }
            if(!contains(movieUnderscored, '_')){
                System.out.println("You win!");
                System.out.print("You have guessed '");
                System.out.print(movieUnderscored);
                System.out.println("' correctly.");
                break;
            }
            System.out.print("You are guessing: ");
            System.out.println(movieUnderscored);
            System.out.println("You have guessed ("+guessing+") wrong letters:");
        }
        if(guessing == 0){
            System.out.println("Game Over! The movie was: ");
            System.out.print(movie);
        }
    }




}
