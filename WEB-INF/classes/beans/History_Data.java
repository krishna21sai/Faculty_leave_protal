package beans;

public class History_Data {
	
	String living_style,friend_registerno,friend_name,friend_contact,friend_branch,friend_college,friend_email,roomno;
	String registerno,name,coursecode,branchcode,sectioncode,gender,dob,fathername,houseno,street,town,mandal,district,state,pincode;
	int edid[][][]=new int[30][30][15];
	String[] student_subjectname=new String[50];
	String[] student_testname=new String[50];
	int[] student_testid=new int[50];
	int[] student_subtestids=new int[50];
	int[] max_marks=new int[50];
	int[] edids=new int[50];
	int[] number_exams=new int[50]; 
	String att_month;
	int att_year;
	double att_percent;
	String subjecttype;
	int passmarks;
	int[] external= new int[50];
	int[] internal= new int[50];
	int[] maxmarks= new int[50];

	String[] subjectname= new String[50];
	String[] subject=new String[50];
	String[] status=new String[3];
	String[] status1=new String[3];
	int communication_skills,beh_with_others,teamspirit,creativity,leadeship,negative_thinking,regularity,dresscode,general_aptitude,beh_aggressive,beh_dull,
	extrovert,introvert,lang_class_teacher,lang_outside_teacher,lang_campus_friends,beh_class,beh_outside,beh_out_campus;
	String beh_opposite_gen,group_attitude,abnormal_beh;

	String program[]=new String[30];
	String[] type=new String[30];
	int weeklyhours[]=new int[30];
	String  timing[]=new String[30];
	String books[]=new String[30];
	String btype[]=new String[30];
	String programs,program_type,timings,book,bt;
	String beh_elders,beh_friends,beh_working,health,confidence_level,comm_skills;
	int counselling_week[]=new int[30];
	String title[]=new String[30];
	String problems[]=new String[30];
	String[] suggestions=new String[30];
	String[] days=new String[30];
	String ename[]=new String[100];
	String cname[]=new String[100];
	String edate[]=new String[100];
	String fname[]=new String[100];
	String loc[]=new String[100];
	String eprize[]=new String[100];
	String esem[]=new String[100];
	String eyear[]=new String[100];
	int com_english,com_mothertongue,com_general,com_confidence,aca_motivation_eng,aca_motivation_gen,aca_pastperformance,aca_expectedperf,hw_theory,hw_problem,
    sm_studies,sm_career;
	String hlth_blodgroup,hlth_eyesight,chronic_diseases,emergency_essentials;
	double hlth_weight,hlth_height,hlth_chest;
	String[] student_subjects=new String[50];
	public String[] getStudent_subjects() {
		return student_subjects;
	}
	public void setStudent_subjects(String[] student_subjects) {
		this.student_subjects = student_subjects;
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
	public int[][][] getEdid() {
		return edid;
	}
	public void setEdid(int[][][] edid) {
		this.edid = edid;
	}
	public String[] getStudent_subjectname() {
		return student_subjectname;
	}
	public void setStudent_subjectname(String[] student_subjectname) {
		this.student_subjectname = student_subjectname;
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
	public int[] getNumber_exams() {
		return number_exams;
	}
	public void setNumber_exams(int[] number_exams) {
		this.number_exams = number_exams;
	}
	public String getAtt_month() {
		return att_month;
	}
	public void setAtt_month(String att_month) {
		this.att_month = att_month;
	}
	public int getAtt_year() {
		return att_year;
	}
	public void setAtt_year(int att_year) {
		this.att_year = att_year;
	}
	public double getAtt_percent() {
		return att_percent;
	}
	public void setAtt_percent(double att_percent) {
		this.att_percent = att_percent;
	}
	public String getSubjecttype() {
		return subjecttype;
	}
	public void setSubjecttype(String subjecttype) {
		this.subjecttype = subjecttype;
	}
	public int getPassmarks() {
		return passmarks;
	}
	public void setPassmarks(int passmarks) {
		this.passmarks = passmarks;
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
	public int getCommunication_skills() {
		return communication_skills;
	}
	public void setCommunication_skills(int communication_skills) {
		this.communication_skills = communication_skills;
	}
	public int getBeh_with_others() {
		return beh_with_others;
	}
	public void setBeh_with_others(int beh_with_others) {
		this.beh_with_others = beh_with_others;
	}
	public int getTeamspirit() {
		return teamspirit;
	}
	public void setTeamspirit(int teamspirit) {
		this.teamspirit = teamspirit;
	}
	public int getCreativity() {
		return creativity;
	}
	public void setCreativity(int creativity) {
		this.creativity = creativity;
	}
	public int getLeadeship() {
		return leadeship;
	}
	public void setLeadeship(int leadeship) {
		this.leadeship = leadeship;
	}
	public int getNegative_thinking() {
		return negative_thinking;
	}
	public void setNegative_thinking(int negative_thinking) {
		this.negative_thinking = negative_thinking;
	}
	public int getRegularity() {
		return regularity;
	}
	public void setRegularity(int regularity) {
		this.regularity = regularity;
	}
	public int getDresscode() {
		return dresscode;
	}
	public void setDresscode(int dresscode) {
		this.dresscode = dresscode;
	}
	public int getGeneral_aptitude() {
		return general_aptitude;
	}
	public void setGeneral_aptitude(int general_aptitude) {
		this.general_aptitude = general_aptitude;
	}
	public int getBeh_aggressive() {
		return beh_aggressive;
	}
	public void setBeh_aggressive(int beh_aggressive) {
		this.beh_aggressive = beh_aggressive;
	}
	public int getBeh_dull() {
		return beh_dull;
	}
	public void setBeh_dull(int beh_dull) {
		this.beh_dull = beh_dull;
	}
	public int getExtrovert() {
		return extrovert;
	}
	public void setExtrovert(int extrovert) {
		this.extrovert = extrovert;
	}
	public int getIntrovert() {
		return introvert;
	}
	public void setIntrovert(int introvert) {
		this.introvert = introvert;
	}
	public int getLang_class_teacher() {
		return lang_class_teacher;
	}
	public void setLang_class_teacher(int lang_class_teacher) {
		this.lang_class_teacher = lang_class_teacher;
	}
	public int getLang_outside_teacher() {
		return lang_outside_teacher;
	}
	public void setLang_outside_teacher(int lang_outside_teacher) {
		this.lang_outside_teacher = lang_outside_teacher;
	}
	public int getLang_campus_friends() {
		return lang_campus_friends;
	}
	public void setLang_campus_friends(int lang_campus_friends) {
		this.lang_campus_friends = lang_campus_friends;
	}
	public int getBeh_class() {
		return beh_class;
	}
	public void setBeh_class(int beh_class) {
		this.beh_class = beh_class;
	}
	public int getBeh_outside() {
		return beh_outside;
	}
	public void setBeh_outside(int beh_outside) {
		this.beh_outside = beh_outside;
	}
	public int getBeh_out_campus() {
		return beh_out_campus;
	}
	public void setBeh_out_campus(int beh_out_campus) {
		this.beh_out_campus = beh_out_campus;
	}
	public String getBeh_opposite_gen() {
		return beh_opposite_gen;
	}
	public void setBeh_opposite_gen(String beh_opposite_gen) {
		this.beh_opposite_gen = beh_opposite_gen;
	}
	public String getGroup_attitude() {
		return group_attitude;
	}
	public void setGroup_attitude(String group_attitude) {
		this.group_attitude = group_attitude;
	}
	public String getAbnormal_beh() {
		return abnormal_beh;
	}
	public void setAbnormal_beh(String abnormal_beh) {
		this.abnormal_beh = abnormal_beh;
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
	public String getPrograms() {
		return programs;
	}
	public void setPrograms(String programs) {
		this.programs = programs;
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
	public String getBeh_elders() {
		return beh_elders;
	}
	public void setBeh_elders(String beh_elders) {
		this.beh_elders = beh_elders;
	}
	public String getBeh_friends() {
		return beh_friends;
	}
	public void setBeh_friends(String beh_friends) {
		this.beh_friends = beh_friends;
	}
	public String getBeh_working() {
		return beh_working;
	}
	public void setBeh_working(String beh_working) {
		this.beh_working = beh_working;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getConfidence_level() {
		return confidence_level;
	}
	public void setConfidence_level(String confidence_level) {
		this.confidence_level = confidence_level;
	}
	public String getComm_skills() {
		return comm_skills;
	}
	public void setComm_skills(String comm_skills) {
		this.comm_skills = comm_skills;
	}
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
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}
	public String[] getEname() {
		return ename;
	}
	public void setEname(String[] ename) {
		this.ename = ename;
	}
	public String[] getCname() {
		return cname;
	}
	public void setCname(String[] cname) {
		this.cname = cname;
	}
	public String[] getEdate() {
		return edate;
	}
	public void setEdate(String[] edate) {
		this.edate = edate;
	}
	public String[] getFname() {
		return fname;
	}
	public void setFname(String[] fname) {
		this.fname = fname;
	}
	public String[] getLoc() {
		return loc;
	}
	public void setLoc(String[] loc) {
		this.loc = loc;
	}
	public String[] getEprize() {
		return eprize;
	}
	public void setEprize(String[] eprize) {
		this.eprize = eprize;
	}
	public String[] getEsem() {
		return esem;
	}
	public void setEsem(String[] esem) {
		this.esem = esem;
	}
	public String[] getEyear() {
		return eyear;
	}
	public void setEyear(String[] eyear) {
		this.eyear = eyear;
	}
	public int getCom_english() {
		return com_english;
	}
	public void setCom_english(int com_english) {
		this.com_english = com_english;
	}
	public int getCom_mothertongue() {
		return com_mothertongue;
	}
	public void setCom_mothertongue(int com_mothertongue) {
		this.com_mothertongue = com_mothertongue;
	}
	public int getCom_general() {
		return com_general;
	}
	public void setCom_general(int com_general) {
		this.com_general = com_general;
	}
	public int getCom_confidence() {
		return com_confidence;
	}
	public void setCom_confidence(int com_confidence) {
		this.com_confidence = com_confidence;
	}
	public int getAca_motivation_eng() {
		return aca_motivation_eng;
	}
	public void setAca_motivation_eng(int aca_motivation_eng) {
		this.aca_motivation_eng = aca_motivation_eng;
	}
	public int getAca_motivation_gen() {
		return aca_motivation_gen;
	}
	public void setAca_motivation_gen(int aca_motivation_gen) {
		this.aca_motivation_gen = aca_motivation_gen;
	}
	public int getAca_pastperformance() {
		return aca_pastperformance;
	}
	public void setAca_pastperformance(int aca_pastperformance) {
		this.aca_pastperformance = aca_pastperformance;
	}
	public int getAca_expectedperf() {
		return aca_expectedperf;
	}
	public void setAca_expectedperf(int aca_expectedperf) {
		this.aca_expectedperf = aca_expectedperf;
	}
	public int getHw_theory() {
		return hw_theory;
	}
	public void setHw_theory(int hw_theory) {
		this.hw_theory = hw_theory;
	}
	public int getHw_problem() {
		return hw_problem;
	}
	public void setHw_problem(int hw_problem) {
		this.hw_problem = hw_problem;
	}
	public int getSm_studies() {
		return sm_studies;
	}
	public void setSm_studies(int sm_studies) {
		this.sm_studies = sm_studies;
	}
	public int getSm_career() {
		return sm_career;
	}
	public void setSm_career(int sm_career) {
		this.sm_career = sm_career;
	}
	public String getHlth_blodgroup() {
		return hlth_blodgroup;
	}
	public void setHlth_blodgroup(String hlth_blodgroup) {
		this.hlth_blodgroup = hlth_blodgroup;
	}
	public String getHlth_eyesight() {
		return hlth_eyesight;
	}
	public void setHlth_eyesight(String hlth_eyesight) {
		this.hlth_eyesight = hlth_eyesight;
	}
	public String getChronic_diseases() {
		return chronic_diseases;
	}
	public void setChronic_diseases(String chronic_diseases) {
		this.chronic_diseases = chronic_diseases;
	}
	public String getEmergency_essentials() {
		return emergency_essentials;
	}
	public void setEmergency_essentials(String emergency_essentials) {
		this.emergency_essentials = emergency_essentials;
	}
	public double getHlth_weight() {
		return hlth_weight;
	}
	public void setHlth_weight(double hlth_weight) {
		this.hlth_weight = hlth_weight;
	}
	public double getHlth_height() {
		return hlth_height;
	}
	public void setHlth_height(double hlth_height) {
		this.hlth_height = hlth_height;
	}
	public double getHlth_chest() {
		return hlth_chest;
	}
	public void setHlth_chest(double hlth_chest) {
		this.hlth_chest = hlth_chest;
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               