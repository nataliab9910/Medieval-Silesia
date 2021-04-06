package app.controllers;

import app.LabelCodes;
import app.model.Game;
import app.model.buildings.Building;
import app.model.memento.Caretaker;
import app.model.memento.Memento;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController {
    private Game game;
    private Caretaker caretaker = new Caretaker();

    public GameController(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Caretaker getCaretaker() {
        return caretaker;
    }

    public LabelCodes buyBuilding(Building building) {

        if (tooMuchBuildings()) {
            return LabelCodes.NO_PLACE;
        }

        if (!checkRequirement(building)) {
            return LabelCodes.NO_BUILDING;
        }

        caretaker.add(new Memento(game));

        int cost = building.getCost();
        if (!pay(cost)) {
            return LabelCodes.NO_MONEY;
        }

        ((ImageView) game.getMapGrid().getChildren().get(game.getNumberOfBuildings())).setImage(new Image(building.getImagePath()));
        game.setNumberOfBuildings(game.getNumberOfBuildings() + 1);
        game.addBuilding(building);

        return LabelCodes.OK;
    }

    public void nextDay() {
        caretaker.add(new Memento(game));
        for (Building building : game.getBuildingList()) {
            game.setMoney(game.getMoney()+building.getProfit());
        }
    }

    private boolean pay(int cost) {
        int money = game.getMoney();
        if (cost <= money) {
            game.setMoney(money - cost);
            return true;
        }
        return false;
    }

    private boolean tooMuchBuildings() {
        return game.getNumberOfBuildings() >= Game.getMaxNumberOfBuildings();
    }
    
    private boolean checkRequirement(Building buildingToPlace) {
        if (buildingToPlace.getRequiredBuilding() == null) return true;
        if (game.getBuildingList() == null) return false;
        return game.getBuildingList().toString().contains(buildingToPlace.getRequiredBuilding());
    }

    public void getStateFromMemento(Memento memento){
        int mementoBuildings = memento.getNumberOfBuildings();
        int diff = game.getNumberOfBuildings() - mementoBuildings;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                ((ImageView) game.getMapGrid().getChildren().get(mementoBuildings + i)).setImage(new Image("placeholder.png"));
                game.getBuildingList().remove(mementoBuildings + i);
            }
        }
        game.setMoney(memento.getMoney());
        game.setNumberOfBuildings(mementoBuildings);
    }
}
