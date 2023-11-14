package edit_user;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.LoginScreen;
import user_management_screen.UserManagementScreen;

public class EditUserScreenController {
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField new_username;
	
	@FXML
	private TextField new_email_id;
	
	@FXML
	private TextField new_password;
	
	@FXML
	private TextField new_confirmpassword;
	
	@FXML
	private TextField new_userrole;
	
	@FXML
	private Button back;
	
	@FXML
	private Button save;
	
	@FXML
	private Button Edit;
	
	public void editButton(ActionEvent event) throws SQLException{
         boolean editstatus = editUser(username.getText());
		
		if(editstatus) {
			editUser(null);
		}
		
		else {
			System.out.println("User not found");
		}
	}
	public boolean editUser(String username) throws SQLException{
		
		
		 String query ="select * from users where username ='"+ username+ "' ";   
         ResultSet rs = DBUtils.executeQueryGetResult(query);
         
	
	try {
		if (rs.next()) {
	    	  
			    new_username.setText(rs.getString("username"));
				new_email_id.setText(rs.getString("email_id"));
				new_password.setText(rs.getString("passwords"));
			    new_confirmpassword.setText(rs.getString("confirmpassword"));
			    new_userrole.setText(rs.getString("userrole"));
	    	}
	}
	
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false; 
	}
		
		

	
	
	public void back_button(ActionEvent event) {
		try {
			UserManagementScreen.showUserManagement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save_button(ActionEvent event) {
		
		String query1 = "UPDATE Users SET username= '" + new_username.getText() + "', email_id = '" + new_email_id.getText() + "', "
				+ "passwords = '" + new_password.getText() + "', " + "confirmpassword= '" + new_confirmpassword.getText() + "',"
				+ "userrole = '" + new_userrole.getText() + "'" + "WHERE username = '" +  username.getText() + "'";

		DBUtils.executeQuery(query1);
		
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			}
			
		
	}
		


			
	
