package add_product;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import product_screen.ProductScreen;
import search_product.SearchProductScreen;

public class AddProductScreenController {
	
	@FXML
	private TextField productName;
	
	@FXML
	private TextField productID;
	
	@FXML
	private TextField productPrice;
	
	@FXML
	private TextField productCategory;
	
	@FXML
	private TextField productQuality;
	
	public void save_button(ActionEvent event) {

		String query = "insert INTO product(ProductName,ProductID,ProductPrice,ProductQuality,ProductCategory)Values('"+productName.getText()+"','"+productID.getText()+"','"+productPrice.getText()+"','"+productQuality.getText()+"','"+productCategory.getText()+"')";
	    DBUtils.executeQuery(query);
	    
	    try {
			SearchProductScreen.showSearchProductScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	public void close_button(ActionEvent event) {
		try {
			ProductScreen.showProductScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
