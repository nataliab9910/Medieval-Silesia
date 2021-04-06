package app.model.buildings;

public class Sawmill extends Building {
    private static String name = "Sawmill";

    public Sawmill() {
        cost = 3000;
        profit = 500;
        imagePath = "sawmill.png";
        requiredBuilding = Lumberjack.getName();
    }

    public static String getName() { return name; }
}
