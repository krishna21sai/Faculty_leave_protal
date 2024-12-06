package operations;


import java.sql.ResultSet;

import beans.*;
import model.DataManager;

public class addstudentsreportdeo {
	public int select(DataManager db,int year,int sem,String sec,addstudentsdeo ad,String branch)
	{
		System.out.println(branch);
		String query="select s.registerno from student_master.student s where s.cyear="+year+" and s.semester="+sem+" and s.sectioncode='"+sec+"' and s.branchcode='"+branch+"' and s.registerno not in (select s1.registerno from student_master.student_faculty s1)" ;                                   
		
		boolean td=db.operation(query,"select");
		System.out.println(query);
		
		String a[]=new String[100];
		
		if(td)
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
			
		
		

	}
		
		else
	{
		 return 0;
	}
	
		ad.setStudents(a);
		return 1;

}
	public int select1(DataManager db,int year,int sem,String sec,addstudentsdeo ad,String branch)
	{
		
		String query="select s.registerno from student_master.student s where s.cyear="+year+" and s.semester="+sem+" and s.sectioncode='"+sec+"' and s.branchcode='"+branch+"'";                                   
		System.out.println(query);
		boolean td=db.operation(query,"select");

		
		String a[]=new String[200];
		
		if(td)
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
			
		
		

	}
		
		else
	{
		 return 0;
	}
	
		ad.setStudents(a);
		return 1;

}
	
	
	
	
	
	public int selectfaculty(DataManager db,addstudentsdeo ad1,int dept)
	{
		
		String query="select name,empcode from staffmaster.facultydetails where departmentid="+dept+" order by name";
		  //  System.out.println(query);           
		boolean td=db.operation(query,"select");
		String a[]=new String[100];
		String b[]=new String[100];
		if(td)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				int i=0;
				while(rs.next())	
				{
					a[i]=rs.getString("name");
					b[i]=rs.getString("empcode");
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
		 return 0;
	}
	
		ad1.setStudents(a);
		ad1.setEmpcode(b);
		return 1;

}
	
	
	
	public int set(DataManager db,String reg[],String fac)
	{   
		int i=0;
		int len=reg.length;
		while(len>0)
		{
		    
			String query="insert into student_master.student_faculty values('"+reg[i]+"','"+fac+"')";
			if(db.operation(query,"update"))
			{
			        i++; 
					len--;
			}
			else 
			{
				return 0;
			}
		} 
	return 1;
	}
	
	
	public String  selectname(DataManager db,String fac)
	{
		String name=null;
		String query="select name from staffmaster.facultydetails where empcode="+fac;
		if(db.operation(query,"select"))
		{
			try
			{
			ResultSet rs=db.getResultSet();
			name=rs.getString("name");
			}
			catch(Exception e)
			{
				
			}
	
			}
		
		return name;
	}
	
	public int update(DataManager db,String reg[],String fac)
	{
		int len=reg.length,i=0;
		while(len>0)
		{
			String query="update student_master.student_faculty set empcode='"+fac+"' where registerno='"+reg[i]+"'";
			boolean t=db.operation(query,"update");
			System.out.println(query);
			System.out.println(t);
			i++;
		     len--;
		}
		
		return 1;
	}
	public int branch(DataManager db,addstudentsdeo ad)
	{
		String query="select branchcode,shortname from vignan.branch where coursecode='A'";
		boolean td=db.operation(query,"select");
	      
			String a[]=new String[100];
			String b[]=new String[100];
			if(td)
			{
				try
				{
					ResultSet rs=db.getResultSet();
					rs.beforeFirst();
					int i=0;
					while(rs.next())	
					{
						a[i]=rs.getString("branchcode");
						b[i]=rs.getString("shortname");
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
			 return 0;
		}
		
			ad.setStudents(a);
			ad.setEmpcode(b);
			return 1;

	}
	
	
	
}