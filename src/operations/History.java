package operations;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DataManager;
import beans.CareerDevelopment;
import beans.History_Data;
import beans.ParentObservation;
import beans.Previous_counselling;
import beans.Student;
import beans.StudentEvents;
import beans.StudentSelfAnalysis;
import beans.emotional;

public class History {
	String m[] =new String[50];
	String m1[] =new String[50];
	public boolean studentsemPreviouslivingdata(History_Data s, DataManager db,String batch,String sem)	 // to get Details of student in present sem :: start
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
	
	public int selectEmotional(History_Data e,DataManager db,String name,String sem,String batch)
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
				    System.out.println(e.getCommunication_skills()+" zdghj");
				    e.setBeh_with_others(rs.getInt("beh_with_others"));
				    e.setTeamspirit(rs.getInt("teamspirit"));
				    e.setCreativity(rs.getInt("creativity"));
				    e.setLeadeship(rs.getInt("leadeship"));
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
	
	
	public int subname( History_Data s1,DataManager db,String name,String cyear ,String sem)
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


	
	
public int subname1(History_Data s1,DataManager db,String name,String cyear ,String sem)
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
		
public int status(History_Data s1,DataManager db,String name,String cyear ,String sem)	
	
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





public int status1(History_Data s1,DataManager db,String name,String cyear ,String sem)	

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


public int maxmarks(History_Data s1,DataManager db,String name,String cyear ,String sem) throws NumberFormatException, SQLException	

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

public int external( History_Data s1,DataManager db,String name,String cyear,String sem)	

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

public int internal( History_Data s1,DataManager db,String name,String cyear ,String sem) throws NumberFormatException, SQLException	

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
	




	
//Internal Marks Start


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
	

public boolean getRegSubjects(DataManager db,Student s,String sem,History_Data imb)
{
	
   String[]sub=new String[50];
   String[]sub_name=new String[50];
	 int i=0;
	 System.out.println(sem+" semester");
	 int tempyear=Integer.parseInt(sem.substring(0,1));
	// System.out.println(tempyear);
	 int tempsem=Integer.parseInt(sem.substring(2,3));
	String query="select subjectcode from student_master.studentsubject where registerno='"+s.getRegisterno()+"' and cyear='"+tempyear+"' and semester='"+tempsem+"'";
	System.out.println(query);
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
				System.out.println(query);
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

public boolean getExams(DataManager db,History_Data imb,String dbname)
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

public boolean getMarks(DataManager db,History_Data imb,String database,Student s)
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

public int select(History_Data e,DataManager db,String name,String sem,String batch)
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
public boolean previousdata(History_Data c,DataManager db,Student s,String sem,String batch)   //To get Previous Other Courses Details :: Start
{
	int i=0;

	String programs[]=new String[30];
	String[] type=new String[30];
	int weeklyhours[]=new int[30];
	String  timings[]=new String[30];
	 
	String query="select programs,program_type,timings,hours_week from aeps"+batch+".career_develop_"+sem+" where registerno='"+s.getRegisterno()+"'";
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
		System.out.println(c.getProgram()[0]);
		return true;
	}
	else
	{
		System.out.println(db.getErrorMessage());
		return false;
	}
}	   //To get Previous Other Courses Details :: Start

public int previousSaData(History_Data sa,DataManager db,String sem,String batch)
{
	
 
	String query="select com_english,com_mothertongue,com_general,com_confidence,aca_motivation_eng,aca_motivation_gen,aca_pastperformance,aca_expectedperf,hw_theory,hw_problem,sm_studies,sm_career,hlth_blodgroup,hlth_weight,hlth_height,hlth_chest,hlth_eyesight,chronic_diseases,emergency_essentials from aeps"+batch+".student_selfanalysis_"+sem+" where registerno='"+sa.getRegisterno()+"'";
	boolean t=db.operation(query,"select");
	sa.setCom_english(0);	
	sa.setCom_mothertongue(0);	
	sa.setCom_general(0);	
	sa.setCom_confidence(0);
	sa.setAca_motivation_eng(0);
    sa.setAca_motivation_gen(0);
	sa.setAca_pastperformance(0);
	sa.setAca_expectedperf(0);
	sa.setHw_theory(0);
	sa.setHw_problem(0);
	sa.setSm_studies(0);
	sa.setSm_studies(0);
    sa.setHlth_blodgroup(null);
    sa.setHlth_weight(0);
    sa.setHlth_height(0);	 
    sa.setHlth_chest(0);
    sa.setHlth_eyesight(null);
    sa.setChronic_diseases(null);
    sa.setEmergency_essentials(null);
	if(t)
	{
		try
		{
			ResultSet rs=db.getResultSet();
			rs.beforeFirst();
			if(rs.next())
			{
				
			sa.setCom_english(rs.getInt("com_english"));	
			sa.setCom_mothertongue(rs.getInt("com_mothertongue"));	
			sa.setCom_general(rs.getInt("com_general"));	
			sa.setCom_confidence(rs.getInt("com_confidence"));
			sa.setAca_motivation_eng(rs.getInt("aca_motivation_eng"));
            sa.setAca_motivation_gen(rs.getInt("aca_motivation_gen"));
			sa.setAca_pastperformance(rs.getInt("aca_pastperformance"));
			sa.setAca_expectedperf(rs.getInt("aca_expectedperf"));
			sa.setHw_theory(rs.getInt("hw_theory"));
			sa.setHw_problem(rs.getInt("hw_problem"));
			sa.setSm_studies(rs.getInt("sm_studies"));
			sa.setSm_studies(rs.getInt("sm_studies"));
            sa.setHlth_blodgroup(rs.getString("hlth_blodgroup"));
            sa.setHlth_weight(rs.getInt("hlth_weight"));
            sa.setHlth_height(rs.getInt("hlth_height"));	 
            sa.setHlth_chest(rs.getInt("hlth_chest"));
            sa.setHlth_eyesight(rs.getString("hlth_eyesight"));
            sa.setChronic_diseases(rs.getString("chronic_diseases"));
            sa.setEmergency_essentials(rs.getString("emergency_essentials"));
			
					
			
			
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

  	}	 // To get Previous Student Self Data data ::end

public int previousPoData(History_Data s,DataManager db,String sem,String batch)  // To get Previous Events data :: Start
{
	
 
	String query="select beh_elders,beh_friends,beh_working,health,confidence_level,comm_skills from aeps"+batch+".parent_observation_"+sem+" where registerno='"+s.getRegisterno()+"'";
	boolean r=db.operation(query,"select");
	s.setBeh_elders(null);
	s.setBeh_friends(null);
	s.setBeh_working(null);
    s.setHealth(null);
	s.setConfidence_level(null);
	s.setComm_skills(null);
	
	if(r)
	{
		try
		{
			ResultSet rs=db.getResultSet();
			rs.beforeFirst();
			if(rs.next())
			{
				s.setBeh_elders(rs.getString("beh_elders"));
				s.setBeh_friends(rs.getString("beh_friends"));
				s.setBeh_working(rs.getString("beh_working"));
			    s.setHealth(rs.getString("health"));
				s.setConfidence_level(rs.getString("confidence_level"));
				s.setComm_skills(rs.getString("comm_skills"));
				
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

}	 // To get Previous Events data :: END	

public boolean getPreviousWeeks(History_Data register,DataManager db,String batch,String sem)	//To get Previous week Data :: start 
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
	 
		register.setCounselling_week(counselling_week);
		register.setTitle(title);
		register.setProblems(problems);
		register.setSuggestions(suggestions);
		register.setDays(days);
		return true;
	}
	else
	{
		System.out.println(db.getErrorMessage());
		return false;
	}

}	////To get Previous week Data :: End

	
public boolean previousEventData(History_Data s, DataManager db,String batch,int tempyear,int tempsem)  // To get Previous Events data :: Start
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
		s.setEname(enam);
		s.setEdate(edate);
		s.setFname(efest);
		s.setCname(ecname);
		s.setLoc(ecloc);
		s.setEprize(eprize);
		s.setEyear(eyear);
		s.setEsem(esem);
		return true;
	}
	else
	{
		System.out.println("fg dhgf hdg f"+db.getErrorMessage());
		return false;
	}

}	 // To get Previous Events data :: Start


}

