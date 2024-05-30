import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DetectorDoor extends Hardware {


    // Konstruktor

    public DetectorDoor(String hardwarePlacement) {
        super(hardwarePlacement);
        this.setHardwarePlacement(hardwarePlacement);
        setDetectorActivated(true);
        setDetectorTriggered(false);
        setHardwareType("dörrdetektor");
    }


    // Startar inbrottslarmsprocessen för dörr

    public void detectAction(int randomDetection) {
        CentralUnit centralUnit = new CentralUnit();
        List<Hardware> hardware = centralUnit.getList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n" + "Dörren har manipulerats, ange kod för att nollställa larmet : ");
        String code = scanner.nextLine();
        if (Objects.equals(code, "780705")) {
            for (int i = 0; i < hardware.size(); i++) {
                hardware.get(i).setDetectorTriggered(false);
                centralUnit.sirens.setDetectorTriggered(false);
            }
            System.out.println("\n" + "Alarmet är nollställt");
        } else {
            System.out.println("Felaktig kod.");
            System.out.println("\n" + "Larmets " + hardware.get(randomDetection).getHardwareType() + " i " + hardware.get(randomDetection).getHardwarePlacement() + " har aktiverats.");
            centralUnit.sirens.detectAction();
        }
    }

}

