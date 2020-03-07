import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Bandit extends Stage {
    private static int tax = 200;
    private VBox vbox = new VBox(100);
    private HBox hbox1 = new HBox(450);
    private HBox hbox2 = new HBox(460);
    private HBox hbox3 = new HBox(525);
    private HBox hbox4 = new HBox(210);
    private HBox gap1 = new HBox();
    private HBox gap2 = new HBox();
    private ImageView padding = new ImageView();
    private ImageView padding2 = new ImageView();
    private ImageView padding3 = new ImageView();
    private ImageView padding4 = new ImageView();
    private Button btn1 = new Button("Pay The Bandit");
    private Button btn2 = new Button("Flee The Bandit");
    private Button btn3 = new Button("Fight The Bandit");
    private Scene scene;

    public Bandit() {
        Label header = new Label("A Bandit appears!");
        header.setStyle("-fx-font-size: 60px");
        Label subheader = new Label("He requests " + tax + " credits.");
        subheader.setStyle("-fx-font-size: 40px");
        Label body = new Label("What do you do?");
        body.setStyle("-fx-font-size: 35px");
        hbox1.getChildren().addAll(padding, header);
        hbox2.getChildren().addAll(padding2, subheader);
        hbox3.getChildren().addAll(padding3, body);
        hbox4.getChildren().addAll(padding4, btn1, btn2, btn3);
        vbox.getChildren().addAll(hbox1, hbox2, gap1, gap2, hbox3, hbox4);
        payEvent();
        fleeEvent();
        fightEvent();
        scene = new Scene(vbox, 1700, 800);

    }

    public void setScene() {
        scene.getStylesheets().addAll("Event.css");
        this.setFullScreen(true);
        this.setScene(scene);
        this.show();
    }

    public void payEvent() {
        btn1.setOnAction(actionEvent -> {
            if (Player.getCurrentWealth2() > tax) {
                Player.setCurrentWealth(Player.getCurrentWealth2() - tax);
                Player.getCurrIsland().setScene();
                this.close();
            } else {
                if (Ship.getItemInventory().size() == 0) {
                    Ship.setHealth(Ship.getHealth() - 50);
                    Ship.setHealthLabel(Ship.getHealth());
                } else {
                    Ship.getItemInventory().clear();
                    Ship.setCargoCapacityLabel(0);
                }
                Player.getCurrIsland().setScene();
                this.close();
            }
        });

    }

    public void fleeEvent() {
        btn2.setOnAction(actionEvent -> {
            int chance = (int) Player.getSkillPointsPilot();
            int luckyNum = (int) ((Math.random() * 100));
            if (chance > luckyNum) {
                Ship.setFuelCapacity(Ship.getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                Universe.getIslands().get(0).setScene();
            } else {
                Player.setCurrentWealth(0);
                Ship.setHealth(Ship.getHealth() - 50);
                Ship.setHealthLabel(Ship.getHealth());
                Player.getCurrIsland().setScene();
            }
            this.close();
        });

    }

    public void fightEvent() {

        btn3.setOnAction(actionEvent -> {
            int chance = (int) Player.getSkillPointsFighter();
            int luckyNum = (int) ((Math.random() * 100));
            if (chance > luckyNum) {
                Player.setCurrentWealth(Player.getCurrentWealth2() + tax);
            } else {
                Player.setCurrentWealth(0);
                Ship.setHealth(Ship.getHealth() - 50);
                Ship.setHealthLabel(Ship.getHealth());

            }
            Player.getCurrIsland().setScene();
            this.close();

        });

    }

    private String getDescription(String terrain, String element) {
        return String.format("This island is known for its %s \n terrain and the "
                + "most common element \n found on this " + "island is %s", terrain, element);
    }


}
