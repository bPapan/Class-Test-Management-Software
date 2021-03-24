/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.routinegenarator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Abhik_Blaze
 */
public class main implements java.io.Serializable{
    
    public static int coursecount = 0 ;
    public static int termcount  = 0;
    public static course c[] = new course[30] ;
    public static time t[] = new time[30] ;
    public static int timecount = 0 ;
    public static int slotcount = 0 ;
    public static int ctcount = 0 ;
    public static ct ct[] = new ct[140] ;
    public static slot s[] = new slot[140] ;
    public static int mark[][] ;
    public static String teachers[] = new String[30] ;
    public static int teachercount = 0 ;
    public static int currentteacher = 0 ;
    public static Map<String,String[]> user_data = new HashMap<>() ;
    public static Map<String,String[]> student_data = new HashMap<>() ;
    public static Map<String,String> teacher_data = new HashMap<>() ;
    public static String level_terminfo[] = new String[10] ;
    public static ct studentctinfo[][] = new ct[30][30] ;
    public static ct teacherctinfo[][] = new ct[30][30] ;
    public static ct teacherinvigilationinfo[][] = new ct[30][30] ;
    public static Map<String,ct[]> studentctarray = new HashMap<>() ;
    public static Map<String,ct[]> teacherctarray = new HashMap<>() ;
    public static Map<String,ct[]> teacherinvigilationarray = new HashMap<>() ;
    
    static void initializer() throws Exception
    {
        //URL url = main.class.getResource("")
        //File file = new File(getClass()) ;
        Scanner in = new Scanner(main.class.getResourceAsStream("/TextContent/course_data.txt")) ;
        //in.useDelimiter(",|;") ;
        for( int i = 0 ; i < 30 ; i++)
            for(int j = 0 ; j < 30 ; j++)
            {
                studentctinfo[i][j] = new ct(0, 0, null, 0, 0) ;
                teacherctinfo[i][j] = new ct(0, 0 , null , 0 , 0) ;
                teacherinvigilationinfo[i][j] = new ct(0 , 0 , null ,0 , 0);
            }
        while( in.hasNextLine() )
        {
            Scanner tmp = new Scanner(in.nextLine()) ;
            tmp.useDelimiter(",|;");
            c[coursecount] = new course( Integer.parseInt(tmp.next()) , Integer.parseInt(tmp.next()) , tmp.next() , Integer.parseInt(tmp.next())) ;
            if(termcount == 0)
            {
                level_terminfo[0] = String.valueOf(c[coursecount].level*10 + c[coursecount].term) ;
                termcount++;
            }
            else
            {
                int flag = 0 ;
                for( int i = 0 ; i < termcount ; i++)
                {
                    if(level_terminfo[i].equals(String.valueOf(c[coursecount].level*10 + c[coursecount].term)))
                        flag = 1 ;
                }
                if(flag == 0)
                    level_terminfo[termcount++] = String.valueOf(c[coursecount].level*10 + c[coursecount].term) ;
            }
            for( int i = 0 ; i < c[coursecount].credit + 1 ; i++)
            {
                ct[ctcount] = new ct(c[coursecount].level, c[coursecount].term ,c[coursecount].sub_code, c[coursecount].credit, i) ;
                ct[ctcount].s = new slot(0, 0, "hello", 0) ;
                ctcount++ ;
            }
            
            coursecount++ ;
            tmp.close();
        }
        for( int i = 0 ; i < coursecount; i++)
            for( int j = 0 ; j < c[i].credit + 1 ; j++)
             c[i].t[j] = new time(0, 0, "hello") ;
        in.close();
        //file = new File("/TextContent/Time_data.txt") ;
        in = new Scanner(main.class.getResourceAsStream("/TextContent/Time_data.txt")) ;
        for (int i = 3; i <= 12; i++)
            for (int j = 1; j <= 3; j++)
            {
                t[timecount] = new time(i, j,in.nextLine());
                for( int k = 0 ; k < 4 ; k++)
                {
                    s[slotcount] = new slot(t[timecount].week, t[timecount].day, t[timecount].date, k ) ;
                    s[slotcount].ct = new ct(0, 0, "hello", 0, 0) ;
                    slotcount++ ;
                }
                
                timecount++ ;
            }
        for( int i = 0 ; i < timecount ; i++)
            for( int j = 0 ; j < 4 ; j++)
                t[i].c[j] = new course(0, 0, "hello", 0) ;
        in.close();
        //file = new File("/TextContent/teacher_data.txt") ;
        in = new Scanner(main.class.getResourceAsStream("/TextContent/teacher_data.txt")) ;
	//in.useDelimiter(":|;") ;
        while( in.hasNextLine() )
        {
            Scanner tmp = new Scanner(in.nextLine()) ;
            tmp.useDelimiter(":|;");
            teachers[teachercount] = tmp.next() ;
            String unimportant = tmp.next() ;
            teachercount++ ;
            tmp.close();
        }
        in.close();
         
    }
    
    static boolean canAllot(ct ctnow , slot slot , int ctnum , int slotnum)
    {
        boolean b = true ;
        int room = - 1;
        int currentstate = 0 ;
        int flag = 0 ;
        int room802 = 0 ;
        int room8121 = 0 ;
        if( mark[slotnum][ctnum] == 1)
            {
                System.out.println("0");
                return false ;
            }
        if(s[slotnum].ct.level != 0)
        {
            //System.out.println("6");
            return false ;
        }
        for( int i = 0 ; i <= slotnum ; i++) // check the already alloted slots if they are the same date then check if already alloted 
        {                                    // cts has the level-term same as the current ct
            if(s[i].date.equals(slot.date))
            {
                if(s[i].ct.level == ctnow.level && s[i].ct.term == ctnow.term)
                {
                    //System.out.println("1");
                    return false ;
                }
                    
            }
            if(ctnow.ct_num != 0) // if its not the first ct of a course then check if its previous ct has been alloted
            {
                if(s[i].ct.ct_num == ctnow.ct_num - 1 && s[i].ct.sub_code.equals(ctnow.sub_code))
                {
                    flag = 1;
                    if((slot.week - s[i].week < 2 ) || ( (slot.week - s[i].week == 2 ) && (slot.day - s[i].day <= 0 ) ) ) //checking time constraints
                    {
                    //System.out.println("2");
                    return false ;
                    }
                }
            }
        }

        if(flag == 0 &&  ctnow.ct_num != 0 )
            return false ;
        //if(ctnow.ct_num == 0)
            for( int i = 0 ; i <= slotnum ; i++)
            {
                
                if(s[i].date.equals(slot.date))
                {
                    if(s[i].room[0] == 802)
                        room802++ ;
                    else if(s[i].room[0] == 8121)
                        room8121++ ;
                }
            }
            String pos = null ;
            for( int i = 0 ; i <= slotnum ; i++)
            {
                if(s[i].ct.level == ctnow.level && s[i].ct.term == ctnow.term)
                {
                    room = s[i].ct.room[0] ;
                    pos = s[i].ct.position ;
                    break ;
                }
            }
            
            for( int i = 0 ; i <= slotnum ; i++)
            {
                if(s[i].date.equals(slot.date))
                {
                    if(s[i].room[0] == room)
                        currentstate++ ;
                }
            }
            if(currentstate == 2)
                {
                    //System.out.println("3");
                    return false ;
                }
            else
            {
                if(room == 802)
                {
                    int counter = 0 ;
                    for(int i = 0 ; i <= slotnum ; i++)
                    {
                        if((s[i].date.equals(slot.date)) && (s[i].room[0] == 802))
                        {
                            slot.teacher[0] = s[i].teacher[0];
                            slot.teacher[1] = s[i].teacher[1];
                            slot.teacher[2] = s[i].teacher[2];
                            slot.teacher[3] = s[i].teacher[3];
                            slot.room[0] = 802 ;
                            slot.room[1] = 803 ;
                            slot.room[2] = 804 ;
                            slot.room[3] = 805 ;
                            counter = 1 ;
                            break;

                        }
                    }
                    if(counter == 0)
                    {
                        if(currentteacher == teachercount || currentteacher > teachercount - 5)
                        currentteacher = 0 ;
                    
                        slot.teacher[0] = teachers[currentteacher++];
                        slot.teacher[1] = teachers[currentteacher++];
                        slot.teacher[2] = teachers[currentteacher++];
                        slot.teacher[3] = teachers[currentteacher++];
                        slot.room[0] = 802 ;
                        slot.room[1] = 803 ;
                        slot.room[2] = 804 ;
                        slot.room[3] = 805 ;
                        
                    }
                    ctnow.room = slot.room ;
                    ctnow.position = pos ;
                    ctnow.s = slot ;
             
                    slot.ct = ctnow ;
                    return true ;
                    
                }
                else if( room == 8121)
                {
                    int counter = 0 ;
                    for(int i = 0 ; i <= slotnum ; i++)
                    {
                        if((s[i].date.equals(slot.date)) && (s[i].room[0] == 8121))
                        {
                            slot.teacher[0] = s[i].teacher[0];
                            slot.teacher[1] = s[i].teacher[1];
                            slot.teacher[2] = s[i].teacher[2];
                            slot.teacher[3] = s[i].teacher[3];
                            slot.room[0] = 8121 ;
                            slot.room[1] = 8122 ;
                            slot.room[2] = 8123 ;
                            slot.room[3] = 8124 ;
                            counter = 1 ;
                            break;

                        }
                    }
                    
                    
                    if(counter == 0)
                    {
                        if(currentteacher == teachercount || currentteacher > teachercount - 5)
                        currentteacher = 0 ;
                    
                        slot.teacher[0] = teachers[currentteacher++];
                        slot.teacher[1] = teachers[currentteacher++];
                        slot.teacher[2] = teachers[currentteacher++];
                        slot.teacher[3] = teachers[currentteacher++];
                        slot.room[0] = 8121 ;
                        slot.room[1] = 8122 ;
                        slot.room[2] = 8123 ;
                        slot.room[3] = 8124 ;

                    }
                    ctnow.room = slot.room ;
                    ctnow.position = pos ;
                    ctnow.s = slot ;
                    
                    slot.ct = ctnow ;
                    return true ;
                }
                else  ;
            }
             if( room == -1 )
            {
                if(room802 < 2)
                {
                    
                    int counter = 0 ;
                    for(int i = 0 ; i <= slotnum ; i++)
                    {
                        if((s[i].date.equals(slot.date)) && (s[i].room[0] == 802))
                        {
                            slot.teacher[0] = s[i].teacher[0];
                            slot.teacher[1] = s[i].teacher[1];
                            slot.teacher[2] = s[i].teacher[2];
                            slot.teacher[3] = s[i].teacher[3];
                            slot.room[0] = 802 ;
                            slot.room[1] = 803 ;
                            slot.room[2] = 804 ;
                            slot.room[3] = 805 ;
                            counter = 1 ;
                            break;

                        }
                    }
                    if(counter == 0)
                    {
                        if(currentteacher == teachercount || currentteacher > teachercount - 5)
                           currentteacher = 0 ;

                       slot.teacher[0] = teachers[currentteacher++];
                       slot.teacher[1] = teachers[currentteacher++];
                       slot.teacher[2] = teachers[currentteacher++];
                       slot.teacher[3] = teachers[currentteacher++];
                       slot.room[0] = 802 ;
                       slot.room[1] = 803 ;
                       slot.room[2] = 804 ;
                       slot.room[3] = 805 ;   
                    }
                    
                    ctnow.room = slot.room ;
                    
                    if(room802 == 0)
                        ctnow.position = "left" ;
                    else
                        ctnow.position = "right" ;
                    ctnow.s = slot ;
                    slot.ct = ctnow ;    
                    return true ;
                    
                }
                else if (room8121 < 2 )
                {
                    int counter = 0 ;
                    for(int i = 0 ; i <= slotnum ; i++)
                    {
                        if((s[i].date.equals(slot.date)) && (s[i].room[0] == 8121))
                        {
                            slot.teacher[0] = s[i].teacher[0];
                            slot.teacher[1] = s[i].teacher[1];
                            slot.teacher[2] = s[i].teacher[2];
                            slot.teacher[3] = s[i].teacher[3];
                            slot.room[0] = 8121 ;
                            slot.room[1] = 8122 ;
                            slot.room[2] = 8123 ;
                            slot.room[3] = 8124 ;
                            counter = 1 ;
                            break;

                        }
                    }
                    if(counter == 0)
                    {
                        if(currentteacher == teachercount || currentteacher > teachercount - 5)
                           currentteacher = 0 ;
                       slot.teacher[0] = teachers[currentteacher++];
                       slot.teacher[1] = teachers[currentteacher++];
                       slot.teacher[2] = teachers[currentteacher++];
                       slot.teacher[3] = teachers[currentteacher++];
                       slot.room[0] = 8121 ;
                       slot.room[1] = 8122 ;
                       slot.room[2] = 8123 ;
                       slot.room[3] = 8124 ;   
                    }
                    
                    ctnow.room = slot.room ;
                    
                    if(room8121 == 0)
                        ctnow.position = "left" ;
                    else
                        ctnow.position = "right" ;
                    ctnow.s = slot ;
                    slot.ct = ctnow ;
                    return true ;
                    
                }
                else 
                {
                     //System.out.println("4");
                    return false ;
                }
            }
           
            
        return b ;
    }
    
    static void deallot(ct ctnow , slot slot)
    {
        ctnow.room = new int[4] ;
        ctnow.s = new slot(0, 0, "hello", 0) ;
        slot.room = new int[4] ;
        slot.ct = new ct(0, 0, "hello", 0, 0) ;
        System.out.println("dealloting");
    }
    static boolean backtrack( int j )
    {
        try
        {
            int m ;
            if( j >= ctcount)
                return true ;
            for(  m = 0 ; m < slotcount ; m++)
            {
                if(canAllot(ct[j], s[m], j, m))
                {
                    mark[m][j] = 1 ;
                    //System.out.println(j);
                    if( backtrack(j + 1))
                        return true ;
                }

            }
            if(mark[m][j] == 1)
            {
                deallot(ct[j], s[m]) ;
                mark[m][j] = 0 ;
            }
        }catch(Exception e)
           {
                e.printStackTrace();
           }
        return false ;
    }
    
    static void hashmapcreator() throws Exception
    {
        //File file = new File("/TextContent/user_data.txt");
        Scanner in = new Scanner(main.class.getResourceAsStream("/TextContent/user_data.txt")) ;
        //in.useDelimiter(":|;");
        while(in.hasNextLine())
        {
            Scanner tmp = new Scanner(in.nextLine()) ;
            tmp.useDelimiter(":|;");
            String str ;
            String st[] = new String[2] ;
            str = tmp.next() ;
            st[0] = tmp.next() ;
            st[1] = tmp.next() ;
            user_data.put(str,st);
            tmp.close();
        }
        in.close();
        //file = new File("/TextContent/student_data.txt") ;
        in = new Scanner(main.class.getResourceAsStream("/TextContent/student_data.txt")) ;
        //in.useDelimiter(":|;") ;
        while(in.hasNextLine())
        {
            Scanner tmp = new Scanner(in.nextLine()) ;
            tmp.useDelimiter(":|;");
            String str ;
            String st[] = new String[2] ;
            str = tmp.next() ;
            st[0] = tmp.next() ;
            st[1] = tmp.next() ;
            student_data.put(str,st);
            tmp.close();
        }
        in.close();
        //file = new File("/TextContent/teacher_data.txt") ;
        in = new Scanner(main.class.getResourceAsStream("/TextContent/teacher_data.txt")) ;
        //in.useDelimiter(":|;") ;
        while(in.hasNextLine())
        {
            Scanner tmp = new Scanner(in.nextLine()) ;
            tmp.useDelimiter(":|;");
            String str ;
            String st ;
            str = tmp.next() ;
            st = tmp.next() ;
            teacher_data.put(str,st);
            tmp.close();
        }
        in.close();
        
        int count = 0 ;
        for(int i = 0 ; i < termcount ;i++)
        {
            for(int j = 0 ; j < ctcount ; j++)
            {
                if(level_terminfo[i].equals(String.valueOf(ct[j].level*10 + ct[j].term)))
                {
                    studentctinfo[i][count] = ct[j] ;
                    count++;
                }
            }
            count = 0 ;
            ct tmp ;
            for(int k = 0 ; studentctinfo[i][k].level!=0 ; k++)
                for(int l = k+1 ; studentctinfo[i][l].level!= 0 ; l++)
                {
                    if( (studentctinfo[i][l].s.week*10 + studentctinfo[i][l].s.day) < (studentctinfo[i][k].s.week*10 + studentctinfo[i][k].s.day) )
                    {
                        tmp = studentctinfo[i][l] ;
                        studentctinfo[i][l] = studentctinfo[i][k] ;
                        studentctinfo[i][k] = tmp ;
                    }
                }
            studentctarray.put(level_terminfo[i], studentctinfo[i]) ;
        }
        count = 0 ;
        for( int i = 0 ; i < teachercount ; i++)
        {
            for( int j = 0 ; j < ctcount ; j++)
            {
                if( teacher_data.get(teachers[i]).equals(ct[j].sub_code))
                {
                    teacherctinfo[i][count] = ct[j] ;
                    count++;
                }
            }
            count = 0 ;
            teacherctarray.put(teachers[i], teacherctinfo[i]) ;
        }
        count = 0 ;
        for( int i = 0 ; i < teachercount ; i++)
        {
            for( int j = 0 ; j < ctcount ; j++)
            {
                if(teachers[i].equals(ct[j].s.teacher[0]) || teachers[i].equals(ct[j].s.teacher[1]) || teachers[i].equals(ct[j].s.teacher[2])|| teachers[i].equals(ct[j].s.teacher[3])       )
                {
                    teacherinvigilationinfo[i][count] = ct[j] ;
                    count++;
                }    
            }
            ct tmp1;
            for(int k = 0 ; teacherinvigilationinfo[i][k].level!=0 ; k++)
                for(int l = k+1 ; teacherinvigilationinfo[i][l].level!= 0 ; l++)
                {
                    if( (teacherinvigilationinfo[i][l].s.week*10 + teacherinvigilationinfo[i][l].s.day) < (teacherinvigilationinfo[i][k].s.week*10 + teacherinvigilationinfo[i][k].s.day) )
                    {
                        tmp1 = teacherinvigilationinfo[i][l] ;
                        teacherinvigilationinfo[i][l] = teacherinvigilationinfo[i][k] ;
                        teacherinvigilationinfo[i][k] = tmp1 ;
                    }
                }
            count = 0 ;
            teacherinvigilationarray.put(teachers[i], teacherinvigilationinfo[i]) ;
        }
        
        
        
    }
    
    static void hashmapwriter() throws Exception
    {
        String filePath = new File("").getAbsolutePath();
        //File file = new File("src/TextContent/data.dat") ;
        //URL url = main.class.getResource("/TextContent/data.dat");
        // File file = new File(url.getPath()) ;
        if(!filePath.endsWith("src"))
            filePath+="/src" ;
        FileOutputStream fout = new FileOutputStream(filePath + "/TextContent/data.dat") ;
        ObjectOutputStream oos = new ObjectOutputStream(fout) ;
        oos.writeObject(user_data);
        oos.writeObject(student_data);
        oos.writeObject(teacher_data);
        oos.writeObject(studentctarray);
        oos.writeObject(teacherctarray);
        oos.writeObject(teacherinvigilationarray);
        oos.close();
        
    }
    static void hashmapreader() throws Exception
    {
        //URL url = main.class.getResource("/TextContent/data.dat");
        //File file = new File(url.getPath()) ;
        //File file = new File("src/TextContent/data.dat") ;
        InputStream in = main.class.getResourceAsStream("/TextContent/data.dat") ;
        //FileInputStream fin = new FileInputStream(file) ;
        ObjectInputStream oin = new ObjectInputStream(in) ;
        Map<String,String[]>user = (HashMap<String, String[]>)oin.readObject() ;
        Map<String,String[]>student = (HashMap<String, String[]>)oin.readObject() ;
        Map<String,String>teacher = (HashMap<String, String>)oin.readObject() ;
        Map<String,ct[]> studentct = (HashMap<String, ct[]>) oin.readObject() ;
        Map<String,ct[]> teacherct = (HashMap<String, ct[]>) oin.readObject() ;
        Map<String,ct[]> teacherinvigilationct = (HashMap<String, ct[]>) oin.readObject() ;
        oin.close();
        //ct test[] =studentct.get("31") ;
       // System.out.println(test);
//        String st[] = user.get("abhik bhattacharjee") ;
//        System.out.println(st[0]);
//        if(test.equals(null))
//            System.out.println("NO success");
//        else
//            for( int i = 0 ; test[i].level != 0 ; i++) ;
//                //System.out.println(test[i]);
  
    }
    public static void main( String args[] ) throws Exception
    {
        initializer();
        mark = new int[slotcount][ctcount] ;
        
        try{
             
            
            if( backtrack(0))
                {
                   //backtrack(0) ;
                   for( int i = 0 ; i < slotcount ; i++)
                       System.out.println("Week: "+ s[i].week + " day:"+s[i].day + " Date:"+ s[i].date + " level:"+s[i].ct.level + " term:" + s[i].ct.term + " sub:" + s[i].ct.sub_code + " ctnum:" + (++s[i].ct.ct_num  ) + " rooms:" + s[i].ct.room[0] + "," + s[i].ct.room[1] +","+s[i].ct.room[2]+","+s[i].ct.room[3] + " pos:" + s[i].ct.position+" teachers:"+s[i].teacher[0] + ","+s[i].teacher[1] + ","+s[i].teacher[2] + ","+s[i].teacher[3] );

               }
            else
                System.out.println("Impossibe to allot");
       
        }catch(Exception e)
        {
            System.out.println("Impossibe to allot");
        }
        
        
        
        hashmapcreator();
        hashmapwriter();
        hashmapreader();
//        String st[] = user_data.get("abhik bhattacharjee") ;
//        System.out.println(st[0]);
//        for( int i = 0 ; i < termcount ; i++)
//            System.out.println(level_terminfo[i]);
        //ct test[];
        //test = studentctarray.get("31") ;
        //test = teacherctarray.get("teacher1");
        //System.out.println(test);
//        for( int i = 0 ; test[i].level != 0 ; i++)
//            System.out.println(test[i]);
//  
        
        
        
    }

}
