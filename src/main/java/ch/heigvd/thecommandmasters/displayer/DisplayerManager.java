package ch.heigvd.thecommandmasters.displayer;

public class DisplayerManager {

    private static Displayer displayer = null;

    public static void setDisplayer(Displayer displayer) {
        DisplayerManager.displayer = displayer;
    }

    public static boolean hasDisplayer() {
        return displayer != null;
    }

    public static Displayer getDisplayer() {
        return displayer;
    }
}
