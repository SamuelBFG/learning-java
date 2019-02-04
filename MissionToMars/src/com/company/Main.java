package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        ArrayList <Item> itemsPhase1 = new ArrayList<>();
        ArrayList <Item> itemsPhase2 = new ArrayList<>();
        Simulation simulation = new Simulation();
        ArrayList <U1> fleetU1Phase1;
        ArrayList <U2> fleetU2Phase1;
        ArrayList <U1> fleetU1Phase2;
        ArrayList <U2> fleetU2Phase2;

        // Load items from files
        itemsPhase1 = simulation.loadItems("Phase-1.txt");
        itemsPhase2 = simulation.loadItems("Phase-2.txt");

        // Load Fleet for phase 1
        fleetU1Phase1 = simulation.loadU1(itemsPhase1);
        int nrU1Rockets = fleetU1Phase1.size();
        fleetU2Phase1 = simulation.loadU2(itemsPhase1);
        int nrU2Rockets = fleetU2Phase1.size();

        // Load Fleet for phase 2
        fleetU1Phase2 = simulation.loadU1(itemsPhase2);
        nrU1Rockets = fleetU1Phase2.size();
        fleetU2Phase2 = simulation.loadU2(itemsPhase2);
        nrU2Rockets = fleetU2Phase2.size();

        // Phase 1 -- run simulation using the fleet of U1 rockets and display the total budget required
        System.out.println("Simulation Phase 1 with U1 rockets START ---------");
        int totalBudgetP1U1 = simulation.runSimulation(fleetU1Phase1);
        System.out.println("Simulation Phase 1 using the fleet of U1 rockets: budget = $" + totalBudgetP1U1 + " millions");

        // Phase 2 -- run simulation using the fleet of U1 rockets and display the total budget required
        System.out.println("Simulation Phase 2 with U1 rockets START ---------");
        int totalBudgetP2U1 = simulation.runSimulation(fleetU1Phase2);
        System.out.println("Simulation Phase 2 using the fleet of U1 rockets: budget = $" + totalBudgetP2U1 + " millions");

        int totalBudgetU1 = totalBudgetP1U1 + totalBudgetP2U1;
        System.out.println("Simulation using the fleet of U1 rockets: total budget = $" + totalBudgetU1 + " millions");

        // Phase 1 -- run simulation using the fleet of U2 rockets and display the total budget required
        System.out.println("Simulation Phase 1 with U2 rockets START ---------");
        int totalBudgetP1U2 = simulation.runSimulation(fleetU2Phase1);
        System.out.println("Simulation Phase 1 using the fleet of U1 rockets: budget = $" + totalBudgetP1U2 + " millions");

        // Phase 2 -- run simulation using the fleet of U2 rockets and display the total budget required
        System.out.println("Simulation Phase 2 with U2 rockets START ---------");
        int totalBudgetP2U2 = simulation.runSimulation(fleetU2Phase2);
        System.out.println("Simulation Phase 2 using the fleet of U2 rockets: budget = $" + totalBudgetP2U2 + " millions");

        int totalBudgetU2 = totalBudgetP1U2 + totalBudgetP2U2;
        System.out.println("Simulation using the fleet of U2 rockets: total budget = $" + totalBudgetU2 + " millions");
    }
}


