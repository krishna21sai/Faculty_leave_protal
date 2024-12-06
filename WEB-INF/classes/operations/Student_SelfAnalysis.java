package operations;

import java.sql.ResultSet;

import model.DataManager;
import beans.ParentObservation;
import beans.Student;
import beans.StudentSelfAnalysis;

public class Student_SelfAnalysis
{
    //Insert into Student SElf Details into DB::start
	public int insertSad(Student s,DataManager db,StudentSelfAnalysis sa,String sem,String batch)
	  {
		
	
		String st="insert into aeps"+batch+".student_selfanalysis_"+sem+" values('"+s.getRegisterno()+"',"+sa.getCom_english()+","+sa.getCom_mothertongue()+","+sa.getCom_general()+","+sa.getCom_confidence()+","+sa.getAca_motivation_eng()+","+sa.getAca_motivation_gen()+","+sa.getAca_pastperformance()+","+sa.getAca_expectedperf()+","+sa.getHw_theory()+","+sa.getHw_problem()+","+sa.getSm_studies()+","+sa.getSm_career()+",'"+sa.getHlth_blodgroup()+"',"+sa.getHlth_weight()+","+sa.getHlth_height()+","+sa.getHlth_chest()+",'"+sa.getHlth_eyesight()+"','"+sa.getChronic_diseases()+"','"+sa.getEmergency_essentials()+"')";
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
		 
		 
				
		}	 // To insert the student Self Analysis  Data into DB :: End

	 
	// To update the student Self Analysis  Data into DB :: start
	public int updateSad(Student s,DataManager db,StudentSelfAnalysis sa,String sem,String batch)
	  {
		
	
		String st="update aeps"+batch+".student_selfanalysis_"+sem+" set com_english="+sa.getCom_english()+",com_mothertongue="+sa.getCom_mothertongue()+",com_general="+sa.getCom_general()+",com_confidence="+sa.getCom_confidence()+",aca_motivation_eng="+sa.getAca_motivation_eng()+",aca_motivation_gen="+sa.getAca_motivation_gen()+",aca_pastperformance="+sa.getAca_pastperformance()+",aca_expectedperf="+sa.getAca_expectedperf()+",hw_theory="+sa.getHw_theory()+",hw_problem="+sa.getHw_problem()+",sm_studies="+sa.getSm_studies()+",sm_career="+sa.getSm_career()+",hlth_blodgroup='"+sa.getHlth_blodgroup()+"',hlth_weight="+sa.getHlth_weight()+",hlth_height="+sa.getHlth_height()+",hlth_chest="+sa.getHlth_chest()+",hlth_eyesight='"+sa.getHlth_eyesight()+"',chronic_diseases='"+sa.getChronic_diseases()+"',emergency_essentials='"+sa.getEmergency_essentials()+"' where registerno='"+s.getRegisterno()+"'";
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
		 
		 
				
		}	 // To update the student Self Analysis  Data into DB :: End
	
	
	
	// To get Previous Events data :: Start
	public int previousSaData(Student s,DataManager db,StudentSelfAnalysis sa,String sem,String batch)
	{
		
	 
		String query="select com_english,com_mothertongue,com_general,com_confidence,aca_motivation_eng,aca_motivation_gen,aca_pastperformance,aca_expectedperf,hw_theory,hw_problem,sm_studies,sm_career,hlth_blodgroup,hlth_weight,hlth_height,hlth_chest,hlth_eyesight,chronic_diseases,emergency_essentials from aeps"+batch+".student_selfanalysis_"+sem+" where registerno='"+s.getRegisterno()+"'";
		boolean t=db.operation(query,"select");
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
	
 }

	
