package app.model.memento;

import app.model.Game;

public class Memento {
    private int money;
    private int numberOfBuildings;

    public Memento(Game game) {
        this.money = game.getMoney();
        this.numberOfBuildings = game.getNumberOfBuildings();
    }

    public int getMoney() {
        return money;
    }

    public int getNumberOfBuildings() {
        return numberOfBuildings;
    }
}
