import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
//import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class RequestPage extends Application
{
	
	User current_User;
	
	public RequestPage(User current_User) 
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
		Scene RequestScene;
		GridPane grid;
		primaryStage.setTitle("Classroom Booking System");

		grid = new GridPane();

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		//Title 
		Label Title = new Label("REQUEST");
		GridPane.setHalignment(Title, HPos.RIGHT);
		GridPane.setConstraints(Title, 3, 0);

		//Purpose
		Label Purpose = new Label("Purpose:");
		GridPane.setConstraints(Purpose, 0, 2);
		TextField Purpose_input = new TextField();
		GridPane.setConstraints(Purpose_input, 1, 2, 4, 1);

		//Preferred Room
		Label Preferred = new Label("Preferred Room:");
		GridPane.setConstraints(Preferred, 0, 3);
		TextField Preferred_input = new TextField();
		GridPane.setConstraints(Preferred_input, 1, 3);

		//Capacity
		Label Capacity = new Label("Capacity:");
		GridPane.setConstraints(Capacity, 0, 4);
		TextField Capacity_input = new TextField();
		GridPane.setConstraints(Capacity_input, 1, 4);

		//date
		Label Date = new Label("Date:");
		GridPane.setConstraints(Date, 0, 5);
		DatePicker checkInDatePicker = new DatePicker();
		GridPane.setConstraints(checkInDatePicker, 1, 5);

		// Time
		Label Time = new Label("Time:");
		GridPane.setConstraints(Time, 2, 5);
		ChoiceBox<String> Hours = new ChoiceBox<>();
		Hours.setPrefWidth(100);
		Hours.getItems().addAll("1" , "2" , "3" , "4", "5", "6" ,"7" ,"8", "9", "11", "12");
		Hours.setValue("1");
		GridPane.setConstraints(Hours, 3, 5);

		ChoiceBox<String> Minutes = new ChoiceBox<>();
		Minutes.getItems().addAll("00", "15", "30", "45");
		Minutes.setValue("00");
		GridPane.setConstraints(Minutes, 4, 5);
		

		ChoiceBox<String> M = new ChoiceBox<>();
		M.getItems().addAll("a.m.", "p.m.");
		M.setValue("p.m.");
		GridPane.setConstraints(M, 5, 5);

		//Duration
		Label Duration = new Label("Duration(Minutes):");
		GridPane.setConstraints(Duration, 0, 6);
		TextField Duration_input = new TextField();
		GridPane.setConstraints(Duration_input, 1, 6);


		//Submit
		Button Submit = new Button("Submit");
		GridPane.setConstraints(Submit, 3, 7);
		
		Submit.setOnAction(e ->{
			String Purpose1, Room1,Date1, Time1, Duration1; 
			String Capacity1;
			String current;
			Purpose1 = new String(Purpose_input.getText());
			Room1 = new String(Preferred_input.getText());
			Capacity1 = new String(Capacity_input.getText());
			Duration1 = new String(Duration_input.getText());
			
			Date1 = checkInDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			if(Date1 == null)
			{
				Date1 = new String ("Null");
			}
			
			Time1 = new String(Hours.getValue() + " " + Minutes.getValue());
			if(M.getValue().equals("p.m."))
			{
				int change = Integer.parseInt(Hours.getValue())+ 12;
				Time1 = new String(change + " " + Minutes.getValue());
			}
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(0);
			current = new String(dateFormat.format(date));
			//System.out.println(current); //2016/11/16 12:08:43
			
			try {
				App.deserialize("adminrequestlist");
				App.deserializeRequests(current_User);
			} catch (NullPointerException | IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("Nw File");
			}
			//add to admin List
			
			App.getAdmin_List().add(new Request(current_User,Purpose1, Room1, Integer.parseInt(Capacity1), Date1, Time1, Integer.parseInt(Duration1), current));
			//add to user List
			current_User.getMyRequests().add(new Request(current_User, Purpose1, Room1, Integer.parseInt(Capacity1), Date1, Time1, Integer.parseInt(Duration1), current));
			System.out.println(current_User.MyRequests.size());
			System.out.println(App.getAdmin_List().size());
			try {
				
				App.serialize("adminrequestlist", "adminrequest");
				App.serializeRequests(current_User);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			
		});
		
		Button btn3 = new Button("Back");
		GridPane.setConstraints(btn3, 0, 30);
		
		btn3.setOnAction(e -> {new student_Page(current_User).start(primaryStage);});

		grid.getChildren().addAll(Title, Purpose, Purpose_input, Preferred, Preferred_input, Capacity, Capacity_input, Date, Hours, Minutes, M, Duration_input, Time, Duration, Submit, checkInDatePicker, btn3);
		//GridPane.setC(checkInDatePicker, 1, 5);
		
		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		
		VBox y = new VBox();
		y.setAlignment(Pos.TOP_CENTER);
		y.getChildren().addAll(l, Title, grid);
		
		y.setStyle("-fx-background-color: #00DDDD");

		RequestScene = new Scene(y, 1000, 600);			
		RequestScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(RequestScene);
		primaryStage.show();

	}
}