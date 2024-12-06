package operations;

import java.sql.ResultSet;

import model.DataManager;
import beans.emotional;

public class emotional_insert 
{
	public int update(emotional e,DataManager db,String name,String sem,String batch)
	{
		String st="update aeps"+batch+".student_details_"+sem+" set communication_skills="+e.getCommunication_skills()+",beh_with_others="+e.getBeh_with_others()+
				",teamspirit="+e.getTeamspirit()+",creativity="+e.getCreativity()+
				",leadeship="+e.getLeadership()+",negative_thinking="+e.getNegative_thinking()+
				",regularity="+e.getRegularity()+",dresscode="+e.getDresscode()+
				",general_aptitude="+e.getGeneral_aptitude()+
				",beh_aggressive="+e.getBeh_aggressive()+",beh_dull="+e.getBeh_dull()+
				",extrovert="+e.getExtrovert()+",introvert="+e.getIntrovert()+
				" where registerno='"+name+"'";                  
		boolean t=db.operation(st,"update");
		System.out.println(t); 
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
		String st="select communication_skills,beh_with_others,teamspirit,creativity,leadeship,negative_thinking,regularity,"+
				"dresscode,general_aptitude,beh_aggressive,beh_dull,extrovert,introvert"+
				" from aeps"+batch+".student_details_"+sem+" where registerno='"+name+"'";
	        boolean r=db.operation(st,"select");
	        System.out.println(db.getErrorMessage());
	        System.out.println(r);
		    if(r)
		    {
		    	try
		    	{
		    		ResultSet rs=db.getResultSet();
				    
				    e.setCommunication_skills(rs.getInt("communication_skills"));
				    e.setBeh_with_others(rs.getInt("beh_with_others"));
				    e.setTeamspirit(rs.getInt("teamspirit"));
				    e.setCreativity(rs.getInt("creativity"));
				    e.setLeadership(rs.getInt("leadeship"));
				    e.setNegative_thinking(rs.getInt("negative_thinking"));
				    e.setRegularity(rs.getInt("regularity"));
				    e.setDresscode(rs.getInt("dresscode"));
				    e.setGeneral_aptitude(rs.getInt("general_aptitude"));
				    e.setBeh_aggressive(rs.getInt("beh_aggressive"));
				    e.setBeh_dull(rs.getInt("beh_dull"));
				    e.setExtrovert(rs.getInt("extrovert"));
				    e.setIntrovert(rs.getInt("introvert"));
			
		    	   
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
