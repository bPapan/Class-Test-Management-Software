/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.routinegenarator;

/**
 *
 * @author Abhik_Blaze
 */
import java.io.Serializable;

public class course implements Serializable
	{
		public String sub_code ;
		public int level ;
		public int term ;
		public int ct_count = 0 ;
		public int credit ;
		public int rooms[][] = new int[credit + 1][4]; 
		public time t[] ;
		public int total_course ;
		public int obj_set = 0 ;
		public level_term obj ;
                public int printer = 0 ;
		course(int level,int term, String sub_code, int credit)
		{
			this.level = level ;
			this.term = term ;
			this.sub_code = sub_code ;
			//this.total_course = total_course ;
                        this.credit = credit ;
			//this.obj = obj ;
                        t = new time[credit+1] ;
		
		}

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        String s = "level:"+ level + " term: "+ term + " sub:"+ sub_code + " credit:" + credit + " totalcourse:" + total_course ;
        return s ;
    }
                
		
		
		
	}
