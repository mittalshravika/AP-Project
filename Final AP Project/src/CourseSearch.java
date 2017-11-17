import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

public class CourseSearch extends Application
{
	User current_User;
	
	public CourseSearch(User current_User)
	{
		this.current_User = current_User;
	}

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{

		Scene CourseSearchScene;

		primaryStage.setTitle("Classroom Booking System");
		
		
		HBox[] show = new HBox[5];
		
		for(int i = 0; i < 5; i++)
		{
			show[i] = new HBox();
			show[i].setSpacing(150);
		}
		
		



		//Title
		Label Title = new Label("SEARCH");
		Title.getStyleClass().add("admin_Page_Heading");
		
		//Search Field
		TextField Search = new TextField();
		
		Search.setPrefWidth(900);

		Button Search_Button = new Button("Search");
	
		
		Search_Button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				
				try 
				{
					App.deserialize("courselist");
					String str = Search.getText();
					search_Course obj = new search_Course(str, App.course_List, current_User);
					App.serialize("courselist", "course");
					Search.setText("");
					new CourseList(current_User).start(primaryStage);
				} catch (ClassNotFoundException | IOException e)
				{
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		Button btn3 = new Button("Back");
		
		
		btn3.setOnAction(e -> {new student_Page(current_User).start(primaryStage);});
		
		
		Label l = new Label("IIIT-D");
		//l.setAlignment(Pos.TOP_CENTER);
		l.getStyleClass().add("labelIIITD");
		
		show[0].getChildren().addAll(l);
		show[0].setAlignment(Pos.CENTER);
		show[1].getChildren().addAll(Title);
		show[1].setAlignment(Pos.CENTER);
		show[2].getChildren().addAll(Search);
		show[2].setAlignment(Pos.CENTER);
		show[3].getChildren().addAll(Search_Button);
		show[3].setAlignment(Pos.BOTTOM_CENTER);
		show[4].getChildren().addAll(btn3);
		show[4].setAlignment(Pos.CENTER_LEFT);
		
		
		VBox y = new VBox();
		y.setPadding(new Insets(20));
		y.setSpacing(50);
		y.setAlignment(Pos.TOP_CENTER);
		for(int i = 0; i < 5; i++)
		{
			y.getChildren().add(show[i]);
		}
		
		y.getStyleClass().add("background");
		CourseSearchScene = new Scene(y, 1100, 800);
		CourseSearchScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

		primaryStage.setScene(CourseSearchScene);	
		primaryStage.show();
	}
}