package operations;

import java.sql.ResultSet;

import beans.*;
import model.DataManager;
public class parent_observe

{

		
	public int insertRating(Student s,DataManager db,ParentObservation po,String sem,String batch)
	{
		
	
		String st="insert into aeps"+batch+".parent_observation_"+sem+" values('"+s.getRegisterno()+"','"+po.getBeh_elders()+"','"+po.getBeh_friends()+"','"+po.getBeh_working()+"','"+po.getHealth()+"','"+po.getConfidence_level()+"','"+po.getComm_skills()+"')";
		
		boolean t=db.operation(st, "insert");
		System.out.println(db);
		System.out.println(t);
		System.out.println(db.getErrorMessage());
		 if(t)
			 return 1;
		 else
			{
				System.out.println(db.getErrorMessage());
				return 0;
			}
				
		}	 // To update the parentObservation Data into DB :: End

	public int updateRating(Student s,DataManager db,ParentObservation po,String sem,String batch)
	{
		
	
		String st="update aeps"+batch+".parent_observation_"+sem+" set beh_elders ='"+po.getBeh_elders()+"',beh_friends='"+po.getBeh_friends()+"',beh_working='"+po.getBeh_working()+"',health='"+po.getHealth()+"',confidence_level='"+po.getConfidence_level()+"',comm_skills='"+po.getComm_skills()+
"' where registerno='"+s.getRegisterno()+"'";
		boolean t=db.operation(st, "insert");
		System.out.println(db);
		System.out.println(t);
		System.out.println(db.getErrorMessage());
		 if(t)
			 return 1;
		 else
			{
				System.out.println(db.getErrorMessage());
				return 0;
			}
				
		}	 // To update the parentObservation Data into DB :: End
	
	
	
	public int previousPoData(Student s,DataManager db,ParentObservation po,String sem,String batch)  // To get Previous Events data :: Start
	{
		
	 
		String query="select beh_elders,beh_friends,beh_working,health,confidence_level,comm_skills from aeps"+batch+".parent_observation_"+sem+" where registerno='"+s.getRegisterno()+"'";
		boolean r=db.operation(query,"select");
		if(r)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				if(rs.next())
				{
					po.setBeh_elders(rs.getString("beh_elders"));
					po.setBeh_friends(rs.getString("beh_friends"));
					po.setBeh_working(rs.getString("beh_working"));
				    po.setHealth(rs.getString("health"));
					po.setConfidence_level(rs.getString("confidence_level"));
					po.setComm_skills(rs.getString("comm_skills"));
					
				}			
		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			 
			return 1;
		}
		else
		{
			System.out.println(db.getErrorMessage());
			return 0;
		}
	
	}	 // To get Previous Events data :: Start
	
	
}
