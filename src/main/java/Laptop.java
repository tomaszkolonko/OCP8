public class Laptop {
    private String model;
    private int numberOfPorts;

    public Laptop(String model, int numberOfPorts) {
        this.model = model;
        this.numberOfPorts = numberOfPorts;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }
}
