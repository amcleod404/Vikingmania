import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Cop extends Stage {
    private Circle dotPrev;
    private Island islandHolder = null;
    private Label copTitle = new Label("You have encountered a Cop! ");
    private ListView<Item> inventory1 = new ListView<>(Ship.getItemInventory());
    private Label availableWealth1 =
            new Label("Your Current Wealth:  " + Player.getCurrentWealth2());
    private Label inven1 = new Label("Your Inventory: ");
    private Label shipFuelBtn1 = new Label("View Ship");
    private Label optionsTitle = new Label("Select an option below:");
    private VBox labels1 = new VBox(50);
    private HBox invenWealth = new HBox(50);
    private HBox buttonOptions = new HBox(50);
    private Scene scene;
    private Button forefit = new Button("Forefit items");
    private Button flee = new Button("Flee back to previous region");
    private Button fight = new Button("Fight the police officer");
    private Item itmCatch;
    private Label itemForefit;
    private int rand;
    public Cop() {
        int max = Ship.getItemInventory().size() - 1;
        int min = 0;
        int range = max - min + 1;
        this.rand = (int) (Math.random() * range) + min;
        this.itmCatch = Ship.getItemInventory().get(rand);
        this.itemForefit = new Label("Item to forfit: " + itmCatch.name());
        inventory1.setPrefWidth(500);
        buttonOptions.getChildren().addAll(forefit, flee, fight);
        invenWealth.getChildren().addAll(availableWealth1, inven1, inventory1);
        labels1.getChildren().addAll(copTitle, invenWealth,
                optionsTitle, itemForefit, buttonOptions);
        buttonEvent1();
        buttonEvent2();
        buttonEvent3();
        scene = new Scene(labels1, 1700, 800);
    }
    public void buttonEvent1() {
        forefit.setOnAction(ae -> {
            Ship.getItemInventory().remove(itmCatch);
            Player.setCurrIsland(islandHolder);
            islandHolder.setScene();
            this.close();
        });
    }

    public void buttonEvent2() {
        flee.setOnAction(ae -> {
            int chance = (int) Player.getSkillPointsPilot();
            int luckyNum = (int) ((Math.random() * 100));
            if (chance > luckyNum) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You successfully escaped!");
                errorAlert.showAndWait();
                if (Universe.getIslands().indexOf(islandHolder) == 0) {
                    Universe.getIslands().get(0).setScene();
                    Player.setCurrIsland(Universe.getIslands().get(0));
                    this.close();
                } else {
                    Ship.setFuelCapacity(Ship.getFuelCapacity() - 15);
                    Ship.setFuelLabel(Ship.getFuelCapacity());
                    int index = Universe.getIslands().indexOf(islandHolder) - 1;
                    dotPrev.setStyle("-fx-fill: blue");
                    dotPrev.setUserData("visited");
                    Universe.getIslands().get(index).setScene();
                    Player.setCurrIsland(Universe.getIslands().get(index));
                    this.close();
                }

            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You did not successfully escaped!");
                errorAlert.setContentText("stolen item will be taken, "
                        + "ship health will be damaged,"
                        + "you will give up 10 of your wealth,"
                        + "and return to the previous region.");
                errorAlert.showAndWait();
                Ship.getItemInventory().remove(itmCatch);
                Player.setCurrentWealth(Player.getCurrentWealth2() - 10);
                Ship.setHealth(Ship.getHealth() - 50);
                Ship.setHealthLabel(Ship.getHealth());
                if (Universe.getIslands().indexOf(islandHolder) == 0) {
                    if (Ship.getHealth() <= 0) {
                        GameOver gm1 = new GameOver();
                        gm1.setScene();
                        this.close();
                    } else {
                        Universe.getIslands().get(0).setScene();
                        Player.setCurrIsland(Universe.getIslands().get(0));
                        this.close();
                    }
                } else {
                    Ship.setFuelCapacity(Ship.getFuelCapacity() - 15);
                    Ship.setFuelLabel(Ship.getFuelCapacity());
                    int index = Universe.getIslands().indexOf(islandHolder) - 1;
                    dotPrev.setStyle("-fx-fill: blue");
                    dotPrev.setUserData("visited");
                    if (Ship.getHealth() <= 0) {
                        GameOver gm1 = new GameOver();
                        gm1.setScene();
                        this.close();
                    } else {
                        Universe.getIslands().get(index).setScene();
                        Player.setCurrIsland(Universe.getIslands().get(index));
                        this.close();
                    }
                }
            }

        });
    }

    public void buttonEvent3() {
        fight.setOnAction(ae -> {
            int chance = (int) Player.getSkillPointsFighter();
            int luckyNum = (int) ((Math.random() * 100));
            if (chance > luckyNum) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You successfully fought off the police");
                errorAlert.setContentText("you will keep all your items,"
                        + "and go to the desired island.");
                errorAlert.showAndWait();
                islandHolder.setScene();
                Player.setCurrIsland(islandHolder);
                this.close();
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You did not successfully fight off the police.");
                errorAlert.setContentText("you will lose stolen item.");
                errorAlert.showAndWait();
                Ship.getItemInventory().remove(itmCatch);
                islandHolder.setScene();
                Player.setCurrIsland(islandHolder);
                this.close();
            }
        });
    }


    public void setScene() {
        scene.getStylesheets().addAll("Cop.css");
        this.setFullScreen(true);
        this.setScene(scene);
        this.show();
    }
    public void setIslandHolder(Island i) {
        this.islandHolder = i;
    }
    public Island getIslandHolder() {
        return this.islandHolder;
    }
    public void setDotPrev(Circle c) {
        this.dotPrev = c;
    }
    public Circle getDotPrev() {
        return this.dotPrev;
    }
}
