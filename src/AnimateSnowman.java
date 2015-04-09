    import com.sun.scenario.effect.Glow;
    import javafx.animation.KeyFrame;
    import javafx.animation.KeyValue;
    import javafx.animation.Timeline;
    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Pane;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.paint.Color;
    import javafx.scene.shape.*;
    import javafx.stage.Stage;
    import javafx.util.Duration;
    import javafx.scene.Group;
    import javafx.scene.Node;
    import javafx.scene.effect.*;

    import java.util.Objects;


    public class AnimateSnowman extends Application
{
	final int SCENE_WIDTH = 500;
	final int SCENE_HEIGHT = 350;
	
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

	Button startAnimation = new Button();
	Button exitAnimation = new Button();

    BorderPane borderPane = new BorderPane();
    HBox buttonHBox = new HBox();

    Group snowManGroup = new Group();
	
	static Pane animationPane = new Pane();
	
	static HBox hbox = new HBox();
	
	static Timeline timeLine;
	
	private void drawSun()
	{
		sun.setCenterX(SCENE_WIDTH);
		sun.setCenterY(0);
		sun.setRadius(75);		
		sun.setFill(Color.YELLOW);
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
        snowManGroup.getChildren().add(head);
        snowManGroup.getChildren().add(chest);
        snowManGroup.getChildren().add(bottom);
        snowManGroup.getChildren().add(leftEye);
        snowManGroup.getChildren().add(rightEye);
        snowManGroup.getChildren().add(leftArm);
        snowManGroup.getChildren().add(rightArm);
        Node[] nodes = (Node[])snowManGroup.getChildren().toArray();
        for (Node n : nodes){
          // n.setEffect();
        }


    }

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		startAnimation.setText("Start Animation");
		exitAnimation.setText("Exit Animation");
		
		drawSun();
		drawHead();
		drawChest();
		drawBottom();
		drawHeart();
		
		drawLeftEye();
		drawRightEye();
		drawMouth();
		
		drawLeftArm();
		drawRightArm();

		animationPane.getChildren().addAll(sun, head, chest, bottom, leftArm, rightArm, heart, leftEye, rightEye, mouth);
		animationPane.setStyle("-fx-background-color: ghostwhite");

        buttonHBox.setAlignment(Pos.BASELINE_CENTER);
        buttonHBox.setPadding(new Insets(10));
        buttonHBox.setSpacing(10);
        buttonHBox.getChildren().add(startAnimation);
        buttonHBox.getChildren().add(exitAnimation);


       //Add the buttons
        borderPane.setBottom(buttonHBox);

        borderPane.setCenter(animationPane);

		primaryStage.setTitle("Animate Rectangle");
    	Scene scene = new Scene(borderPane,SCENE_WIDTH,SCENE_HEIGHT);
    	primaryStage.setScene(scene);
        primaryStage.setMaxHeight(SCENE_HEIGHT + 50);
        primaryStage.setMinHeight(SCENE_HEIGHT + 50);
        primaryStage.setMaxWidth(SCENE_WIDTH);
        primaryStage.setMinWidth(SCENE_WIDTH);
    	primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
