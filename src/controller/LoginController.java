package controller;

import au.edu.uts.ap.javafx.*;
import java.io.IOException;
import java.util.HashSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;
import model.Faculties;
import model.Faculty;


public class LoginController extends Controller<Session> {
    public final Session getSession() {return model;}
    
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordTf;
    @FXML private Label incorrectLoginLbl;
    
    public void initialize(){
        stage.getIcons().add(new Image("view/book.png"));
    }
    
    public String getEmailTf(){
        return emailTf.getText();
    }
    
    public String getPasswordTf(){
        return passwordTf.getText();
    }
    
    private String facultyName;
    
    
    public void okBtn(ActionEvent e) throws IOException{
        Session session = getSession();
        if(session.faculties.hasFaculty(getEmailTf(), getPasswordTf())){
            
            Faculty faculty = session.getFaculty(getEmailTf(), getPasswordTf());
            facultyName = faculty.getName();
            
            incorrectLoginLbl.setText("");
            
            ViewLoader.showStage(session.getFaculty(getEmailTf(), getPasswordTf()), "/view/faculty.fxml", "Session Admin: " + facultyName, new Stage());
        }
        else{
            incorrectLoginLbl.setText("Incorrect login details");
        }
    }
    
    public void cancelBtn(ActionEvent e) throws IOException{
        stage.close();
    }
}
