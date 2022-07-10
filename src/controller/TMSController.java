package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import model.Student;
import model.TMS;

public class TMSController extends Controller<TMS>  {
    
    public TMS getTMS() { return model; }
    
    @FXML private TableView tmsTv;
    @FXML private Label tuitionLbl;
    @FXML private Label netFeeLbl;
    @FXML private Label basLbl;
    @FXML private Label scholarshipLbl;
    @FXML private Label deductionLbl;
    
    public void initialize(){
        stage.getIcons().add(new Image("view/uts.jpeg"));
        tmsTv.setColumnResizePolicy(tmsTv.CONSTRAINED_RESIZE_POLICY);
        tmsTv.setPlaceholder(new Label("Students list is not loaded"));
        
        TMS tms = getTMS();
        
        tuitionLbl.setText("$" + tms.getTotalTuitionFee());
        netFeeLbl.setText("$" + tms.getTotalNetFee());
        basLbl.setText("$" + tms.getBas());
        scholarshipLbl.setText("$" + tms.getTotalScholarship());
        deductionLbl.setText("$" + tms.getTotalDeduction());
    }
    
    public void closeBtn(ActionEvent e){
        stage.close();
    }

    
}
