package search_product;

import java.sql.ResultSet;
import java.sql.SQLException;

import db_operations.DBUtils;
import edit_product.EditProductScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_screen.ProductScreen;

public class SearchProductScreenController {
	
	@FXML
	private TextField Search_ProductName;
	
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
	private Button Edit;
	
	@FXML
	private Button Delete;
	
	@FXML
	private Button Back;
	
	public void search_button(ActionEvent event) throws SQLException{
		boolean searchstatus = searchUser(Search_ProductName.getText());
		
		if(searchstatus) {
			searchUser(null);
		}
		
		else {
			System.out.println("User not found");
		}
	}
	public boolean searchUser(String Search_ProductName) throws SQLException{
		
		
		 String query ="select * from product where ProductName ='"+ Search_ProductName+ "' ";   
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
	
	public void edit_button(ActionEvent event) {
		try {
			EditProductScreen.showeditproductscreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_button(ActionEvent event) {
		String query = "delete from product where ProductName ='" + Search_ProductName.getText()+"' ";
	     DBUtils.executeQuery(query);
	    
	}

}
