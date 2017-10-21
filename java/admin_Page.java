import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class admin_Page extends Application
{
	public static void main(String[] args)	
	{	
		launch(args);	
	}	
	@Override	
	public void start(Stage	primaryStage)	
	{	
		primaryStage.setTitle("Admin Page");		
		Button btn	= new Button("View Room");	
		Button btn2 = new Button("Book Room");
		Button btn3 = new Button("Cancel Request");
		Button btn4 = new Button("Logout");
		Button btn5 = new Button("Show Request");
		Label l1 = new Label("Name:");
		Label l2 = new Label("Type:");
		
		btn.setPrefHeight(80);
		btn.setPrefWidth(150);
		btn2.setPrefHeight(80);
		btn2.setPrefWidth(150);
		btn3.setPrefHeight(80);
		btn3.setPrefWidth(150);
		btn4.setPrefHeight(80);
		btn4.setPrefWidth(300);
		btn5.setPrefHeight(80);
		btn5.setPrefWidth(150);
		
		GridPane root = new GridPane();
		
		root.setPadding(new Insets(20));
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
		
		Scene scene	= new Scene(root, 900, 400);		
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}
