import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Island extends Stage {
    private String techLevel;
    private String name;
    private String description;
    private String background;
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Item item5;
    private VBox islandData = new VBox(30);
    private HBox vboxs = new HBox();
    private VBox displayBox = new VBox();
    private HBox buttonBox = new HBox();
    private Button mapBtn = new Button("Back to Map");
    private ImageView padding = new ImageView();
    private ImageView padding2 = new ImageView();
    private ImageView padding3 = new ImageView();
    private Scene scene;
    private Button marketButton = new Button("MarketPlace");
    private MarketPlace mkt;

    public Island(String techLevel,
                  String name, String description, Item item1, Item item2, Item item3, Item item4) {
        this.techLevel = techLevel;
        this.description = description;
        this.name = name;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        Label labelName = new Label("Name: " + this.name);
        Label labelTechLevel = new Label("Tech Level: " + this.techLevel);
        Label labelDescription = new Label("Description: " + this.description);
        mapBtn.setMinSize(200, 100);
        marketButton.setMinSize(200, 100);
        padding.setFitWidth(125);
        padding2.setFitHeight(300);
        padding3.setFitWidth(825);
        islandData.getChildren().addAll(labelName, labelTechLevel, labelDescription);
        vboxs.getChildren().addAll(islandData, padding);
        buttonEvent();
        setMarketButtonEvent();
        setForgeEvent();
        buttonBox.getChildren().addAll(mapBtn, padding3, marketButton);
        displayBox.getChildren().addAll(vboxs, padding2, buttonBox);
        this.scene = new Scene(displayBox, 1700, 800);

    }

    public Island(String techLevel,
                  String name, String description, Item item1, Item item2,
                  Item item3, Item item4, Item item5) {
        this.techLevel = techLevel;
        this.description = description;
        this.name = name;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        Label labelName = new Label("Name: " + this.name);
        Label labelTechLevel = new Label("Tech Level: " + this.techLevel);
        Label labelDescription = new Label("Description: " + this.description);
        mapBtn.setMinSize(200, 100);
        marketButton.setMinSize(200, 100);
        padding.setFitWidth(125);
        padding2.setFitHeight(300);
        padding3.setFitWidth(825);
        islandData.getChildren().addAll(labelName, labelTechLevel, labelDescription);
        vboxs.getChildren().addAll(islandData, padding);
        buttonEvent();
        setMarketButtonEvent2();
        setForgeEvent();
        buttonBox.getChildren().addAll(mapBtn, padding3, marketButton);
        displayBox.getChildren().addAll(vboxs, padding2, buttonBox);
        this.scene = new Scene(displayBox, 1700, 800);

    }

    public void buttonEvent() {
        mapBtn.setOnAction(actionEvent -> {
            Vikingmania.getUni().setScene();
            this.close();
        });
    }

    public void setScene() {
        scene.getStylesheets().addAll("islandStyle.css");
        this.setFullScreen(true);
        this.setScene(scene);
        this.show();
    }

    public void setMarketButtonEvent() {
        marketButton.setOnAction(actionEvent -> {
            mkt = new MarketPlace(item1, item2, item3, item4);
            mkt.setScene();
            Player.setCurr(mkt);
            this.close();
        });
    }



    public void setMarketButtonEvent2() {
        marketButton.setOnAction(actionEvent -> {
            mkt = new MarketPlace(item1, item2, item3, item4, item5);
            mkt.setScene();
            Player.setCurr(mkt);
            this.close();
        });
    }

    public void setForgeEvent() {
        islandData.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                if (mouseEvent.getClickCount() == 2) {
                    Player.getForge().setScene();
                    this.close();
                }
            }

        });
    }

    public String getTechLevel() {
        return techLevel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
