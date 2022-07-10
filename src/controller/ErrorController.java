package controller;

import au.edu.uts.ap.javafx.*;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import model.Student;



public class ErrorController extends Controller<Student>  {
    public Student getStudent() { return model; }
    
    @FXML private Label errorsLbl;
    
    private final Validator validator = new Validator();
    
    public void initialize(){
        stage.getIcons().add(new Image("view/error.png"));
        Student student = getStudent();
        validator.generateErrors(student.getName(), student.getEmail(), student.getPhone(), student.getAddress(), student.getType(), student.getID(), student.getCredits(), student.getScholarship());
        LinkedList<String> errors = validator.errors();
        String errorsString = "";
        for(String string:errors){
            errorsString += string;
        }
        
        errorsLbl.setText(errorsString);
    }
    
    public void okayBtn(ActionEvent e){
        stage.close();
    }
    
}
