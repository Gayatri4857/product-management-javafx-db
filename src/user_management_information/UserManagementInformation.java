package user_management_information;

import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UserManagementInformation {
	public static void showUserManagementInformation() throws Exception{
try {
			
			Parent actorGroup = FXMLLoader.load(new URL("file:///C:\\Users\\hemag\\eclipse-workspace\\ShopManagementJavaFxDB\\src\\user_management_information\\User_Information.fxml"));
			StageFactory.stage.setTitle("Customer Login");
			Scene scene = new Scene(actorGroup,400,200);
			StageFactory.stage.setScene(scene);
			StageFactory.stage.setFullScreen(true);
			StageFactory.stage.show();
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}

}
