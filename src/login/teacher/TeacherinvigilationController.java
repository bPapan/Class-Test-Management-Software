/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.teacher;

import Server.routinegenarator.*;
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
import login.simplestring2;

/**
 * FXML Controller class
 *
 * @author Abhik_Blaze
 */
public class TeacherinvigilationController extends AnchorPane implements Initializable{

    @FXML
    private TableView<simplestring2> teacherroutine;
    @FXML
    private TableColumn<simplestring2, String> date;
    @FXML
    private TableColumn<simplestring2, String> roomno;
    @FXML
    private Text teachername;
    @FXML
    private Text currentdate;
    private Main application;
    public final ObservableList<simplestring2> data2 = FXCollections.observableArrayList() ;
    simplestring2 array[] ;
    public String dateoutput ;
    @FXML
    private Button routine;
    @FXML
    private Hyperlink tlogout;
    //ct ctarray[] = this.application.teacherctarray.get(this.application.teachername) ;
//    @FXML
//    private TableView<?> teacherinvigilation;
    
    String syear;
    String smonth;
    String sday;
    int differentiator = 0 ;
    
    public void setApp(Main application)
    {
        this.application = application ;
        animateMessage();
        dateoutput = new java.sql.Date(System.currentTimeMillis()).toString() ;
        teachername.setText("Welcome "+ this.application.teachername);
        currentdate.setText("Date: "+ dateoutput);
        syear = dateoutput.substring(0, 4);
        smonth = dateoutput.substring(5, 7);
        sday = dateoutput.substring(8);
        differentiator = Integer.parseInt(syear)*365 + Integer.parseInt(smonth)*30 + Integer.parseInt(sday) ;
        
        ct ctarray[] = this.application.teacherinvigilationarray.get(this.application.teachername) ;
        int j = 0;
         for( j = 0 ; ctarray[j].level!= 0 ; j++) ;
            //System.out.println(ctarray[j]);
        array = new simplestring2[j] ;
        for(int i = 0 ; i < j ; i++)
        {
            array[i] = new simplestring2("hello", i) ;
        }
       // System.out.println("j"+j);
//        for(int i =0 ; i < j ; i++)
//            System.out.println(ctarray[i].s.teacher[0]);
        for( int i = 0 ; i < j ; i++)
        {
            int flag = 0 ;
            if(ctarray[i].s.teacher[0].equals(this.application.teachername))
            {
                for(int k =0 ; k < i ;k++)
                {
                    if(array[k].req.equals(ctarray[i].s.date))
                    {
                        flag = 1 ;
                        break;
                    }
                }
                if(flag == 1)
                    continue ;
                array[i] = new simplestring2(ctarray[i].s.date, ctarray[i].room[0]) ;
            }
            else if(ctarray[i].s.teacher[1].equals(this.application.teachername))
            {
                for(int k =0 ; k < i ;k++)
                {
                    if(array[k].req.equals(ctarray[i].s.date))
                    {
                        flag = 1 ;
                        break;
                    }
                }
                if(flag == 1)
                    continue ;
                array[i] = new simplestring2(ctarray[i].s.date, ctarray[i].room[1]) ;
            }
            else if(ctarray[i].s.teacher[2].equals(this.application.teachername))
            {
                for(int k =0 ; k < i ;k++)
                {
                    if(array[k].req.equals(ctarray[i].s.date))
                    {
                        flag =1 ;
                        break;
                    }
                }
                if(flag == 1)
                    continue ;
                array[i] = new simplestring2(ctarray[i].s.date, ctarray[i].room[2]) ;
            }
            else
            {
                for(int k =0 ; k < i ;k++)
                {
                    if(array[k].req.equals(ctarray[i].s.date))
                    {
                        flag = 1 ;
                        break;
                    }
                }
                if(flag == 1)
                    continue ;
                array[i] = new simplestring2(ctarray[i].s.date, ctarray[i].room[3]) ;
            }
            //this.teacherroutine.setItems(this.data2);
            data2.add(array[i]) ;
                
        }
        int length =0 ;
        for(int i = 0 ; i < j ; i++)
        {
            if(!array[i].req.equals("hello"))
               length++;
        }
        System.out.println(length);
        
        Button bt[] = new Button[length] ;
        double ypos = 220.0 ;
        for(int i =0 ; i < length ; i++)
        {
            bt[i] = new Button("View seat plan") ;
            bt[i].setLayoutX(798.0);
            bt[i].setLayoutY(ypos);
            ypos+=60 ;
            
        }
       
        date.setCellFactory(new Callback<TableColumn<simplestring2, String>, TableCell<simplestring2, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring2, String>() {

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
    
        this.teacherroutine.setItems(this.data2);
        
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.date.setCellValueFactory(new PropertyValueFactory<simplestring2,String>("Date"));
        this.roomno.setCellValueFactory(new PropertyValueFactory<simplestring2,String>("Room"));
        //ctno.setCellValueFactory(new PropertyValueFactory<simplestring,String>("Ct"));
        this.teacherroutine.setItems(data2); 
    }

    @FXML
    private void backtoroutine(ActionEvent event) {
        application.gotoTeacherPage1();
    }

    @FXML
    private void teacherlogout(ActionEvent event) {
        
        application.gotoLogin();
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
   

    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
    
}
