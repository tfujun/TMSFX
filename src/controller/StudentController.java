package controller;

import au.edu.uts.ap.javafx.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculty;
import model.Student;


public class StudentController extends Controller<Student>{
    
    public Student getStudent(){ return model;}
    
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    
    @FXML private TextField studentIDTf;
    @FXML private TextField typeTf;
    @FXML private TextField creditsTf;
    @FXML private TextField scholarshipTf;
    @FXML private TextField deductionTf;
    
    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    @FXML private Button closeBtn;
    
    @FXML 
    public void initialize(){
        stage.getIcons().add(new Image("view/edit.png"));
        Student student = getStudent();
        nameTf.setText(student.getName());
        emailTf.setText(student.getEmail());
        phoneTf.setText(student.getPhone());
        addressTf.setText(student.getAddress());
        
        studentIDTf.setText(student.getID());
        typeTf.setText(student.getType());
        creditsTf.setText(Integer.toString(student.getCredits()));
        scholarshipTf.setText(Double.toString(student.getScholarship()));
        deductionTf.setText(Double.toString(student.getDeduction()));
        
        if(!nameTf.getText().isEmpty()){
            addBtn.setDisable(true);
        }
        else{
            updateBtn.setDisable(true);
        }
        
    }
    
    public void addBtn(ActionEvent e) throws IOException{
        Student student = getStudent();
        Validator validator = new Validator();
        Faculty faculty = student.getFaculty();
        if(validator.isValid(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), studentIDTf.getText(), Integer.parseInt(creditsTf.getText()), Double.parseDouble(scholarshipTf.getText()))){
            student.updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), studentIDTf.getText(), Integer.parseInt(creditsTf.getText()), Double.parseDouble(scholarshipTf.getText()), deductionTf.getText());
            faculty.addStudent(student);
            stage.close();
        }
        else{
            student.updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), studentIDTf.getText(), Integer.parseInt(creditsTf.getText()), Double.parseDouble(scholarshipTf.getText()), deductionTf.getText());
            ViewLoader.showStage(validator, "/view/error.fxml", "Input Exceptions", new Stage());
        }
    }
    
    public void updateBtn(ActionEvent e)throws IOException{
        Validator validator = new Validator();
        Student student = getStudent();
        if(validator.isValid(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), studentIDTf.getText(), Integer.parseInt(creditsTf.getText()), Double.parseDouble(scholarshipTf.getText()))){
            student.updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), studentIDTf.getText(), Integer.parseInt(creditsTf.getText()), Double.parseDouble(scholarshipTf.getText()), deductionTf.getText());
            stage.close();
        }
        else{
            student.updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), typeTf.getText(), studentIDTf.getText(), Integer.parseInt(creditsTf.getText()), Double.parseDouble(scholarshipTf.getText()), deductionTf.getText());
            ViewLoader.showStage(student, "/view/error.fxml", "Input Exceptions", new Stage());
        }
    }
    
    public void closeBtn(ActionEvent e) throws IOException{
        stage.close();
    }
    
    
}
