import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

/**
 * GUI for the student making the request Creates a request object and adds it
 * the admin request list and students request list
 * 
 * @author Yajur
 * @author Shravika
 */
public class RequestPage extends Application {

	User current_User;

	public RequestPage(User current_User) {
		this.current_User = current_User;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene RequestScene;
		GridPane grid;
		primaryStage.setTitle("Classroom Booking System");

		grid = new GridPane();

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		// Title
		Label Title = new Label("REQUEST");
		GridPane.setHalignment(Title, HPos.RIGHT);
		GridPane.setConstraints(Title, 3, 0);

		// Purpose
		Label Purpose = new Label("Purpose:");
		GridPane.setConstraints(Purpose, 0, 2);
		TextArea Purpose_input = new TextArea();
		Purpose_input.setPrefHeight(100);
		Purpose_input.setPrefWidth(750);
		// Purpose_input.setAlignment(Pos.TOP_LEFT);
		GridPane.setConstraints(Purpose_input, 1, 2, 4, 1);

		// Preferred Room
		Label Preferred = new Label("Preferred Room:");
		GridPane.setConstraints(Preferred, 0, 3);
		ChoiceBox<String> Preferred_input = new ChoiceBox<>();
		Preferred_input.getItems().addAll("C01", "C02", "C03", "C04", "C11", "C12", "C13", "C14", "C21", "C22", "C23",
				"C24", "LR1", "LR2", "LR3", "S01", "S02", "L21", "L22", "L23");
		Preferred_input.setValue("C01");
		Preferred_input.getStyleClass().add("dropdown");
		Preferred_input.prefHeight(15);

		GridPane.setConstraints(Preferred_input, 1, 3);

		// Capacity
		Label Capacity = new Label("Capacity:");
		GridPane.setConstraints(Capacity, 0, 4);
		TextField Capacity_input = new TextField();
		GridPane.setConstraints(Capacity_input, 1, 4);

		// date
		Label Date = new Label("Date:");
		GridPane.setConstraints(Date, 0, 5);
		DatePicker checkInDatePicker = new DatePicker();
		GridPane.setConstraints(checkInDatePicker, 1, 5);

		// Time
		Label Time = new Label("Time:");
		GridPane.setConstraints(Time, 2, 5);
		ChoiceBox<String> Hours = new ChoiceBox<>();
		Hours.setPrefWidth(100);
		Hours.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12");
		Hours.setValue("1");
		Hours.getStyleClass().add("dropdown");
		GridPane.setConstraints(Hours, 3, 5);

		ChoiceBox<String> Minutes = new ChoiceBox<>();
		Minutes.getItems().addAll("00", "30");
		Minutes.setValue("00");
		Minutes.getStyleClass().add("dropdown");
		GridPane.setConstraints(Minutes, 4, 5);

		ChoiceBox<String> M = new ChoiceBox<>();
		M.getItems().addAll("a.m.", "p.m.");
		M.setValue("p.m.");
		M.getStyleClass().add("dropdown");
		GridPane.setConstraints(M, 5, 5);

		// Duration
		Label Duration = new Label("Duration(Minutes):");
		GridPane.setConstraints(Duration, 0, 6);
		TextField Duration_input = new TextField();
		GridPane.setConstraints(Duration_input, 1, 6);

		// Submit
		Button Submit = new Button("Submit");
		GridPane.setConstraints(Submit, 3, 7);
		/**
		 * Submit Button Makes an object out of the input given by User Adds to the
		 * Request list of both user and admin
		 */
		Submit.setOnAction(e -> {
			String Purpose1, Room1, Date1, Time1, Duration1;
			String Capacity1;
			String current;
			Purpose1 = new String(Purpose_input.getText());
			Room1 = new String(Preferred_input.getValue());
			Capacity1 = new String(Capacity_input.getText());
			Duration1 = new String(Duration_input.getText());

			LocalDate d = checkInDatePicker.getValue();
			Date1 = checkInDatePicker.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			if (Date1 == null) {
				Date1 = new String("Null");
			}

			Time1 = new String(Hours.getValue() + " " + Minutes.getValue());
			if (M.getValue().equals("p.m.")) {

				Time1 = new String(Hours.getValue() + ":" + Minutes.getValue() + " p.m.");
			} else {
				Time1 = new String(Hours.getValue() + ":" + Minutes.getValue() + " a.m.");
			}

			LocalDate book_Date = java.time.LocalDate.now();
			DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			current = book_Date.format(f);

			System.out.println(current);

			try {
				App.deserialize("adminrequestlist");
				App.deserializeRequests(current_User);
			} catch (NullPointerException | IOException | ClassNotFoundException e1) {

				System.out.println("Nw File");
			}
			// add to admin List

			Request obj = new Request(current_User, Purpose1, Room1, Integer.parseInt(Capacity1), Date1, Time1,
					Integer.parseInt(Duration1), current, d);

			try {
				App.deserialize("requestlist");
			} catch (ClassNotFoundException | IOException | NullPointerException e2) {

				System.out.println("New File");
			}

			App.request.get(0).ref = App.request.get(0).ref + 1;

			try {
				App.serialize("requestlist", "request");
			} catch (IOException e2) {

				e2.printStackTrace();
			}

			obj.identify = App.request.get(0).ref;

			App.getAdmin_List().add(obj);
			// add to user List
			current_User.getMyRequests().add(obj);
			System.out.println(current_User.MyRequests.size());
			System.out.println(App.getAdmin_List().size());
			try {

				App.serialize("adminrequestlist", "adminrequest");
				App.serializeRequests(current_User);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Purpose_input.setText("");
			Preferred_input.setValue("C01");
			Capacity_input.setText("");
			Duration_input.setText("");
			Hours.setValue("1");
			Minutes.setValue("00");

		});

		Button btn3 = new Button("Back");
		GridPane.setConstraints(btn3, 0, 20);
		/**
		 * Back Button Goes to the previous page
		 */
		btn3.setOnAction(e -> {
			new student_Page(current_User).start(primaryStage);
		});

		grid.getChildren().addAll(Title, Purpose, Purpose_input, Preferred, Preferred_input, Capacity, Capacity_input,
				Date, Hours, Minutes, M, Duration_input, Time, Duration, Submit, checkInDatePicker, btn3);

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");

		VBox y = new VBox();
		y.setAlignment(Pos.TOP_CENTER);
		y.getChildren().addAll(l, Title, grid);

		y.getStyleClass().add("background");

		RequestScene = new Scene(y, 1100, 800);
		RequestScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(RequestScene);
		primaryStage.show();

	}
}