package core;

import ui.ConsoleUI;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //some initial setup of objects to show the application working
        Windfarm windfarm = new Windfarm("Windfarm 1");
        Turbine turbine1 = new Turbine("1", true);
        Turbine turbine2 = new Turbine("2", false);
        windfarm.addTurbine(turbine1);
        windfarm.addTurbine(turbine2);
        Defect defect1 = new Defect("Erosion", 1);
        turbine1.addDefect(defect1);
        Defect defect2 = new Defect("Contamination", 2);
        turbine2.addDefect(defect1);
        turbine2.addDefect(defect2);
        Windfarm windfarm2 = new Windfarm("Windfarm 2");
        Turbine turbine3 = new Turbine("3", true);
        windfarm2.addTurbine(turbine3);
        ArrayList<Windfarm> windfarms = new ArrayList<>();
        windfarms.add(windfarm);
        windfarms.add(windfarm2);
        ArrayList<String> engineers = new ArrayList<>();
        engineers.add("Mike");
        engineers.add("Dave");
        Inspection inspection = new Inspection(windfarm, new Date(), engineers);
        windfarm.addInspection(inspection);

        //start the application
        ConsoleUI consoleUI = new ConsoleUI(windfarms);
    }
}
