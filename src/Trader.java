import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Trader extends Stage {
    private Circle dotPrev2;
    private Island islandHolder2 = null;
    private Label traderTitle = new Label("You have encountered a Trader! ");
    private ListView<Item> inventory2 = new ListView<>(Ship.getItemInventory());
    private Label availableWealth2 =
            new Label("Your Current Wealth:  " + Player.getCurrentWealth2());
    private Label inven2 = new Label("Your Inventory: ");
    private Item toSell;
    private Label optionsTitle2 = new Label("Select an option below:");
    private Label itemToSell;
    private Item[] items = Item.values();
    private VBox labels2 = new VBox(50);
    private HBox invenWealth2 = new HBox(50);
    private HBox buttonOptions2 = new HBox(50);
    private VBox options2 = new VBox(50);
    private Scene scene;
    private Button buyItems = new Button("buy item");
    private Button ignoreTrader = new Button("Ignore");
    private Button rob = new Button("Rob Trader");
    private Button neg = new Button("negotiate");
    private int counter = 0;
    private ToggleGroup groupItems = new ToggleGroup();
    private double priceTracker;

    public Trader() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name().equals(Item.AETHER)) {
                items[i] = Item.DIAMOND;
            }
        }
        int max = items.length - 1;
        int min = 0;
        int range = max - min + 1;
        int index = (int) (Math.random() * range) + min;
        this.toSell = items[index];
        priceTracker = toSell.getX();
        this.itemToSell = new Label("Item to sell: " + toSell.name() + " price: " + priceTracker);
        inventory2.setPrefWidth(500);
        buttonOptions2.getChildren().addAll(buyItems, ignoreTrader, rob, neg);
        invenWealth2.getChildren().addAll(availableWealth2, inven2, inventory2);
        labels2.getChildren().addAll(traderTitle, invenWealth2, optionsTitle2,
                itemToSell, buttonOptions2);
        RadioButton btn22 = new RadioButton("Alternate price: " + (priceTracker - 7));
        RadioButton btn23 = new RadioButton("Alternate price: " + (priceTracker - 10));
        btn22.setUserData(priceTracker - 7);
        btn23.setUserData(priceTracker - 10);
        btn22.setToggleGroup(groupItems);
        btn23.setToggleGroup(groupItems);
        options2.getChildren().addAll(btn22, btn23);
        buttonOptions2.getChildren().addAll(options2);
        buttonEvent1();
        buttonEvent2();
        buttonEvent3();
        buttonEvent4();
        scene = new Scene(labels2, 1700, 800);
    }
    public void setScene() {
        scene.getStylesheets().addAll("Trader.css");
        this.setFullScreen(true);
        this.setScene(scene);
        this.show();
    }
    private void buttonEvent1() {
        buyItems.setOnAction(ae -> {
            if (Player.getCurrentWealth2() < (priceTracker)
                    || (Player.getShip().getItemInventory().size() + 1
                    > Player.getShip().getCargoCapacity())) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Purchase Error");
                errorAlert.setContentText("You do not have enough credits to buy this item or "
                        + "you will exceed cargo capacity.");
                errorAlert.showAndWait();
            } else {
                Player.getShip().getItemInventory().addAll(toSell);
                Player.setCurrentWealth(Player.getCurrentWealth2() - priceTracker);
                islandHolder2.setScene();
                Player.setCurrIsland(islandHolder2);
                this.close();
            }
        });
    }

    private void buttonEvent2() {
        ignoreTrader.setOnAction(ae -> {
            islandHolder2.setScene();
            Player.setCurrIsland(islandHolder2);
            this.close();
        });
    }

    private void buttonEvent3() {
        rob.setOnAction(ae -> {
            if ((Player.getShip().getItemInventory().size() + 1
                    > Player.getShip().getCargoCapacity())) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Robbing Error");
                errorAlert.setContentText("You do not have space in your cargo.");
                errorAlert.showAndWait();
            } else {
                int chance = (int) Player.getSkillPointsFighter();
                int luckyNum = (int) ((Math.random() * 100));
                if (chance > luckyNum) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("You Have successfully robbed the trader");
                    errorAlert.showAndWait();
                    Player.getShip().getItemInventory().addAll(toSell);
                    Ship.setCargoCapacityLabel(1);
                    islandHolder2.setScene();
                    Player.setCurrIsland(islandHolder2);
                    this.close();
                } else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Robbing Error");
                    errorAlert.setContentText("You did not successfully rob the Trader."
                            + "He will damage your health");
                    errorAlert.showAndWait();
                    Ship.setHealth(Ship.getHealth() - 50);
                    if (Ship.getHealth() <= 0) {
                        GameOver gm1 = new GameOver();
                        gm1.setScene();
                        this.close();
                    } else {
                        Ship.setHealthLabel(Ship.getHealth());
                        islandHolder2.setScene();
                        Player.setCurrIsland(islandHolder2);
                        this.close();
                    }
                }
            }
        });
    }

    private void buttonEvent4() {
        neg.setOnAction(ae -> {
            if (counter > 0) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Negotiating Error");
                errorAlert.setContentText("You have already tried negotiating.");
                errorAlert.showAndWait();
            } else {
                if ((Player.getShip().getItemInventory().size() + 1
                        > Player.getShip().getCargoCapacity())) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Negotiating Error");
                    errorAlert.setContentText("You do not have space in your cargo.");
                    errorAlert.showAndWait();
                } else {
                    counter++;
                    int chance = (int) Player.getSkillPointsMerchant2();
                    int luckyNum = (int) ((Math.random() * 100));
                    Double x = (Double) groupItems.getSelectedToggle().getUserData();
                    if (chance > luckyNum) {
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setHeaderText("You Have successfully negotiated a new price!");
                        errorAlert.setContentText("Your new item is"
                                + "added to your inventory for the new price.");
                        errorAlert.showAndWait();
                        Player.getShip().getItemInventory().addAll(toSell);
                        Ship.setCargoCapacityLabel(1);
                        Player.setCurrentWealth(Player.getCurrentWealth2() - x);
                        islandHolder2.setScene();
                        Player.setCurrIsland(islandHolder2);
                        this.close();
                    } else {
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setHeaderText("You did not successfully negotiate a new price!");
                        errorAlert.setContentText("");
                        errorAlert.showAndWait();
                        priceTracker = priceTracker + 15;
                        itemToSell.setText("Item to sell: " + toSell.name()
                                + "price: " + priceTracker);
                    }
                }
            }
        });
    }
    public void setIslandHolder2(Island i) {
        this.islandHolder2 = i;
    }
    public Island getIslandHolder2() {
        return this.islandHolder2;
    }
    public void setDotPrev2(Circle c) {
        this.dotPrev2 = c;
    }
    public Circle getDotPrev2() {
        return this.dotPrev2;
    }
}
