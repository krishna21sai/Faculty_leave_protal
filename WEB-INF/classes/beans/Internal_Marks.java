package beans;

public class Internal_Marks {
	int edid[][][]=new int[30][30][15];
	
   public int[][][] getEdid() {
		return edid;
	}
	public void setEdid(int[][][] edid) {
		this.edid = edid;
	}
String[] student_subjectname=new String[50];
	public String[] getStudent_subjectname() {
	return student_subjectname;
}
public void setStudent_subjectname(String[] student_subjectname) {
	this.student_subjectname = student_subjectname;
}
	String[] student_subjects=new String[50];
	public String[] getStudent_subjects() {
		return student_subjects;
	}
	public void setStudent_subjects(String[] student_subjects) {
		this.student_subjects = student_subjects;
	}
	public String[] getStudent_testname() {
		return student_testname;
	}
	public void setStudent_testname(String[] student_testname) {
		this.student_testname = student_testname;
	}
	public int[] getStudent_testid() {
		return student_testid;
	}
	public void setStudent_testid(int[] student_testid) {
		this.student_testid = student_testid;
	}
	public int[] getStudent_subtestids() {
		return student_subtestids;
	}
	public void setStudent_subtestids(int[] student_subtestids) {
		this.student_subtestids = student_subtestids;
	}
	public int[] getMax_marks() {
		return max_marks;
	}
	public void setMax_marks(int[] max_marks) {
		this.max_marks = max_marks;
	}
	public int[] getEdids() {
		return edids;
	}
	public void setEdids(int[] edids) {
		this.edids = edids;
	}
	String[] student_testname=new String[50];
	int[] student_testid=new int[50];
	int[] student_subtestids=new int[50];
	int[] max_marks=new int[50];
	int[] edids=new int[50];
	int[] number_exams=new int[50];
	public int[] getNumber_exams() {
		return number_exams;
	}
	public void setNumber_exams(int[] number_exams) {
		this.number_exams = number_exams;
	}
	
	
	
	
	
	
}
