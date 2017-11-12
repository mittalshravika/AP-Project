import java.io.IOException;

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

public class admin_Page extends Application
{
	User admin_User;
	
	public admin_Page(User admin_User) 
	{
		this.admin_User = admin_User;
	}
	
	public static void main(String[] args)	
	{	
		launch(args);	
	}	
	@Override	
	public void start(Stage	primaryStage)	
	{	
		primaryStage.setTitle("Class Room Booking System");		
		Button btn	= new Button("View Room");	
		Button btn2 = new Button("Book Room");
		Button btn3 = new Button("Cancel Booking");
		Button btn4 = new Button("Logout");
		Button btn5 = new Button("Show Request");
		Label l1 = new Label("Name:");
		Label l2 = new Label("Type:");
		
		btn.setOnAction(e -> {new book_Room(2, admin_User).start(primaryStage);});
		btn2.setOnAction(e -> {new book_Room(2, admin_User).start(primaryStage);});
		btn4.setOnAction(e -> {try {
			new Login().start(primaryStage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
		btn3.setOnAction(e -> {try {
			new FacultyBooking(2, admin_User).start(primaryStage);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
		btn5.setOnAction(e -> {new RequestList(admin_User).start(primaryStage);});
		
		btn.setPrefHeight(80);
		btn.setPrefWidth(200);
		btn2.setPrefHeight(80);
		btn2.setPrefWidth(200);
		btn3.setPrefHeight(80);
		btn3.setPrefWidth(200);
		btn4.setPrefHeight(80);
		btn4.setPrefWidth(100);
		btn5.setPrefHeight(80);
		btn5.setPrefWidth(200);
		
		GridPane root = new GridPane();
		
		HBox x = new HBox();
		x.setAlignment(Pos.TOP_RIGHT);
		
	    root.setHgap(35);
	    root.setVgap(15);
		
		root.getColumnConstraints().add(new ColumnConstraints(100));
		root.getColumnConstraints().add(new ColumnConstraints(200));
		root.getColumnConstraints().add(new ColumnConstraints(200));
		
		root.add(l1, 0, 0, 1, 1);
		root.add(btn4, 3, 0, 1, 1);
		root.add(l2, 0, 1, 1, 1);
		root.add(btn, 2, 3, 1, 1);
		root.add(btn2, 2, 4, 1, 1);
		root.add(btn3, 2, 5, 1, 1);
		root.add(btn5, 2, 6, 1, 1);
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		x.getChildren().addAll(l, btn4);
		x.setSpacing(310);
		
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