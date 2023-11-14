package user_management_screen;

import edit_user.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import search_user.SearchUserScreen;
import user_management_information.UserManagementInformation;

public class UserManagementScreenController {
	
	@FXML
	private Button Add_User;
	
	@FXML
	private Button Edit_User;
	
	@FXML
	private Button Delete_User;
	
	@FXML
	private Button Search_User;
	
	@FXML
	private Button Quit;
	
	public void show_add_user_screen(ActionEvent event) {
		
		try {
			UserManagementInformation.showUserManagementInformation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void show_edit_user_screen(ActionEvent event) {
		try {
			EditUserScreen.showeditscreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void show_delete_user_screen(ActionEvent event) {
		try {
			SearchUserScreen.showsearchscreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void show_search_user_screen(ActionEvent event) {
		try {
			SearchUserScreen.showsearchscreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	public void show_quit_user(ActionEvent event) {
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}