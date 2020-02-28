import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MarketPlace extends Stage {
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private HBox marketPlace = new HBox(50);
    private Label marketPlaceLabel = new Label("Marketplace");
    private VBox wealthanditems = new VBox(50);
    private Label availableWealth =
            new Label("Your Current Wealth:  " + Player.getCurrentWealth2());
    private ImageView padding2 = new ImageView();
    private VBox selling = new VBox(50);
    private ToggleGroup groupItems = new ToggleGroup();
    private Button purchase = new Button("purchase item");
    private Button mapBtn = new Button("Back to Map");
    private Button sellBtn = new Button("Sell Item");
    private HBox hbox = new HBox(50);
    private Scene scene;
    private ListView<Item> listofItems = new ListView<>(Ship.getItemInventory());
    private ImageView img = new ImageView();
    private Button shipBtn = new Button("View Ship");
    private ImageView padding = new ImageView();


    public MarketPlace(Item item1, Item item2, Item item3, Item item4) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        RadioButton radioItem1 = new RadioButton(item1.name() + ": " + (item1.getX()
                + (500.0 / (Player.getSkillPointsMerchant2() + 1))));
        radioItem1.setUserData(item1);
        RadioButton radioItem2 = new RadioButton(item2.name() + ": " + (item2.getX()
                + (500.0 / (Player.getSkillPointsMerchant2() + 1))));
        radioItem2.setUserData(item2);
        RadioButton radioItem3 = new RadioButton(item3.name() + ": " + (item3.getX()
                + (500.0 / (Player.getSkillPointsMerchant2() + 1))));
        radioItem3.setUserData(item3);
        RadioButton radioItem4 = new RadioButton(item4.name() + ": " + (item4.getX()
                + (500.0 / (Player.getSkillPointsMerchant2() + 1))));
        radioItem4.setUserData(item4);
        radioItem1.setToggleGroup(groupItems);
        radioItem2.setToggleGroup(groupItems);
        radioItem3.setToggleGroup(groupItems);
        radioItem4.setToggleGroup(groupItems);
        img.setFitHeight(50);
        padding2.setFitWidth(450);
        padding.setFitHeight(50);
        listofItems.setMinHeight(300);
        selling.getChildren().addAll(img, radioItem1,
                radioItem2, radioItem3, radioItem4, purchase, padding, hbox);
        mapBtn.setMinSize(200, 100);
        buttonEvent();
        hbox.getChildren().addAll(mapBtn);
        wealthanditems.getChildren().addAll(marketPlaceLabel,
                availableWealth, listofItems, sellBtn, shipBtn);
        marketPlace.getChildren().addAll(wealthanditems, padding2, selling);
        buttonEvent2();
        buttonEvent33();
        shipBtnEvent();
        scene = new Scene(marketPlace, 1700, 800);
    }

    public Item getItem1() {
        return item1;
    }

    public Item getItem2() {
        return item2;
    }

    public Item getItem3() {
        return item3;
    }

    public Item getItem4() {
        return item4;
    }
    public void buttonEvent() {
        mapBtn.setOnAction(actionEvent -> {
            Vikingmania.getUni().setScene();
            this.close();
        });
    }

    public void buttonEvent2() {
        purchase.setOnAction(ae -> {
            Item itm1 = (Item) groupItems.getSelectedToggle().getUserData();
            if (itm1.getX() > Player.getCurrentWealth2()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Purchase error");
                errorAlert.setContentText("You do no have enough money to purchase this item.");
                errorAlert.showAndWait();
            } else if (Player.getShip().getItemInventory().size()
                    + 1 > Player.getShip().getCargoCapacity()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Cargo error");
                errorAlert.setContentText("You do no have enough space"
                        + "on your ship for this item.");
                errorAlert.showAndWait();
            } else {
                Player.getShip().getItemInventory().add(itm1);
                Player.setCurrentWealth(Player.getCurrentWealth2() - (itm1.getX()
                        + (500.0 / (Player.getSkillPointsMerchant2() + 1))));
                Label x = new Label(itm1.toString());
                availableWealth.setText("Your Current Wealth:" + Player.getCurrentWealth2());
                Forge.getAvailableWealthLabel().setText("Your Current Wealth:"
                        + Player.getCurrentWealth2());
                Player.getShip().setCargoCapacityLabel(Ship.getItemInventory().size());
            }
        });
    }

    /*public void buttonEvent3() {
        listofItems.setOnMouseClicked(ae -> {
            Item itm1 = listofItems.getSelectionModel().getSelectedItem();
            double x = itm1.getX() - 5;
            if (x < 0) {
                x = 0;
            }
            Player.setCurrentWealth(x + Player.getCurrentWealth2());
            availableWealth.setText("Your Current Wealth:" + Player.getCurrentWealth2());
            Forge.getAvailableWealthLabel().setText("Your Current Wealth:"
                    + Player.getCurrentWealth2());
            Ship.getItemInventory().remove(itm1);
            Player.getShip().setCargoCapacityLabel(Ship.getItemInventory().size());
        });
    } */

    public void buttonEvent33() {
        sellBtn.setOnAction(ae -> {
            Item itm1 = null;
            itm1 = listofItems.getSelectionModel().getSelectedItem();
            if (itm1 == null) {
                itm1 = null;
            } else {
                double x = itm1.getX() - 5;
                if (x < 0) {
                    x = 0;
                }
                Player.setCurrentWealth(x + Player.getCurrentWealth2());
                availableWealth.setText("Your Current Wealth:" + Player.getCurrentWealth2());
                Forge.getAvailableWealthLabel().setText("Your Current Wealth:"
                        + Player.getCurrentWealth2());
                Ship.getItemInventory().remove(itm1);
                Player.getShip().setCargoCapacityLabel(Ship.getItemInventory().size());
            }
        });
    }

    public void shipBtnEvent() {
        shipBtn.setOnAction(actionEvent -> {
            Player.getShip().setScene();
            this.close();
        });
    }
    public void setScene() {
        scene.getStylesheets().addAll("Market.css");
        this.setFullScreen(true);
        this.setScene(scene);
        this.show();
    }

}
