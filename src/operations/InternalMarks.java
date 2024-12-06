package operations;

import java.sql.ResultSet;

import model.DataManager;
import beans.Internal_Marks;
import beans.Student;

public class InternalMarks {

	    
	   public String getDbname(DataManager db,Student s,String sem)
	    {
		   int y=0;
		   String course="",database="";
		 String query="select batchno,coursecode from student_master.student where registerno='"+s.getRegisterno()+"'";

		 if(db.operation(query, "select"))
		 {
			 try
			 {
				 ResultSet rs=db.getResultSet();
				 rs.beforeFirst();
				 rs.next();
				 y=Integer.parseInt(rs.getString("batchno"));
				 course=rs.getString("coursecode");
				 
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
			 System.out.println(sem+" semes");
			 int tempyear=Integer.parseInt(sem.substring(0,1));
			 int tempsem=Integer.parseInt(sem.substring(2,3));
			 int required_year=y+tempyear-1;
			 System.out.println(required_year+" Year of Use");
	         String query2="select `database` from student_master.alldatabases where cyear="+required_year+" and semester="+tempsem+" and coursecode='"+course+"'";
	        // System.out.println(query2);
	         boolean t=db.operation(query2, "select");
	        // System.out.println(db.getErrorMessage());
	    		if(t)
	    		{
	    			try
	    			{
	    				//System.out.println("In side Operation");
	    				 ResultSet rs1=db.getResultSet();
	    				 //rs1.beforeFirst();
	    				 //rs1.next();
	    				database=rs1.getString("database"); 
	    				System.out.println(database+" result");
	    			}
	    			catch(Exception e)
	    			{
	    				 System.out.println(e);
	    			}
	    		}
			 
			 
		 }
		 return database;
	   }
		
	   
	public boolean getRegSubjects(DataManager db,Student s,String sem,Internal_Marks imb)
	{
		
          String[]sub=new String[50];
          String[]sub_name=new String[50];
		 int i=0;
		 System.out.println(sem+" semester");
		 int tempyear=Integer.parseInt(sem.substring(0,1));
		// System.out.println(tempyear);
		 int tempsem=Integer.parseInt(sem.substring(2,3));
		String query="select subjectcode from student_master.studentsubject where registerno='"+s.getRegisterno()+"' and cyear='"+tempyear+"' and semester='"+tempsem+"'";
		boolean t=db.operation(query, "select");
		//System.out.println(query+" subject");
	//	System.out.println(db.getErrorMessage()+"Get Subjects");
	    if(t)
	    {
	    	try
	    	{
	    		ResultSet rs=db.getResultSet();
	    		rs.beforeFirst();
				 while(rs.next())
				 {
					sub[i]=rs.getString("subjectcode");
					
					query="select subjectname from vignan.subjects where subjectcode='"+sub[i]+"'";
					 if(db.operation(query, "select"))
					  {
						  ResultSet rs1=db.getResultSet();
						    sub_name[i]=rs1.getString("subjectname");
						    System.out.println(rs1.getString("subjectname"));
						  
					  }
					i++; 
				 }
	    		
				 
			
			    	rs.close();
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	    	
	    	
	    	
	    	imb.setStudent_subjectname(sub_name);
	    	imb.setStudent_subjects(sub);
	    
	    	return true;
	    }
	    return false;
	
	}
	
	public boolean getExams(DataManager db,Internal_Marks imb,String dbname)
	{
		int[] exam_type=new int[50];
		String[] exam_name=new String[50];int i=0;
		int[] number_exam=new int[50];
		int[] max_marks=new int[50];
		String query="select etid,name,no_of_exams,max_marks from "+dbname+".types";
		System.out.println(query);
		 if(db.operation(query, "select"))
		 {
			 try
			 {
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				 while(rs.next())
				 {
					 exam_type[i]=rs.getInt("etid");
					 exam_name[i]=rs.getString("name");
					 number_exam[i]=rs.getInt("no_of_exams");
					 max_marks[i]=rs.getInt("max_marks");
					 i++;
					 
				 }
				rs.close();
			 }
			 			 
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
			 
			 imb.setStudent_testid(exam_type);
			 imb.setStudent_testname(exam_name);
			 imb.setMax_marks(max_marks);
			 imb.setNumber_exams(number_exam);
			
			 return true;
		 }
		return false; 
	}
	
	public boolean getMarks(DataManager db,Internal_Marks imb,String database,Student s)
	{ 
		int i=0,j=0,k=0;
		int marks[][][]=new int[30][30][15];
		for(i=0;i<30;i++)
		{
			for(j=0;j<30;j++)
			{
				for(k=0;k<15;k++)
				{
					marks[i][j][k]=-1;
				}
				
			}
			
			
		}
		String query="";
		int subject_count=0,test_count=0,subtest_count=0;
		int test_ids[]=imb.getStudent_testid();
		int[] exams=imb.getNumber_exams();
		String[] subject_ids=imb.getStudent_subjects();
		ResultSet rs=null;
		   for(int l=0;l<imb.getStudent_subjects().length;l++)
		   {
			   if(subject_ids[l]!=null)
			   {
				   subject_count++;
			   }
		   }
		   for(int l=0;l<test_ids.length;l++)
		   {
			   if(subject_ids[l]!=null)
			   {
				   test_count++;
			   }
		   }
		
		System.out.println(test_count);
		for(i=0;i<test_count;i++)
		{
			for(j=0;j<exams[i];j++)
			{
				//System.out.println(exams[i]+" sub Exams");
				for(k=0;k<subject_count;k++)
				{
					query="select marks from "+database+".exam where registerno='"+s.getRegisterno()+"' and edid=(SELECT edid from "+database+".register where etid="+test_ids[i]+" and exam_no="+(j+1)+" and subjectcode='"+subject_ids[k]+"')";
					System.out.println(query);
					boolean t1=db.operation(query,"select");
					System.out.println(db.getErrorMessage()+"Babu Error ");
					System.out.println("Babu          "+t1);
					if(t1)
					{
						try
						{
					ResultSet rs1=db.getResultSet();
						rs1.beforeFirst();
						if(rs1.next())
						marks[i][j][k]=rs1.getInt("marks");
					//	System.out.println("Babu          ");
						System.out.println(marks[i][j][k]+" Marks ");
						//rs.close();
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
							
					}
					
				}
			}
		}
		
		imb.setEdid(marks);
		
		
	return true;
	}
	
	   
}
