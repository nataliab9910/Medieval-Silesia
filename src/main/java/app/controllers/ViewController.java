package app.controllers;

import app.LabelCodes;
import app.model.Game;
import app.model.buildings.*;
import app.model.memento.Memento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ViewController {
    @FXML
    private Button undoButton;
    @FXML
    private Button mintButton;
    @FXML
    private Button goldMineButton;
    @FXML
    private Button sawmillButton;
    @FXML
    private Button lumberjackButton;
    @FXML
    private Button stonepitButton;
    @FXML
    private Button nextDayButton;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label instructionLabel;
    @FXML
    private GridPane mapGrid;

    private GameController gameController;

    public void initialize() {
        gameController = new GameController(new Game(mapGrid));

        nextDayButton.setOnAction(e -> nextDayButtonAction(e));

        stonepitButton.setOnAction(e -> buildingButtonAction(e, new StonePit()));

        lumberjackButton.setOnAction(e -> buildingButtonAction(e, new Lumberjack()));

        sawmillButton.setOnAction(e -> buildingButtonAction(e, new Sawmill()));

        goldMineButton.setOnAction(e -> buildingButtonAction(e, new GoldMine()));

        mintButton.setOnAction(e -> buildingButtonAction(e, new Mint()));

        undoButton.setOnAction(e -> undoButtonAction(e));
    }

    private void buildingButtonAction(ActionEvent e, Building building) {
        LabelCodes labelCode = gameController.buyBuilding(building);
        switch (labelCode) {
            case OK -> { welcomeLabel.setText("Terŏz mŏsz " + gameController.getGame().getMoney() + " mōnet. Co dalij?");
            instructionLabel.setText("Kupiōłś se nowy stawiynie! Co dalij?");}
            case NO_MONEY -> instructionLabel.setText("Mŏsz za mało mōnet! Kup se coś tōńszego abo przecuć nowy dziyń!");
            case NO_PLACE -> instructionLabel.setText("Gratulacyje! Kōniec szpilu.");
            case NO_BUILDING -> instructionLabel.setText("Niy tak wartko! Nojprzōd kup se coś tōńszego.");
        }
    }

    private void undoButtonAction(ActionEvent e) {
        Memento memento = gameController.getCaretaker().get();
        if (memento == null) {
            welcomeLabel.setText("Styknie ci tego cŏfaniŏ! Terŏz mŏsz " + gameController.getGame().getMoney() + " mōnet.");
        } else {
        gameController.getStateFromMemento(memento);
        welcomeLabel.setText("Cŏfniynte! Zaś mŏsz " + gameController.getGame().getMoney() + " mōnet."); }
    }

    private void nextDayButtonAction(ActionEvent e) {
        gameController.nextDay();
        welcomeLabel.setText("Nadszoł nowy dziyń! Mŏsz " + gameController.getGame().getMoney() + " mōnet.");
        instructionLabel.setText("Postŏw se jakeś stawiynie abo przecuć nowy dziyń!");
    }
}
