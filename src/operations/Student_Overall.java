package operations;
import java.sql.ResultSet;
import model.DataManager;
import beans.Student;
import beans.StudentSelfAnalysis;

public class Student_Overall {

	
	
	 //Obtain Student Overall Details into DB::start
	public int obtainOverallData(Student s,DataManager db,String sem,String batch)
	{
		
	 
		String query="select name,branchcode,sectioncode,coursecode,gender,dob,fathername,houseno,street,town,mandal,district,state,pincode,landline,studentmobile,fathermobile,doj,studentemailid,parentemailid,entrancetest,entrancetestrank,entrancemarks,seatcategory,interpercent,intertype,interpassyear,intercollege,interlocation,interdistrict,tenthpercent,ssctype,sscpassyear,sscschool,ssclocation,sscdistrict,ugpercent,ugpassyear,ugsubstream,ugmainstream,ugcollege,uguniversity,uglocation,ugdistrict,pgpercent,pgpassyear,pgsubstream,pgmainstream,pgcollege,pguniversity,pglocation,pgdistrict,fatheroccupation,fathereducation,fathermobile,parentemailid,mothername,motheroccupation,mothereducation,annualincome,mothertongue,familystatus,batchno from student_master.student where registerno='"+s.getRegisterno()+"'";
		
		
		boolean t=db.operation(query,"select");
		if(t)
		{
			try
			{
				ResultSet rs=db.getResultSet();
				rs.beforeFirst();
				if(rs.next())
				{
					
					s.setName(rs.getString("name"));
                    //s.setSemester(rs.getInt("semester"));
					s.setCoursecode(rs.getString("coursecode"));
					//int b=Integer.parseInt(rs.getString("branchcode"));
					String q="SELECT distinct shortname FROM vignan.branch where branchcode='"+rs.getString("branchcode")+"'";
					if(db.operation(q,"select"))
					{
						System.out.println(q);
						ResultSet r1=db.getResultSet();
						s.setBranchcode(r1.getString("shortname"));
					}
					//s.setBranchcode(rs.getString("branchcode"));
                    s.setSectioncode(rs.getString("sectioncode"));
                    s.setGender(rs.getString("gender"));
                    s.setDob(rs.getString("dob"));
                    s.setFathername(rs.getString("fathername"));
                    s.setHouseno(rs.getString("houseno"));
                    s.setStreet(rs.getString("street"));
                    s.setTown(rs.getString("town"));
                    s.setMandal(rs.getString("mandal"));
                    s.setDistrict(rs.getString("district"));
                    s.setState(rs.getString("state"));
                    s.setPincode(rs.getString("pincode"));
                    s.setLandline(rs.getString("landline"));
                    s.setStudentmobile(rs.getString("studentmobile"));
                    s.setFathermobile(rs.getString("fathermobile"));
                    s.setDob(rs.getString("dob"));
                    s.setStudentemailid(rs.getString("studentemailid"));
                    s.setBatchno(rs.getString("batchno"));
                    s.setParentemailid(rs.getString("parentemailid"));
                    s.setEntrancetest(rs.getString("entrancetest"));
                    s.setEntrancetestrank(rs.getInt("entrancetestrank"));
                    s.setEntrancemarks(rs.getInt("entrancemarks"));
                    s.setSeatcategory(rs.getString("seatcategory"));
                    s.setInterpercent(rs.getInt("interpercent"));
                    s.setIntertype(rs.getString("intertype"));
                    s.setInterpassyear(rs.getInt("interpassyear"));
                    s.setIntercollege(rs.getString("intercollege"));
                    s.setInterlocation(rs.getString("interlocation"));
                    s.setInterdistrict(rs.getString("interdistrict"));
                    s.setTenthpercent(rs.getShort("tenthpercent"));
                    s.setSsctype(rs.getString("ssctype"));
                    s.setSscpassyear(rs.getInt("sscpassyear"));
                    s.setSscschool(rs.getString("sscschool"));
                    s.setSsclocation(rs.getString("ssclocation"));
                    s.setSscdistrict(rs.getString("sscdistrict"));
                    s.setUgpercent(rs.getDouble("ugpercent"));
                    s.setUgpassyear(rs.getInt("ugpassyear"));
                    s.setUgsubstream(rs.getString("ugsubstream"));
                    s.setUgmainstream("ugmainstream");
                    s.setUgcollege(rs.getString("ugcollege"));
                    s.setUguniversity(rs.getString("uguniversity"));
                    s.setUglocation(rs.getString("uglocation"));
                    s.setUgdistrict(rs.getString("ugdistrict"));
                    s.setPgpercent(rs.getDouble("pgpercent"));
                    s.setPgpassyear(rs.getInt("pgpassyear"));
                    s.setPgsubstream(rs.getString("pgsubstream"));
                    s.setPgmainstream(rs.getString("pgmainstream"));
                    s.setPgcollege(rs.getString("pgcollege"));
                    s.setPguniversity(rs.getString("pguniversity"));
                    s.setPglocation(rs.getString("pglocation"));
                    s.setPgdistrict(rs.getString("pgdistrict"));
                    s.setFatheroccupation(rs.getString("fatheroccupation"));
					s.setFathereducation(rs.getString("fathereducation"));
					s.setFathermobile(rs.getString("fathermobile"));
					s.setFatheremailid(rs.getString("parentemailid"));
					s.setMothername(rs.getString("mothername"));
					s.setMotheroccupation(rs.getString("motheroccupation"));
					s.setMothereducation(rs.getString("mothereducation"));
					s.setAnnualincome(rs.getInt("annualincome"));
					s.setMothertongue(rs.getString("mothertongue"));
					s.setFamilystatus(rs.getString("familystatus"));
					         
                     System.out.println(s.getBranchcode());              
                                 
				
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
