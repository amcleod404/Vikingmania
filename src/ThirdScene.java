import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class ThirdScene extends Stage {

    private ArrayList<Island> islands = new ArrayList<>();
    private Random rand = new Random();
    private Player player1 = new Player();
    private Label playerText = new Label(player1.getName().toUpperCase() + ":");
    private HBox playerHbox = new HBox(30);
    private Label playerDifficultyLabel1 = new Label("CHOSEN DIFFICULTY: ");
    private Label playerDifficultyLabel2 = new Label((player1.getDifficultyLevel().toString()));
    private HBox playerDifficultyBox = new HBox(30);
    private Label skillPointAllocations = new Label("CHOSEN SKILLS: ");
    private HBox points = new HBox(30);
    private Label sailorPoints = new Label("Sailor:   " + (player1.getSkillPointsPilot()));
    private Label fighterPoints = new Label("Fighter:   " + (player1.getSkillPointsFighter()));
    private Label barterPoints = new Label("Barter:   " + (player1.getSkillPointsMerchant()));
    private Label engineerPoints = new Label(" Engineer:   " + (player1.getSkillPointsEngineer()));
    private Label awardedCredits = new Label("STARTING CREDITS: ");
    private Label numCredits = new Label("" + player1.getNumCredits());
    private VBox vbox = new VBox(65);
    private Button contButton = new Button("CONTINUE");
    private Button gobackButton = new Button("CHANGE SETTINGS");
    private HBox buttons = new HBox(30);
    private Region buttonSpace = new Region();



    public ThirdScene() {
        playerTextStyle();
        difficultyStyle();
        awardedCreditsStyle();
        skillPointAllocationStyle();
        difficultyTextStyle();
        stylePoints();
        setContinueEvent();
        setResetEvent();
        playerHbox.getChildren().add(playerText);
        playerHbox.setAlignment(Pos.CENTER);
        playerDifficultyBox.getChildren().add(playerDifficultyLabel2);
        buttonSpace.setPrefWidth(355);
        buttons.getChildren().addAll(numCredits, buttonSpace, contButton, gobackButton);
        numCredits.setAlignment(Pos.CENTER_LEFT);
        points.getChildren().addAll(sailorPoints, barterPoints, engineerPoints, fighterPoints);
        vbox.getChildren().addAll(playerHbox, playerDifficultyLabel1, playerDifficultyBox,
                skillPointAllocations, points, awardedCredits, buttons);
        Scene scene  = new Scene(vbox, 1700, 800);
        this.setFullScreen(true);
        scene.getStylesheets().add("characterSheetStyle.css");
        this.setTitle("Welcome to VikingMania!");
        this.setScene(scene);
        this.show();
    }

    public void playerTextStyle() {
        playerText.setStyle("-fx-font-size: 60px");
    }

    public void difficultyStyle() {
        playerDifficultyLabel1.setStyle("-fx-font-size: 35px");
    }

    public void skillPointAllocationStyle() {
        skillPointAllocations.setStyle("-fx-font-size: 35px");
    }

    public void awardedCreditsStyle() {
        awardedCredits.setStyle("-fx-font-size: 35px");
        numCredits.setStyle("-fx-font-size: 25px");
    }

    public void difficultyTextStyle() {
        playerDifficultyLabel2.setStyle("-fx-font-size: 25px");
    }

    public void stylePoints() {
        sailorPoints.setStyle("-fx-font-size: 25px");
        barterPoints.setStyle("-fx-font-size: 25px");
        engineerPoints.setStyle("-fx-font-size: 25px");
        fighterPoints.setStyle("-fx-font-size: 25px");
    }

    public void setContinueEvent() {
        contButton.setOnAction(actionEvent -> {
            Vikingmania vik = new Vikingmania();
            AudioClip start = vik.getAudioClip();
            start.stop();
            URL source = getClass().getResource("gameMusic.mp3");
            AudioClip clip = new AudioClip(source.toString());
            clip.play();
            if (!clip.isPlaying()) {
                clip.play();
            }
            Universe.getIslands().get(0).setScene();
            Player.setCurrIsland(Universe.getIslands().get(0));
            this.close();
        });
    }

    public void setResetEvent() {
        gobackButton.setOnAction(actionEvent -> {
            new SecondScene();
            this.close();
        });
    }
    private String getDescription(String terrain, String element) {
        return String.format("This island is known for its %s \n terrain and the "
                + "most common element \n found on this " + "island is %s", terrain, element);
    }



}