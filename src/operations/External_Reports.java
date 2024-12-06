package operations;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DataManager;
import beans.ExternalReports;
import beans.SemEndReports;

public class External_Reports {
	
	String m[] =new String[50];
	String m1[] =new String[50];
	private Object String;
public int subname(ExternalReports s1,DataManager db,String name,String sem,String cyear)
{
		
	String st="select distinct subjectcode from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"'order by subjecttypeid";
	//System.out.println(st+" SUb code");
	boolean r=db.operation(st,"select");
	//System.out.println(db.getErrorMessage());
	//System.out.println(r);


	int i=0;
	if(r)
	{
		try
		{
			ResultSet rs=db.getResultSet();
			
			rs.beforeFirst();
			while(rs.next())
			{
        	//System.out.println(rs.getString("subjectcode")+" sub");
				m[i]=rs.getString("subjectcode");
        	
				i++;
        	 
			}
       	 
			s1.setSubjectname(m);
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
	 
		}
	 return 1;	 

	}
	else
	{
		return 0;        
	}


}
	
public int subname1(ExternalReports s1,DataManager db,String name,String sem,String cyear)
{
		int i=0;
		String st1="";
		 String subjectname[]=s1.getSubjectname();
		for(i=0;i<subjectname.length;i++)
		{
			if(subjectname[i]!=null)
			{
			 st1="select SubjectName from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"' and subjectcode='"+subjectname[i]+"' order by subjecttypeid";
			boolean r=db.operation(st1,"select");

			//System.out.println(db.getErrorMessage());
			//System.out.println(st1);


			//int j=0;
			if(r)
			{
				try
				{
					ResultSet rs=db.getResultSet();
	 
					rs.beforeFirst();
					if(rs.next())
					{
						
						//System.out.println(rs.getString("SubjectName"));
						m1[i]=rs.getString("SubjectName");
						//j++;
        	 
					}
	 

				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
					
				}
				
				
			}
			
			}
	}

		if(m1.length==0)
		return 0;
		else
		{
			s1.setSubject(m1);

			//System.out.println(s1.getSubject()+" Test");
			return 1;

		}
}
		
public int status(ExternalReports s1,DataManager db,String name,String sem,String cyear)	
	
{ 
	String stat[]=new String[30];
	m=s1.getSubjectname();
	for(int i=0;i<m.length;i++)
	{
		if(m[i]==null)
         break;	
		String s2="select count(*)from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"' and subjectcode='"+m[i]+"' and status='FAIL'";
		boolean r=db.operation(s2,"select");

		//System.out.println(s2+" Marks");
		//System.out.println(db.getErrorMessage());

		ResultSet rs=db.getResultSet();
		if(r)
		{
			try 
			{
				stat[i]=rs.getString("count(*)");
				//System.out.println("status"+stat[i]);
			} 


			catch (SQLException e)
			{
				System.out.println(e);
			}
		}

	}
	s1.setStatus(stat);
	return 1;	


}	


public int status1(ExternalReports s1,DataManager db,String name,String sem,String cyear)	

{
	String stat1[]=new String[30];
	m=s1.getSubjectname();
	for(int i=0;i<m.length;i++)
	{
		if(m[i]==null)
         break;	
		String s3="select count(*)from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"' and subjectcode='"+m[i]+"' and status='PASS'";
		boolean r=db.operation(s3,"select");



		//System.out.println(db.getErrorMessage());

		ResultSet rs=db.getResultSet();
		if(r)
		{
			try
			{
			stat1[i]=rs.getString("count(*)");
			} 


			catch (SQLException e) 
			{
	
				System.out.println(e);
			}
		}

	}
	for(int k=0;k<9;k++)
		//System.out.println(stat1[k]);
		s1.setStatus1(stat1);
	return 1;	

}	


public int maxmarks(ExternalReports s1,DataManager db,String name,String sem,String cyear) throws NumberFormatException, SQLException	

{ 
	int max[]=new int[30];
	m=s1.getSubjectname();
	for(int i=0;i<m.length;i++)
	{
	if(m[i]==null)
     continue;	
	String s2="select maxmarks from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"' and subjectcode='"+m[i]+"'order by subjecttypeid ";
	boolean r=db.operation(s2,"select");


	//System.out.println(db.getErrorMessage());

	ResultSet rs=db.getResultSet();
	if(r)
	{
	max[i]=Integer.parseInt(rs.getString("maxmarks"));
	
	}

	}
	s1.setMaxmarks(max);
	return 1;	
}	

public int external(ExternalReports s1,DataManager db,String name,String sem,String cyear)	

{
	String s2="";
	m=s1.getSubjectname();
	String pass[]=s1.getStatus1();
	String fail[]=s1.getStatus();
	int ext[]=new int[30];
	for(int i=0;i<m.length;i++)
	{
	int p=0,f=0;
	if(m[i]==null)
     continue;
	p=Integer.parseInt(pass[i]);
	f=Integer.parseInt(fail[i]);
	System.out.println(pass[i]+" pass");
	String day="";
	if(p==0&&f>0)
	{
		

		
		String dd="select max(date) from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"' and subjectcode='"+m[i]+"' and status='fail'";
		System.out.println(dd);
		boolean r=db.operation(dd, "select");
		if(r)
		{
			System.out.println("Max Date");
			try
			{
				ResultSet rss=db.getResultSet();
				day=rss.getString(1);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		s2="select external from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"' and subjectcode='"+m[i]+"' and status='pass' and date='"+day+"'order by subjecttypeid";
		
	}
	
	
	
	else
	{
		s2="select external from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"' and subjectcode='"+m[i]+"' and status='pass'order by subjecttypeid";
		
	}
	//System.out.println(s2+"  "+i);
	boolean r=db.operation(s2,"select");


	//System.out.println(db.getErrorMessage());

	ResultSet rs=db.getResultSet();
	if(r)
	{  
     try
     {
		ext[i]=Integer.parseInt(rs.getString("external"));
     } 
     catch (SQLException e)
     {
		
		e.printStackTrace();
	}	
	
}


}
	s1.setExternal(ext);
	return 1;	

}

public int internal(ExternalReports s1,DataManager db,String name,String sem,String cyear) throws NumberFormatException, SQLException	

{
	int intr[]=new int[30];
	for(int i=0;i<m.length;i++)
	{
		if(m[i]==null)
			continue;	
		String s2="select internal from university.marksmaster where registerno='"+name+"' and semester='"+sem+"'and cyear='"+cyear+"' and subjectcode='"+m[i]+"' order by subjecttypeid ";
		boolean r=db.operation(s2,"select");

		//System.out.println(db.getErrorMessage());

		ResultSet rs=db.getResultSet();

		if(r)
		{   
			intr[i]=Integer.parseInt(rs.getString("internal"));

		}

	}
	s1.setInternal(intr);
	return 1;	
}
	
	

}
