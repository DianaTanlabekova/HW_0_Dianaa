package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.bodies.CelestialBody;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.HeavyDrone;

public class BigFactory implements DeliveryFactory {
    
    @Override
    public Drone createDrone(String id, double maxWeight) {
        System.out.println("BigFactory: making heavy drone " + id);
        return new HeavyDrone(id, maxWeight);
    }
    
    @Override
    public Cargo createCargo(double weight, String desc) {
        return new Cargo(weight, "Big cargo: " + desc);
    }
    
    @Override
    public CelestialBody createPlace(String name, double x, double y, String info) {
        return new SpaceStation(name, x, y, 1);
    }
}