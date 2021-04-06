package app.model.buildings;

public class StonePit extends Building {
    private static String name = "StonePit";

    public StonePit() {
        cost = 500;
        profit = 200;
        imagePath = "stonepit.png";
    }

    public static String getName() {return name;}
}
