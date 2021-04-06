package app.model.buildings;

public class Lumberjack extends Building {
    private static String name = "Lumberjack";

    public Lumberjack() {
        cost = 1500;
        profit = 300;
        imagePath = "lumberjack.png";
        requiredBuilding = StonePit.getName();
    }

    public static String getName() {return name;}
}
