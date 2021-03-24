/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.teacher;

import Server.routinegenarator.ct;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import login.Main;
import login.simplestring;

/**
 * FXML Controller class
 *
 * @author Abhik_Blaze
 */
public class TeacherprofileController extends AnchorPane implements Initializable {

    @FXML
    public TableView<simplestring> teacherroutine;
    @FXML
    public TableColumn<simplestring, String> date;
    @FXML
    public TableColumn<simplestring, String> course;
    @FXML
    public TableColumn<simplestring, String> ctno;
    @FXML
    public Text teachername;
    @FXML
    public Text currentdate;
    public final ObservableList<simplestring> data = FXCollections.observableArrayList() ;
    simplestring array[] ;
    @FXML
    private Button invigilations;
    @FXML
    private Hyperlink tlogout2;

    void initialize() {
        
    }
    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    } 
    public String dateoutput ;
    private Main application;
    String syear;
    String smonth;
    String sday;
    int differentiator = 0 ;
    
    public void setApp(Main application){
        this.application = application;
        dateoutput = new java.sql.Date(System.currentTimeMillis()).toString() ;
        teachername.setText("Welcome "+ this.application.teachername);
        currentdate.setText("Date: "+ dateoutput);
        syear = dateoutput.substring(0, 4);
        smonth = dateoutput.substring(5, 7);
        sday = dateoutput.substring(8);
        differentiator = Integer.parseInt(syear)*365 + Integer.parseInt(smonth)*30 + Integer.parseInt(sday) ;
        
        //String scode = this.application.teacher_data.get(this.application.teachername);
        ct ctarray[] = this.application.teacherctarray.get(this.application.teachername) ;
        //System.out.println(ctarray.length);
        int j = 0 ;
        for( j = 0 ; ctarray[j].level!= 0 ; j++) ;
           // System.out.println(ctarray[j]);
       // System.out.println(j);
        array = new simplestring[j] ;
        for( int i = 0 ; i < j ; i++)
        {
            array[i] = new simplestring(ctarray[i].s.date, ctarray[i].sub_code, ctarray[i].ct_num) ;
            data.add(array[i]) ;
           // System.out.println(array[i].getsub_code()); ;
        }
        
        
    date.setCellFactory(new Callback<TableColumn<simplestring, String>, TableCell<simplestring, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        
                        String oday = item.substring(0,2) ;
                        String omonth = item.substring(3,5) ;
                        String oyear = "20"+ item.substring(6) ;
                        //System.out.println("day " + oday + " month " + omonth + " year" + oyear);
                        int checker = Integer.parseInt(oyear) * 365 + Integer.parseInt(omonth) * 30 + Integer.parseInt(oday) ; 
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        //if(item.contains(dat[1]))
                            //this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                            if(checker<differentiator)
                                {
                                    item = "FINISHED" ;
                                    
                                }
                            setText(item);
                    }
                }
            };
        }
    });
        
        teacherroutine.setItems(this.data);
        animateMessage();
    }
    
     private void animateMessage() {
        //Node success;
        FadeTransition ft = new FadeTransition(Duration.millis(3000), teacherroutine);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
        FadeTransition ft1 = new FadeTransition(Duration.millis(3000), teachername);
        ft1.setFromValue(0.0);
        
        ft1.setToValue(1);
        ft1.play();
        
        FadeTransition ft2 = new FadeTransition(Duration.millis(3000), currentdate);
        ft2.setFromValue(0.0);
        ft2.setToValue(1);
        ft2.play();
    }
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        date.setCellValueFactory(new PropertyValueFactory<simplestring,String>("Date"));
        course.setCellValueFactory(new PropertyValueFactory<simplestring,String>("Sub"));
        ctno.setCellValueFactory(new PropertyValueFactory<simplestring,String>("Ct"));
        teacherroutine.setItems(data); 
    }

    @FXML
    private void handleinvigilation(ActionEvent event) {
        application.gotoTeacherPage2();
        
    }

    @FXML
    private void teacherlogout2(ActionEvent event) {
        
        application.gotoLogin();
    }
    
}
