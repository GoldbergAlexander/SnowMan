import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

//Update 2
public class AnimateSnowman extends Application {
    static Circle head = new Circle();
    static Circle chest = new Circle();
    static Circle bottom = new Circle();
    static Ellipse leftArm = new Ellipse();
    static Ellipse rightArm = new Ellipse();
    static Timeline timeLine;
    final int SCENE_WIDTH = 500;
    final int SCENE_HEIGHT = 350;

    public static void main(String[] args) {
        launch(args);
    }

    private void drawHead() {
        //head = new Circle();
        head.setCenterX(SCENE_WIDTH / 2);
        head.setCenterY(135);
        head.setRadius(25);
        head.setFill(Color.AQUAMARINE);
    }

    private void drawChest() {
        //chest = new Circle();
        chest.setCenterX(SCENE_WIDTH / 2);
        chest.setCenterY(195);
        chest.setRadius(45);
        chest.setFill(Color.AQUAMARINE);
    }

    private void drawBottom() {
        //bottom = new Circle();
        bottom.setCenterX(SCENE_WIDTH / 2);
        bottom.setCenterY(265);
        bottom.setRadius(65);
        bottom.setFill(Color.AQUAMARINE);
    }

    private void drawLeftArm() {
        //leftArm = new Ellipse();
        leftArm.setRadiusX(50.0);
        leftArm.setRadiusY(15.0);
        leftArm.setCenterX((SCENE_WIDTH + leftArm.getRadiusX() + chest.getRadius()) / 2);
        leftArm.setCenterY(175.0);
        leftArm.setFill(Color.AQUAMARINE);

        timeLine = new Timeline();
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.setAutoReverse(true);
        //KeyValue LeftValue = new KeyValue(leftArm.centerYProperty(), 165);
        KeyValue LeftValue = new KeyValue(leftArm.rotateProperty(), 10);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), LeftValue);
        timeLine.getKeyFrames().addAll(keyFrame);
        timeLine.play();
    }

    private void drawRightArm() {
        //rightArm = new Ellipse();
        rightArm.setRadiusX(50.0);
        rightArm.setRadiusY(15.0);
        rightArm.setCenterX((SCENE_WIDTH - rightArm.getRadiusX() - chest.getRadius()) / 2);
        rightArm.setCenterY(175.0);

        rightArm.setFill(Color.AQUAMARINE);
        timeLine = new Timeline();
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.setAutoReverse(true);
        //KeyValue RightValue = new KeyValue(rightArm.centerYProperty(), 165);
        KeyValue RightValue = new KeyValue(rightArm.rotateProperty(), 10);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), RightValue);
        timeLine.getKeyFrames().addAll(keyFrame);
        timeLine.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button startAnimation;
        Button exitAnimation;
        Pane animationPane = new Pane();
        HBox hbox = new HBox();
        Canvas canvas = new Canvas(500, 350);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        startAnimation = new Button();
        exitAnimation = new Button();
        startAnimation.setText("Start Animation");
        exitAnimation.setText("Exit Animation");
        drawHead();
        drawChest();
        drawBottom();
        drawLeftArm();
        drawRightArm();
        animationPane.getChildren().add(canvas);
        animationPane.getChildren().addAll(head, chest, bottom, leftArm, rightArm);
        //animationPane.setStyle("-fx-background-color: red");
        primaryStage.setTitle("Animate Rectangle");
        Scene scene = new Scene(animationPane, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
