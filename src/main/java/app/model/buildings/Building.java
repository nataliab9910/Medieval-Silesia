package app.model.buildings;

public abstract class Building {
    protected int cost;
    protected int profit;
    protected String imagePath;
    protected String requiredBuilding = null;

    public int getCost() {
        return cost;
    }

    public int getProfit() {
        return profit;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getRequiredBuilding() {
        return requiredBuilding;
    }
}
