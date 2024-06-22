import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.control.Slider;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ColorPicker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.geometry.Orientation;
import javafx.scene.shape.SVGPath;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.PixelReader; 
import javafx.scene.image.PixelWriter; 
import javafx.scene.image.WritableImage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import java.io.FileNotFoundException; 
import java.lang.Math;
//imports all the libraries from JavaFX needed, some other libraries are used
public class Main extends Application { 
  Label label; // holds function as a string
  Color c = Color.web("#FF0000"); //default color for graphing, can be changed later
  @Override
  //main function to create the JavaFX stage
  public void start(Stage stage) throws FileNotFoundException{
    Operations hm = new Operations(); 
    EvalFunction eval = new EvalFunction();
    String f = "";
    TextField tf;
    Button button;
    //width and height of graph
    double height = 256;
    double width = 256;
    //creates slider
    Slider slider = new Slider(0, 100, 0);
    slider.setBlockIncrement(10);
    slider.setShowTickLabels(true);
    slider.setShowTickMarks(true);
    slider.setPrefWidth(200);
    slider.setPrefHeight(150);
    Color black = Color.web("#000000");
    Color white = Color.web("#FFFFFF");
    Image image = new Image(new FileInputStream("Graph.jpg"));
    //creates blank white image for graph that is able to be rewritten
    WritableImage wImage = new WritableImage(2048, 2048);  
    PixelReader pixelReader = image.getPixelReader(); 
    PixelWriter writer = wImage.getPixelWriter();
    Group root = new Group();
    Scene scene = new Scene(root, 800, 400);
    //adds the styling for the entire program, stored in a css file
    scene.getStylesheets().add("Index.css");
    scene.setFill(new LinearGradient(
        0, 0, 1, 1, true,                      //sizing
        CycleMethod.NO_CYCLE,                  //cycling
        new Stop(0, Color.web("#000000")),     //colors
        new Stop(1, Color.web("#444444")))
    );
    //creating vbox and hbox, they are containers that are able to hold buttons, text, images, etc.
    VBox vbox = new VBox(5);
    vbox.getStyleClass().add("vbox");
    HBox h1 = new HBox(6);
    HBox h2 = new HBox(5);
    HBox h3 = new HBox(5);
    VBox v1 = new VBox(5);
    VBox v2 = new VBox(5);
    VBox v3 = new VBox(5);
    VBox v4 = new VBox(5);
    stage.setTitle("visualize");
    // sets the spacing between elements on the stage
    vbox.setPadding(new Insets(10));
    label = new Label("Function: y=");
    label.getStyleClass().add("label");
    Button enter = new Button("Enter"); 
    Button clear = new Button("Clear");
    clear.setOnAction(new EventHandler<ActionEvent>() {
      //clears the function input area and graph
      @Override public void handle(ActionEvent e){
        label.setText("Function: y=");
        //creates a blank graph
        for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        if((x > ((width/2)-(0.003*width)) && x < ((width/2)+(0.003*width)))||(y > ((height/2)-(0.003*height)) && y < ((height/2)+(0.003*height)))){
            writer.setColor(x, y, black);
        }
        else{
          writer.setColor(x, y, white);
        }
      }
    }
      }
    });
    enter.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e){
        //evaluates the function for each value of x and graphs it
        eval.setFunction(label.getText().substring(12));
        String res2 = eval.f(2.0);
        label.setText("Function: y=");
        int a = 0;
        // draws the function on the graph
        for(double y = height/2-1; y > -height/2+1; y--) { 
        int b = 0;
        for(double x = -width/2+1; x < width/2-1; x++) {
          if(eval.fRange(x, y, slider.getValue(), Math.abs(x))){
            writer.setColor(b, a, c);
          }
          b++;
        }
        a++;
        }	
      }
    });
    // Matrix h = new Matrix();
    // double[][] matrix = {{3.0, 4.0, 5.0}, {3.0, 4.0, 5.0}, {3.0, 4.0, 5.0}};
    // matrix = h.rref(matrix);
    // for(int i = 0; i < matrix.length; i++){
    //   for(int j = 0; j < matrix[0].length; j++){
    //     System.out.print(matrix[i][j]+" ");
    //   }
    //   System.out.println();
    // }
    //creates buttons for inputing numbers and symbols, selecting colors
    Button bp = new Button("+");
    buttonUpdate(bp, "+");
    Button bmi = new Button("-");
    buttonUpdate(bmi, "-");
    Button bmu = new Button("*");
    buttonUpdate(bmu, "*");
    Button bd = new Button("/");
    buttonUpdate(bd, "/");
    Button bc = new Button("^");
    buttonUpdate(bc, "^");
    Button b1 = new Button("1");
    buttonUpdate(b1, "1");
    Button b2 = new Button("2");
    buttonUpdate(b2, "2");
    Button b3 = new Button("3");
    buttonUpdate(b3, "3");
    Button b4 = new Button("4");
    buttonUpdate(b4, "4");
    Button b5 = new Button("5");
    buttonUpdate(b5, "5");
    Button b6 = new Button("6");
    buttonUpdate(b6, "6");
    Button b7 = new Button("7");
    buttonUpdate(b7, "7");
    Button b8 = new Button("8");
    buttonUpdate(b8, "8");
    Button b9 = new Button("9");
    buttonUpdate(b9, "9");
    Button b0 = new Button("0");
    buttonUpdate(b0, "0");
    Button bX = new Button("x");
    buttonUpdate(bX, "x");
    Button red = new Button("");
    buttonColor(red, "#FF0000");
    red.getStyleClass().add("red");
    Button blue = new Button("");
    buttonColor(blue, "#0000FF");
    blue.getStyleClass().add("blue");
    Button yellow = new Button("");
    buttonColor(yellow, "#FFFF00");
    yellow.getStyleClass().add("yellow");
    Button orange = new Button("");
    buttonColor(orange, "#FFA500");
    orange.getStyleClass().add("orange");
    //creates a blank graph
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        if((x > ((width/2)-(0.003*width)) && x < ((width/2)+(0.003*width)))||(y > ((height/2)-(0.003*height)) && y < ((height/2)+(0.003*height)))){
            writer.setColor(x, y, black);
        }
        else{
          writer.setColor(x, y, white);
        }
      }
    }
    //creates a view point for the graph
    ImageView imageView1 = new ImageView(wImage);
    imageView1.setFitHeight(2500); 
    imageView1.setFitWidth(2500);  
    //starts to add the buttons to the horizontal and veritcle containers
    h2.getChildren().addAll(red, blue);
    h3.getChildren().addAll(yellow, orange);
    v1.getChildren().addAll(clear, bc, bd, bmu, bmi, bp, enter);
    v2.getChildren().addAll(b7, b4, b1, b0, h2);
    v3.getChildren().addAll(b8, b5, b2, h3);
    v4.getChildren().addAll(b9, b6, b3, bX);
    //slider.setOrientation(Orientation.VERTICAL);
    slider.getStyleClass().add("slider");
    //nests containers inside of containers
    h1.getChildren().addAll(slider,v2, v3, v4, v1,imageView1);
    vbox.getChildren().addAll(label, h1);
    HBox h9 = new HBox(5);
    h9.getChildren().addAll(vbox);
    //puts the container into the stage
    root.getChildren().add(h9);
    stage.setScene(scene);
    //reveals the stage
    stage.show();
  } 
  //function that takes the name of the button and assigns it with a label, updates the function when pressed, also adds styling to the button
  public void buttonUpdate(Button b, String num){
    b.getStyleClass().add("b");
    b.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e){
        label.setText(label.getText()+num);
      }
    });
  }
  //sets the color of the buttons that control color selection
  public void buttonColor(Button b, String col){
    b.getStyleClass().add("c");
    b.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e){
        c = Color.web(col);
      }
    });
  }
  //launches the program
  public static void main(String[] args) {
    launch(args);
  }
} 