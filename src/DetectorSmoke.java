import java.util.List;

public class DetectorSmoke extends Hardware {


    // Konstruktor

    public DetectorSmoke(String hardwarePlacement) {
        super(hardwarePlacement);
        this.setHardwarePlacement(hardwarePlacement);
        setDetectorActivated(true);
        setDetectorTriggered(false);
        setHardwareType("rökdetektor");
    }


    // Startar brandlarmsprocessen

    public void detectAction(int randomDetection) {

        CentralUnit centralUnit = new CentralUnit();
        List<Hardware> hardware = centralUnit.getList();
        System.out.println("\n" + "Larmets " + hardware.get(randomDetection).getHardwareType() + " i " + hardware.get(randomDetection).getHardwarePlacement() + " har aktiverats.");
        centralUnit.sprinkler.detectAction(randomDetection);
        centralUnit.sirens.detectAction();

    }



}
