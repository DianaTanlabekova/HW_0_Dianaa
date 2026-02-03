package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.bodies.CelestialBody;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;

public interface DeliveryFactory {
    Drone createDrone(String id, double maxWeight);
    Cargo createCargo(double weight, String desc);
    CelestialBody createPlace(String name, double x, double y, String info);
}