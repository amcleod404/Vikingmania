import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import java.net.URL;

public class Vikingmania extends Application {
    private static Universe uni = new Universe();
    private final URL source = getClass().getResource("Viking.mp3");
    private AudioClip clip = new AudioClip(source.toString());

    @Override
    public void start(Stage primaryStage) {
        clip.play();
        new FirstScene();


    }

    public AudioClip getAudioClip() {
        return clip;
    }

    public static Universe getUni() {
        return uni;
    }

}