package com.company;

public class Rocket implements SpaceShip{

    int rocketCost;
    int rocketWeight;
    int maxRocketWeigth; // Max weight with cargo
    int cargoCarried;
    int rocketCurrentWeight;

    double explosionRate;
    double crashingRate;



    public boolean launch(){

        return true;
    }

    public boolean land(){
        return true;
    }

    public boolean canCarry(Item item){
        if(item.weight + this.rocketCurrentWeight <= maxRocketWeigth){
            return true;
        }
        return false;
    }

    public void carry(Item item){
        this.rocketCurrentWeight = this.rocketCurrentWeight + item.weight;
        this.cargoCarried = this.rocketCurrentWeight - this. rocketWeight;
    }

}
