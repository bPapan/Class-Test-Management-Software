/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.student;

import Server.routinegenarator.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import login.Main;
import login.simplestring;
import login.simplestring3;

/**
 * FXML Controller class
 *
 * @author Abhik_Blaze
 */
public class StudentseatplanController extends AnchorPane implements Initializable{

    @FXML
    private Button seatplantoroutine;
    @FXML
    private Text roomno;
    @FXML
    private Text currentdate;
    @FXML
    private TableView<simplestring3> Group1;
    @FXML
    private TableColumn<simplestring3,String> column1;
    @FXML
    private TableColumn<simplestring3, String> column2;
    @FXML
    private TableColumn<simplestring3, String> column3;
    @FXML
    private TableView<simplestring3> Group2;
    @FXML
    private TableColumn<simplestring3, String> column4;
    @FXML
    private TableColumn<simplestring3, String> column5;
    @FXML
    private TableColumn<simplestring3, String> column6;
    @FXML
    private TableView<simplestring3> Group3;
    @FXML
    private TableColumn<simplestring3, String> column7;
    @FXML
    private TableColumn<simplestring3, String> column8;
    @FXML
    private TableColumn<simplestring3, String> column9;
    public final ObservableList<simplestring3> data1 = FXCollections.observableArrayList() ;
    public final ObservableList<simplestring3> data2 = FXCollections.observableArrayList() ;
    public final ObservableList<simplestring3> data3 = FXCollections.observableArrayList() ;
    simplestring3 array1[] = new simplestring3[8];
    simplestring3 array2[] = new simplestring3[8];
    simplestring3 array3[]  = new simplestring3[8];
    simplestring3 array4[] = new simplestring3[8];
    @FXML
    private Hyperlink logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        column1.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
//        column2.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll2"));
//        column3.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
//        column4.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
//        column5.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
//        column6.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
//        column7.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
//        column8.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
//        column9.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
//        Group1.setItems(data1); 
//        Group2.setItems(data2);
//        Group3.setItems(data3);
    }    
     private Main application;
     public String dateoutput ;
     public void setApp(Main application){
         
         int flag = 0 ;
         int pos = 0 ;
         this.application = application;
         dateoutput = new java.sql.Date(System.currentTimeMillis()).toString() ;
         currentdate.setText("Date: "+ dateoutput);
         String dat[] = application.student_data.get(this.application.studentname) ;
         ct ctarray[] = application.studentctarray.get(dat[0]) ;
         if(ctarray[0].room[0] == 802)
             flag = 1;
         else
             flag = 2 ;
         if(ctarray[0].position.equals("left")) 
            pos  = 1;
         else
            pos = 2 ;
         String yearcode = dat[1].substring(0, 4) ;
         int roll = Integer.parseInt(dat[1].substring(4)) ;
         animateMessage();
       
         
         
         if(roll/100 == 1)
         {
             if(flag == 1)
                 roomno.setText("Room no.: 805");
             else
                 roomno.setText("Room no.: 812D");
               if(pos == 1)
             {
                 column1.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column3.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
                 column5.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column7.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
                 for( int i =0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+String.valueOf(i+91)) ;
                     data1.add(array1[i]) ;
                 }
                 for(int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+String.valueOf(i+107));
                     data2.add(array1[i]) ;
                 }
                 for( int i = 0 ; i < 6 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+ String.valueOf(i+115)) ;
                     data3.add(array1[i]) ;
                 }
                 column1.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1]))
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column3.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column5.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column7.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1]))
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 
                 Group1.setItems(data1); 
                Group2.setItems(data2);
                Group3.setItems(data3);
             }
             else
             {
                 column2.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column4.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column6.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
                 column9.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 for( int i =0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+String.valueOf(i+91)) ;
                     data1.add(array1[i]) ;
                 }
                 for(int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+String.valueOf(i+99));
                     data2.add(array1[i]) ;
                 }
                 for( int i = 0 ; i < 6 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+ String.valueOf(i+115)) ;
                     data3.add(array1[i]) ;
                 }
                 
                 column2.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 
                 column4.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 
                 column6.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                          this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 
                 column9.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 Group1.setItems(data1); 
                Group2.setItems(data2);
                Group3.setItems(data3);
                 
             }
             
                 
         }
         else
         {
             if(roll%100>60 && roll%100 < 91)
             {
                 if(flag == 1)
                 roomno.setText("Room no.: 804");
             else
                 roomno.setText("Room no.: 812C");
               if(pos == 1)
             {
                 column1.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column3.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
                 column5.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column7.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
                 for( int i =0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+61)) ;
                     data1.add(array1[i]) ;
                 }
                 for(int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+77));
                     data2.add(array1[i]) ;
                 }
                 for( int i = 0 ; i < 6 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+ "0"+String.valueOf(i+85)) ;
                     data3.add(array1[i]) ;
                 }
                  column1.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1]))
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column3.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1]))
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column5.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1]))
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column7.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 Group1.setItems(data1); 
                Group2.setItems(data2);
                Group3.setItems(data3);
             }
             else
             {
                 column2.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column4.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column6.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
                 column9.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 for( int i =0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+61)) ;
                     data1.add(array1[i]) ;
                 }
                 for(int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+69));
                     data2.add(array1[i]) ;
                 }
                 for( int i = 0 ; i < 6 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+ "0"+String.valueOf(i+85)) ;
                     data3.add(array1[i]) ;
                 }
                 column2.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column4.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                          this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column6.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column9.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1]))
                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 Group1.setItems(data1); 
                Group2.setItems(data2);
                Group3.setItems(data3);
                 
                }
             }
             else if(roll%100>30 && roll%100 < 61)
             {
                 if(flag == 1)
                 roomno.setText("Room no.: 803");
             else
                 roomno.setText("Room no.: 812B");
               if(pos == 1)
             {
                 column1.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column3.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
                 column5.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column7.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
                 for( int i =0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+31)) ;
                     data1.add(array1[i]) ;
                 }
                 for(int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+47));
                     data2.add(array1[i]) ;
                 }
                 for( int i = 0 ; i < 6 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+ String.valueOf(i+55)) ;
                     data3.add(array1[i]) ;
                 }
                  column1.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                
                        
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //System.out.println("Helllllll") ;
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column3.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //System.out.println("Helllllll") ;
                    if (!isEmpty()) {
                       // this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        // Get fancy and change color based on data
                        //System.out.println("Helllllll") ;
                        if(item.contains(dat[1]))
                        {
                            //System.out.println("HELL");
                            //this.setTextFill(Color.RED);
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        }
                        setText(item);
                    }
                }
            };
        }
    });
                 column5.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1]))
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column7.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 Group1.setItems(data1); 
                Group2.setItems(data2);
                Group3.setItems(data3);
             }
             else
             {
                 column2.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column4.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column6.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
                 column9.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 for( int i =0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+31)) ;
                     data1.add(array1[i]) ;
                 }
                 for(int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+39));
                     data2.add(array1[i]) ;
                 }
                 for( int i = 0 ; i < 6 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+ String.valueOf(i+55)) ;
                     data3.add(array1[i]) ;
                 }
                 column2.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column4.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column6.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column9.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 Group1.setItems(data1); 
                Group2.setItems(data2);
                Group3.setItems(data3);
                 
                }
             }
             else
             {
                 if(flag == 1)
                 roomno.setText("Room no.: 802");
             else
                 roomno.setText("Room no.: 812A");
               if(pos == 1)
             {
                 column1.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column3.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
                 column5.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column7.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll4"));
                 for( int i =0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"00"+String.valueOf(i+1)) ;
                     data1.add(array1[i]) ;
                 }
                 for(int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+17));
                     data2.add(array1[i]) ;
                 }
                 for( int i = 0 ; i < 6 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+ String.valueOf(i+25)) ;
                     data3.add(array1[i]) ;
                 }
                  column1.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column3.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column5.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column7.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 Group1.setItems(data1); 
                Group2.setItems(data2);
                Group3.setItems(data3);
             }
             else
             {
                 column2.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column4.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 column6.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll3"));
                 column9.setCellValueFactory(new PropertyValueFactory<simplestring3,String>("Roll1"));
                 for( int i =0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+1)) ;
                     data1.add(array1[i]) ;
                 }
                 for(int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+String.valueOf(i+9));
                     data2.add(array1[i]) ;
                 }
                 for( int i = 0 ; i < 8 ; i++)
                 {
                     array1[i] = new simplestring3(yearcode+"0"+ String.valueOf(i+25)) ;
                     data3.add(array1[i]) ;
                 }
                 
                 
                 column2.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column4.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                            this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column6.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 column9.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
        public TableCell call(TableColumn param) {
            return new TableCell<simplestring3, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                       // this.setTextFill(Color.RED);
                        // Get fancy and change color based on data
                        if(item.contains(dat[1])) 
                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
                        setText(item);
                    }
                }
            };
        }
    });
                 
                 Group1.setItems(data1); 
                Group2.setItems(data2);
                Group3.setItems(data3);
                 
                
                }
             }
         }
         
         
         
//        column1.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
//        public TableCell call(TableColumn param) {
//            return new TableCell<simplestring3, String>() {
//
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!isEmpty()) {
//                       // this.setTextFill(Color.RED);
//                        // Get fancy and change color based on data
//                        if(item.equals(new SimpleStringProperty(dat[0]))) 
//                            this.setTextFill(Color.RED);
//                        setText(item);
//                    }
//                }
//            };
//        }
//    });
//        
//        
//        column2.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
//        public TableCell call(TableColumn param) {
//            return new TableCell<simplestring3, String>() {
//
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!isEmpty()) {
//                       // this.setTextFill(Color.RED);
//                        // Get fancy and change color based on data
//                        if(item.equals(new SimpleStringProperty(dat[0]))) ; 
//                            this.setTextFill(Color.RED);
//                        setText(item);
//                    }
//                }
//            };
//        }
//    });
//        
//        column3.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
//        public TableCell call(TableColumn param) {
//            return new TableCell<simplestring3, String>() {
//
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!isEmpty()) {
//                       // this.setTextFill(Color.RED);
//                        // Get fancy and change color based on data
//                        if(item.equals(new SimpleStringProperty(dat[0])))
//                            this.setTextFill(Color.RED);
//                        setText(item);
//                    }
//                }
//            };
//        }
//    });
//        
//        column4.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
//        public TableCell call(TableColumn param) {
//            return new TableCell<simplestring3, String>() {
//
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!isEmpty()) {
//                       // this.setTextFill(Color.RED);
//                        // Get fancy and change color based on data
//                        if(item.equals(new SimpleStringProperty(dat[0])))
//                            this.setTextFill(Color.RED);
//                        setText(item);
//                    }
//                }
//            };
//        }
//    });
//        
//        column5.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
//        public TableCell call(TableColumn param) {
//            return new TableCell<simplestring3, String>() {
//
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!isEmpty()) {
//                       // this.setTextFill(Color.RED);
//                        // Get fancy and change color based on data
//                        if(item.equals(new SimpleStringProperty(dat[0])))
//                            this.setTextFill(Color.RED);
//                        setText(item);
//                    }
//                }
//            };
//        }
//    });
//        
//        column6.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
//        public TableCell call(TableColumn param) {
//            return new TableCell<simplestring3, String>() {
//
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!isEmpty()) {
//                       // this.setTextFill(Color.RED);
//                        // Get fancy and change color based on data
//                        if(item.equals(new SimpleStringProperty(dat[0])))
//                            this.setTextFill(Color.RED);
//                        setText(item);
//                    }
//                }
//            };
//        }
//    });
//        
//        
//        column7.setCellFactory(new Callback<TableColumn<simplestring3, String>, TableCell<simplestring3, String>>() {
//        public TableCell call(TableColumn param) {
//            return new TableCell<simplestring3, String>() {
//
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!isEmpty()) {
//                       // this.setTextFill(Color.RED);
//                        // Get fancy and change color based on data
//                        if(item.equals(new SimpleStringProperty(dat[0])))
//                           this.setStyle("-fx-background-image: url(\"CoarseGrid.png\")");
//                        setText(item);
//                    }
//                }
//            };
//        }
//    });

         
         
     }
        
      private void animateMessage() {
        //Node success;
        FadeTransition ft = new FadeTransition(Duration.millis(3000), Group1);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
        FadeTransition ft1 = new FadeTransition(Duration.millis(3000), Group2);
        ft1.setFromValue(0.0);
        ft1.setToValue(1);
        ft1.play();
        
        FadeTransition ft2 = new FadeTransition(Duration.millis(3000), Group3);
        ft2.setFromValue(0.0);
        ft2.setToValue(1);
        ft2.play();
    }
   

    @FXML
    private void gotoroutine(ActionEvent event) {
        
        this.application.gotoStudentPage1();
    }

    @FXML
    private void processlogout(ActionEvent event) {
        this.application.gotoLogin();
    }
    
}
