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
		Label l1 = new Label("ADMIN");
		l1.getStyleClass().add("admin_Page_Heading");
		Label l2 = new Label("");
		
		btn.setOnAction(e -> {try {
			new book_Room(2, admin_User).start(primaryStage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
		btn2.setOnAction(e -> {try {
			new book_Room(2, admin_User).start(primaryStage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
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
		btn5.setOnAction(e -> {try {
			new AdminRequestList(admin_User).start(primaryStage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
		
		btn.setPrefHeight(80);
		btn.setPrefWidth(400);
		btn2.setPrefHeight(80);
		btn2.setPrefWidth(400);
		btn3.setPrefHeight(80);
		btn3.setPrefWidth(400);
		btn4.setPrefHeight(40);
		btn4.setPrefWidth(200);
		btn5.setPrefHeight(80);
		btn5.setPrefWidth(400);
	
		
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.CENTER_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		HBox[] show = new HBox[4];
		for(int i = 0; i < 4;  i++)
		{
			show[i] = new HBox();
			show[i].setSpacing(150);
		}
		
		
		show[0].getChildren().addAll(l, btn4);
		show[0].setSpacing(550);
		show[0].setAlignment(Pos.TOP_CENTER);
		show[0].setAlignment(Pos.CENTER);
		show[1].getChildren().addAll(btn, btn2);
		show[1].setAlignment(Pos.CENTER);
		show[2].getChildren().addAll(btn3, btn5);	
		show[2].setAlignment(Pos.CENTER);
		show[3].getChildren().addAll(l1);	
		show[3].setAlignment(Pos.CENTER);
		
	
		
		
		
	
		
		
		
		HBox x2 = new HBox();
		x2.setSpacing(300);
		//x2.getChildren().addAll(btn6);
		x2.setAlignment(Pos.CENTER);
		
		VBox y = new VBox();
		y.setSpacing(50);
		y.setPadding(new Insets(20));
		
		VBox final_page = new VBox();
		
		
		
		
		y.getChildren().addAll(show[1], show[2], x2);
		final_page.getStyleClass().add("background");
		final_page.setSpacing(50);
		final_page.setPadding(new Insets(50, 20, 20, 20));
		final_page.getChildren().addAll(show[0],show[3], y);
		Scene scene	= new Scene(final_page, 1100, 800);			
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}
