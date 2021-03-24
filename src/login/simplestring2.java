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
public class simplestring2 {
         
    
        public  SimpleStringProperty Date;
        public SimpleStringProperty Sub;
        public SimpleStringProperty Roomno;
        String room1 ;
        public String req;
        public simplestring2(String date, int room)
        {
            this.Date = new SimpleStringProperty(date) ;
            this.req = date ;
            if(room/10 == 812)
            {
                if(room%10 == 1)
                    room1 = String.valueOf(room/10)+"A" ;
                else if( room % 10 == 2)
                    room1 = String.valueOf(room/10) + "B" ;
                else
                    room1 = String.valueOf(room/10) + "C" ;    
            }
            else
                room1 = String.valueOf(room) ;
            this.Roomno = new SimpleStringProperty(room1) ;
        }
        
         public StringProperty DateProperty()
        {
            return this.Date ;
        }
        
         public StringProperty RoomProperty()
         {
             return this.Roomno ;
         }
    
}
