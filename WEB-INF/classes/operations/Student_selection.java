package operations;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DataManager;
import beans.*;
public class Student_selection {

	public boolean result(Counselling cs,DataManager db)  //To select Students for a given Faculty :: start
	
	{
		String a[]=new String[200];
		String query="select registerno from student_master.student_faculty1 where empcode='"+cs.getEmpcode()+"'";
		boolean t=db.operation(query,"select" );
		System.out.println(t);
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				int i=0;
				while(rs.next())	
				{
					a[i]=rs.getString("registerno");
					i++;
		
				}
				
				
			}
			
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
			
			
			cs.setStudents(a);
			 
			
		return true;
		}
		else
		{
		return false;
		}
		
	}	//To select Students for a given Faculty :: End
	
	
	public boolean getBatchno(Student register,DataManager db) //To return Batch Number :: start
	{
	
		String query="select batchno from student_master.financestudent where registerno='"+register.getRegisterno()+"'";
		
		boolean t=db.operation(query,"select" );
		System.out.println(db.getErrorMessage());
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				rs.next();
				int k=Integer.parseInt(rs.getString("batchno"));
				int j=k+4;
				String batch=k+"-"+j;
				System.out.println(batch);
				String start = batch.substring(2,4);
				String en = batch.substring(5);
				String end=en.substring(2);
				String Batch=start+"_"+end;
				register.setBatchno(Batch);
				System.out.println(Batch);
			
			}
		
			catch(Exception e)
			{
				System.out.println(e);
			}
			return true;
	
		}
		else
		{
			return false;
		}
							
	} // End Of Batch Number
	

	public boolean getPreviousWeeks(Student register,DataManager db,String batch,String sem,Previous_counselling pc)	//To get Previous week Data :: start 
	{
		String problems[]=new String[30];
		String[] suggestions=new String[30];
		int counselling_week[]=new int[30];
		String  title[]=new String[30];
		String days[]=new String[30];
		int i=0;
		String query="select counselling_week,title,problems,suggestions,date from aeps"+batch+".counselling_"+sem+" where registerno='"+register.getRegisterno()+"'";
		boolean t=db.operation(query,"select");
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				while(rs.next())
				{
					counselling_week[i]=rs.getInt("counselling_week");
					title[i]=rs.getString("title");
					problems[i]=rs.getString("problems");
					suggestions[i]=rs.getString("suggestions");
					days[i]=rs.getString("date");
					i++;
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		 
			pc.setCounselling_week(counselling_week);
			pc.setTitle(title);
			pc.setProblems(problems);
			pc.setSuggestions(suggestions);
			pc.setDays(days);
			return true;
		}
		else
		{
			System.out.println(db.getErrorMessage());
			return false;
		}
	
	}	////To get Previous week Data :: End
	
	
	public boolean presentCounselling(Student register,DataManager db,String batch,String sem,Counselling c)   //TO Insert Counselling Attributes :: Start
	{
		String query="";
		String dummy="select title from aeps"+batch+".counselling_"+sem+" where registerno='"+register.getRegisterno()+"' and counselling_week="+c.getCounselling_week();
		boolean dummy_exec=db.operation(dummy,"select");
		System.out.println(db.getErrorMessage());
		System.out.println("dummy "+dummy_exec);
		if(dummy_exec)
		{
			query="update aeps"+batch+".counselling_"+sem+" set title='"+c.getTitle()+"',problems='"+c.getProblems()+"',suggestions='"+c.getSuggestions()+"',date='"+c.getDay()+"'  where registerno='"+register.getRegisterno()+"' and counselling_week="+c.getCounselling_week();
		}
		else
		{
		query="insert into aeps"+batch+".counselling_"+sem+" values('"+register.getRegisterno()+"',"+c.getCounselling_week()+",'"+c.getTitle()+"','"+c.getProblems()+"','"+c.getSuggestions()+"','"+c.getDay()+"')";
		}
		boolean t=db.operation(query,"insert");
		if(db.getEffectedRows()>0)
		{
			return true;
		}
		else
		{
			System.out.println(db.getErrorMessage());
			return false;
		}
		
	} //TO Insert Counselling Attributes :: End
	
	
	public boolean studentdetails(Student s,DataManager db) // to get Student from Student Master table Details :: start
	{
		String query="select name,landline,studentmobile,fathermobile,studentemailid,parentemailid from student_master.financestudent where registerno='"+s.getRegisterno()+"'";
		boolean t=db.operation(query,"select");
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				rs.next();
				s.setStudentmobile(rs.getString("studentmobile"));
				s.setName(rs.getString("name"));
				s.setFathermobile(rs.getString("fathermobile"));
				s.setLandline(rs.getString("landline"));
				s.setStudentemailid(rs.getString("studentemailid"));
				s.setFatheremailid(rs.getString("parentemailid"));
			}
			catch(Exception e)
			{
				
			}
		return true;
		}
		
		else
		{
			System.out.println(db.getErrorMessage());
			return false;	
		}
		
		
		
	}	 // to get Student from Student Master table Details :: End
	
	public boolean getBranches(DataManager db,branches bs)
	{
		int i=0;
		int id[]=new int[50];
		String names[]=new String[50];
		String query="SELECT * FROM vignan.department";
		if(db.operation(query,"select"))
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				while(rs.next())
				{
					id[i]=rs.getInt("deptid");
					names[i]=rs.getString("deptname");
					i++;
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			bs.setBrachids(id);
			bs.setBranch(names);
			return true;
		}
		return false;
	}
	
	
	
	
	
	public boolean studentsemPreviouslivingdata(Student s, DataManager db,String batch,String sem)	 // to get Details of student in present sem :: start
	{
		String query="select living_style,friend_registerno,friend_name,friend_contact,friend_branch,friend_college,friend_email,hostel_roomno,doorno,street,town,district,state,pin from aeps"+batch+".student_details_"+sem+" where registerno='"+s.getRegisterno()+"'";
		boolean t=db.operation(query,"select");
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				if(rs.next())
				{
					s.setLiving_style(rs.getString("living_style"));
					s.setFriend_registerno(rs.getString("friend_registerno"));
					s.setFriend_name(rs.getString("friend_name"));
					s.setFriend_contact(rs.getString("friend_contact"));
					s.setFriend_branch(rs.getString("friend_branch"));
					s.setFriend_college(rs.getString("friend_college"));
					s.setFriend_email(rs.getString("friend_email"));
					s.setRoomno(rs.getString("hostel_roomno"));
					s.setHouseno(rs.getString("doorno"));
					s.setStreet(rs.getString("street"));
					s.setTown(rs.getString("town"));
					s.setDistrict(rs.getString("district"));
					s.setState(rs.getString("state"));
					s.setPincode(rs.getString("pin"));
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return true;
		}
		else
		{
			System.out.println(db.getErrorMessage());
			return false;
		}
	}		 // to get Details of student in present sem :: End
	
	public boolean insertStudentsemDetails(Student s, DataManager db,String batch,String sem) // To Insert Semester Details :: Start
	{
		String dummy="select * from aeps"+batch+".student_details_"+sem+" where registerno='"+s.getRegisterno()+"'";
		boolean dumm_execute=db.operation(dummy,"select");
		System.out.println(dumm_execute+"cvhbh ");
		System.out.println(db.getErrorMessage());
		String query="";
		if(dumm_execute)
		{
			System.out.println(dumm_execute+"in Update");
			query="update aeps"+batch+".student_details_"+sem+" set living_style='"+s.getLiving_style()+"',friend_registerno='"+s.getFriend_registerno()+"',friend_name='"+s.getFriend_name()+"',friend_contact='"+s.getFriend_contact()+"',friend_branch='"+s.getFriend_branch()+"',friend_college='"+s.getFriend_college()+"',friend_email='"+s.getFriend_email()+"',hostel_roomno='"+s.getRoomno()+"',doorno='"+s.getHouseno()+"',street='"+s.getStreet()+"',town='"+s.getTown()+"',district='"+s.getDistrict()+"',state='"+s.getState()+"',pin='"+s.getPincode()+"' where registerno='"+s.getRegisterno()+"'";	
		}
		else
		{
		query="insert into aeps"+batch+".student_details_"+sem+" (registerno,living_style,friend_registerno,friend_name,friend_contact,friend_branch,friend_college,friend_email,hostel_roomno,doorno,street,town,district,state,pin) values('"+s.getRegisterno()+"','"+s.getLiving_style()+"','"+s.getFriend_registerno()+"','"+s.getFriend_name()+"','"+s.getFriend_contact()+"','"+s.getFriend_branch()+"','"+s.getFriend_college()+"','"+s.getFriend_email()+"','"+s.getRoomno()+"','"+s.getHouseno()+"','"+s.getStreet()+"','"+s.getTown()+"','"+s.getDistrict()+"','"+s.getState()+"','"+s.getPincode()+"')";
		}
		boolean t=db.operation(query,"insert");
		if(t)
		{
			return true;
		}
		else
		{
			System.out.println(db.getErrorMessage());
			return false;
			
		}
	}	// To Insert Semester Details :: End
	
	public int retrival(DataManager db,Student register) throws SQLException
	{
		boolean i;int s1=1,s2=1;
	
	
		String str="select cyear,semester from student_master.financestudent where registerno='"+register.getRegisterno()+"'";
		i=db.operation(str,"select");

		if(i)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				  
				
		         s1=rs.getInt("cyear");
		           s2=rs.getInt("semester");
		      
					
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			register.setCyear(s1);
			 register.setSemester(s2);
			
			return 1;
		}
		else
		{
			System.out.println(db.getErrorMessage());
			return 0;
		}
	 

}

	public String[] getSection(DataManager db,int y,int se,String course,String branch)
	{
		int i=0;
		String[] sec=new String[10];
		String query="select section from student_master.sections1 where coursecode='"+course+"' and branchcode='"+branch+"' and year='"+y+"' and semester='"+se+"'";
		boolean b=db.operation(query, "select");
		System.out.println(query);
		System.out.println(db.getErrorMessage());
		if(b)
		{
		try
		{
			ResultSet rs=db.getResultSet();
			rs.beforeFirst();
			while(rs.next())
			{
				System.out.println(rs.getString("section"));
				sec[i]=rs.getString("section");
				System.out.println(sec[i]);
				i++;
				
			}
		}  
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		}
		else
		{
			System.out.println(db.getErrorMessage());
		}
	
		return sec;
	}
	
	
	
	
}
