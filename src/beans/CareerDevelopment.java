package beans;

public class CareerDevelopment {
	
	
	String program[]=new String[30];
	String[] type=new String[30];
	int weeklyhours[]=new int[30];
	String  timing[]=new String[30];
	String books[]=new String[30];
	String btype[]=new String[30];
	
	
public String programs,program_type,timings,book,bt;
public String[] getBooks() {
	return books;
}
public void setBooks(String[] books) {
	this.books = books;
}
public String[] getBtype() {
	return btype;
}
public void setBtype(String[] btype) {
	this.btype = btype;
}
public String getBook() {
	return book;
}
public void setBook(String book) {
	this.book = book;
}
public String getBt() {
	return bt;
}
public void setBt(String bt) {
	this.bt = bt;
}
public	double hours_week;
	public String getPrograms() {
		return programs;
	}
	public void setPrograms(String programs) {
		this.programs = programs;
	}
	public String[] getProgram() {
		return program;
	}
	public void setProgram(String[] program) {
		this.program = program;
	}
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	public int[] getWeeklyhours() {
		return weeklyhours;
	}
	public void setWeeklyhours(int[] weeklyhours) {
		this.weeklyhours = weeklyhours;
	}
	public String[] getTiming() {
		return timing;
	}
	public void setTiming(String[] timing) {
		this.timing = timing;
	}
	public String getProgram_type() {
		return program_type;
	}
	public void setProgram_type(String program_type) {
		this.program_type = program_type;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public double getHours_week() {
		return hours_week;
	}
	public void setHours_week(double hours_week) {
		this.hours_week = hours_week;
	}
	
	
	
	
	

}
