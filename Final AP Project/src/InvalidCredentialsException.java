import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Exception class for invalid credentials entered on login
 * 
 * @author Yajur Ahuja - 2016121
 * @author Shravika Mittal - 2016093
 *
 */
class InvalidCredentialsException extends Exception 
{
	InvalidCredentialsException(String message) 
	{
		super(message);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Your Email ID or Password is Invalid");
		alert.showAndWait();
	}
}
