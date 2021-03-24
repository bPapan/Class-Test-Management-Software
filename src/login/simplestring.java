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
public class simplestring {

         public  SimpleStringProperty Date;
         public SimpleStringProperty Sub;
          public SimpleStringProperty Ct;

          public simplestring(String date, String sub_code, int ctno) {
            this.Date = new SimpleStringProperty(date);
            //System.out.println(Date);
            this.Sub = new SimpleStringProperty(sub_code);
            this.Ct = new SimpleStringProperty(String.valueOf(ctno));
        }

        public String getdate() {
            return Date.get();
        }

        public void setdate(String ndate) {
            Date.set(ndate);
        }

        public String getsub_code() {
            return Sub.get();
        }

        public void setLastName(String nsub_code) {
            Sub.set(nsub_code);
        }

        public String getctno() {
            return Ct.get();
        }

        public void setctno(String nctno) {
            Ct.set(nctno);
        }
        public StringProperty DateProperty()
        {
            return this.Date ;
        }
        public StringProperty SubProperty()
        {
            return this.Sub ;
        }
        public StringProperty CtProperty()
        {
            return this.Ct ;
        }
        
    }