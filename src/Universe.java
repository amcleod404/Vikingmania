import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.ArrayList;
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
    private Island1 island1 = new Island1();
    private Island2 island2 = new Island2();
    private Island3 island3 = new Island3();
    private Island4 island4 = new Island4();
    private Island5 island5 = new Island5();
    private Island6 island6 = new Island6();
    private Island7 island7 = new Island7();
    private Island8 island8 = new Island8();
    private Island9 island9 = new Island9();
    private Island10 island10 = new Island10();
    private Island11 island11 = new Island11();
    private Island12 island12 = new Island12();
    private ArrayList<Object> islands = new ArrayList<>();
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

        grid1.setPrefSize(100,100);
        grid2.setPrefSize(100,100);
        grid3.setPrefSize(100,100);
        grid4.setPrefSize(100,100);
        grid5.setPrefSize(100,100);
        grid6.setPrefSize(100,100);
        grid7.setPrefSize(100,100);
        grid8.setPrefSize(100,100);
        grid9.setPrefSize(100,100);
        grid10.setPrefSize(100,100);
        grid11.setPrefSize(100,100);
        grid12.setPrefSize(100,100);


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
        h1.getChildren().addAll(padding11,grid1,padding1,grid2,padding2,grid3,padding3,grid4);
        h2.getChildren().addAll(padding12, grid6,padding4,grid7,padding5,grid8,padding6,grid9);
        h3.getChildren().addAll(padding10, grid5, padding9, grid10, padding13, grid11, padding14, grid12);
        v1.getChildren().addAll(h1,padding8,h2, padding7, h3);
        logic();
        dot1.setUserData("This will be a double that's assigned randomly");
        dot1.setId("point");
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

        setIsland1Event();
        Scene scene = new Scene(v1, 1700, 800);
        scene.getStylesheets().add("universeStyle.css");
        this.setTitle("VIKINGMANIA");
        this.setScene(scene);
        this.show();
    }

    public void setIsland1Event() {
        dot1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

            islands.get(rand.nextInt(12))
            this.close();
        });

        dot2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot4.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot5.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot6.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot7.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot8.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot9.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot10.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot11.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });

        dot12.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            new Island1();
            this.close();
        });


    }

    public void logic() {
        for (int i = 0; i < 5 ; i++ ) {
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

        for (int i = 0; i < 3 ; i++ ) {
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
        grid6.add(dot6, num.nextInt(5) , num.nextInt(5));
        grid7.add(dot7, num.nextInt(5), num.nextInt(5));
        grid8.add(dot8, num.nextInt(5), num.nextInt(5));
        grid9.add(dot9, num.nextInt(5), num.nextInt(5));
        grid10.add(dot10,num.nextInt(5), num.nextInt(3));
        grid11.add(dot11,num.nextInt(5), num.nextInt(3));
        grid12.add(dot12,num.nextInt(5), num.nextInt(3));

    }
}
