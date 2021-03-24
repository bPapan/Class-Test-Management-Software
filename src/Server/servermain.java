/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;

/**
 *
 * @author Abhik_Blaze
 */
public class servermain implements java.io.Serializable {
    
    public static void main(String[] args) {
        
        
        try(ServerSocket ss = new ServerSocket(5050) )
        {
            System.out.println("Server started.....");
           while(true)
           {
               
               new serverthread(ss.accept()) ;
               System.out.println("New client connected....");
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
