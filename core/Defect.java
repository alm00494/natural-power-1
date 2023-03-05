package core;

public class Defect {
    private String type;
    private int severity;

    // Constructor for the Defect class, which initializes the type and severity fields
    public Defect(String type, int severity) {
        this.type = type;
        this.severity = severity;
    }

    // Getters and setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        //if type is one of Erosion, Contamination or Porositie then set type to type
        //else throw new IllegalArgumentException("Invalid type");

        if (type.equals("Erosion") || type.equals("Contamination") || type.equals("Porosities")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    public int getSeverity() {
        return severity;
    }

}
