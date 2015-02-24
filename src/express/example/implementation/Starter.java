package express.example.implementation;

import express.api.model.MachineController;
import express.example.implementation.containers.LiquidContainer;
import express.example.implementation.devices.*;

/**
 * Created by Admin on 2015-02-23.
 */
public class Starter {

    public static void main(String[] args) {
        MachineController expressController = MachineController.getInstance();
        expressController.addDevice(new Heater("Grzałka wody"));
        expressController.addDevice(new PressurePad("Czujnik kubka"));
        expressController.addDevice(new Grinder("Młynek"));
        expressController.addDevice(new Pump("Pompa wody"));
        expressController.addDevice(new Dispenser("Podajnik"));

    }
}
