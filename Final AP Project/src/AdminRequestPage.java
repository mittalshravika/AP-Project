import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox.*;
import javafx.scene.layout.VBox.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

/**
 * Diasplays the request details made by the students
 * 
 * @author Yajur
 * @author Shravika
 */
public class AdminRequestPage extends Application {

	private Request object;
	private User current_User;

	public AdminRequestPage(Request obj, User a) {
		this.object = obj;
		this.current_User = a;

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene CourseView;
		GridPane request;

		primaryStage.setTitle("Classroom Booking System");

		request = new GridPane();
		request.setPadding(new Insets(20, 20, 20, 20));
		request.setVgap(8);
		request.setHgap(10);

		Label title = new Label("Request");

		HBox x = new HBox();
		x.getChildren().addAll(title);
		x.setAlignment(Pos.CENTER);
		VBox y = new VBox();

		Label Name = new Label("Name:");
		GridPane.setConstraints(Name, 0, 0);
		Label Name_D = new Label();
		Name_D.setText(object.RequestUser.getName());
		GridPane.setConstraints(Name_D, 1, 0);

		Label Purpose = new Label("Purpose:");
		GridPane.setConstraints(Purpose, 0, 1);
		Label Purpose_D = new Label();
		Purpose_D.setText(object.purpose);
		GridPane.setConstraints(Purpose_D, 1, 1);

		Label Preferred = new Label("Preferred Room:");
		GridPane.setConstraints(Preferred, 0, 2);
		Label Preferred_D = new Label();
		Preferred_D.setText(object.preferred_Room);
		GridPane.setConstraints(Preferred_D, 1, 2);

		Label Date = new Label("Date:");
		GridPane.setConstraints(Date, 0, 3);
		Label Date_D = new Label();
		Date_D.setText(object.date);
		GridPane.setConstraints(Date_D, 1, 3);

		Label Time = new Label("Time:");
		GridPane.setConstraints(Time, 0, 4);
		Label Time_D = new Label();
		Time_D.setText(object.time);
		GridPane.setConstraints(Time_D, 1, 4);

		Label Duration = new Label("Duration: ");
		GridPane.setConstraints(Duration, 0, 5);
		Label Duration_D = new Label();
		Duration_D.setText(String.valueOf(object.duration) + " Min");
		GridPane.setConstraints(Duration_D, 1, 5);

		Button Back = new Button("Back");
		Back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					new AdminRequestList(current_User).start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		Button Book = new Button("Cancel");

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");

		HBox x1 = new HBox();
		x1.getChildren().addAll(Back);
		x1.setAlignment(Pos.BOTTOM_LEFT);
		x1.setSpacing(710);

		request.getChildren().addAll(Name, Name_D, Purpose, Purpose_D, Preferred, Preferred_D, Date, Date_D, Time,
				Time_D, Duration, Duration_D);
		y.getChildren().addAll(l, x, request, x1);
		y.setSpacing(30);
		y.setPadding(new Insets(20));
		y.setAlignment(Pos.TOP_CENTER);

		y.getStyleClass().add("background");

		CourseView = new Scene(y, 1000, 600);
		CourseView.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(CourseView);
		primaryStage.show();

	}
}
