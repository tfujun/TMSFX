package controller;

import au.edu.uts.ap.javafx.*;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculty;
import model.Session;
import model.Student;
import model.TMS;


public class FacultyController extends Controller<Faculty> {
    
    public Faculty getFaculty() { return model; }
    
    @FXML private TableView<Student> studentsTv;
    @FXML private TableColumn studentsTvName;
    @FXML private TableColumn studentsTvEmail;
    @FXML private TableColumn studentsTvPhone;
    
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button slipBtn;
    @FXML private Button addBtn;
    
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    
    public Student getCurrentStudent(){
        return studentsTv.getSelectionModel().getSelectedItem();
    }
    
    
    public void initialize() {   
        stage.getIcons().add(new Image("view/faculty.png"));
        studentsTv.setColumnResizePolicy(studentsTv.CONSTRAINED_RESIZE_POLICY);
        studentsTv.setPlaceholder(new Label("Students list is not loaded"));
        
        deleteBtn.setDisable(true);
        selectBtn.setDisable(true);
        slipBtn.setDisable(true);
        
        studentsTv.getSelectionModel().selectedItemProperty().addListener((observer, oldSelection, newSelection) ->
        { deleteBtn.setDisable(newSelection == null);
          slipBtn.setDisable(newSelection == null);
          selectBtn.setDisable(newSelection == null);
        });
        
        Faculty faculty = getFaculty();
        
        nameTf.textProperty().addListener((observable, oldValue, newValue) -> {
            faculty.filterList(newValue, newValue);
        });
        
        emailTf.textProperty().addListener((observable, oldValue, newValue) -> {
            faculty.filterList(newValue, newValue);
        });
    }
    
    public void addBtn(ActionEvent e) throws IOException{
//        Opens student window with empty fields.
        Faculty faculty = getFaculty();
        Student newStudent = new Student("", "", "", "", "", "", 0, 0.00,"");
        newStudent.setFaculty(faculty);
        ViewLoader.showStage(newStudent, "/view/student.fxml", "Adding New Student", new Stage());
    }
    
    public void deleteBtn(ActionEvent e) throws IOException{
        Faculty faculty = getFaculty();
        faculty.removeStudent(getCurrentStudent());
    }
    
    public void selectBtn(ActionEvent e) throws IOException{
//        Opens student window with information in fields.
        Student currentStudent = getCurrentStudent();
        String currentStudentName = currentStudent.getName();
        ViewLoader.showStage(currentStudent, "/view/student.fxml", "Accessing File: " + currentStudentName, new Stage());
    }
    
    public void slipBtn(ActionEvent e) throws IOException{
//        Opens slip window
        Student currentStudent = getCurrentStudent();
        String currentStudentName = currentStudent.getName();
        ViewLoader.showStage(currentStudent, "/view/slip.fxml", currentStudentName + " SLIP Report", new Stage()); 
    }
    
    public void reportBtn(ActionEvent e) throws IOException{
//        Opens tms window
        Faculty faculty = getFaculty();
        TMS tms = new TMS(faculty);
        ViewLoader.showStage(tms, "/view/tms.fxml", "TMS Report", new Stage());
    }
    
    public void closeBtn(ActionEvent e){
        stage.close();
    }
    
}
