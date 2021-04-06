package app.model.buildings;

public class Mint extends Building {
    private static String name = "Mint";

    public Mint() {
        cost = 10000;
        profit = 3000;
        imagePath = "mint.png";
        requiredBuilding = GoldMine.getName();
    }

    public static String getName() {return name;}
}
