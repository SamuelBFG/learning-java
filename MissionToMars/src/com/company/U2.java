package com.company;

/**
 Rocket cost = $120 Million
 Rocket weight = 18 Tonnes
 Max weight (with cargo) = 29 Tonnes
 Chance of launch explosion = 4% * (cargo carried / cargo limit)
 Chance of landing crash = 8% * (cargo carried / cargo limit)
 */

public class U2 extends Rocket{
    U2(){
        rocketCost = 120; //In millions USD
        rocketWeight = 18000; //In kilograms
        maxRocketWeigth = 29000; //In kilograms
        explosionRate = 0.04;
        crashingRate = 0.08;
        cargoLimit = maxRocketWeigth - rocketWeight;
    }

    public boolean launch(){
        return (this.explosionRate*(this.cargoCarried/this.cargoLimit) < Math.random());
    }

    public boolean land(){
        return (this.crashingRate*(this.cargoCarried/this.cargoLimit) < Math.random());
    }

}
