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
public class slot implements java.io.Serializable{
    
                public int week ;
		public int day ;
		//int max_ct = 0 ;
		public String date ;
                public int room[] = new int[4] ;
                public int slot_no = 0 ;
                public String teacher[] = new String[4] ;
		//int rooms[] = { 802, 803 , 804 , 805, 8121, 8122 , 8123 , 8124 } ;
		//int section_in_room[] = new int [8] ;
		//course c[] = new course[4] ;
		public ct ct ;
		
		slot( int week , int day , String date , int slot_no)
		{
			this.week = week ;
			this.day = day ;
			this.date = date ;
                        this.slot_no = slot_no ;
                        //this.ct = ct ;
			
		}

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        String s = "Week:"+week + " day:" + day + " date:" + date + " slot:" + slot_no ;
        return s ;
        
    }
    
}
