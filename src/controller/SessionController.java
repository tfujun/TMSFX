package controller;
import au.edu.uts.ap.javafx.*;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Faculty;
import model.Session;

public class SessionController extends Controller<Session>{
    
    public Session getSession(){
        return model;
    }
    
    public void loginBtn(ActionEvent e) throws IOException {
        Session session = getSession();
        ViewLoader.showStage(session, "/view/login.fxml", "Sign in", new Stage());
    }
    
    public void exitBtn(ActionEvent e) throws IOException {
        Platform.exit();
        System.exit(0);
    }
   
}
