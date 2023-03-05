package core;

import java.util.ArrayList;

public class Turbine {
    private String id;
    private boolean operational;
    private int numDefects;
    private ArrayList<Defect> defects;

    // Constructor for the Turbine class, which initializes the id, operational and numDefects fields
    public Turbine(String id, boolean operational, int numDefects) {
        this.id = id;
        this.operational = operational;
        this.numDefects = numDefects;
    }

    // Constructor for the Turbine class, which initializes the id and operational fields
    // Used where the number of defects is zero
    public Turbine(String id, boolean operational) {
        this.id = id;
        this.operational = operational;
        this.numDefects = 0;
        this.defects = new ArrayList<>();
    }

    public void addDefect(Defect defect) {
        defects.add(defect);
        numDefects++;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public int getNumDefects() {
        return numDefects;
    }

    public ArrayList<Defect> getDefects() {
        return defects;
    }

    public void setDefects(ArrayList<Defect> defects) {
        this.defects = defects;
    }

    public String getActivity() {
        if (operational) {
            return "Operational";
        } else {
            return "Non-operational";
        }
    }
}
