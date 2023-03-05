package ui;
import core.Defect;
import core.Inspection;
import core.Turbine;
import core.Windfarm;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {

    private ArrayList<Windfarm> windFarms;
    private Windfarm windFarm;
    private Scanner scanner;

    public ConsoleUI(ArrayList<Windfarm> windFarms) {
        this.windFarms = windFarms;
        this.scanner = new Scanner(System.in);
        start();
    }

    // Method to begin the application UI
    public void start() {
        System.out.println("Welcome to the Wind Farm Management System!");

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. List all turbines");
            System.out.println("2. Add a new turbine");
            System.out.println("3. View turbine details");
            System.out.println("4. View Inspections");
            System.out.println("5. Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    listAllTurbines();
                    break;
                case "2":
                    addNewTurbine();
                    break;
                case "3":
                    viewTurbineDetails();
                    break;
                case "4":
                    viewInspections();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    // Method to view the details of inspections
    // A user can select a windfarm and view the details of inspections for that windfarm
    private void viewInspections() {

        System.out.println("Which windfarm would you like to view?");
        for (int i = 0; i < windFarms.size(); i++) {
            System.out.println((i + 1) + ". " + windFarms.get(i).getName());
        }
        int input = Integer.parseInt(scanner.nextLine());
        windFarm = windFarms.get(input - 1);
        System.out.println("Inspections for " + windFarm.getName() + ":");
        for (Inspection inspection : windFarm.getInspections()) {
            System.out.println("- " + inspection.getInspectionDate());
            for (String engineer : inspection.getInspectionEngineers()) {
                System.out.println("  - " + engineer);
            }
            for (Turbine turbine : windFarm.getTurbines()) {
                System.out.println("  - " + turbine.getId() + ": " + turbine.getActivity());
            }
        }
    }

    // Method to view the details of all turbines per windfarm
    private void listAllTurbines() {
        for(Windfarm windFarm : windFarms) {
            System.out.println("Turbines for " + windFarm.getName() + ":");
            for (Turbine turbine : windFarm.getTurbines()) {
                System.out.println("- " + turbine.getId() + ": " + turbine.getActivity());
            }
        }
    }

    // Method to store a new turbine
    private void addNewTurbine() {
        System.out.println("Which windfarm would you like to add a turbine to?");
        for (int i = 0; i < windFarms.size(); i++) {
            System.out.println((i + 1) + ". " + windFarms.get(i).getName());
        }
        int input = Integer.parseInt(scanner.nextLine());
        windFarm = windFarms.get(input - 1);
        System.out.print("Enter the ID of the new turbine: ");
        String id = scanner.nextLine();
        System.out.print("Is the turbine operational? (Y/N): ");
        String activityInput = scanner.nextLine();
        boolean isOperational = activityInput.equalsIgnoreCase("Y");
        System.out.println("Number of defects?: ");
        int numDefects = Integer.parseInt(scanner.nextLine());
        boolean hasDefects = numDefects > 0;

        Turbine turbine = new Turbine(id, isOperational, numDefects);

        // If the turbine has defects, add them to the turbine
        if (hasDefects) {
            ArrayList<Defect> defects = new ArrayList<>();
            for (int i = 0; i < numDefects; i++) {
                System.out.println("Defect " + (i + 1) + ":");
                System.out.print("Type: ");
                String type = scanner.nextLine();
                System.out.print("Severity: ");
                int severity = Integer.parseInt(scanner.nextLine());
                Defect defect = new Defect(type, severity);
                defects.add(defect);
            }
            turbine.setDefects(defects);
        }
        windFarm.addTurbine(turbine);
        System.out.println("Turbine added successfully.");
    }

    // Method to view the details of a given turbine
    private void viewTurbineDetails() {
        System.out.print("Enter the ID of the turbine: ");
        String id = scanner.nextLine();

        //iterate through windfarms to find the turbine
        for(Windfarm windFarm : windFarms) {
            Turbine turbine = windFarm.getTurbineById(id);
            if (turbine != null) {
                this.windFarm = windFarm;
                System.out.println("Details for Turbine " + turbine.getId() + ":");
                System.out.println("- Activity: " + turbine.getActivity());
                System.out.println("- Number of Defects: " + turbine.getNumDefects());
                for (Defect defect : turbine.getDefects()) {
                    System.out.println("- " + defect.getType() + " Defect (Severity: " + defect.getSeverity() + ")");
                }
                return;
            }
            System.out.println("Turbine not found.");
        }
    }
}
