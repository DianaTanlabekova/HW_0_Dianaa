package edu.narxoz.galactic.drones;

public class DroneFactory {
    public static Drone createDrone(int typeCode, String id, double maxPayloadKg) {
        if (typeCode == 1) {  
            System.out.println("creating Light Drone: " + id);
            return new LightDrone(id, maxPayloadKg);
        } else if (typeCode == 2) {  
            System.out.println("creating Heavy Drone: " + id);
            return new HeavyDrone(id, maxPayloadKg);
        } else {
            throw new IllegalArgumentException("error! please use 1 for light or 2 for heavy");
        }
    }
}

