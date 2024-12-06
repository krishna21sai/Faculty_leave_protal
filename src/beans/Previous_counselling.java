package beans;

public class Previous_counselling {
	int counselling_week[]=new int[30];
	String title[]=new String[30];
	public int[] getCounselling_week() {
		return counselling_week;
	}
	public void setCounselling_week(int[] counselling_week) {
		this.counselling_week = counselling_week;
	}
	public String[] getTitle() {
		return title;
	}
	public void setTitle(String[] title) {
		this.title = title;
	}
	public String[] getProblems() {
		return problems;
	}
	public void setProblems(String[] problems) {
		this.problems = problems;
	}
	public String[] getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String[] suggestions) {
		this.suggestions = suggestions;
	}
	String problems[]=new String[30];
	String[] suggestions=new String[30];
	String[] days=new String[30];
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}

}
