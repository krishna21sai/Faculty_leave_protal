package beans;

public class ExternalReports {
	
String subjecttype;
public String getSubjecttype() {
	return subjecttype;
}
public void setSubjecttype(String subjecttype) {
	this.subjecttype = subjecttype;
}
public int[] getExternal() {
	return external;
}
public void setExternal(int[] external) {
	this.external = external;
}
public int[] getInternal() {
	return internal;
}
public void setInternal(int[] internal) {
	this.internal = internal;
}
public int[] getMaxmarks() {
	return maxmarks;
}
public void setMaxmarks(int[] maxmarks) {
	this.maxmarks = maxmarks;
}
public int getPassmarks() {
	return passmarks;
}
public void setPassmarks(int passmarks) {
	this.passmarks = passmarks;
}
int passmarks;
int[] external= new int[50];
int[] internal= new int[50];
int[] maxmarks= new int[50];

String[] subjectname= new String[50];
String[] subject=new String[50];
	

public String[] getSubjectname() {
	return subjectname;
}
public void setSubjectname(String[] subjectname) {
	this.subjectname = subjectname;
}

public String[] getSubject() {
	return subject;
}
public void setSubject(String[] subject) {
	this.subject = subject;
}

String[] status=new String[3];
String[] status1=new String[3];

public String[] getStatus() {
	return status;
}
public void setStatus(String[] status) {
	this.status = status;
}
public String[] getStatus1() {
	return status1;
}
public void setStatus1(String[] status1) {
	this.status1 = status1;
}
}
