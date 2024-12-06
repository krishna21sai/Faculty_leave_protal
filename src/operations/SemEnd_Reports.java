package operations;
import java.sql.ResultSet;

import model.DataManager;
import beans.*;

public class SemEnd_Reports {
	public int update(SemEndReports s1,DataManager db,String name,String sem,String batch)
	{
		

		
	System.out.println("chetan");	
	String str="update aeps"+batch+".student_details_"+sem+" set counsellor_report='"+s1.getReoprt()+"',counsellor_suggestions='"+s1.getSuggestions()+
	"',sem_student_rating="+s1.getStudent_rating()+",sem_counsellor_rating="+s1.getCouncellor_rating()+
	",health_height='"+s1.getHeight()+"',health_weight='"+s1.getWeight()+
	"',health_eyesight='"+s1.getEyesight()+"',health_abnormal='"+s1.getAbnormal()+
	"',health_report='"+s1.getAcademic_development()+
	"',academic_development='"+s1.getAcademicdevelopment()+
	"' where registerno='"+name+"'";     
	System.out.println(s1.getAcademic_development());
boolean t=db.operation(str,"update");
		
		System.out.println(db);
		System.out.println(t);
		System.out.println(db.getErrorMessage());
		//System.out.println(t);
		 if(t)
			 return 1;
		return 0;
		
	}
	public int select(SemEndReports e,DataManager db,String name,String sem,String batch)
	{
		String st="select counsellor_report,counsellor_suggestions,sem_student_rating,sem_counsellor_rating,academic_development,health_height,health_weight,health_eyesight,health_abnormal,health_report"+
				" from aeps"+batch+".student_details_"+sem+" where registerno='"+name+"'";
	        boolean r=db.operation(st,"select");
	        System.out.println(db.getErrorMessage());
	        System.out.println(r);
		    if(r)
		    {
		    	try
		    	{
		    		ResultSet rs=db.getResultSet();
				  
				    e.setReoprt(rs.getString("counsellor_report"));
				    e.setSuggestions(rs.getString("counsellor_suggestions"));
				    e.setStudent_rating(rs.getInt("sem_student_rating"));
				    e.setCouncellor_rating(rs.getInt("sem_counsellor_rating"));
				    e.setAcademicdevelopment(rs.getString("academic_development"));
				    e.setHeight(rs.getString("health_height"));
				    e.setWeight(rs.getString("health_weight"));
				    e.setEyesight(rs.getString("health_eyesight"));
				    e.setAbnormal(rs.getString("health_abnormal"));
				    e.setAcademic_development(rs.getString("health_report"));
				   
		    	   
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
