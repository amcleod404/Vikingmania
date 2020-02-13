import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Island8 extends Stage {
    private static String techLevel = "Tech Level 1";
    private static String name = "Island 1";
    private static String description = "This is a description";
    private VBox islandData = new VBox(30);
    private VBox marketPlace = new VBox(30);
    private HBox Vboxs = new HBox();
    private VBox DisplayBox = new VBox();
    private HBox buttonBox = new HBox();
    private Button mapBtn = new Button("Back to Map");
    private Button nextReg = new Button("Next Region");
    private Button purchase = new Button("purchase item");
    private Label labelName = new Label("Name: " + Island8.name);
    private Label labelTechLevel = new Label("Tech Level: " + Island8.techLevel);
    private Label labelDescription = new Label("This island is cool");
    private Label marketPlaceLabel = new Label("Marketplace");
    private ToggleGroup groupItems = new ToggleGroup();
    private RadioButton item1 = new RadioButton("item1");
    private RadioButton item2 = new RadioButton("item2");
    private RadioButton item3 = new RadioButton("item3");
    private RadioButton item4 = new RadioButton("item4");
    private ImageView padding = new ImageView();
    private ImageView padding2 = new ImageView();
    private ImageView padding3 = new ImageView();
    public Island8() {
        padding.setFitWidth(500);
        padding2.setFitHeight(300);
        padding3.setFitWidth(875);
        item1.setToggleGroup(groupItems);
        item2.setToggleGroup(groupItems);
        item3.setToggleGroup(groupItems);
        item4.setToggleGroup(groupItems);
        marketPlace.getChildren().addAll(marketPlaceLabel,item1, item2,item3,item4,purchase);
        islandData.getChildren().addAll(labelName,labelTechLevel,labelDescription);
        Vboxs.getChildren().addAll(islandData, padding, marketPlace);
        buttonEvent();
        buttonBox.getChildren().addAll(mapBtn,padding3,nextReg);
        DisplayBox.getChildren().addAll(Vboxs, padding2, buttonBox);
    }

    public void buttonEvent() {
        mapBtn.setOnAction(actionEvent -> {
            new Universe();
            this.close();
        });
    }

    public void setScene() {
        Scene scene = new Scene(DisplayBox, 1700, 800);
        scene.getStylesheets().addAll("islandStyle.css");
        this.setScene(scene);
        this.show();
    }

}
