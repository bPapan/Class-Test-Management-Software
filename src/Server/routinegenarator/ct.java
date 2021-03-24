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
public class ct implements java.io.Serializable{
    
                public String sub_code ;
		public int level ;
		public int term ;
		//int ct_count = 0 ;
                public int ct_num = 0 ;
		public int credit ;
                public String position = null ;
		//int rooms[][] = new int[credit + 1][4]; 
                public int room[] = new int [4] ;
		//time t[] = new time[ credit + 1 ];
                public slot s ;
		public int total_course ;
		public int obj_set = 0 ;
		public level_term obj ;
                public int printer = 0 ;
		ct(int level,int term, String sub_code, int credit , int ct_num)
		{
			this.level = level ;
			this.term = term ;
			this.sub_code = sub_code ;
			//this.total_course = total_course ;
                        this.ct_num = ct_num ;
                        //this.s = s ;
			//this.obj = obj ;
		
		}

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        
         String s = "level:"+ level + " term: "+ term + " sub:"+ sub_code + " credit:" + credit + " ct_num:" + ct_num ;
        return s ;
        
    }
                

}
