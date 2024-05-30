import java.util.List;

public class DetectorMovement extends Hardware {


    // Konstruktor

    public DetectorMovement(String hardwarePlacement) {
        super(hardwarePlacement);
        this.setHardwarePlacement(hardwarePlacement);
        setDetectorActivated(true);
        setDetectorTriggered(false);
        setHardwareType("rörelsedetektor");
    }


    // Startar rörelsedetektorprocessen

    public void detectAction() {
        CentralUnit centralUnit = new CentralUnit();
        List<Hardware> hardware = centralUnit.getList();
        System.out.println("\n" + "Larmets " + hardware.get(14).getHardwareType() + " i " + hardware.get(14).getHardwarePlacement() + " har aktiverats.");
        centralUnit.sirens.detectAction();
    }



}
