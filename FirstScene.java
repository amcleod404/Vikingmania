import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstScene extends Stage {
    private HBox startBox;
    private Button startButton;
    private BorderPane pane;

    public FirstScene() {
        startBox = new HBox();
        startButton = new Button("START GAME");
        pane = new BorderPane();
        startButton.setPrefSize(400, 100);
        startBox.getChildren().addAll(startButton);
        startBox.setAlignment(Pos.CENTER);
        pane.setBottom(startBox);
        pane.setPadding(new Insets(60));
        Scene sceneOne = new Scene(pane, 1700, 800);
        startButton.setOnAction(actionEvent -> {
            new SecondScene();
            this.close();
        });
        sceneOne.getStylesheets().add("https://fonts.googleapis.com/css?family=Alegreya&display=swap");
        sceneOne.getStylesheets().add("startStyle.css");
        this.setTitle("Welcome to VikingMania!");
        this.setScene(sceneOne);
        this.setFullScreen(true);
        this.show();

    }

    public Button getStartButton() {
        return startButton;
    }
}
