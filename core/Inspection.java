package core;

import java.util.ArrayList;
import java.util.Date;

public class Inspection {
    private Windfarm windFarm;
    private ArrayList<Turbine> turbines;
    private Date inspectionDate;
    private ArrayList<String> inspectionEngineers;

    // Constructor for the Inspection class, which initializes the windFarm, inspectionDate and inspectionEngineers fields
    public Inspection(Windfarm windFarm,
                              Date inspectionDate, ArrayList<String> inspectionEngineers) {
        this.windFarm = windFarm;
        this.inspectionDate = inspectionDate;
        this.inspectionEngineers = inspectionEngineers;
    }

    // Getters and setters

    public Date getInspectionDate() {
        return inspectionDate;
    }


    public String[] getInspectionEngineers() {
        String[] engineers = new String[inspectionEngineers.size()];
        for (int i = 0; i < inspectionEngineers.size(); i++) {
            engineers[i] = inspectionEngineers.get(i);
        }
        return engineers;
    }
}
