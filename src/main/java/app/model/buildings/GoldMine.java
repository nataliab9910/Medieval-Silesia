package app.model.buildings;

public class GoldMine extends Building {
    private static String name = "GoldMine";

    public GoldMine() {
        cost = 5000;
        profit = 1000;
        imagePath = "goldmine.png";
        requiredBuilding = Sawmill.getName();
    }

    public static String getName() {return name;}
}
