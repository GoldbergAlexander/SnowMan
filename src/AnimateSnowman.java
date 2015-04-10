/*
* Name: Michael Kovalsky, Alexander Goldberg
* Date: 4/10/2015
* Class: CSCI1302
* Purpose: To create an animated snowman utilizing built in Javafx 2D figures such as circles, ovals, as well as using
* concepts such as Timeline, keyFrame, keyValue, and fading.
* */


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class AnimateSnowman extends Application
{
	final int SCENE_WIDTH = 700;
	final int SCENE_HEIGHT = 400;

	static Circle head = new Circle();
	static Circle chest = new Circle();
	static Circle bottom = new Circle();
	static Circle leftEye = new Circle();
	static Circle rightEye = new Circle();
	static Circle sun = new Circle();
	static Circle heart = new Circle();
	static Circle boulder = new Circle();
	static Group circles = new Group();

	static Ellipse leftArm = new Ellipse();
	static Ellipse rightArm = new Ellipse();

	static Arc mouth = new Arc();
	static Arc moon = new Arc();

//	static Button startAnimation = new Button();
	//static Button exitAnimation = new Button();

	static Rectangle night = new Rectangle();

	static Pane animationPane = new Pane();

	static HBox hbox = new HBox();

	static Timeline timeLine;


	private void drawRollingBoulders()
	{
		boulder.setCenterX(SCENE_WIDTH);
		boulder.setCenterY(SCENE_HEIGHT - 10);
		boulder.setRadius(25);

		boulder.setFill(Color.BLACK);

		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);


			KeyValue boulderValue = new KeyValue(boulder.centerXProperty(), 0);
			KeyFrame keyFrame  = new KeyFrame(Duration.millis(5000), boulderValue);

			timeLine.getKeyFrames().addAll(keyFrame);
			timeLine.play();



	}

	private void drawSun()
	{
		sun.setRadius(50);
		sun.setCenterX(SCENE_WIDTH - (sun.getRadius() + 5));
		sun.setCenterY(SCENE_HEIGHT + sun.getRadius());
		sun.setFill(Color.YELLOW);

		timeLine = new Timeline();
		timeLine.setCycleCount(1);
		timeLine.setAutoReverse(false);

		KeyValue sunValue = new KeyValue(sun.translateYProperty(), (-SCENE_HEIGHT + 5));
		KeyFrame keyFrame  = new KeyFrame(Duration.millis(6000), sunValue);

		timeLine.getKeyFrames().addAll(keyFrame);
		timeLine.play();
	}

	private void drawMoon()
	{
		moon.setRadiusX(35);
		moon.setRadiusY(35);
		moon.setType(ArcType.OPEN);
		moon.setCenterX(moon.getRadiusX() + 5);
		moon.setCenterY(moon.getRadiusY());
		moon.setStartAngle(135);
		moon.setLength(180);
		moon.setStrokeType(StrokeType.INSIDE);
		moon.setFill(Color.WHEAT);

		timeLine = new Timeline();
		timeLine.setCycleCount(1);
		timeLine.setAutoReverse(false);

		KeyValue moonValue = new KeyValue(moon.translateYProperty(), (SCENE_HEIGHT + moon.getCenterY()));
		KeyFrame keyFrame  = new KeyFrame(Duration.millis(6000), moonValue);

		timeLine.getKeyFrames().addAll(keyFrame);
		timeLine.play();
	}

	private void drawHead()
	{
		head.setCenterX(SCENE_WIDTH / 2);
		head.setCenterY(SCENE_HEIGHT - 215);
		head.setRadius(25);
		head.setFill(Color.AQUAMARINE);
	}
	private void drawMouth()
	{
		mouth.setCenterX(SCENE_WIDTH / 2);
		mouth.setCenterY(SCENE_HEIGHT - 255);
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
		leftEye.setCenterY(SCENE_HEIGHT - 220);
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
		rightEye.setCenterY(SCENE_HEIGHT -220);
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
		chest.setCenterY(SCENE_HEIGHT - 155);
		chest.setRadius(45);
		chest.setFill(Color.AQUAMARINE);
	}

	private void drawHeart()
	{
		heart.setCenterX(SCENE_WIDTH/2 + 15);
		heart.setCenterY(SCENE_HEIGHT - 160);
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

	private void drawBottom() {
		bottom.setCenterX(SCENE_WIDTH / 2);
		bottom.setCenterY(SCENE_HEIGHT - 85);
		bottom.setRadius(65);
		bottom.setFill(Color.AQUAMARINE);


	}

	private void drawLeftArm()
	{
		leftArm.setRadiusX(50.0);
		leftArm.setRadiusY(15.0);
		leftArm.setCenterX((SCENE_WIDTH + leftArm.getRadiusX() + chest.getRadius()) / 2);
		leftArm.setCenterY(SCENE_HEIGHT - 175);

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
		rightArm.setCenterY(SCENE_HEIGHT - 175);

		rightArm.setFill(Color.AQUAMARINE);

		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);

		KeyValue rightArmValue = new KeyValue(rightArm.rotateProperty(), 10);
		KeyFrame keyFrame  = new KeyFrame(Duration.millis(1000), rightArmValue);

		timeLine.getKeyFrames().addAll(keyFrame);
		timeLine.play();
	}

	public void drawNight()
	{
		night.setX(0);
		night.setY(0);
		night.setWidth(SCENE_WIDTH);
		night.setHeight(SCENE_HEIGHT);
		night.setFill(Color.BLACK);

		FadeTransition ft = new FadeTransition(Duration.millis(6000), night);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//startAnimation.setText("Start Animation");
		//exitAnimation.setText("Exit Animation");

		drawNight();
		drawSun();
		drawMoon();

		drawHead();
		drawChest();
		drawBottom();
		drawHeart();

		drawLeftEye();
		drawRightEye();
		drawMouth();

		drawLeftArm();
		drawRightArm();
		drawRollingBoulders();


		animationPane.getChildren().addAll(sun, head, chest, bottom, leftArm, rightArm, heart, leftEye, rightEye, mouth, night, moon, boulder);
		animationPane.setStyle("-fx-background-color: red");

		primaryStage.setTitle("Animate Rectangle");
		Scene scene = new Scene(animationPane,SCENE_WIDTH,SCENE_HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
