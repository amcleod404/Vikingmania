import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver extends Stage {
    private Scene scene;
    private Label gameOver = new Label("GAME OVER");
    private Label credits = new Label("Credits: ");
    private Label yash = new Label("Yash Talwar: Software Engineer / Game Designer");
    private Label andrew = new Label("Andrew Mcleod: Software Engineer / Game Designer");
    private Label mason = new Label("Mason Blanchard: Software Engineer / Game Designer");
    private Label sid = new Label("Sidarth Rajan: Game Designer");
    private Button closeGame = new Button("Close Game");
    private Button newGame = new Button("Start New Game");
    private VBox list = new VBox(60);
    private HBox buttons = new HBox(40);
    private HBox title = new HBox(420);
    private ImageView space = new ImageView();
    public GameOver() {
        gameOver.setStyle("-fx-font-size: 100px");
        credits.setStyle("-fx-font-size: 40px");
        title.getChildren().addAll(space, gameOver);
        buttons.getChildren().addAll(closeGame, newGame);
        list.getChildren().addAll(title, buttons, credits, yash, andrew, mason, sid);
        buttons.setAlignment(Pos.CENTER);
        closeGameButton();
        newGameButton();
        scene = new Scene(list, 1700, 800);
        scene.getStylesheets().addAll("EndGame.css");
    }
    public void setScene() {
        this.setFullScreen(true);
        this.setScene(scene);
        this.show();
    }
    public void closeGameButton() {
        closeGame.setOnAction(ae -> {
            this.close();
        });
    }

    public void newGameButton() {
        newGame.setOnAction(ae -> {
            Stage primary = new Stage();
            Vikingmania vk1 = new Vikingmania();
            vk1.start(primary);
            this.close();
        });
    }
}
