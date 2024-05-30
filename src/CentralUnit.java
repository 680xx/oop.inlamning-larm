import java.util.*;

public class CentralUnit {


    Scanner scanner = new Scanner(System.in);


    // Variabler

    private boolean runMainMenu = true;
    private boolean activeAlarm = true;
    private int randomDetection;

    // Konstruktor

    public CentralUnit() {
        initialize();
    }


    // Skapa lista

    List<Hardware> hardware = new ArrayList<>();


    // Skapa objekt

    DetectorSmoke detectorSmoke = new DetectorSmoke("");
    DetectorWindow detectorWindow = new DetectorWindow("", "");
    DetectorDoor detectorDoor = new DetectorDoor("");
    DetectorMovement detectorMovement = new DetectorMovement("");
    Sprinkler sprinkler = new Sprinkler("");
    Sirens sirens = new Sirens("huset");


    // Skapa rummens objekt och lägga till i listan

    public void initialize() {

        Sirens sirens = new Sirens("huset");

        DetectorWindow detectorWindow1 = new DetectorWindow("garaget", "");
        DetectorDoor detectorDoor1 = new DetectorDoor("garaget");
        DetectorSmoke detectorSmoke1 = new DetectorSmoke("garaget");
        Sprinkler sprinkler1 = new Sprinkler("garaget");

        DetectorWindow detectorWindow2 = new DetectorWindow("vardagsrummet", "1");
        DetectorWindow detectorWindow3 = new DetectorWindow("vardagsrummet", "2");
        DetectorSmoke detectorSmoke2 = new DetectorSmoke("vardagsrummet");
        Sprinkler sprinkler2 = new Sprinkler("vardagsrummet");

        DetectorWindow detectorWindow4 = new DetectorWindow("köket", "");
        DetectorSmoke detectorSmoke3 = new DetectorSmoke("köket");
        Sprinkler sprinkler3 = new Sprinkler("köket");

        DetectorWindow detectorWindow5 = new DetectorWindow("hallen", "");
        DetectorDoor detectorDoor2 = new DetectorDoor("hallen");
        DetectorSmoke detectorSmoke4 = new DetectorSmoke("hallen");
        Sprinkler sprinkler4 = new Sprinkler("hallen");

        DetectorMovement detectorMovement = new DetectorMovement("trädgården");

        DetectorWindow detectorWindow6 = new DetectorWindow("sovrum 1", "1");
        DetectorWindow detectorWindow7 = new DetectorWindow("sovrum 1", "2");
        DetectorSmoke detectorSmoke5 = new DetectorSmoke("sovrum 1");
        Sprinkler sprinkler5 = new Sprinkler("sovrum 1");

        DetectorWindow detectorWindow8 = new DetectorWindow("sovrum 2", "");
        DetectorSmoke detectorSmoke6 = new DetectorSmoke("sovrum 2");
        Sprinkler sprinkler6 = new Sprinkler("sovrum 2");

        DetectorWindow detectorWindow9 = new DetectorWindow("sovrum 3", "");
        DetectorSmoke detectorSmoke7 = new DetectorSmoke("sovrum 3");
        Sprinkler sprinkler7 = new Sprinkler("sovrum 3");

        DetectorWindow detectorWindow10 = new DetectorWindow("sovrum 4", "1");
        DetectorWindow detectorWindow11 = new DetectorWindow("sovrum 4", "2");
        DetectorSmoke detectorSmoke8 = new DetectorSmoke("sovrum 4");
        Sprinkler sprinkler8 = new Sprinkler("sovrum 4");

        DetectorWindow detectorWindow12 = new DetectorWindow("sovrum 5", "");
        DetectorSmoke detectorSmoke9 = new DetectorSmoke("sovrum 5");
        Sprinkler sprinkler9 = new Sprinkler("sovrum 5");

        hardware.add(detectorWindow1);
        hardware.add(detectorWindow2);
        hardware.add(detectorWindow3);
        hardware.add(detectorWindow4);
        hardware.add(detectorWindow5);
        hardware.add(detectorWindow6);
        hardware.add(detectorWindow7);
        hardware.add(detectorWindow8);
        hardware.add(detectorWindow9);
        hardware.add(detectorWindow10);
        hardware.add(detectorWindow11);
        hardware.add(detectorWindow12);

        hardware.add(detectorDoor1);
        hardware.add(detectorDoor2);

        hardware.add(detectorMovement);

        hardware.add(detectorSmoke1);
        hardware.add(detectorSmoke2);
        hardware.add(detectorSmoke3);
        hardware.add(detectorSmoke4);
        hardware.add(detectorSmoke5);
        hardware.add(detectorSmoke6);
        hardware.add(detectorSmoke7);
        hardware.add(detectorSmoke8);
        hardware.add(detectorSmoke9);

        hardware.add(sprinkler1);
        hardware.add(sprinkler2);
        hardware.add(sprinkler3);
        hardware.add(sprinkler4);
        hardware.add(sprinkler5);
        hardware.add(sprinkler6);
        hardware.add(sprinkler7);
        hardware.add(sprinkler8);
        hardware.add(sprinkler9);

        hardware.add(sirens);

    }


    // Returnera lista

    public List<Hardware> getList() {
        return hardware;
    }

    // Huvudmeny

    public void mainMenu() {

        Scanner scanner = new Scanner(System.in);

        while (runMainMenu) {
            boolean runSimulationMenu = true;
            System.out.println("\n" + "--------------------------------------------------");
            System.out.print("MENY (Alarmstatus : ");
            if (activeAlarm) {
                System.out.println("Aktiverat)");
            } else {
                System.out.println("Inaktiverat, endast brandlarm)");
            }

            System.out.println("--------------------------------------------------");
            System.out.println("1. Aktivera / Avaktivera larm");
            System.out.println("2. Avbryta / Återställa larm");
            System.out.println("3. Simulering av händelse");
            System.out.println("4. Avsluta");
            System.out.print("\n" + "Ange val: ");
            int mainMenuChoice = scanner.nextInt();
            switch (mainMenuChoice) {
                case 1:
                    activateDeactivate();
                    break;
                case 2:
                    resetAlarm();
                    break;
                case 3:
                    while (runSimulationMenu) {
                        System.out.println("\n" + "Välj händelse att simulera");
                        System.out.println("--------------------------");
                        System.out.println("1. Brand");
                        System.out.println("2. Inbrott");
                        System.out.println("3. Rörelse i poolområdet");
                        System.out.println("4. <- Tillbaka");
                        System.out.print("\n" + "Ange val: ");
                        int simulationMenuChoice = scanner.nextInt();

                        switch (simulationMenuChoice) {
                            case 1:
                                randomizerSmoke();
                                hardware.get(randomDetection).setDetectorTriggered(true);
                                sirens.setDetectorTriggered(true);

                                detectorSmoke.detectAction(randomDetection);
                                runSimulationMenu = false;
                                break;
                            case 2:
                                if (hardware.get(randomDetection).isDetectorActivated()) {
                                    sirens.setDetectorTriggered(true);
                                    randomizerBurglary();
                                    if (randomDetection < 12) {
                                        hardware.get(randomDetection).setDetectorTriggered(true);
                                        detectorWindow.detectAction(randomDetection);
                                        runSimulationMenu = false;
                                        break;
                                    } else {
                                        hardware.get(randomDetection).setDetectorTriggered(true);
                                        detectorDoor.detectAction(randomDetection);
                                        runSimulationMenu = false;
                                        break;
                                    }
                                } else {
                                    runSimulationMenu = false;
                                    break;
                                }
                            case 3:
                                if (hardware.get(14).isDetectorActivated()) {
                                    hardware.get(14).setDetectorTriggered(true);
                                    sirens.setDetectorTriggered(true);
                                    detectorMovement.detectAction();
                                } else {
                                    runSimulationMenu = false;
                                    break;

                                }
                            case 4:
                                runSimulationMenu = false;
                                break;

                            default:
                                System.out.println("Felaktigt val");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n" + "Systemet avslutas");
                    runMainMenu = false;
                    break;
                default:
                    System.out.println("Felaktigt val");
            }
        }
    }


    // Aktivera/avaktivera Larm

    public void activateDeactivate() {
        System.out.print("\n" + "Ange kod för att inaktivera / aktivera larmet: ");
        String code = scanner.nextLine();
        if (Objects.equals(code, "780705")) {
            for (int i = 0; i < hardware.size(); i++) {
                if (!Objects.equals(hardware.get(i).getHardwareType(), "rökdetektor"))
                    if (hardware.get(i).isDetectorActivated()) {
                        hardware.get(i).setDetectorActivated(false);
                        activeAlarm = false;
                    } else {
                        hardware.get(i).setDetectorActivated(true);
                        activeAlarm = true;
                    }
            }
        } else {
            System.out.println("Koden är felaktig.");
        }
    }



    // Återställer larm

    public void resetAlarm() {
        if ((hardware.get(randomDetection).isDetectorTriggered()) || (hardware.get(14).isDetectorTriggered())){
            System.out.println("\n" + "Ange kod för att avbryta / återställa larmet: ");
            String code = scanner.nextLine();
            if (Objects.equals(code, "780705")) {
                for (int i = 0; i < hardware.size(); i++) {
                    hardware.get(i).setDetectorTriggered(false);
                }
                System.out.println("\n" + "Larmet är återställt");
            } else {
                System.out.println("\n" + "Koden är felaktig.");
            }
        } else {
            System.out.println("\n" + "Det finns inget aktivt larm att återställa.");
        }

    }


    // Slumpar fram en rökdetektor ur listan

    public void randomizerSmoke() {
        Random random = new Random();
        randomDetection = random.nextInt(9) + 15;
    }


    // Slumpar fram fönster- alt. dörrdetektor ur listan

    public void randomizerBurglary() {
        Random random = new Random();
        randomDetection = random.nextInt(14);
    }

}











