package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.bodies.CelestialBody;
import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.LightDrone;

public class FastFactory implements DeliveryFactory {
    
    @Override
    public Drone createDrone(String id, double maxWeight) {
        System.out.println("Fast factory: creating light drone " + id);
        return new LightDrone(id, maxWeight);
    }
    
    @Override
    public Cargo createCargo(double weight, String desc) {
        return new Cargo(weight, "Fast: " + desc);
    }
    
    @Override
    public CelestialBody createPlace(String name, double x, double y, String info) {
        return new Planet(name, x, y, "Oxygen");
    }
}