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
public class time implements java.io.Serializable {
    
                int week ;
		int day ;
		int max_ct = 0 ;
		String date ;
		int rooms[] = { 802, 803 , 804 , 805, 8121, 8122 , 8123 , 8124 } ;
		int section_in_room[] = new int [8] ;
		course c[] = new course[4] ;
		
		
		time( int week , int day , String date)
		{
			this.week = week ;
			this.day = day ;
			this.date = date ;
			
		}

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        String s = "Week:"+week + " day:" + day + " date:" + date ;
        return s ;
        
    }
               
    
    
}
