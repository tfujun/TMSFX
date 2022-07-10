package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import model.Student;



public class SlipController extends Controller<Student>  {
    
    public Student getStudent(){return model;}
    
    @FXML private Label creditsLbl;
    @FXML private Label totalFeeLbl;
    @FXML private Label netFeeLbl;
    @FXML private Label ppCreditLbl;
    @FXML private Label scholarshipLbl;
    @FXML private Label deductionLbl;
    
    
    public void initialize(){
        stage.getIcons().add(new Image("view/edit.png"));
        Student student = getStudent();
        
        String credits = student.getCredits() + " credits";
        creditsLbl.setText(credits);
        
        String totalFee = "$" + student.getTotalFee();
        totalFeeLbl.setText(totalFee);
        
        String netFee = "$" + student.getNetFee();
        netFeeLbl.setText(netFee);
        
        String ppCredit = "$" + student.getPayPerCredit();
        ppCreditLbl.setText(ppCredit);
        
        String scholarship = "$" + student.getScholarship();
        scholarshipLbl.setText(scholarship);
        
        String deduction = "$" + student.getDeduction();
        deductionLbl.setText(deduction);
        
    }
    
    public void closeBtn(ActionEvent e){
        stage.close();
    }
    
    
}
