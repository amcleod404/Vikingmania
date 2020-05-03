import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Forge extends Stage {
    private VBox vbox;
    private HBox hbox1 = new HBox(475);
    private HBox hbox2 = new HBox(850);
    private HBox hbox3 = new HBox(10);
    private HBox labels = new HBox(940);
    private Label availableLabel = new Label("BUY POWERS");
    private Label currUpgradesLabel = new Label("EQUIPPED POWERS");
    private static Label availableWealth = new Label("Your Current Wealth:  " + 500);
    private ListView<Object> availableUpgrades = new ListView<>(available);
    private ListView<Object> currUpgrades = new ListView<>(upgrades);
    private ImageView padding = new ImageView();
    private ImageView pad1 = new ImageView();
    private ImageView pad2 = new ImageView();
    private Label label = new Label("CHARACTER UPGRADES");
    private Scene scene;
    private Button islandButton = new Button("Back to Island");
    private Button purchase = new Button("Purchase");
    private static ObservableList<Object> available = FXCollections.observableArrayList();
    private static ObservableList<Object> upgrades = FXCollections.observableArrayList();

    public Forge() {
        available.addAll(CharacterUpgrades.AFTERLIFE, CharacterUpgrades.INVISIBILITY,
                CharacterUpgrades.MAXSKILL, CharacterUpgrades.INVESTOR, CharacterUpgrades.VIKINGGOD,
                CharacterUpgrades.ALWAYS_DRUNK);
        hbox1.getChildren().addAll(padding, label);
        hbox2.getChildren().addAll(availableUpgrades, currUpgrades);
        hbox3.getChildren().addAll(purchase, pad1, availableWealth, pad2, islandButton);
        pad1.setFitWidth(315);
        pad2.setFitWidth(225);
        availableLabel.setStyle("-fx-font-size: 25px");
        currUpgradesLabel.setStyle("-fx-font-size: 25px");
        labels.getChildren().addAll(availableLabel, currUpgradesLabel);
        vbox = new VBox(60);
        vbox.getChildren().addAll(hbox1, labels, hbox2, hbox3);
        scene = new Scene(vbox, 1700, 800);
        setIslandButtonEvent();
        purchaseEvent();
        hoverEvent();
        hoverEvent3();
        sellEvent();

    }

    public void setScene() {
        scene.getStylesheets().addAll("forge.css");
        this.setFullScreen(true);
        this.setScene(scene);
        this.show();

    }

    public void setIslandButtonEvent() {
        islandButton.setOnAction(actionEvent -> {
            Player.getCurrIsland().setScene();
            this.close();
        });
    }

    public void purchaseEvent() {
        purchase.setOnAction(ae -> {
            CharacterUpgrades itm1 =
                    (CharacterUpgrades) availableUpgrades.getSelectionModel().getSelectedItem();
            if (itm1.getX() > Player.getCurrentWealth2()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Purchase Error");
                errorAlert.setContentText("You do no have enough money to purchase this item.");
                errorAlert.showAndWait();
            } else {
                upgrades.add(itm1);
                available.removeAll(itm1);
                Player.setCurrentWealth(Player.getCurrentWealth2() - itm1.getX());
                availableWealth.setText("Your Current Wealth:  " + Player.getCurrentWealth2());

            }
        });
    }

    public void hoverEvent() {
        availableUpgrades.setOnMouseEntered(ae -> {
            ObservableList<Object> cost = FXCollections.observableArrayList();
            cost.addAll(CharacterUpgrades.AFTERLIFE.getX(), CharacterUpgrades.INVISIBILITY.getX(),
                    CharacterUpgrades.MAXSKILL.getX(), CharacterUpgrades.INVESTOR.getX(),
                    CharacterUpgrades.VIKINGGOD.getX(), CharacterUpgrades.ALWAYS_DRUNK.getX());
            availableUpgrades.setItems(cost);
        });
    }

    public void hoverEvent3() {
        availableUpgrades.setOnMouseClicked(ae -> {
            availableUpgrades.setItems(available);
        });
    }

    public void sellEvent() {
        currUpgrades.setOnMouseClicked(ae -> {
            CharacterUpgrades itm1 =
                    (CharacterUpgrades) currUpgrades.getSelectionModel().getSelectedItem();
            upgrades.removeAll(itm1);
            available.addAll(itm1);
        });
    }





    public static Label getAvailableWealthLabel() {
        return availableWealth;
    }
}
