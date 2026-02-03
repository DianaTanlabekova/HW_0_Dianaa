package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.DroneFactory;
import edu.narxoz.galactic.factory.BigFactory;
import edu.narxoz.galactic.factory.DeliveryFactory;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main {
    public static void main(String[] args) {

        Planet p1 = new Planet("Earth", 3, 5, "Oxygen");
        SpaceStation s1 = new SpaceStation("ISS", 150, 0, 3);
        Cargo c1 = new Cargo(20, "Medical supplies");
        Drone d1 = DroneFactory.createDrone(1, "Ld-1", 5);
        Drone d2 = DroneFactory.createDrone(2, "Hd-1", 50);
    
        System.out.println( d1.getId() + " (speed: " + d1.speedKmPerMin() + " km/min)");
        System.out.println(d2.getId() + " (speed: " + d2.speedKmPerMin() + " km/min)");
        
        DeliveryTask t1 = new DeliveryTask(p1, s1, c1);
        Dispatcher disp = new Dispatcher();

        Result result_1 = disp.assignTask(t1, d1);
        System.out.println("try light drone: " + (result_1.ok() ? "OK" : "FAIL") + 
         " - " + result_1.reason());

        Result result_2 = disp.assignTask(t1, d2);
        System.out.println("try heavy drone: " + (result_2.ok() ? "OK" : "FAIL"));

        System.out.println("delivery time: " + t1.estimateTime() + " min");

        Result result_3 = disp.completeTask(t1);
        System.out.println("task done: " + (result_3.ok() ? "YES" : "NO"));

        System.out.println("- Task: " + t1.getState());
        System.out.println("- Drone: " + d2.getStatus());
        
        System.out.println("Abstract factory: ");
        DeliveryFactory big = new BigFactory();
        Drone bigDrone = big.createDrone("Big-1", 100);
        Cargo bigCargo = big.createCargo(60, "Big load");
        System.out.println("Big factory made: " + bigDrone.getId() + " and " + bigCargo.getDescription());
               
    }
}