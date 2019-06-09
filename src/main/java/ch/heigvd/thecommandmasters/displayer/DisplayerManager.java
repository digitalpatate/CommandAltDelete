package ch.heigvd.thecommandmasters.displayer;

public class DisplayerManager {

    private static Displayer displayer = null;

    private static void setDisplayer(Displayer displayer) {
        DisplayerManager.displayer = displayer;
    }

    private static boolean hasDisplayer() {
        return displayer != null;
    }

    private static Displayer getDisplayer() {
        return displayer;
    }
}
