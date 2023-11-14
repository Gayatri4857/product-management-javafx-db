package home_screen;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import product_screen.ProductScreen;
import user_management_screen.UserManagementScreen;

public class HomeScreenController {
	
	@FXML
	private Button userManagement;
	
	@FXML
	private Button productManagement;
	
	@FXML
	private Button backButton;
	
	public void showUserManagementScreen(ActionEvent event) {
		
		try {
			UserManagementScreen.showUserManagement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void showProductManagementScreen(ActionEvent event) {
		try {
			ProductScreen.showProductScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void backToHomeScreen(ActionEvent event) {
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
