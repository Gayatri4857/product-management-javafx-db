package user_management_information;

import java.util.Scanner;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.LoginScreenController;
import search_user.SearchUserScreen;
import user_management_screen.UserManagementScreen;



public class UserManagementInformationController {
	
	@FXML
	private TextField user_name;
	
	@FXML
	private TextField email_id;
	
	@FXML
	private TextField pass;
	
	@FXML
	private TextField confirm_password;
	
	@FXML
	private TextField user_role;
	
	@FXML 
	private Button close_button;
	
	@FXML
	private Button save_button;
	
	
	public void SaveButton(ActionEvent event) {
		String query = "insert INTO users(username,email_id,passwords,confirmpassword,userrole)Values('"+user_name.getText()+"','"+email_id.getText()+"','"+pass.getText()+"','"+confirm_password.getText()+"','"+user_role.getText()+"')";
		
		DBUtils.executeQuery(query);
	
		try {
			SearchUserScreen.showsearchscreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   }
	public void CloseButton(ActionEvent event) {
		try {
			UserManagementScreen.showUserManagement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}