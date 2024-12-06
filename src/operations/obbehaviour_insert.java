package operations;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DataManager;
import beans.emotional;

public class obbehaviour_insert
{
	public int update(emotional e,DataManager db,String name,String sem,String batch)
	{
		String st="update aeps"+batch+".student_details_"+sem+" set lang_class_teacher="+e.getLang_class_teacher()+",lang_outside_teacher="+e.getLang_outside_teacher()+
				",lang_campus_friends="+e.getLang_campus_friends()+",beh_class="+e.getBeh_class()+
				",beh_outside="+e.getBeh_outside()+",beh_out_campus="+e.getBeh_out_campus()+
				",beh_opposite_gen='"+e.getBeh_opposite_gen()+"',group_attitude='"+e.getGroup_attitude()+
				"',abnormal_beh='"+e.getAbnormal_beh()+
				"' where registerno='"+name+"'";                  
		boolean t=db.operation(st,"update");
		 if(t)
		 {
			 return 1;
		 }
		 else
		 {
			 System.out.println(db.getErrorMessage());
			 return 0;	 
		 }
			 
		
	}
	
	public int select(emotional e,DataManager db,String name,String sem,String batch)
	{
		String st="select lang_class_teacher,lang_outside_teacher,lang_campus_friends,beh_class,beh_outside,"+
				"beh_out_campus,beh_opposite_gen,group_attitude,abnormal_beh"+
				" from aeps"+batch+".student_details_"+sem+" where registerno='"+name+"'";
	        boolean r=db.operation(st,"select");
	        System.out.println(db.getErrorMessage());
	        System.out.println(r);
		    if(r)
		    {
		    	try
		    	{
		    		ResultSet rs=db.getResultSet();
				  
				    e.setLang_class_teacher(rs.getInt("lang_class_teacher"));
				    e.setLang_outside_teacher(rs.getInt("lang_outside_teacher"));
				    e.setLang_campus_friends(rs.getInt("lang_campus_friends"));
				    e.setBeh_class(rs.getInt("beh_class"));
				    e.setBeh_outside(rs.getInt("beh_outside"));
				    e.setBeh_out_campus(rs.getInt("beh_out_campus"));
				    e.setBeh_opposite_gen(rs.getString("beh_opposite_gen"));
				    e.setGroup_attitude(rs.getString("group_attitude"));
				    e.setAbnormal_beh(rs.getString("abnormal_beh"));
				   
		    	   
		    	}
		    	catch(Exception ex)
		    	{
		    		
		    	}
		    	 return 1; 
		    }
		    else
		    {
		    	
		        return 0;
		    }
	    
	}

         public int check(String name,DataManager db,String sem,String batch) 
         {
             String st="select registerno"+" from aeps"+batch+".student_details_"+sem+" where registerno='"+name+"'";
             db.operation(st,"select");
         	ResultSet rs=db.getResultSet();
            try
            {
         	       if(rs.getString("registerno")!=null)
                   {
            	          return 1;
                   } 
         	      
            }
            catch(Exception e)
            {
            	
            	
            }
            
            return 0;
         }
}