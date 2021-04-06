package app.model;

import app.model.buildings.Building;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private GridPane mapGrid;
    private int money = 2000;
    private List<Building> buildingList = new ArrayList<>();
    private int numberOfBuildings = 0;
    private static int maxNumberOfBuildings;

    public Game(GridPane mapGrid) {
        this.mapGrid = mapGrid;
        maxNumberOfBuildings = mapGrid.getColumnCount() * mapGrid.getRowCount();
    }

    public void addBuilding(Building building) {
        buildingList.add(building);
    }

    public GridPane getMapGrid() {
        return mapGrid;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public int getNumberOfBuildings() {
        return numberOfBuildings;
    }

    public void setNumberOfBuildings(int numberOfBuildings) {
        this.numberOfBuildings = numberOfBuildings;
    }

    public static int getMaxNumberOfBuildings() {
        return maxNumberOfBuildings;
    }
}
