import javafx.application.Application;
import javafx.stage.Stage;


/*
    @version 1.3
    Changed the Structure of the project
    Added Scene 3 compatibility
    Changed Player class to static since there's only one player

 */

public class Vikingmania extends Application {

    @Override
    public void start(Stage primaryStage) {
        new FirstScene();

    }

}
