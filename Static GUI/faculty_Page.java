import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public	class faculty_Page extends Application	
{	
	public static void main(String[] args)	
	{	
		launch(args);	
	}	
	@Override	
	public void start(Stage	primaryStage)	
	{	
		primaryStage.setTitle("Classroom Booking System");		
		Button btn	= new Button("View Room");	
		btn.getStyleClass().add("button");
		Button btn2 = new Button("Book Room");	
		btn2.getStyleClass().add("button");
		Button btn3 = new Button("Cancel Booking");	
		btn3.getStyleClass().add("button");
		Button btn4 = new Button("Logout");
		Label l1 = new Label("Name:");
		Label l2 = new Label("Type:");
		Label l3 = new Label("Courses:");
		
		btn.setOnAction(e -> {new book_Room(1).start(primaryStage);});
		btn2.setOnAction(e -> {new book_Room(1).start(primaryStage);});
		btn3.setOnAction(e -> {new FacultyBooking(1).start(primaryStage);});
		btn4.setOnAction(e -> {try {
			new Login().start(primaryStage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
		
		
		btn.setPrefHeight(80);
		btn.setPrefWidth(200);
		btn2.setPrefHeight(80);
		btn2.setPrefWidth(200);
		btn3.setPrefHeight(80);
		btn3.setPrefWidth(200);
		btn4.setPrefHeight(80);
		btn4.setPrefWidth(100);
		
		HBox x = new HBox();
		x.setAlignment(Pos.TOP_RIGHT);
		
		GridPane root = new GridPane();
		
	    root.setHgap(35);
	    root.setVgap(15);
		
		root.getColumnConstraints().add(new ColumnConstraints(110));
		root.getColumnConstraints().add(new ColumnConstraints(200));
		root.getColumnConstraints().add(new ColumnConstraints(200));
		
		root.add(l1, 0, 0, 1, 1);
		//root.add(btn4, 3, 0, 1, 1);
		root.add(l2, 0, 1, 1, 1);
		root.add(btn, 2, 3, 1, 1);
		root.add(btn2, 2, 4, 1, 1);
		root.add(btn3, 2, 5, 1, 1);
		root.add(l3, 0, 6, 1, 1);
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		x.getChildren().addAll(l, btn4);
		x.setSpacing(300);
		
		Button btn6 = new Button("Home");
		HBox x2 = new HBox();
		x2.setSpacing(300);
		x2.getChildren().addAll(btn6);
		x2.setAlignment(Pos.TOP_LEFT);
		
		VBox y = new VBox();
		y.setPadding(new Insets(20));
		
		y.getChildren().addAll(x, root);
		y.setSpacing(30);
		y.setStyle("-fx-background-color: #00DDDD");
		
		Scene scene	= new Scene(y, 1000, 600);		
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}