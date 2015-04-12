import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
* Creators: Michael Kovalsky and Alexander Goldberg
* Class: CSCI 1302
* Date: 4/11/2015
* Purpose: To animate a snowman, as well as practice other animation methods.
* */

public class AnimateSnowman extends Application
{
	static Circle head = new Circle();
	static Circle chest = new Circle();
	static Circle bottom = new Circle();
	static Circle leftEye = new Circle();
	static Circle rightEye = new Circle();
	static Circle sun = new Circle();
	static Circle heart = new Circle();
	static Ellipse leftArm = new Ellipse();
	static Ellipse rightArm = new Ellipse();

	static Arc mouth = new Arc();
	static Arc moon = new Arc();

	static Rectangle night = new Rectangle();

	static Pane animationPane = new Pane();
	static HBox hbox = new HBox();
	static Timeline timeLine;
    final int SCENE_WIDTH = 500;
    final int SCENE_HEIGHT = 350;
    Pane tempPane = new Pane();

    public static void main(String[] args)
	{

		launch(args);
    }


    private void drawPlanetaryBodies()
	{


		night.setX(0);
		night.setY(0);
		night.setWidth(SCENE_WIDTH);
		night.setHeight(SCENE_HEIGHT-10);
		night.setFill(Color.BLACK);

		FadeTransition ft = new FadeTransition(Duration.millis(1000), night);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();

		FadeTransition ft1 = new FadeTransition(Duration.millis(1000), night);
		ft1.setFromValue(0.0);
		ft1.setToValue(1.0);
		ft1.setCycleCount(1);
		ft1.setAutoReverse(false);
		ft1.play();


        sun.setCenterX(SCENE_WIDTH);
		sun.setCenterY(0);
        sun.setRadius(55);
        sun.setFill(Color.YELLOW);
		sun.setEffect(new Bloom());

        Path path = new Path();
        path.getElements().add(new MoveTo(-100, 200));
        path.getElements().add(new CubicCurveTo(-100, 200, SCENE_WIDTH / 2, -100, SCENE_WIDTH + 100, 200));
        path.setFill(Color.BLACK);

		PathTransition sunTransition = new PathTransition();
        sunTransition.setDuration(Duration.millis(10000));
        sunTransition.setPath(path);
        sunTransition.setNode(sun);
        sunTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        sunTransition.setAutoReverse(false);


		moon.setRadiusX(45);
		moon.setRadiusY(45);
		moon.setType(ArcType.OPEN);
		moon.setCenterX(SCENE_WIDTH);
		moon.setCenterY(0);
		moon.setStartAngle(135);
		moon.setLength(180);
		moon.setStrokeType(StrokeType.INSIDE);
		moon.setFill(Color.WHEAT);
		moon.setEffect(new Lighting());

		Path moonPath = new Path();
		moonPath.getElements().add(new MoveTo(-100, 200));
		moonPath.getElements().add(new CubicCurveTo(-100, 200, SCENE_WIDTH / 2, -100, SCENE_WIDTH + 100, 200));
		moonPath.setFill(Color.BLACK);

		PathTransition moonTransition = new PathTransition();
		moonTransition.setDuration(Duration.millis(10000));
		moonTransition.setPath(path);
		moonTransition.setNode(moon);
		moonTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		moonTransition.setAutoReverse(false);

		SequentialTransition sequentialTransition = new SequentialTransition();
		sequentialTransition.setCycleCount(Timeline.INDEFINITE);
		sequentialTransition.setAutoReverse(false);
		sequentialTransition.getChildren().addAll(ft, sunTransition, ft1, moonTransition);
		sequentialTransition.play();


	}


	private void drawHead()
	{
		head.setCenterX(SCENE_WIDTH / 2);
		head.setCenterY(135);
        head.setRadius(25);
        head.setFill(Color.AQUAMARINE);
	}

    private void drawMouth()
	{
		mouth.setCenterX(SCENE_WIDTH / 2);
		mouth.setCenterY(95);
		mouth.setLength(30);
		mouth.setRadiusX(30);
		mouth.setRadiusY(53);
		mouth.setStartAngle(255);
		mouth.setFill(Color.BLACK);


		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);

		KeyValue mouthXValue = new KeyValue(mouth.scaleXProperty(), 1.3);
		KeyValue mouthYValue = new KeyValue(mouth.scaleYProperty(), 2);
		KeyFrame keyFrameX  = new KeyFrame(Duration.millis(1000), mouthXValue);
		KeyFrame keyFrameY  = new KeyFrame(Duration.millis(1000), mouthYValue);

        timeLine.getKeyFrames().addAll(keyFrameX, keyFrameY);
        timeLine.play();
	}
	
	private void drawLeftEye()
	{
		leftEye.setCenterX(SCENE_WIDTH/2 + 7);
		leftEye.setCenterY(130);
        leftEye.setRadius(4);
        leftEye.setFill(Color.BLUE);

		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);

		KeyValue leftEyeValue = new KeyValue(leftEye.centerXProperty(), SCENE_WIDTH/2 + 4);
		KeyFrame keyFrame  = new KeyFrame(Duration.millis(1000), leftEyeValue);

        timeLine.getKeyFrames().addAll(keyFrame);
        timeLine.play();
	}
	
	private void drawRightEye()
	{
		rightEye.setCenterX(SCENE_WIDTH/2 - 7);
		rightEye.setCenterY(130);
        rightEye.setRadius(4);
        rightEye.setFill(Color.GREEN);

		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);

		KeyValue rightEyeValue = new KeyValue(rightEye.centerXProperty(), SCENE_WIDTH/2 - 4);
		KeyFrame keyFrame  = new KeyFrame(Duration.millis(1000), rightEyeValue);

        timeLine.getKeyFrames().addAll(keyFrame);
        timeLine.play();
	}
	
	private void drawChest()
	{
		chest.setCenterX(SCENE_WIDTH/2);
		chest.setCenterY(195);
        chest.setRadius(45);
        chest.setFill(Color.AQUAMARINE);
	}
	
	private void drawHeart()
	{
		heart.setCenterX(SCENE_WIDTH/2 + 15);
		heart.setCenterY(190);
        heart.setRadius(7);
        heart.setFill(Color.PURPLE);

		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);

		KeyValue heartXValue = new KeyValue(heart.scaleXProperty(), 1.5);
		KeyValue heartYValue = new KeyValue(heart.scaleYProperty(), 1.5);
		KeyFrame keyFrameX  = new KeyFrame(Duration.millis(500), heartXValue);
		KeyFrame keyFrameY  = new KeyFrame(Duration.millis(500), heartYValue);

        timeLine.getKeyFrames().addAll(keyFrameX, keyFrameY);
        timeLine.play();
	}
	
	private void drawBottom()
	{
		bottom.setCenterX(SCENE_WIDTH / 2);
		bottom.setCenterY(265);
        bottom.setRadius(65);
        bottom.setFill(Color.AQUAMARINE);
	}
	
	private void drawLeftArm()
	{
		leftArm.setRadiusX(50.0);
		leftArm.setRadiusY(15.0);
		leftArm.setCenterX((SCENE_WIDTH + leftArm.getRadiusX() + chest.getRadius()) / 2);
		leftArm.setCenterY(175.0);

		leftArm.setFill(Color.AQUAMARINE);

		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);

		KeyValue leftArmValue = new KeyValue(leftArm.rotateProperty(), 10);
		KeyFrame keyFrame  = new KeyFrame(Duration.millis(1000), leftArmValue);

        timeLine.getKeyFrames().addAll(keyFrame);
        timeLine.play();
	}

	private void drawRightArm()
	{
		rightArm.setRadiusX(50.0);
		rightArm.setRadiusY(15.0);
		rightArm.setCenterX((SCENE_WIDTH - rightArm.getRadiusX() - chest.getRadius()) / 2);
		rightArm.setCenterY(175.0);

		rightArm.setFill(Color.AQUAMARINE);

		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);

		KeyValue rightArmValue = new KeyValue(rightArm.rotateProperty(), 10);
		KeyFrame keyFrame  = new KeyFrame(Duration.millis(1000), rightArmValue);

        timeLine.getKeyFrames().addAll(keyFrame);
        timeLine.play();
    }

    private void setUpBlending(){
        Node[] nodes = {head, chest, bottom, leftArm, rightArm};
        for (Node n : nodes) {
            n.setEffect(new Glow(0.4));
            n.setEffect(new BoxBlur());
        }
        Node[] nodes2 = {leftEye, rightEye, mouth, heart};
        for (Node n : nodes2) {
            n.setBlendMode(BlendMode.DARKEN);

        }

        sun.setEffect(new Glow(0.8));
        sun.setEffect(new BoxBlur());


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
		Button startAnimation = new Button();
		Button exitAnimation = new Button();

        final BorderPane borderPane = new BorderPane();
        HBox buttonHBox = new HBox();

		startAnimation.setText("Start Animation");
		exitAnimation.setText("Exit Animation");

		drawPlanetaryBodies();
        drawHead();
        drawChest();
        drawBottom();
        drawHeart();

        drawLeftEye();
        drawRightEye();
        drawMouth();

        drawLeftArm();
        drawRightArm();

        setUpBlending();

        startAnimation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(animationPane);
			}
		});
        exitAnimation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(tempPane);
			}
		});


		animationPane.getChildren().addAll(night, sun, head, chest, bottom, leftArm, rightArm, heart, leftEye, rightEye, mouth, moon);
		animationPane.setStyle("-fx-background-color: #5b61ff");

        buttonHBox.setAlignment(Pos.BASELINE_CENTER);
        buttonHBox.setPadding(new Insets(10));
        buttonHBox.setSpacing(10);
        buttonHBox.getChildren().add(startAnimation);
        buttonHBox.getChildren().add(exitAnimation);
		buttonHBox.setStyle("-fx-background-color: red");


       //Add the buttons
        borderPane.setBottom(buttonHBox);

		primaryStage.setTitle("Animated Snowman");

    	Scene scene = new Scene(borderPane,SCENE_WIDTH,SCENE_HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.setMaxHeight(SCENE_HEIGHT + 100);
		primaryStage.setMinHeight(SCENE_HEIGHT + 70);
		primaryStage.setMaxWidth(SCENE_WIDTH);
		primaryStage.setMinWidth(SCENE_WIDTH);
    	primaryStage.show();
	}

}
