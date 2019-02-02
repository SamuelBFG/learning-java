package com.company;
import java.util.Random;

/**
  Rocket cost = $100 Million
  Rocket weight = 10 Tonnes
  Max weight (with cargo) = 18 Tonnes
  Chance of launch explosion = 5% * (cargo carried / cargo limit)
  Chance of landing crash = 1% * (cargo carried / cargo limit)
 */

public class U1 extends Rocket {

    U1(){
        rocketCost = 100; //In millions USD
        rocketWeight = 10000; //In kilograms
        maxRocketWeigth = 18000; //In kilograms, with cargo
        explosionRate = 0.05; //Chance launch explosion;
        crashingRate = 0.01; //Chance landing crash;
    }

    public boolean launch(){
        double probLaunch = Math.random();
        return (this.explosionRate*(this.cargoCarried/this.cargoLimit) < probLaunch);
    }

    public boolean land(){
        double probLand = Math.random();
        return (this.crashingRate*(this.cargoCarried/this.cargoLimit) < probLand);
    }

}
