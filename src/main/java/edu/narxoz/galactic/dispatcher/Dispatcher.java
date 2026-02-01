package edu.narxoz.galactic.dispatcher;

import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.DroneStatus;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.task.TaskState;

public class Dispatcher {
    public Result assignTask(DeliveryTask task, Drone drone) {
        if (task == null || drone == null) {
            return new Result(false, "error: null reference detected");
        }       
        if (drone.getStatus() != DroneStatus.IDLE) {
            return new Result(false, "drone isnt idle");
        }      
        if (task.getCargo().getWeightKg() > drone.getMaxPayloadKg()) {
            return new Result(false, "critical overweight");
        }   
        if (task.getState() != TaskState.CREATED) {
            return new Result(false, "task isnt in CREATED");
        }    
        task.setAssignedDrone(drone);
        task.setState(TaskState.ASSIGNED);
        drone.setStatus(DroneStatus.IN_FLIGHT);

        return new Result(true, null);
    }

    public Result completeTask(DeliveryTask task) {
        
        if (task == null) {
            return new Result(false, "data error: null task");
        }
        if (task.getState() != TaskState.ASSIGNED) {
            return new Result(false, "task isnt ASSIGNED");
        }
        if (task.getAssignedDrone() == null) {
            return new Result(false, "no drone linked to mission");
        }
        if (task.getAssignedDrone().getStatus() != DroneStatus.IN_FLIGHT) {
            return new Result(false, "assigned drone isnt IN_FLIGHT");
        }

        
        task.setState(TaskState.DONE);
        task.getAssignedDrone().setStatus(DroneStatus.IDLE);

        return new Result(true, null);
    }
    
}
