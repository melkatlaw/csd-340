import javafx.application.Application; 

import javafx.scene.Scene; 

import javafx.scene.control.CheckBox; 

import javafx.scene.control.RadioButton; 

import javafx.scene.control.ToggleGroup; 

import javafx.scene.layout.VBox; 

import javafx.scene.paint.Color; 

import javafx.scene.shape.Circle; 

import javafx.scene.shape.Ellipse; 

import javafx.scene.shape.Rectangle; 

import javafx.scene.shape.Shape; 

import javafx.stage.Stage; 

  

import java.util.Random; 

  

public class Main extends Application { 

  

    private Shape shape = new Circle(50); 

    private CheckBox fillCheckBox = new CheckBox("Fill shape"); 

  

    public static void main(String[] args) { 

        launch(args); 

    } 

  

    @Override 

    public void start(Stage primaryStage) { 

        VBox root = new VBox(); 

        root.getChildren().add(shape); 

  

        ToggleGroup group = new ToggleGroup(); 

  

        RadioButton circleButton = new RadioButton("Circle"); //Radio buttons 

        circleButton.setToggleGroup(group); 

        circleButton.setOnAction(e -> changeShape(new Circle(50))); 

  

        RadioButton rectangleButton = new RadioButton("Rectangle"); 

        rectangleButton.setToggleGroup(group); 

        rectangleButton.setOnAction(e -> changeShape(new Rectangle(100, 50))); 

  

        RadioButton ellipseButton = new RadioButton("Ellipse"); 

        ellipseButton.setToggleGroup(group); 

        ellipseButton.setOnAction(e -> changeShape(new Ellipse(50, 30))); 

  

        fillCheckBox.setOnAction(e -> fillShape()); 

  

        root.getChildren().addAll(circleButton, rectangleButton, ellipseButton, fillCheckBox); 

  

        Scene scene = new Scene(root, 200, 200); 

        primaryStage.setScene(scene); 

        primaryStage.show(); 

    } 

  

    private void changeShape(Shape newShape) { //displays the shapes 

        shape = newShape; 

        fillShape(); 

    } 

  

    private void fillShape() { //fill in the shapes with color 

        if (fillCheckBox.isSelected()) { 

            Random rand = new Random(); 

            float r = rand.nextFloat(); 

            float g = rand.nextFloat(); 

            float b = rand.nextFloat(); 

            shape.setFill(new Color(r, g, b, 1.0)); 

        } else { 

            shape.setFill(Color.WHITE); 

        } 

    } 

} 

 