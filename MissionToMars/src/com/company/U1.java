package com.company;

/**
 Rocket cost = $100 Million
 Rocket weight = 10 Tonnes
 Max weight (with cargo) = 18 Tonnes
 Chance of launch explosion = 5% * (cargo carried / cargo limit)
 Chance of landing crash = 1% * (cargo carried / cargo limit)
 */

public class U1 extends Rocket{
    U1(){
        rocketCost = 100; //In millions USD
        rocketWeight = 10000; //In kilograms
        maxRocketWeigth = 18000; //In kilograms, with cargo
        explosionRate = 0.05; //Chance launch explosion;
        crashingRate = 0.01; //Chance landing crash;
    }

    public boolean launch(){
        return (this.explosionRate*(this.cargoCarried/this.cargoLimit) < Math.random());
    }

    public boolean land(){
        return (this.crashingRate*(this.cargoCarried/this.cargoLimit) < Math.random());
    }

}
