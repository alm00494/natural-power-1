package core;

import java.util.ArrayList;

public class Windfarm {
    private String name;
    private ArrayList<Turbine> turbines;
    private ArrayList<Inspection> inspections;

    // Constructor for the Windfarm class, which initializes the name, turbines and inspections fields
    public Windfarm(String name) {
        this.name = name;
        this.turbines = new ArrayList<>();
        this.inspections = new ArrayList<>();
    }

    public void addTurbine(Turbine turbine) {
        turbines.add(turbine);
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public ArrayList<Turbine> getTurbines() {
        return turbines;
    }

    public ArrayList<Inspection> getInspections() {
        return inspections;
    }

    public void addInspection(Inspection inspection) {
        inspections.add(inspection);
    }

    public Turbine getTurbineById(String id) {
        for (Turbine turbine : turbines) {
            if (turbine.getId().equals(id)) {
                return turbine;
            }
        }
        return null;
    }
}
