package operations;

import java.sql.ResultSet;

import beans.*;
import model.DataManager;
public class Career_development

{

	
	
	public int insert(CareerDevelopment c,DataManager db,Student s,String sem,String batch,String h) //Inserting Other Courses Details :: Start
	{
		
	//	 System.out.println(c.getPrograms());
		// System.out.println(c.getTimings());
		 //System.out.println(c.getProgram_type());
		 
		 
		String st="insert into aeps"+batch+".career_develop_"+sem+" values('"+s.getRegisterno()+"','"+c.getPrograms()+"','"+c.getProgram_type()+"','"+c.getTimings()+"',"+c.getHours_week()+",'"+h+"')";                   
		boolean t=db.operation(st,"insert");
		System.out.println(db);
		System.out.println(t);
		System.out.println(db.getErrorMessage());
		 if(t)
			 return 1;
		return 0;
		
		}  //Inserting Other Courses Details :: End
	
	
	
	
	public boolean previousdata(CareerDevelopment c,DataManager db,Student s,String sem,String batch)   //To get Previous Other Courses Details :: Start
	{
		int i=0;

		String programs[]=new String[30];
		String[] type=new String[30];
		int weeklyhours[]=new int[30];
		String  timings[]=new String[30];
		 
		String query="select programs,program_type,timings,hours_week from aeps"+batch+".career_develop_"+sem+" where registerno='"+s.getRegisterno()+"' and study_or_job='higher'";
		boolean t=db.operation(query,"select");
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				while(rs.next())
				{
				programs[i]=rs.getString("programs");
				type[i]=rs.getString("program_type");
				timings[i]=rs.getString("timings");
				weeklyhours[i]=rs.getInt("hours_week");
				i++;	
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			c.setProgram(programs);
			c.setType(type);
			c.setTiming(timings);
			c.setWeeklyhours(weeklyhours);
			
			return true;
		}
		else
		{
			System.out.println(db.getErrorMessage());
			return false;
		}
	}	   //To get Previous Other Courses Details :: Start
	
	
	
	public int jobinsert(CareerDevelopment c,DataManager db,Student s,String sem,String batch,String h) //Inserting Other Courses Details :: Start
	{
		
	//	 System.out.println(c.getPrograms());
		// System.out.println(c.getTimings());
		 //System.out.println(c.getProgram_type());
		 
		 
		String st="insert into aeps"+batch+".career_develop_"+sem+" values('"+s.getRegisterno()+"','"+c.getPrograms()+"','"+c.getProgram_type()+"','"+c.getTimings()+"',"+c.getHours_week()+",'"+h+"')";                   
		boolean t=db.operation(st,"insert");
		System.out.println(db);
		System.out.println(t);
		System.out.println(db.getErrorMessage());
		 if(t)
			 return 1;
		return 0;
		
		}
	
	
	
	
	
	
	public boolean jobpreviousdata(CareerDevelopment c,DataManager db,Student s,String sem,String batch)   //To get Previous Other Courses Details :: Start
	{
		int i=0;

		String programs[]=new String[30];
		String[] type=new String[30];
		int weeklyhours[]=new int[30];
		String  timings[]=new String[30];
		 
		String query="select programs,program_type,timings,hours_week from aeps"+batch+".career_develop_"+sem+" where registerno='"+s.getRegisterno()+"' and study_or_job='job'";
		boolean t=db.operation(query,"select");
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				while(rs.next())
				{
				programs[i]=rs.getString("programs");
				type[i]=rs.getString("program_type");
				timings[i]=rs.getString("timings");
				weeklyhours[i]=rs.getInt("hours_week");
				i++;	
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			c.setProgram(programs);
			c.setType(type);
			c.setTiming(timings);
			c.setWeeklyhours(weeklyhours);
			
			return true;
		}
		else
		{
			System.out.println(db.getErrorMessage());
			return false;
		}
	}	   //To get Previous Other Courses Details :: Start
	
	
	
	
	
}
	
	
	