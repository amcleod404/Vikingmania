import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ThirdScene extends Stage {
    Player player1 = new Player();
    private Label totalskill = new Label(Double.toString(player1.getTotalSkillPoints()));
    private VBox vbox = new VBox(30);

    public ThirdScene() {
        vbox.getChildren().addAll(totalskill);
        Scene scene  = new Scene(vbox, 1700, 800);
        this.setTitle("Welcome to VikingMania!");
        this.setScene(scene);
        this.show();
    }

}
