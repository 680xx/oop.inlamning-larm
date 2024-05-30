public class Hardware {


    // Variabler

    private String hardwarePlacement;
    private String hardwareType;
    private String comment;
    private boolean detectorActivated;
    private boolean detectorTriggered;


    // Konstruktor

    public Hardware(String hardwarePlacement) {
        this.hardwarePlacement = hardwarePlacement;
    }


    // Metoder

    public void detectAction() {
    }


    // Getters & Setters

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getHardwarePlacement() {
        return hardwarePlacement;
    }
    public void setHardwarePlacement(String hardwarePlacement) {
        this.hardwarePlacement = hardwarePlacement;
    }
    public String getHardwareType() {
        return hardwareType;
    }
    public void setHardwareType(String hardwareType) {
        this.hardwareType = hardwareType;
    }
    public boolean isDetectorActivated() {
        return detectorActivated;
    }
    public void setDetectorActivated(boolean detectorActivated) {
        this.detectorActivated = detectorActivated;
    }
    public boolean isDetectorTriggered() {
        return detectorTriggered;
    }
    public void setDetectorTriggered(boolean detectorTriggered) {
        this.detectorTriggered = detectorTriggered;
    }


    @Override
    public String toString() {
        return "Hardware{" +
                "hardwarePlacement='" + hardwarePlacement + '\'' +
                ", hardwareType='" + hardwareType + '\'' +
                ", detectorActivated=" + detectorActivated +
                ", detectorTriggered=" + detectorTriggered +
                '}';
    }


}
