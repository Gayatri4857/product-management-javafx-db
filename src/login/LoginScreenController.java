package login;


import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginScreenController {
	
		
		@FXML
		private TextField Email_ID;
		
		@FXML
		private TextField Password;
		
		@FXML
		private Button Login;
		
		public void login_button(ActionEvent event)
		{
			boolean loginStatus = LoginScreenController.validateUserandPassword(Email_ID.getText(),Password.getText());
			
			if(loginStatus)
			{
			 
			try {
				HomeScreen.showHomeScreen();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
			else {
				System.out.println("Login Unsuccessfully!!");
				
			}
		}
		
		public static boolean validateUserandPassword(String Email_ID,String Password) {
			String query = "Select * from users where email_id= '"+ Email_ID + "'and passwords='" +Password+"' ";
			ResultSet rs = DBUtils.executeQueryGetResult(query);
			
			try {
				if (rs.next()) {
					return true;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		
		
	} 
	

}
