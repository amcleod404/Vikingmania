import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class SecondScene extends Stage {
    private VBox configScreen = new VBox(30);
    private Player player1 = new Player();
    private Label titleLabel = new Label("Welcome to Vikingmania!, let's set up your character!");
    private TextField characterName = new TextField();
    private Label gameDifficulty = new Label("SELECT GAME DIFFICULTY:");
    private ToggleGroup toggles = new ToggleGroup();
    private RadioButton rookieButton = new RadioButton("Rookie; (100 Skill Points)");
    private RadioButton beginnerButton = new RadioButton("Beginner; (75 Skill Points)");
    private RadioButton intermediateButton = new RadioButton("Intermediate; (50 Skill Points)");
    private RadioButton advancedButton = new RadioButton("Advanced; (25 Skill Points)");
    private VBox chooseDifficultyBox = new VBox(20);
    private Label allocateSkillPointsLabel = new Label("DISTRIBUTE SKILL POINTS:");
    private Label sailorLabel = new Label("Sailor");
    private Slider sailorSlide = new Slider(0, 100, 50);
    private Label barterLabel = new Label("Barter");
    private Slider barterSlide = new Slider(0, 100, 50);
    private Label engineerLabel = new Label("Engineer");
    private Slider engineerSlide = new Slider(0, 100, 50);
    private Label fighterLabel = new Label("Fighter");
    private Slider fighterSlide = new Slider(0, 100, 50);
    private Button continueButton = new Button("CONTINUE");
    private HBox attributes = new HBox(50);
    private VBox layout2 = new VBox(20);
    private HBox layout3 = new HBox(30);
    private final double[] playerpoints = new double[1];
    private final Difficulty[] playerDiff = {Difficulty.ROOKIE};
    private boolean criteriaMet;

    public SecondScene() {
        setTitleLabelStyle();
        setCharacterNameStyle();
        setGameDifficultyStyle();
        setToggleGroup();
        chooseDifficultyBox.getChildren().addAll(rookieButton,
                beginnerButton, intermediateButton, advancedButton);
        setAllocateSkillPointsStyle();
        setSliders();
        setToggleLogic();
        setSlideLogic();
        setContinueButtonStyle();
        attributes.getChildren().addAll(sailorLabel, sailorSlide,
                barterLabel, barterSlide, engineerLabel, engineerSlide, fighterLabel, fighterSlide);
        layout3.getChildren().addAll(characterName);
        layout2.getChildren().addAll(titleLabel);
        layout2.setAlignment(Pos.CENTER);
        configScreen.getChildren().addAll(layout2, layout3,
                gameDifficulty, chooseDifficultyBox, allocateSkillPointsLabel,
                attributes, continueButton);
        Scene scene = new Scene(configScreen, 1700, 800);
        scene.getStylesheets().add("configStyle.css");
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Alegreya&display=swap");
        continueButton.setDefaultButton(true);
        this.setFullScreen(true);
        this.setTitle("Welcome to VikingMania!");
        this.setScene(scene);
        this.show();
    }

    private void setTitleLabelStyle() {
        titleLabel.setStyle("-fx-font-size: 30px");
        titleLabel.setAlignment(Pos.CENTER);
    }

    private void setCharacterNameStyle() {
        characterName.setPromptText("Enter a character name");
        characterName.setFocusTraversable(false);
        characterName.setPrefWidth(350);
    }

    private void setGameDifficultyStyle() {
        gameDifficulty.setStyle("-fx-font-size: 25px");
    }

    private void setToggleGroup() {
        rookieButton.setToggleGroup(toggles);
        beginnerButton.setToggleGroup(toggles);
        intermediateButton.setToggleGroup(toggles);
        advancedButton.setToggleGroup(toggles);
        toggles.selectToggle(rookieButton);

    }

    private void setAllocateSkillPointsStyle() {
        allocateSkillPointsLabel.setStyle("-fx-font-size: 25px");
    }

    private void setSliders() {
        sailorSlide.setPrefSize(175, 200);
        sailorSlide.setBlockIncrement(25);
        sailorSlide.setMax(100);
        sailorSlide.setMin(0);
        sailorSlide.setMajorTickUnit(50);
        sailorSlide.setMinorTickCount(1);
        sailorSlide.setShowTickLabels(true);
        sailorSlide.setShowTickMarks(true);
        sailorSlide.setSnapToTicks(true);

        barterSlide.setPrefSize(175, 200);
        barterSlide.setBlockIncrement(25);
        barterSlide.setMax(100);
        barterSlide.setMin(0);
        barterSlide.setMajorTickUnit(50);
        barterSlide.setMinorTickCount(1);
        barterSlide.setShowTickLabels(true);
        barterSlide.setShowTickMarks(true);
        barterSlide.setSnapToTicks(true);

        engineerSlide.setPrefSize(175, 200);
        engineerSlide.setBlockIncrement(25);
        engineerSlide.setMax(100);
        engineerSlide.setMin(0);
        engineerSlide.setMajorTickUnit(50);
        engineerSlide.setMinorTickCount(1);
        engineerSlide.setShowTickLabels(true);
        engineerSlide.setShowTickMarks(true);
        engineerSlide.setSnapToTicks(true);

        fighterSlide.setPrefSize(175, 200);
        fighterSlide.setBlockIncrement(25);
        fighterSlide.setMax(100);
        fighterSlide.setMin(0);
        fighterSlide.setMajorTickUnit(50);
        fighterSlide.setMinorTickCount(1);
        fighterSlide.setShowTickLabels(true);
        fighterSlide.setShowTickMarks(true);
        fighterSlide.setSnapToTicks(true);
    }

    private void setToggleLogic() {
        rookieButton.setOnAction(actionEvent -> {
            sailorSlide.setBlockIncrement(25);
            sailorSlide.setMax(100);
            sailorSlide.setMajorTickUnit(50);
            sailorSlide.setMinorTickCount(1);
            barterSlide.setBlockIncrement(25);
            barterSlide.setMax(100);
            barterSlide.setMajorTickUnit(50);
            barterSlide.setMinorTickCount(1);
            engineerSlide.setBlockIncrement(25);
            engineerSlide.setMax(100);
            engineerSlide.setMajorTickUnit(50);
            engineerSlide.setMinorTickCount(1);
            fighterSlide.setBlockIncrement(25);
            fighterSlide.setMax(100);
            fighterSlide.setMajorTickUnit(50);
            fighterSlide.setMinorTickCount(1);
            playerDiff[0] = Difficulty.ROOKIE;
        });

        beginnerButton.setOnAction(actionEvent -> {
            sailorSlide.setBlockIncrement(12.5);
            sailorSlide.setMax(75);
            sailorSlide.setMajorTickUnit(25);
            sailorSlide.setMinorTickCount(1);
            barterSlide.setBlockIncrement(12.5);
            barterSlide.setMax(75);
            barterSlide.setMajorTickUnit(25);
            barterSlide.setMinorTickCount(1);
            engineerSlide.setBlockIncrement(12.5);
            engineerSlide.setMax(75);
            engineerSlide.setMajorTickUnit(25);
            engineerSlide.setMinorTickCount(1);
            fighterSlide.setBlockIncrement(12.5);
            fighterSlide.setMax(75);
            fighterSlide.setMajorTickUnit(25);
            fighterSlide.setMinorTickCount(1);
            playerDiff[0] = Difficulty.BEGINNER;
        });

        intermediateButton.setOnAction(actionEvent -> {
            sailorSlide.setBlockIncrement(12.5);
            sailorSlide.setMax(50);
            sailorSlide.setMajorTickUnit(25);
            sailorSlide.setMinorTickCount(1);
            barterSlide.setBlockIncrement(12.5);
            barterSlide.setMax(50);
            barterSlide.setMajorTickUnit(25);
            barterSlide.setMinorTickCount(1);
            engineerSlide.setBlockIncrement(12.5);
            engineerSlide.setMax(50);
            engineerSlide.setMajorTickUnit(25);
            engineerSlide.setMinorTickCount(1);
            fighterSlide.setBlockIncrement(12.5);
            fighterSlide.setMax(50);
            fighterSlide.setMajorTickUnit(25);
            fighterSlide.setMinorTickCount(1);
            playerDiff[0] = Difficulty.INTERMEDIATE;
        });

        advancedButton.setOnAction(actionEvent -> {
            sailorSlide.setBlockIncrement(5);
            sailorSlide.setMax(25);
            sailorSlide.setMajorTickUnit(5);
            sailorSlide.setMinorTickCount(0);
            barterSlide.setBlockIncrement(5);
            barterSlide.setMax(25);
            barterSlide.setMajorTickUnit(5);
            barterSlide.setMinorTickCount(0);
            engineerSlide.setBlockIncrement(5);
            engineerSlide.setMax(25);
            engineerSlide.setMajorTickUnit(5);
            engineerSlide.setMinorTickCount(0);
            fighterSlide.setBlockIncrement(5);
            fighterSlide.setMax(25);
            fighterSlide.setMajorTickUnit(5);
            fighterSlide.setMinorTickCount(0);
            playerDiff[0] = Difficulty.ADVANCED;
        });
    }

    private void setSlideLogic() {
        sailorSlide.valueProperty().addListener(observable -> {
            playerpoints[0] = sailorSlide.getValue() + barterSlide.getValue()
                    + engineerSlide.getValue() + fighterSlide.getValue();
        });

        barterSlide.valueProperty().addListener(observable -> {
            playerpoints[0] = sailorSlide.getValue() + barterSlide.getValue()
                    + engineerSlide.getValue() + fighterSlide.getValue();
        });

        engineerSlide.valueProperty().addListener(observable -> {
            playerpoints[0] = sailorSlide.getValue() + barterSlide.getValue()
                    + engineerSlide.getValue() + fighterSlide.getValue();
        });

        fighterSlide.valueProperty().addListener(observable -> {
            playerpoints[0] = sailorSlide.getValue() + barterSlide.getValue()
                    + engineerSlide.getValue() + fighterSlide.getValue();
        });

    }

    private void setContinueButtonStyle() {
        continueButton.setAlignment(Pos.CENTER_RIGHT);
        continueButton.setOnAction(ae -> {
            if (characterName.getText().equals("")) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Character name not valid");
                errorAlert.setContentText("Please enter a name.");
                errorAlert.showAndWait();
            } else if (playerpoints[0] > playerDiff[0].getSkillPointAllocation()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Distribution error");
                errorAlert.setContentText("You do not have enough skill points!"
                        + "Please change the difficulty or allocate less skill points.");
                errorAlert.showAndWait();
            } else if (playerpoints[0] < playerDiff[0].getSkillPointAllocation()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Distribution error");
                errorAlert.setContentText("You haven't used all of your skill points!"
                        + "Please change the difficulty or allocate more skill points..");
                errorAlert.showAndWait();
            } else {
                player1.setSkillPointsFighter(fighterSlide.getValue());
                player1.setSkillPointsEngineer(engineerSlide.getValue());
                player1.setSkillPointsPilot(sailorSlide.getValue());
                Player.setSkillPointsMerchant(barterSlide.getValue());
                player1.setDifficultyLevel(playerDiff[0]);
                player1.setTotalSkillPoints(playerDiff[0].getSkillPointAllocation());
                player1.setName(characterName.getText());
                player1.setNumCredits(playerDiff[0].getNumCredits());
                new ThirdScene();
                this.close();
            }


        });
    }

}
