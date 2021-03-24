/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.routinegenarator.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Abhik_Blaze
 */
public class serverthread implements Runnable,java.io.Serializable{
    
    Socket socket = null ;
    Thread t  ;
    ObjectOutputStream oos = null ;
    ObjectInputStream oin = null ;
    ObjectInputStream ofile = null ;
    serverthread( Socket s)
    {
        this.socket = s ;
        this.t = new Thread(this) ;
        t.start();
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            oos = new ObjectOutputStream(socket.getOutputStream()) ;
            oin = new ObjectInputStream(socket.getInputStream()) ;
            
           // File file = new File("src/TextContent/data.dat") ;
           // FileInputStream fin = new FileInputStream(file) ;
            InputStream in = getClass().getResourceAsStream("/TextContent/data.dat") ;
            ObjectInputStream ofile = new ObjectInputStream(in) ;
            Map<String,String[]>user = (HashMap<String, String[]>)ofile.readObject() ;
            Map<String,String[]>student = (HashMap<String, String[]>)ofile.readObject() ;
            Map<String,String>teacher = (HashMap<String, String>)ofile.readObject() ;
            Map<String,ct[]> studentct = (HashMap<String, ct[]>) ofile.readObject() ;
            Map<String,ct[]> teacherct = (HashMap<String, ct[]>) ofile.readObject() ;
            Map<String,ct[]> teacherinvigilationct = (HashMap<String, ct[]>) ofile.readObject() ;
            ofile.close();
            System.out.println("Read hashmaps from file....");
            oos.writeObject(user);
            oos.writeObject(student);
            oos.writeObject(teacher);
            oos.writeObject(studentct);
            oos.writeObject(teacherct);
            oos.writeObject(teacherinvigilationct);
            System.out.println("Written hashmaps to socket....");
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                oos.close();
                oin.close();
                //System.out.println("connection terminated....");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
 
        }
        
    }
    
}
