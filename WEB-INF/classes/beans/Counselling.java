package beans;

public class Counselling {
	int counselling_week;
	public int getCounselling_week() {
		return counselling_week;
	}
	public void setCounselling_week(int counselling_week) {
		this.counselling_week = counselling_week;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProblems() {
		return problems;
	}
	public void setProblems(String problems) {
		this.problems = problems;
	}
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
	String title,problems,suggestions,empcode,day;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	String students[]=new String[150];
	public String getEmpcode() {
		return empcode;
	}
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	public String[] getStudents() {
		return students;
	}
	public void setStudents(String[] students) {
		this.students = students;
	}
	

}
