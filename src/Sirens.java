public class Sirens extends Hardware {


    // Konstruktor

    public Sirens(String hardwarePlacement) {
        super(hardwarePlacement);
        this.setHardwarePlacement(hardwarePlacement);
        setDetectorActivated(true);
        setDetectorTriggered(false);
        setHardwareType("sirener");
    }


    // Startar sirenprocessen

    public void detectAction() {

        CentralUnit centralUnit = new CentralUnit();
        System.out.println("Larmets sirener ljuder i " + centralUnit.sirens.getHardwarePlacement() + ".");
    }

}

