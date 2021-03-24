
package login;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Server.routinegenarator.*;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import login.model.User;
import login.security.Authenticator;
import Server.*;
import java.util.Scanner;
import login.student.StudentprofileController;
import login.student.StudentseatplanController;
import login.teacher.TeacherinvigilationController;
import login.teacher.TeacherprofileController;

/**
 * Main Application.
 * 
 * @author Abhik_Blaze
 */
public class Main extends Application {

    private Stage stage;
    private User loggedUser;
    private final double MINIMUM_WINDOW_WIDTH = 420.0;
    private final double MINIMUM_WINDOW_HEIGHT = 560.0;
    public static Map<String,String[]> user_data = new HashMap<>() ;
    public static Map<String,String[]> student_data = new HashMap<>() ;
    public static Map<String,String> teacher_data = new HashMap<>() ;
    public static Map<String,ct[]> studentctarray = new HashMap<>() ;
    public static Map<String,ct[]> teacherctarray = new HashMap<>() ;
    public static Map<String,ct[]> teacherinvigilationarray = new HashMap<>() ;
    public static ObjectOutputStream oos = null ;
    public static ObjectInputStream oin = null ;
    public static Socket socket = null ;
    public static String studentname = null ;
    public static String teachername = null ;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            stage.setTitle("CT routine manager");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/BinaryContent/icon.jpg")))  ;
            networking();
            gotoLogin();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }
        
    static void networking() throws Exception
    {
        Scanner in = new Scanner(Main.class.getResourceAsStream("/TextContent/ServerIP.txt")) ;
        socket = new Socket(in.next(), 5050) ;
        oos = new ObjectOutputStream(socket.getOutputStream()) ;
        oin = new ObjectInputStream(socket.getInputStream()) ;
        user_data = (HashMap<String, String[]>)oin.readObject() ;
        student_data = (HashMap<String, String[]>)oin.readObject() ;
        teacher_data = (HashMap<String, String>)oin.readObject() ;
        studentctarray = (HashMap<String, ct[]>) oin.readObject() ;
        teacherctarray = (HashMap<String, ct[]>) oin.readObject() ;
        teacherinvigilationarray = (HashMap<String, ct[]>) oin.readObject() ;
//        ct test[] =studentctarray.get("31") ;
//         for( int i = 0 ; test[i].level != 0 ; i++)
//           System.out.println(test[i]);
        
        
        
        oos.close();
        oin.close();
               
    }
    public boolean userLogging(String userId, String password){
        //System.out.println("User id test: " + userId + " password test :" + password);
        Authenticator a = new Authenticator(this) ;
        if (Authenticator.validate(userId, password)) {
            //System.out.println("OK");
            loggedUser = User.of(userId);
            //gotoProfile();
            if(Authenticator.identity(userId).equals("student"))
            {
                studentname = userId ;
                gotoStudentPage1() ;
            }
            else
            {
                teachername = userId ;
                gotoTeacherPage1() ;
            }
                
            return true;
            
        } else {
            //System.out.println("NOT OK");
            return false;
        }
    }
    
    void userLogout(){
        loggedUser = null;
        gotoLogin();
    }
    
    public void gotoProfile() {
        try {
            ProfileController profile = (ProfileController) replaceSceneContent("/TextContent/Profile.fxml");
            profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public  void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("/TextContent/Login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gotoStudentPage1()
    {
        try
        {
            StudentprofileController studentPage1 = (StudentprofileController) replaceSceneContent("/TextContent/studentprofile.fxml") ;
            studentPage1.setApp(this);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void gotoStudentPage2()
    {
        try
        {
            StudentseatplanController studentPage2 = (StudentseatplanController) replaceSceneContent("/TextContent/studentseatplan.fxml") ;
            studentPage2.setApp(this) ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void gotoTeacherPage1()
    {
        try
        {
            TeacherprofileController teachrePage1 = (TeacherprofileController) replaceSceneContent("/TextContent/teacherprofile.fxml") ;
            teachrePage1.setApp(this);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void gotoTeacherPage2()
    {
        try
        {
            TeacherinvigilationController teacherPage2 = (TeacherinvigilationController) replaceSceneContent("/TextContent/teacherinvigilation.fxml") ;
            teacherPage2.setApp(this) ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    

    private Node replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        //fxml+="src/TextContent/";
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        
        
        // Store the stage width and height in case the user has resized the window
        double stageWidth = stage.getWidth();
        if (!Double.isNaN(stageWidth)) {
            stageWidth -= (stage.getWidth() - stage.getScene().getWidth());
        }
        
        double stageHeight = stage.getHeight();
        if (!Double.isNaN(stageHeight)) {
            stageHeight -= (stage.getHeight() - stage.getScene().getHeight());
        }
        
        Scene scene = new Scene(page);
        if (!Double.isNaN(stageWidth)) {
            page.setPrefWidth(stageWidth);
        }
        if (!Double.isNaN(stageHeight)) {
            page.setPrefHeight(stageHeight);
        }
        
        stage.setScene(scene);
        stage.sizeToScene();
        return (Node) loader.getController();
    }
}
