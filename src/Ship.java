import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class Ship extends Stage {
    private static String name;
    private static int cargoCapacity;
    private static ObservableList<Item> itemInventory = FXCollections.observableArrayList();
    private static int fuelCapacity;
    private static int health;
    private VBox vbox1 = new VBox(150);
    private VBox vbox2 = new VBox(75);
    private HBox hbox = new HBox(750);
    private Label nameLabel;
    private Label cargoLabel;
    private Label itemLabel;
    private Label fuelLabel;
    private Label healthLabel;
    private ListView<Item> listofItems = new ListView<>(Ship.getItemInventory());
    private Scene scene;
    private Button mktBtn = new Button("MarketPlace");

    public Ship(String name, int cargoCapacity, int fuelCapacity, int health) {
        this.name = name;
        this.cargoCapacity = cargoCapacity;
        this.fuelCapacity = fuelCapacity;
        this.health = health;
        nameLabel = new Label(name);
        cargoLabel = new Label("Remaining Space: " +  (cargoCapacity - itemInventory.size()));
        itemLabel = new Label("Inventory:");
        fuelLabel = new Label("Remaining fuel: " + fuelCapacity);
        healthLabel = new Label("Remaining Health: " + health);
        vbox1.getChildren().addAll(nameLabel, cargoLabel, fuelLabel, healthLabel);
        vbox2.getChildren().addAll(itemLabel, listofItems, mktBtn);
        hbox.getChildren().addAll(vbox1, vbox2);
        mktBtnEvent();
        scene = new Scene(hbox, 1700, 800);
    }

    public String getName() {
        return name;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public  static ObservableList<Item> getItemInventory() {
        return itemInventory;
    }

    public int getHealth() {
        return health;
    }
    public static List<Item> getItemInventory2() {
        return itemInventory;
    }

    public void mktBtnEvent() {
        mktBtn.setOnAction(actionEvent -> {
            Player.getCurrMarket().setScene();
            this.close();
        });
    }


    public void setScene() {
        scene.getStylesheets().addAll("ship.css");
        this.setFullScreen(true);
        this.setScene(scene);
        this.show();
    }

    public void setCargoCapacityLabel(int size) {
        cargoLabel.setText("Remaining Space: " + (cargoCapacity - size));
    }
}
