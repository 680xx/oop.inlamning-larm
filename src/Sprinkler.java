import java.util.List;
import java.util.Objects;

public class Sprinkler extends Hardware {


    // Konstruktor

    public Sprinkler(String hardwarePlacement) {
        super(hardwarePlacement);
        this.setHardwarePlacement(hardwarePlacement);
        setDetectorActivated(true);
        setDetectorTriggered(false);
        setHardwareType("sprinkler");
    }

    // Startar sprinklerprocessen

    public void detectAction(int randomDetection) {

        CentralUnit centralUnit = new CentralUnit();
        List<Hardware> hardware = centralUnit.getList();
        for (int i = 0; i < hardware.size(); i++) {
            if (Objects.equals(hardware.get(i).getHardwareType(), "sprinkler") && Objects.equals(hardware.get(i).getHardwarePlacement(), hardware.get(randomDetection).getHardwarePlacement())) {
                System.out.println("Sprinklern i " + hardware.get(i).getHardwarePlacement() + " är aktiv.");
            }
        }
    }
}

