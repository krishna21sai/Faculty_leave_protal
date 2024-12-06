package beans;

public class Student {
	String registerno,name,coursecode,branchcode,sectioncode,gender,dob,fathername,houseno,street,town,mandal,district,state,pincode,landline,studentmobile,fathermobile,doj,studentemailid,parentemailid,entrancetest,seatcategory,
	intertype,intercollege,interlocation,interdistrict,ssctype,sscschool,ssclocation,sscdistrict,ugsubstream,ugmainstream,ugcollege,uguniversity,uglocation,ugdistrict,
	pgsubstream,pgmainstream,pgcollege,pguniversity,pglocation,pgdistrict,fatheroccupation,fathereducation,mothername,motheroccupation,mothereducation,
	mothertongue,familystatus,employename,caste,batchno,fatheremailid;
	String living_style,friend_registerno,friend_name,friend_contact,friend_branch,friend_college,friend_email,roomno;
	
	public String getFatheremailid() {		return fatheremailid;
	}
	public void setFatheremailid(String fatheremailid) {
		this.fatheremailid = fatheremailid;
	}
	public String getBatchno() {
		return batchno;
	}
	public String getLiving_style() {
		return living_style;
	}
	public void setLiving_style(String living_style) {
		this.living_style = living_style;
	}
	public String getFriend_registerno() {
		return friend_registerno;
	}
	public void setFriend_registerno(String friend_registerno) {
		this.friend_registerno = friend_registerno;
	}
	public String getFriend_name() {
		return friend_name;
	}
	public void setFriend_name(String friend_name) {
		this.friend_name = friend_name;
	}
	public String getFriend_contact() {
		return friend_contact;
	}
	public void setFriend_contact(String friend_contact) {
		this.friend_contact = friend_contact;
	}
	public String getFriend_branch() {
		return friend_branch;
	}
	public void setFriend_branch(String friend_branch) {
		this.friend_branch = friend_branch;
	}
	public String getFriend_college() {
		return friend_college;
	}
	public void setFriend_college(String friend_college) {
		this.friend_college = friend_college;
	}
	public String getFriend_email() {
		return friend_email;
	}
	public void setFriend_email(String friend_email) {
		this.friend_email = friend_email;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	int cyear,semester,entrancetestrank,entrancemarks,interpassyear,sscpassyear,ugpassyear,pgpassyear;
	
	double interpercent,tenthpercent,ugpercent,pgpercent,annualincome;
	boolean vignanemployknown;
	 
	public String getRegisterno() {
		return registerno;
	}
	public void setRegisterno(String registerno) {
		this.registerno = registerno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;

	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	public int getCyear() {
		return cyear;
	}
	public void setCyear(int cyear) {
		this.cyear = cyear;
	}
	public String getSectioncode() {
		return sectioncode;
	}
	public void setSectioncode(String sectioncode) {
		this.sectioncode = sectioncode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getStudentmobile() {
		return studentmobile;
	}
	public void setStudentmobile(String studentmobile) {
		this.studentmobile = studentmobile;
	}
	public String getFathermobile() {
		return fathermobile;
	}
	public void setFathermobile(String fathermobile) {
		this.fathermobile = fathermobile;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getStudentemailid() {
		return studentemailid;
	}
	public void setStudentemailid(String studentemailid) {
		this.studentemailid = studentemailid;
	}
	public String getParentemailid() {
		return parentemailid;
	}
	public void setParentemailid(String parentemailid) {
		this.parentemailid = parentemailid;
	}
	public String getEntrancetest() {
		return entrancetest;
	}
	public void setEntrancetest(String entrancetest) {
		this.entrancetest = entrancetest;
	}
	public String getSeatcategory() {
		return seatcategory;
	}
	public void setSeatcategory(String seatcategory) {
		this.seatcategory = seatcategory;
	}
	public String getIntertype() {
		return intertype;
	}
	public void setIntertype(String intertype) {
		this.intertype = intertype;
	}
	public String getIntercollege() {
		return intercollege;
	}
	public void setIntercollege(String intercollege) {
		this.intercollege = intercollege;
	}
	public String getInterlocation() {
		return interlocation;
	}
	public void setInterlocation(String interlocation) {
		this.interlocation = interlocation;
	}
	public String getInterdistrict() {
		return interdistrict;
	}
	public void setInterdistrict(String interdistrict) {
		this.interdistrict = interdistrict;
	}
	public String getSsctype() {
		return ssctype;
	}
	public void setSsctype(String ssctype) {
		this.ssctype = ssctype;
	}
	public String getSscschool() {
		return sscschool;
	}
	public void setSscschool(String sscschool) {
		this.sscschool = sscschool;
	}
	public String getSsclocation() {
		return ssclocation;
	}
	public void setSsclocation(String ssclocation) {
		this.ssclocation = ssclocation;
	}
	public String getSscdistrict() {
		return sscdistrict;
	}
	public void setSscdistrict(String sscdistrict) {
		this.sscdistrict = sscdistrict;
	}
	public String getUgsubstream() {
		return ugsubstream;
	}
	public void setUgsubstream(String ugsubstream) {
		this.ugsubstream = ugsubstream;
	}
	public String getUgmainstream() {
		return ugmainstream;
	}
	public void setUgmainstream(String ugmainstream) {
		this.ugmainstream = ugmainstream;
	}
	public String getUgcollege() {
		return ugcollege;
	}
	public void setUgcollege(String ugcollege) {
		this.ugcollege = ugcollege;
	}
	public String getUguniversity() {
		return uguniversity;
	}
	public void setUguniversity(String uguniversity) {
		this.uguniversity = uguniversity;
	}
	public String getUglocation() {
		return uglocation;
	}
	public void setUglocation(String uglocation) {
		this.uglocation = uglocation;
	}
	public String getUgdistrict() {
		return ugdistrict;
	}
	public void setUgdistrict(String ugdistrict) {
		this.ugdistrict = ugdistrict;
	}
	public String getPgsubstream() {
		return pgsubstream;
	}
	public void setPgsubstream(String pgsubstream) {
		this.pgsubstream = pgsubstream;
	}
	public String getPgmainstream() {
		return pgmainstream;
	}
	public void setPgmainstream(String pgmainstream) {
		this.pgmainstream = pgmainstream;
	}
	public String getPgcollege() {
		return pgcollege;
	}
	public void setPgcollege(String pgcollege) {
		this.pgcollege = pgcollege;
	}
	public String getPguniversity() {
		return pguniversity;
	}
	public void setPguniversity(String pguniversity) {
		this.pguniversity = pguniversity;
	}
	public String getPglocation() {
		return pglocation;
	}
	public void setPglocation(String pglocation) {
		this.pglocation = pglocation;
	}
	public String getPgdistrict() {
		return pgdistrict;
	}
	public void setPgdistrict(String pgdistrict) {
		this.pgdistrict = pgdistrict;
	}
	public String getFatheroccupation() {
		return fatheroccupation;
	}
	public void setFatheroccupation(String fatheroccupation) {
		this.fatheroccupation = fatheroccupation;
	}
	public String getFathereducation() {
		return fathereducation;
	}
	public void setFathereducation(String fathereducation) {
		this.fathereducation = fathereducation;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getMotheroccupation() {
		return motheroccupation;
	}
	public void setMotheroccupation(String motheroccupation) {
		this.motheroccupation = motheroccupation;
	}
	public String getMothereducation() {
		return mothereducation;
	}
	public void setMothereducation(String mothereducation) {
		this.mothereducation = mothereducation;
	}
	public String getMothertongue() {
		return mothertongue;
	}
	public void setMothertongue(String mothertongue) {
		this.mothertongue = mothertongue;
	}
	public String getFamilystatus() {
		return familystatus;
	}
	public void setFamilystatus(String familystatus) {
		this.familystatus = familystatus;
	}
	public String getEmployename() {
		return employename;
	}
	public void setEmployename(String employename) {
		this.employename = employename;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getEntrancetestrank() {
		return entrancetestrank;
	}
	public void setEntrancetestrank(int entrancetestrank) {
		this.entrancetestrank = entrancetestrank;
	}
	public int getEntrancemarks() {
		return entrancemarks;
	}
	public void setEntrancemarks(int entrancemarks) {
		this.entrancemarks = entrancemarks;
	}
	public int getInterpassyear() {
		return interpassyear;
	}
	public void setInterpassyear(int interpassyear) {
		this.interpassyear = interpassyear;
	}
	public int getSscpassyear() {
		return sscpassyear;
	}
	public void setSscpassyear(int sscpassyear) {
		this.sscpassyear = sscpassyear;
	}
	public int getUgpassyear() {
		return ugpassyear;
	}
	public void setUgpassyear(int ugpassyear) {
		this.ugpassyear = ugpassyear;
	}
	public int getPgpassyear() {
		return pgpassyear;
	}
	public void setPgpassyear(int pgpassyear) {
		this.pgpassyear = pgpassyear;
	}
	public double getInterpercent() {
		return interpercent;
	}
	public void setInterpercent(double interpercent) {
		this.interpercent = interpercent;
	}
	public double getTenthpercent() {
		return tenthpercent;
	}
	public void setTenthpercent(double tenthpercent) {
		this.tenthpercent = tenthpercent;
	}
	public double getUgpercent() {
		return ugpercent;
	}
	public void setUgpercent(double ugpercent) {
		this.ugpercent = ugpercent;
	}
	public double getPgpercent() {
		return pgpercent;
	}
	public void setPgpercent(double pgpercent) {
		this.pgpercent = pgpercent;
	}
	public double getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(double annualincome) {
		this.annualincome = annualincome;
	}
	public boolean isVignanemployknown() {
		return vignanemployknown;
	}
	public void setVignanemployknown(boolean vignanemployknown) {
		this.vignanemployknown = vignanemployknown;
	}
	
	
	
	
	
	
	
	

}
