package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;



public class Simulation{

    public ArrayList loadItems(String fileName) throws Exception{

        ArrayList<Item> itemsArray = new ArrayList<Item>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine().trim();
            int equalsIndex = line.indexOf("=");
            Item item = new Item();
            item.name = line.substring(0,equalsIndex);
            item.weight = Integer.parseInt(line.substring(equalsIndex+1));
            itemsArray.add(item);
        }

        scanner.close();
        return itemsArray;
    }

    public ArrayList loadU1(ArrayList<Item> items){

        ArrayList<U1> fleetU1 = new ArrayList<U1>();

        int count = 0;
        while(count < (items.size() - 1)){
            U1 u1 = new U1();
            while(u1.rocketCurrentWeight <= u1.maxRocketWeigth){
                if(items.get(count).weight > u1.cargoLimit){
                    System.out.println("=== File phase-1.txt ===");
                    System.out.println(items.get(count).name + " has weight " + items.get(count).weight);
                    System.out.println("The maximum cargo of U1 rocket is: " + u1.cargoLimit);
                    System.out.println("Program Stopped!");
                    System.exit(1);
                }
                if(u1.canCarry(items.get(count))){ //See if U1 can carry item cont
                    u1.carry(items.get(count)); //Update rocket current weight and carried cargo
                    count++; //Go to the next item 'cont'
                    if(count >= items.size()){
                        fleetU1.add(u1);
                        break;
                    }
                } else {
                    fleetU1.add(u1);
                    break;
                }
            }
        }
        return fleetU1;
    }

    public ArrayList loadU2(ArrayList<Item> items){

        ArrayList<U2> fleetU2 = new ArrayList<U2>();

        int cont = 0;
        while(cont < (items.size() - 1)){
            U2 u2 = new U2();
            while(u2.rocketCurrentWeight <= u2.maxRocketWeigth){
                if(items.get(cont).weight > u2.cargoLimit){
                    System.out.println("=== File phase-1.txt ===");
                    System.out.println(items.get(cont).name + " has weight " + items.get(cont).weight);
                    System.out.println("The maximum cargo of U1 rocket is: " + u2.cargoLimit);
                    System.out.println("Program Stopped!");
                    System.exit(1);
                }
                if(u2.canCarry(items.get(cont))){ //See if U1 can carry item cont
                    u2.carry(items.get(cont)); //Update rocket current weight and carried cargo
                    cont++; //Go to the next item 'cont'
                    if(cont >= items.size()){
                        fleetU2.add(u2);
                        break;
                    }
                } else {
                    fleetU2.add(u2);
                    break;
                }
            }
        }
        return fleetU2;
    }

    int runSimulation(ArrayList fleet){
        int totalBudget;

        Rocket rocket = new Rocket();
        int rocketCounter = 0;
        for(int i = 0; i < fleet.size(); i++){
            rocket = (Rocket) fleet.get(i);
            if(rocket.launch()){
                System.out.println("Rocket " + rocketCounter + " launched!");
                if(rocket.land()){
                    System.out.println("Rocket " + rocketCounter + " landed!");
                    rocketCounter++;
                } else {
                    System.out.println("Rocket " + rocketCounter + " crashed at landing.");
                    fleet = insertNewRocket(fleet, i);
                }
            } else {
                System.out.println("Rocket " + rocketCounter + " exploded at launch.");
                fleet = insertNewRocket(fleet, i);
            }
        }
        totalBudget = fleet.size() * rocket.rocketCost;
        return totalBudget;
    }

    private ArrayList <Rocket> insertNewRocket(ArrayList fleet, int index){

        Rocket rocket;
        rocket = (Rocket) fleet.get(index);

        if (fleet.get(index) instanceof U1) {
            U1 u1New = new U1();
            u1New.rocketCurrentWeight = rocket.cargoCarried;
            u1New.rocketCurrentWeight = rocket.rocketCurrentWeight;
            fleet.add(index + 1, u1New);
        } else if (fleet.get(index) instanceof U2) {
            U2 u2New = new U2();
            u2New.cargoCarried = rocket.cargoCarried;
            u2New.rocketCurrentWeight = rocket.rocketCurrentWeight;
            fleet.add(index + 1, u2New);
        } else {
            System.out.println("Can not run simulation!!!");
            System.out.println("Program stop");
            System.exit(2);
        }

        return fleet;
    }
}
