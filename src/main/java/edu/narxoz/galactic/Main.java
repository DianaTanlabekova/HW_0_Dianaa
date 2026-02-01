package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main {
        public static void main(String[] args) {

        Planet p1 = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation s1 = new SpaceStation("ISS", 100, 0, 5);
        Cargo c1 = new Cargo(20, "Medical supplies");
        LightDrone d1 = new LightDrone("Ld-1", 5);
        HeavyDrone d2 = new HeavyDrone("Hd-1", 50);
        DeliveryTask t1 = new DeliveryTask(p1, s1, c1);
        Dispatcher disp = new Dispatcher();

        Result result_1 = disp.assignTask(t1, d1);
        System.out.println("First check: ok=" + result_1.ok() + ", info=" + result_1.reason());

        Result result_2 = disp.assignTask(t1, d2);
        System.out.println("Second check: ok=" + result_2.ok() + ", info=" + result_2.reason());

        System.out.println("Time to destination: " + t1.estimateTime() + " min");

        Result result_3 = disp.completeTask(t1);
        System.out.println("Finished: ok=" + result_3.ok());

        System.out.println("Final task: " + t1.getState());
        System.out.println("Final drone: " + d2.getStatus());
               
    }
}
