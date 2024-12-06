package operations;

import java.sql.ResultSet;

import beans.Student;
import beans.StudentEvents;
import model.DataManager;

public class EventsProcess {
	
	
	public boolean insertEvents(Student s, DataManager db,StudentEvents es,String batch,int cy,int cs) // To insert the Events Data into DB :: Start
	{
		System.out.println(cy+" cy");
		System.out.println(cs+" cs");
		String query="",dummy;
		dummy="select fest_name,prize from aeps"+batch+".student_events where registerno='"+s.getRegisterno()+"' and event_name='"+es.getEvent_name()+"' and event_date='"+es.getEvent_date()+"'";
		boolean dummy_exec=db.operation(dummy,"select");
		System.out.println("Dummy exec"+db.getErrorMessage());
		if(dummy_exec)
		{
			System.out.println("in Dummy ");
			query="update aeps"+batch+".student_events set fest_name='"+es.getFest_name()+"',college_name='"+es.getCollege_name()+"',college_loc='"+es.getCollege_loc()+"',prize='"+es.getPrize()+"',prize_year="+cy+",sem='"+cs+"' where registerno='"+s.getRegisterno()+"' and event_name='"+es.getEvent_name()+"' and event_date='"+es.getEvent_date()+"'";
		}
		else
		{
		query="insert into aeps"+batch+".student_events values('"+s.getRegisterno()+"','"+es.getEvent_name()+"','"+es.getEvent_date()+"','"+es.getFest_name()+"','"+es.getCollege_name()+"','"+es.getCollege_loc()+"','"+es.getPrize()+"','"+cy+"','"+cs+"')";
		}
		boolean t=db.operation(query,"Insert");
		System.out.println(t+" Insert");
		if(t)
			return true;
		
		else
		{
			System.out.println(db.getErrorMessage());
			return false;
		}
			
	}	 // To insert the Events Data into DB :: End

	
	public boolean previousEventData(Student s, DataManager db,StudentEvents es,String batch,int tempyear,int tempsem)  // To get Previous Events data :: Start
	{
		int i=0;
		String enam[]=new String[100];
		String edate[]=new String[100];
		String efest[]=new String[100];
		String ecname[]=new String[100];
		String ecloc[]=new String[100];
		String eprize[]=new String[100];
		String eyear[]=new String[100];
		String esem[]=new String[100];
		
		String query="select event_name,event_date,fest_name,college_name,college_loc,prize,prize_year,sem from aeps"+batch+".student_events where registerno='"+s.getRegisterno()+"' and prize_year='"+tempyear+"' and sem='"+tempsem+"'";
		boolean t=db.operation(query,"select");
		System.out.println(db.getErrorMessage());
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				while(rs.next())
				{
					
					enam[i]=rs.getString("event_name");
					edate[i]=rs.getString("event_date");
					efest[i]=rs.getString("fest_name");
					ecname[i]=rs.getString("college_name");
					ecloc[i]=rs.getString("college_loc");
					eprize[i]=rs.getString("prize");
					eyear[i]=rs.getString("prize_year");
					esem[i]=rs.getString("sem");
					i++;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			es.setEname(enam);
			es.setEdate(edate);
			es.setFname(efest);
			es.setCname(ecname);
			es.setLoc(ecloc);
			es.setEprize(eprize);
			es.setEyear(eyear);
			es.setEsem(esem);
			return true;
		}
		else
		{
			System.out.println("fg dhgf hdg f"+db.getErrorMessage());
			return false;
		}
	
	}	 // To get Previous Events data :: Start
	
	
}
