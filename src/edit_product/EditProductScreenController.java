package edit_product;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.LoginScreen;
import product_screen.ProductScreen;

public class EditProductScreenController {
	
	@FXML
	private TextField Edit_ProductName;
	
	@FXML
	private TextField productName;
	
	@FXML 
	private TextField productID;
	
	@FXML
	private TextField productPrice;
	
	@FXML
	private TextField productQuality;
	
	@FXML
	private TextField productCategory;
	
	@FXML 
	private Button Search;
	
	@FXML
	private Button Save;
	
	@FXML
	private Button Back;
	
	public void search_button(ActionEvent event) throws SQLException{
		boolean searchstatus = searchUser(Edit_ProductName.getText());
		
		if(searchstatus) {
			searchUser(null);
		}
		
		else {
			System.out.println("User not found");
		}
	}
	public boolean searchUser(String Edit_ProductName) throws SQLException{
		
		
		 String query ="select * from product where ProductName ='"+ Edit_ProductName+ "' ";   
         ResultSet rs = DBUtils.executeQueryGetResult(query);
         
	
	try {
		if (rs.next()) {
	    	  
			    productName.setText(rs.getString("ProductName"));
				productID.setText(rs.getString("ProductID"));
				productPrice.setText(rs.getString("ProductPrice"));
			    productQuality.setText(rs.getString("ProductQuality"));
			    productCategory.setText(rs.getString("ProductCategory"));
	    	}
	}
	
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return false; 
	}
	
	public void back_button(ActionEvent event) {
		try {
			ProductScreen.showProductScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save_button(ActionEvent event) {
		String query1 = "UPDATE product SET ProductName= '" + productName.getText() + "', ProductID = '" + productID.getText() + "', "
				+ "ProductPrice = '" + productPrice.getText() + "', " + "ProductQuality= '" + productQuality.getText() + "',"
				+ "ProductCategory = '" + productCategory.getText() + "'" + "WHERE ProductName = '" +  Edit_ProductName.getText() + "'";

		DBUtils.executeQuery(query1);
		
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			}
	}


