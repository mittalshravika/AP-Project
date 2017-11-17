import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane.*;
import javafx.geometry.Pos;

/**
 * GUI to display student's own request list Contains the Students's personal
 * Request list
 * 
 * @author Yajur - 2016121
 * @author Shravika - 2016093
 */

public class StudentRequest extends Application {

	User current_User;

	public StudentRequest(User current_User) {
		this.current_User = current_User;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException, IOException {
		ScrollPane sp;
		GridPane Table;
		Scene RequestScene;

		primaryStage.setTitle("Classroom Booking System");

		// Title
		Label Title = new Label("Your Requests");

		// Table
		Table = new GridPane();
		Table.setPadding(new Insets(20, 20, 20, 20));

		// Index
		TextField T1 = new TextField("S.No.");
		T1.setPrefWidth(100);
		TextField T2 = new TextField("Date");
		T2.setPrefWidth(100);
		TextField T3 = new TextField("Time");
		T3.setPrefWidth(100);
		TextField T4 = new TextField("Duration");
		T4.setPrefWidth(100);
		TextField T6 = new TextField("Purpose");
		T6.setPrefWidth(100);
		TextField T7 = new TextField("Room");
		T7.setPrefWidth(100);
		TextField T8 = new TextField("Capacity");
		T8.setPrefWidth(100);
		TextField T9 = new TextField("Status");
		T9.setPrefWidth(100);
		TextField T10 = new TextField("Cancel");
		T10.setPrefWidth(100);
		Table.add(T1, 0, 0, 1, 1);
		Table.add(T2, 1, 0, 1, 1);
		Table.add(T3, 2, 0, 1, 1);
		Table.add(T4, 3, 0, 1, 1);
		// Table.add(T5, 4, 0, 1, 1);
		Table.add(T6, 4, 0, 1, 1);
		Table.add(T7, 5, 0, 1, 1);
		Table.add(T8, 6, 0, 1, 1);
		Table.add(T9, 7, 0, 1, 1);
		Table.add(T10, 8, 0, 1, 1);
		T1.setDisable(true);
		T2.setDisable(true);
		T3.setDisable(true);
		T4.setDisable(true);
		T6.setDisable(true);
		T7.setDisable(true);
		T8.setDisable(true);
		T9.setDisable(true);
		T10.setDisable(true);
		try {
			App.deserializeRequests(current_User);
		} catch (FileNotFoundException e) {
			System.out.println("new file");
		}
		System.out.println(current_User.MyRequests.size());
		for (int i = 0; i < current_User.MyRequests.size(); i++) {
			TextField t1 = new TextField(String.valueOf(i + 1));
			TextField t2 = new TextField(current_User.MyRequests.get(i).date);
			TextField t3 = new TextField(current_User.MyRequests.get(i).time);
			TextField t4 = new TextField(String.valueOf(current_User.MyRequests.get(i).duration));
			TextField t6 = new TextField(current_User.MyRequests.get(i).purpose);
			TextField t7 = new TextField(current_User.MyRequests.get(i).preferred_Room);
			TextField t8 = new TextField(String.valueOf(current_User.MyRequests.get(i).capacity));
			TextField t9;
			CheckBox Approval = new CheckBox("Select");
			System.out.println(current_User.MyRequests.get(0).toString());
			if (current_User.MyRequests.get(i).Approved)
				t9 = new TextField("Approved");
			else {
				if (current_User.MyRequests.get(i).Cancel)
					t9 = new TextField("Cancelled");
				else
					t9 = new TextField("Pending");
			}

			Request object = current_User.MyRequests.get(i);

			Button B = new Button("Show");
			/**
			 * Show Button Shows the particular request in a separate page Opens the Request
			 * Details page
			 */
			B.setOnAction(e -> {
				try {

					new RequestDetails(object, current_User).start(primaryStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			});
			t1.setPrefWidth(100);
			t2.setPrefWidth(100);
			t3.setPrefWidth(100);
			t4.setPrefWidth(100);
			t6.setPrefWidth(100);
			t7.setPrefWidth(100);
			t8.setPrefWidth(100);
			t9.setPrefWidth(100);

			Table.add(B, 9, i + 1, 1, 1);

			Table.add(t1, 0, i + 1, 1, 1);
			Table.add(t2, 1, i + 1, 1, 1);
			Table.add(t3, 2, i + 1, 1, 1);
			Table.add(t4, 3, i + 1, 1, 1);
			Table.add(t6, 4, i + 1, 1, 1);
			Table.add(t7, 5, i + 1, 1, 1);
			Table.add(t8, 6, i + 1, 1, 1);
			Table.add(t9, 7, i + 1, 1, 1);

			if (t9.getText().equals("Approved") || (t9.getText().equals("Cancelled"))) {
				Approval.setDisable(true);
			}
			Table.add(Approval, 8, i + 1, 1, 1);
			t1.setDisable(true);
			t2.setDisable(true);
			t3.setDisable(true);
			t4.setDisable(true);
			t6.setDisable(true);
			t7.setDisable(true);
			t8.setDisable(true);
			t9.setDisable(true);
			Table.setAlignment(Pos.CENTER);
		}

		App.serializeRequests(current_User);

		sp = new ScrollPane();
		sp.setContent(Table);

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");

		VBox elements = new VBox();
		HBox x = new HBox();
		Button Cancel = new Button("Cancel");
		/**
		 * Cancel Button Deletes the selected requests from the list
		 */
		Cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("cancel");

				ArrayList<CheckBox> check_Box_List = new ArrayList<>();
				ArrayList<Integer> h = new ArrayList<Integer>();

				for (Node node : Table.getChildren()) {
					if (node instanceof CheckBox) {
						check_Box_List.add((CheckBox) node);
					}
				}

				try {
					App.deserialize("adminrequestlist");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < check_Box_List.size(); i++) {
					if (check_Box_List.get(i).isSelected()) {
						h.add(GridPane.getRowIndex((Node) check_Box_List.get(i)));
						int index = GridPane.getRowIndex((Node) check_Box_List.get(i));
						try {
							App.deserializeRequests(current_User);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Request toremove = current_User.MyRequests.get(index - 1);
						System.out.println(toremove.toString());
						current_User.MyRequests.remove(toremove);
						int sno = 0;
						for (int j = 0; j < App.admin_List.size(); j++) {
							if (App.admin_List.get(j).identify == toremove.identify) {
								sno = j;
								break;
							}
						}
						App.admin_List.remove(App.admin_List.get(sno));
						System.out.println(toremove.toString());

						try {
							App.serializeRequests(current_User);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
				try {
					App.serialize("adminrequestlist", "adminrequest");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					new StudentRequest(current_User).start(primaryStage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		elements.setSpacing(20);
		elements.setPadding(new Insets(20));
		elements.setAlignment(Pos.TOP_CENTER);
		elements.getStyleClass().add("background");

		ScrollPane T = new ScrollPane();
		T.setContent(Table);
		T.setPrefHeight(500);
		T.getStyleClass().add("background");

		Button Home = new Button("Back");
		x.getChildren().addAll(Home, Cancel);
		x.setSpacing(600);
		/**
		 * Home/Back button returns to the student page
		 */
		Home.setOnAction(e -> {
			new student_Page(current_User).start(primaryStage);
		});

		elements.getChildren().addAll(l, Title, T, x);
		RequestScene = new Scene(elements, 1100, 800);
		RequestScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(RequestScene);
		primaryStage.show();

	}

}