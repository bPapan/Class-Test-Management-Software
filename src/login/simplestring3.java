/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Abhik_Blaze
 */
public class simplestring3 {
    public  SimpleStringProperty Roll1;
     public  SimpleStringProperty Roll2;
      public  SimpleStringProperty Roll3;
       public  SimpleStringProperty Roll4;
       
       String change ;
       int rollno ;
       String actual ;
    
    public simplestring3(String roll)
    {
        this.Roll1 = new SimpleStringProperty(roll);
        
        this.Roll2 = new SimpleStringProperty(roll);
        //rollno = Integer.parseInt(roll.substring(4)) ;
        //rollno+=9;
        //actual = change + String.valueOf(rollno);
        change = roll.substring(0, 4) ;
        rollno = Integer.parseInt(roll.substring(4)) ;
        rollno+=8;
        if(rollno>=10 && rollno<= 99)
            actual = change +"0"+ String.valueOf(rollno);
        else if(rollno<10)
            actual = change + "00" + String.valueOf(rollno);
        else
            actual = change + String.valueOf(rollno) ;
        this.Roll3 = new SimpleStringProperty(actual);
        //rollno = Integer.parseInt(roll.substring(4)) ;
        //rollno+=9;
        //actual = change + String.valueOf(rollno);
        this.Roll4 = new SimpleStringProperty(roll);
    }
    public StringProperty Roll1Property()
        {
            return this.Roll1 ;
        }
     public StringProperty Roll2Property()
        {
            return this.Roll2 ;
        }
      public StringProperty Roll3Property()
        {
            return this.Roll3 ;
        }
       public StringProperty Roll4Property()
        {
            return this.Roll4 ;
        }



    
}
