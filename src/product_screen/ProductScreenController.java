package product_screen;

import add_product.AddProductScreen;
import edit_product.EditProductScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import search_product.SearchProductScreen;

public class ProductScreenController {
	
	@FXML
	private Button Add_Product;
	
	@FXML
	private Button Edit_Product;
	
	@FXML
	private Button Delete_Product;
	
	@FXML
	private Button Search_Product;
	
	@FXML
	private Button Quit_Product;
	
	public void add_product(ActionEvent event) {
		try {
			AddProductScreen.showAddProductScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edit_product(ActionEvent event) {
		try {
			EditProductScreen.showeditproductscreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_product(ActionEvent event) {
		try {
			SearchProductScreen.showSearchProductScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void search_product(ActionEvent event) {
		try {
			SearchProductScreen.showSearchProductScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void quit_product(ActionEvent event) {
		try {
			LoginScreen.showLoginScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
