import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Universe extends Stage {
    private Random num = new Random();
    private GridPane grid1 = new GridPane();
    private GridPane grid2 = new GridPane();
    private GridPane grid3 = new GridPane();
    private GridPane grid4 = new GridPane();
    private GridPane grid5 = new GridPane();
    private GridPane grid6 = new GridPane();
    private GridPane grid7 = new GridPane();
    private GridPane grid8 = new GridPane();
    private GridPane grid9 = new GridPane();
    private GridPane grid10 = new GridPane();
    private GridPane grid11 = new GridPane();
    private GridPane grid12 = new GridPane();
    private VBox v1 = new VBox();
    private HBox h1 = new HBox();
    private HBox h2 = new HBox();
    private HBox h3 = new HBox();
    private ImageView padding1 = new ImageView();
    private ImageView padding2 = new ImageView();
    private ImageView padding3 = new ImageView();
    private ImageView padding4 = new ImageView();
    private ImageView padding5 = new ImageView();
    private ImageView padding6 = new ImageView();
    private ImageView padding7 = new ImageView();
    private ImageView padding8 = new ImageView();
    private ImageView padding9 = new ImageView();
    private ImageView padding10 = new ImageView();
    private ImageView padding11 = new ImageView();
    private ImageView padding12 = new ImageView();
    private ImageView padding13 = new ImageView();
    private ImageView padding14 = new ImageView();
    private static ArrayList<Island> islands = new ArrayList<>();
    private Random rand = new Random();
    private Circle dot1 = new Circle(15, Paint.valueOf("black"));
    private Circle dot2 = new Circle(15, Paint.valueOf("black"));
    private Circle dot3 = new Circle(15, Paint.valueOf("black"));
    private Circle dot4 = new Circle(15, Paint.valueOf("black"));
    private Circle dot5 = new Circle(15, Paint.valueOf("black"));
    private Circle dot6 = new Circle(15, Paint.valueOf("black"));
    private Circle dot7 = new Circle(15, Paint.valueOf("black"));
    private Circle dot8 = new Circle(15, Paint.valueOf("black"));
    private Circle dot9 = new Circle(15, Paint.valueOf("black"));
    private Circle dot10 = new Circle(15, Paint.valueOf("black"));
    private Circle dot11 = new Circle(15, Paint.valueOf("black"));
    private Circle dot12 = new Circle(15, Paint.valueOf("black"));
    private Bandit bandit = new Bandit();
    private Scene scene;
    private Island island1 = new Island("basic", "Hrolleifsdalsa", getDescription("rigid",
            "gold"),  Item.HEALTHPOTION, Item.BREASTPLATE, Item.ARROW,
            Item.UNIFORM);
    private Island island2 = new Island("basic", "Flokavaroi", getDescription("rigid",
            "gold"),  Item.BREASTPLATE, Item.HEALTHPOTION, Item.BOOKS,
            Item.BOW);
    private Island island3 = new Island("basic", "Rauoaloekr", getDescription("rigid",
            "gold"),  Item.HEALTHPOTION, Item.RUM, Item.SKYR,
            Item.GAUNTLET);
    private Island island4 = new Island("primitive", "Krokr", getDescription("rigid",
            "gold"),  Item.DIAMOND, Item.ARROW, Item.BOOTS,
            Item.BREASTPLATE);
    private Island island5 = new Island("primitive", "Miklagil", getDescription("rigid",
            "gold"),  Item.DIAMOND, Item.KNIFE, Item.BOOTS,
            Item.GAUNTLET);
    private Island island6 = new Island("primitive", "Lofot", getDescription("rigid",
            "gold"),  Item.DIAMOND, Item.ARROW, Item.KNIFE,
            Item.GAUNTLET);
    private Island island7 = new Island("enhanced", "Grunnafjoror", getDescription("rigid",
            "gold"),  Item.ARROW, Item.BOW, Item.BOOTS,
            Item.KNIFE);
    private Island island8 = new Island("enhanced", "Almenningar", getDescription("rigid",
            "gold"),  Item.DIAMOND, Item.ARROW, Item.BOOTS,
            Item.GAUNTLET);
    private Island island9 = new Island("enhanced", "Haugar", getDescription("rigid",
            "gold"),  Item.DIAMOND, Item.BOOKS, Item.KNIFE,
            Item.GAUNTLET);
    private Island island10 = new Island("legendary", "Skruoey", getDescription("rigid",
            "gold"),  Item.HEALTHPOTION, Item.RUM, Item.CHAINS,
            Item.SKYR, Item.AETHER);
    private Island island11 = new Island("legendary", "Landbrot", getDescription("rigid",
            "gold"),  Item.DIAMOND, Item.HELMET, Item.BOOTS,
            Item.GAUNTLET);
    private Island island12 = new Island("complete", "Bjarkey", getDescription("rigid",
            "gold"),  Item.DIAMOND, Item.ARROW, Item.BOOTS,
            Item.GAUNTLET);
    public Universe() {
        islands.add(island1);
        islands.add(island2);
        islands.add(island3);
        islands.add(island4);
        islands.add(island5);
        islands.add(island6);
        islands.add(island7);
        islands.add(island8);
        islands.add(island9);
        islands.add(island10);
        islands.add(island11);
        islands.add(island12);
        Collections.shuffle(islands);

        grid1.setPrefSize(100, 100);
        grid2.setPrefSize(100, 100);
        grid3.setPrefSize(100, 100);
        grid4.setPrefSize(100, 100);
        grid5.setPrefSize(100, 100);
        grid6.setPrefSize(100, 100);
        grid7.setPrefSize(100, 100);
        grid8.setPrefSize(100, 100);
        grid9.setPrefSize(100, 100);
        grid10.setPrefSize(100, 100);
        grid11.setPrefSize(100, 100);
        grid12.setPrefSize(100, 100);

        padding1.setFitWidth(75);
        padding2.setFitWidth(75);
        padding3.setFitWidth(75);
        padding4.setFitWidth(75);
        padding5.setFitWidth(75);
        padding6.setFitWidth(75);
        padding7.setFitHeight(75);
        padding9.setFitWidth(75);
        padding10.setFitWidth(69);
        padding8.setFitHeight(75);
        padding11.setFitWidth(69);
        padding12.setFitWidth(69);
        padding13.setFitWidth(75);
        padding14.setFitWidth(75);
        h1.getChildren().addAll(padding11, grid1, padding1,
                grid2, padding2, grid3, padding3, grid4);
        h2.getChildren().addAll(padding12, grid6, padding4,
                grid7, padding5, grid8, padding6, grid9);
        h3.getChildren().addAll(padding10, grid5, padding9,
                grid10, padding13, grid11, padding14, grid12);
        v1.getChildren().addAll(h1, padding8, h2, padding7, h3);
        logic();

        dot1.setId("spawn");
        dot2.setId("point");
        dot3.setId("point");
        dot4.setId("point");
        dot5.setId("point");
        dot6.setId("point");
        dot7.setId("point");
        dot8.setId("point");
        dot9.setId("point");
        dot10.setId("point");
        dot11.setId("point");
        dot12.setId("point");

        dot1.setUserData("visited");
        dot2.setUserData("undiscovered");
        dot3.setUserData("undiscovered");
        dot4.setUserData("undiscovered");
        dot5.setUserData("undiscovered");
        dot6.setUserData("undiscovered");
        dot7.setUserData("undiscovered");
        dot8.setUserData("undiscovered");
        dot9.setUserData("undiscovered");
        dot10.setUserData("undiscovered");
        dot11.setUserData("undiscovered");
        dot12.setUserData("undiscovered");

        this.scene = new Scene(v1, 1700, 800);
        setIslandClickedEvent();
        setIslandClickedEvent2();
        setHoveredEvent1();
        setHoveredEvent2();
    }

    public void setIslandClickedEvent() {
        dot1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot1.setStyle("-fx-fill: blue");
                dot1.setUserData("visited");
                if (Player.getShip().getItemInventory(5).size() != 0
                        && Player.getCurrentWealth2() > 10) {
                    Cop cop1 = new Cop();
                    cop1.setIslandHolder(islands.get(0));
                    cop1.setDotPrev(dot1);
                    cop1.setScene();
                    this.close();
                } else {
                    islands.get(0).setScene();
                    Player.setCurrIsland(islands.get(0));
                    this.close();
                }
            }
        });

        dot2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot2.setStyle("-fx-fill: blue");
                dot2.setUserData("visited");
                Bandit bdn1 = new Bandit();
                bdn1.setIslandHolder1(islands.get(1));
                bdn1.setDotPrev1(dot1);
                bdn1.setScene();
                this.close();
            }
        });

        dot3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot3.setStyle("-fx-fill: blue");
                dot3.setUserData("visited");
                islands.get(2).setScene();
                Player.setCurrIsland(islands.get(2));
                this.close();
            }
        });

        dot4.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot4.setStyle("-fx-fill: blue");
                dot4.setUserData("visited");
                islands.get(3).setScene();
                Player.setCurrIsland(islands.get(3));
                this.close();
            }
        });

        dot5.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot5.setStyle("-fx-fill: blue");
                dot5.setUserData("visited");
                if (Player.getShip().getItemInventory(5).size() != 0
                        && Player.getCurrentWealth2() > 10) {
                    Cop cop1 = new Cop();
                    cop1.setIslandHolder(islands.get(4));
                    cop1.setDotPrev(dot4);
                    cop1.setScene();
                    this.close();
                } else {
                    islands.get(4).setScene();
                    Player.setCurrIsland(islands.get(4));
                    this.close();
                }
            }
        });

        dot6.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot6.setStyle("-fx-fill: blue");
                dot6.setUserData("visited");
                islands.get(5).setScene();
                Player.setCurrIsland(islands.get(5));
                this.close();
            }
        });

    }

    public void setIslandClickedEvent2() {
        dot7.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot7.setStyle("-fx-fill: blue");
                dot7.setUserData("visited");
                Bandit bdn1 = new Bandit();
                bdn1.setIslandHolder1(islands.get(6));
                bdn1.setDotPrev1(dot6);
                bdn1.setScene();
                this.close();
                this.close();
            }
        });

        dot8.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot8.setStyle("-fx-fill: blue");
                dot8.setUserData("visited");
                islands.get(7).setScene();
                Player.setCurrIsland(islands.get(7));
                this.close();
            }
        });

        dot9.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot9.setStyle("-fx-fill: blue");
                dot9.setUserData("visited");
                Bandit bdn1 = new Bandit();
                bdn1.setIslandHolder1(islands.get(8));
                bdn1.setDotPrev1(dot8);
                bdn1.setScene();
                this.close();
                this.close();
            }
        });

        dot10.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot10.setStyle("-fx-fill: blue");
                dot10.setUserData("visited");
                islands.get(9).setScene();
                Player.setCurrIsland(islands.get(9));
                this.close();
            }
        });

        dot11.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot11.setStyle("-fx-fill: blue");
                dot11.setUserData("visited");
                islands.get(10).setScene();
                Player.setCurrIsland(islands.get(10));
                this.close();
            }
        });

        dot12.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (Player.getShip().getFuelCapacity(3) < 15) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You do not have enough fuel to travel.");
                errorAlert.showAndWait();
                GameOver gm1 = new GameOver();
                gm1.setScene();
                this.close();
            } else {
                Player.getShip().setFuelCapacity2(Player.getShip().getFuelCapacity() - 15);
                Ship.setFuelLabel(Ship.getFuelCapacity());
                dot12.setStyle("-fx-fill: blue");
                dot12.setUserData("visited");
                if (Player.getCurrentWealth2() > 0) {
                    Trader trader1 = new Trader();
                    trader1.setScene();
                    trader1.setDotPrev2(dot11);
                    trader1.setIslandHolder2(islands.get(11));
                    this.close();
                } else {
                    islands.get(11).setScene();
                    Player.setCurrIsland(islands.get(11));
                    this.close();
                }
            }
        });
    }

    public void setHoveredEvent1() {

        dot1.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(0);
            String name = island.getName();
            Text text;
            if (dot1.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid1.getChildren().add(text);
            dot1.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                grid1.getChildren().remove(text);
            });
        });

        dot2.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(1);
            String name = island.getName();
            Text text;
            if (dot2.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid2.getChildren().add(text);
            dot2.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot3.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(2);
            String name = island.getName();
            Text text;
            if (dot3.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid3.getChildren().add(text);
            dot3.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot4.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(3);
            String name = island.getName();
            Text text;
            if (dot4.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid4.getChildren().add(text);
            dot4.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot5.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(4);
            String name = island.getName();
            Text text;
            if (dot5.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid5.getChildren().add(text);
            dot5.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot6.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(5);
            String name = island.getName();
            Text text;
            if (dot6.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid6.getChildren().add(text);
            dot6.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });
    }

    public void setHoveredEvent2() {

        dot7.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(6);
            String name = island.getName();
            Text text;
            if (dot7.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid7.getChildren().add(text);
            dot7.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot8.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(7);
            String name = island.getName();
            Text text;
            if (dot8.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid8.getChildren().add(text);
            dot8.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot9.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(8);
            String name = island.getName();
            Text text;
            if (dot9.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid9.getChildren().add(text);
            dot9.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot10.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(9);
            String name = island.getName();
            Text text;
            if (dot10.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid10.getChildren().add(text);
            dot10.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot11.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(10);
            String name = island.getName();
            Text text;
            if (dot11.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid11.getChildren().add(text);
            dot11.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });

        dot12.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            Island island = islands.get(11);
            String name = island.getName();
            Text text;
            if (dot12.getUserData().equals("visited")) {
                text = new Text(name);
            } else {
                text = new Text("UNDISCOVERED");
            }
            grid12.getChildren().add(text);
            dot12.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                text.setVisible(false);
            });
        });
    }

    public void logic() {
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints(50);
            ColumnConstraints column = new ColumnConstraints(50);
            grid1.getRowConstraints().add(row);
            grid1.getColumnConstraints().add(column);
            grid2.getRowConstraints().add(row);
            grid2.getColumnConstraints().add(column);
            grid3.getRowConstraints().add(row);
            grid3.getColumnConstraints().add(column);
            grid4.getRowConstraints().add(row);
            grid4.getColumnConstraints().add(column);
            grid5.getColumnConstraints().add(column);
            grid6.getRowConstraints().add(row);
            grid6.getColumnConstraints().add(column);
            grid7.getRowConstraints().add(row);
            grid7.getColumnConstraints().add(column);
            grid8.getRowConstraints().add(row);
            grid8.getColumnConstraints().add(column);
            grid9.getRowConstraints().add(row);
            grid9.getColumnConstraints().add(column);
            grid10.getColumnConstraints().add(column);
            grid11.getColumnConstraints().add(column);
            grid12.getColumnConstraints().add(column);


        }

        for (int i = 0; i < 3; i++) {
            RowConstraints row = new RowConstraints(50);
            grid5.getRowConstraints().add(row);
            grid10.getRowConstraints().add(row);
            grid11.getRowConstraints().add(row);
            grid12.getRowConstraints().add(row);

        }

        grid1.add(dot1, num.nextInt(5), (num.nextInt(5)));
        grid2.add(dot2, num.nextInt(5), num.nextInt(5));
        grid3.add(dot3, num.nextInt(5), num.nextInt(5));
        grid4.add(dot4, num.nextInt(5), num.nextInt(5));
        grid5.add(dot5, num.nextInt(5), num.nextInt(3));
        grid6.add(dot6, num.nextInt(5), num.nextInt(5));
        grid7.add(dot7, num.nextInt(5), num.nextInt(5));
        grid8.add(dot8, num.nextInt(5), num.nextInt(5));
        grid9.add(dot9, num.nextInt(5), num.nextInt(5));
        grid10.add(dot10, num.nextInt(5), num.nextInt(3));
        grid11.add(dot11, num.nextInt(5), num.nextInt(3));
        grid12.add(dot12, num.nextInt(5), num.nextInt(3));

    }

    public void setScene() {
        scene.getStylesheets().add("universeStyle.css");
        this.setFullScreen(true);
        this.setTitle("VIKINGMANIA");
        this.setScene(scene);
        this.show();
    }

    private String getDescription(String terrain, String element) {
        return String.format("This island is known for its %s \n terrain and the "
                + "most common element \n found on this " + "island is %s", terrain, element);
    }

    public static ArrayList<Island> getIslands() {
        return islands;
    }

}