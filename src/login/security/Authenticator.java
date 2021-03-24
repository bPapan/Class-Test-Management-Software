/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.security;

import java.util.HashMap;
import java.util.Map;
import login.Main;

public class Authenticator {
    static Main application;

    public Authenticator(Main application) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.application = application;
    }
    //private static final Map<String, String> USERS = new HashMap<>();
//    static {
//        USERS.put("abhik", "12345");
//    }
    public static boolean validate(String user, String password){
        String str[] = application.user_data.get(user);
        String validUserPassword = str[0];
        return validUserPassword != null && validUserPassword.equals(password);
    }
    
    public static String identity(String user)
    {
        String str[] = application.user_data.get(user);
        String identity = str[1] ;
        return identity ;
    }
    
    
}
