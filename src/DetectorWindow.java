import java.util.List;
import java.util.Objects;

public class DetectorWindow extends Hardware {

    // Konstruktor

    public DetectorWindow(String hardwarePlacement, String comment) {
        super(hardwarePlacement);
        this.setHardwarePlacement(hardwarePlacement);
        this.setComment(comment);
        setDetectorActivated(true);
        setDetectorTriggered(false);
        setHardwareType("fönsterdetektor");
    }

    // Startar inbrottslarmsprocessen för fönster

    public void detectAction(int randomDetection) {

        CentralUnit centralUnit = new CentralUnit();
        List<Hardware> hardware = centralUnit.getList();

        if ((Objects.equals(hardware.get(randomDetection).getComment(), "1")) || (Objects.equals(hardware.get(randomDetection).getComment(), "2"))) {
            System.out.println("\n" + "Larmets " + hardware.get(randomDetection).getHardwareType() + "(" + hardware.get(randomDetection).getComment() + ")" + " i " + hardware.get(randomDetection).getHardwarePlacement() + " har aktiverats.");
        } else {
            System.out.println("\n" + "Larmets " + hardware.get(randomDetection).getHardwareType() + " i " + hardware.get(randomDetection).getHardwarePlacement() + " har aktiverats.");
        }
        centralUnit.sirens.detectAction();
    }


}

