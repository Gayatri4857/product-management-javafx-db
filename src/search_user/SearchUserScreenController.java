package search_user;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import edit_user.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management_information.UserManagementInformation;

public class SearchUserScreenController {
	
	@FXML
	private TextField UserName;
	
	@FXML
	private TextField user_name;
	
	@FXML 
	private TextField Email_id;
	
	@FXML
	private TextField Password;
	
	@FXML
	private TextField ConfirmPassword;
	
	@FXML
	private TextField UserRole;
	
	@FXML
	private Button Edit_Button;
	
	@FXML 
	private Button BackButton;
	
	@FXML
	private Button Delete;
	
	@FXML
	private Button Search;
	

	public void search_button(ActionEvent event) throws SQLException{
		boolean searchstatus = searchUser(UserName.getText());
		
		if(searchstatus) {
			searchUser(null);
		}
		
		else {
			System.out.println("User not found");
		}
	}
	public boolean searchUser(String UserName) throws SQLException{
		
		
		 String query ="select * from users where username ='"+ UserName+ "' ";   
         ResultSet rs = DBUtils.executeQueryGetResult(query);
         
	
	try {
		if (rs.next()) {
	    	  
			    user_name.setText(rs.getString("username"));
				Email_id.setText(rs.getString("email_id"));
				Password.setText(rs.getString("passwords"));
			    ConfirmPassword.setText(rs.getString("confirmpassword"));
			    UserRole.setText(rs.getString("userrole"));
	    	}
	}
	
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false; 
	}

	public void back_button(ActionEvent event) {
		try {
			UserManagementInformation.showUserManagementInformation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edit_button(ActionEvent event) {
		
		try {
			EditUserScreen.showeditscreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delete_button(ActionEvent event) {
		String query = "delete from users where username ='" + UserName.getText()+"' ";
	     DBUtils.executeQuery(query);
	    
		
}
}
