<%@ include file="includingfile.jsp" %>
<%@ page import="java.sql.*,model.DataManager,java.security.MessageDigest"%>
<%@ include file="smscodeNew4.jsp"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<%@ page import="java.sql.*, java.util.ArrayList, java.util.List" %>
<%

		int dept=0;
		int utypeid=0;
		String lid = "";
		if(usertypeid == 10)
		{
			lid=(String)session.getAttribute("emp2");

		}
		else{
			lid=(String)session.getAttribute("who");
		}
		String lid1=(String)session.getAttribute("who");
		String nam = "";
		ResultSet dd = null;
		out.println(lid);
		if(db.operation("select name from staffmaster.facultydetails where empcode = '"+lid+"'","select"))
		{
			dd = db.getResultSet();
			nam = dd.getString("name");
		}
		out.println(nam);
		String dep1 = request.getParameter("department");
		ResultSet fp = null;
		int dep  = 0;
		//out.println(dep1);
		if(db.operation("select deptid from vignan.department where deptname = '"+dep1+"'","select"))
		{
			fp = db.getResultSet();
			dep = fp.getInt("deptid");
			//out.println(dep);
		}
		String ltype=request.getParameter("leavetype");
		String cdate=request.getParameter("date");
        String empcode=request.getParameter("empcode");	
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		Double nod=Double.parseDouble(request.getParameter("nod"));	
		Double nod1=Double.parseDouble(request.getParameter("nod1"));
		Double bal=Double.parseDouble(request.getParameter("bal"));
		String desc=request.getParameter("description").replace("'","`");
		float ii=0.00f,jj1=0.00f;
		String empcode1="",teaching="";
		boolean jj=true;
		String str[]=new String[3];
		str=cdate.split("-");
		String strr1=str[2]+"-"+str[1]+"-"+str[0];
		int designation=0;
		String str1[]=new String[3];
		str1=date1.split("-");
		String strr2=str1[2]+"-"+str1[1]+"-"+str1[0];
		String str2[]=new String[3];
		str2=date2.split("-");
		String strr3=str2[2]+"-"+str2[1]+"-"+str2[0];
		ResultSet rq = null;
		//out.println("select * from staffmaster.leavedetails  where Id='"+empcode+"'");
		if(db.operation("select * from staffmaster.facultydetails where empcode='"+empcode+"'","select"))
		{
			ResultSet rrr1=db.getResultSet();
			rrr1.beforeFirst();
			while(rrr1.next())
			{

				teaching=rrr1.getString("teaching");
				designation=rrr1.getInt("designation");
				dept=rrr1.getInt("departmentid");
			}

		}

		jj=db.operation("insert into staffmaster.leavedetails values(0,'"+empcode+"','"+ltype+"','"+nod+"','"+strr2+"','"+strr3+"','"+nod1+"','"+bal+"','0','"+lid1+"',current_date,'"+designation+"','"+desc+"','1900-01-01','1900-01-01','1900-01-01','1900-01-01','1900-01-01','1900-01-01','1900-01-01',current_time)","insert");
%>
<%
//out.println(jj);
		int pid = 0;
		if(	jj)
		{
			if(db.operation("select * from staffmaster.leavedetails where empcode = '"+empcode+"' and leavetype = '"+ltype+"' and fromdat = '"+strr2+"' and todat = '"+strr3+"'","select"))
			{
				rq = db.getResultSet();
				pid = rq.getInt("Id");
				//out.println(pid);
			}
			
		%>
		
		<html lang="en">
		<head>
    	<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<title>Work adjustment</title>
		<style>
			.faculty-select {
			width: 150px; /* Adjust this value as needed */
			padding: 5px;
			font-size: 16px;
			}
			.deanselect
			{
			width: 150px; /* Adjust this value as needed */
			padding: 5px;
			font-size: 16px;
			}
			
		</style>
		<style>
        .table1 {
            width: 100%; /* Table width can be adjusted as needed */
            border-collapse: collapse;
        }
        .th1, .td1 {
			width : 100%;
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        
    </style>
		</head>
		<body>
		<div class = kk>
			

<%
int p = 0;
String[] dates = new String[1000];
String[] dates2 = new String[1000];
String[] dates3 = new String[1000];
String[] ldate = new String[1000];
String dt[]=new String[10];
String ll1="";
String emp = null;
String datedate ="";

if (usertypeid == 10) {
	emp = (String)session.getAttribute("emp2");
}
else{
	emp = (String)session.getAttribute ("who");
}
String desi11 = "";
String desi112 = "";
String formattedFromDate = "";
String formattedToDate = "";

String fromDate=request.getParameter("date1");
String toDate1=request.getParameter("date2");
SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
//out.println(fromDate);
try{

Date date1a = inputFormat.parse(fromDate);
Date date2a = inputFormat.parse(toDate1);

formattedFromDate = outputFormat.format(date1a);
formattedToDate = outputFormat.format(date2a);
}
catch (Exception e) {
            e.printStackTrace();  // Handle parse exception
        }
//out.println(formattedFromDate);

//String toDate1=request.getParameter("date2");
String[] coursecode=new String[20];
String[] branchcode=new String[20];
int[] year=new int[20];
int[] semester=new int[20];
String[] subjectcode=new String[20];
String[] sectioncode=new String[20];
String[] subjecttypecode=new String[20];
String dname="",name="",tech="";

String ff = "";
Map<String, List<String>> facultyPeriodsMap = new HashMap<String, List<String>>();
ResultSet rs=null,rs1=null,rs2=null,rr1=null,rs10=null;
String database="",bc="",cc="",subject="",section="",subjecttype="",branch="",course="",sname="",dayname="";
int cyear=0,sem=0,sl=0,day=0,design1=0;
if(db.operation("select name,designation from staffmaster.facultydetails where empcode='"+lid+"'","select"))
{
	rs2=db.getResultSet();
	rs2.beforeFirst();
	while(rs2.next())
	{
		name=rs2.getString("name");
        design1 = rs2.getInt("designation");
	}
	rs2=null;
}
//SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
//SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
ResultSet rs11=null,rs12=null;
String name11="";

try {
    //Date date1a = inputFormat.parse(date1);
    //Date date2a = inputFormat.parse(date2);

    //formattedFromDate = outputFormat.format(fromDate);
    //formattedToDate = outputFormat.format(toDate1);
	//
} catch (Exception e) {
    e.printStackTrace();
    // Handle parse exception
}
%>


<center>
<h4><br>work adjustment<br>From <%=fromDate%> To <%=toDate1%></h4>
</center>


<%
String multidesi = "select * from fleavesauto.facultydesignations where empcode = '"+ emp +"'";
List<Integer> designationss = new ArrayList<Integer>();
if (db.operation("select designation from staffmaster.facultydetails where empcode = '"+emp+"'","select")) 
{
    rr1 = db.getResultSet();
    rr1.beforeFirst();
    while (rr1.next()) 
	{
        design1 = rr1.getInt("designation");
        // Add the fetched designation to the list
        designationss.add(design1);
    }
    rr1 = null;
}
if(db.operation(multidesi,"select"))
{
	//out.println(design1);
	rs=db.getResultSet();
    // Fetch designations and add to the list if not null
	Integer designation2 = rs.getInt("designation2");
    Integer designation3 = rs.getInt("designation3");
	Integer designation4 = rs.getInt("designation4");


    // Check each designation for null and add to the list
    if (designation2 != null) designationss.add(designation2);
    if (designation3 != 0) designationss.add(designation3);
    if (designation4 != 0) designationss.add(designation4);
} 
int o = 0;

if(db.operation("SELECT distinct * FROM (SELECT * FROM staffmaster.facultysubjects WHERE facultyid= '"+lid+"' AND databasename IN (SELECT databasename FROM student_master.alldatabases1 WHERE status=1)) AS t1 JOIN (SELECT *, fromdate AS fdate FROM staffmaster.timetablenew WHERE fromdate >= '"+formattedFromDate+"' AND fromdate <= '"+formattedToDate+"') AS t2 ON (t1.coursecode = t2.coursecode) AND (t1.branchcode = t2.branchcode) AND (t1.year = t2.cyear) AND (t1.semester = t2.semester) AND (t1.sectioncode = t2.section) AND (t1.subjectcode = t2.subjectcode) AND (t1.databasename = t2.databasename) GROUP BY t2.fromdate, t2.period ORDER BY t2.fromdate, period ","select"))
{
			rs=db.getResultSet();
			rs.beforeFirst();
			//out.println("SELECT * FROM (SELECT * FROM staffmaster.facultysubjects WHERE facultyid= '"+lid+"' AND databasename IN (SELECT databasename FROM student_master.alldatabases1 WHERE status=1)) AS t1 JOIN (SELECT *, fromdate AS fdate FROM staffmaster.timetablenew WHERE fromdate >= '"+formattedFromDate+"' AND fromdate <= '"+formattedToDate+"') AS t2 ON (t1.coursecode = t2.coursecode) AND (t1.branchcode = t2.branchcode) AND (t1.year = t2.cyear) AND (t1.semester = t2.semester) AND (t1.sectioncode = t2.section) AND (t1.subjectcode = t2.subjectcode) AND (t1.databasename = t2.databasename) ORDER BY t2.fromdate, period");
%>


		<form method="POST" action="addfacassigns.jsp">

			<table border='1' class = "table1">
				<tr><th class = "th1" colspan="11" align="center" >Faculty Adjustment</th></tr>
				<tr>
					<th class = "th1">S.No
					<th class = "th1">Course
					<th class = "th1">Branch
					<th class = "th1">year
					<th class = "th1">Semester
					<th class = "th1">Section
					<th class = "th1">Subject
					<th class = "th1">  Date
					<th class = "th1">Day
					<th class = "th1">Period
					<th class = "th1">faculty
				</tr>

<%
		
		while(rs.next())
		{
			database=rs.getString("databasename");
			cc=rs.getString("coursecode");
			bc=rs.getString("branchcode");
			subject=rs.getString("subjectcode");
			subjecttype=rs.getString("subjecttypecode");
			cyear=rs.getInt("year");
			sem=rs.getInt("semester");

			//out.println("select sectioncode from staffmaster.specialsecassignfaculty where empcode = '"+emp+" and subjectcode ='"+subject+"'");
			if(db.operation("select sectioncode from staffmaster.specialsecassignfaculty where empcode = '"+emp+"' and subjectcode ='"+subject+"' ","select")){
				
				rs10 = db.getResultSet();
				section = rs10.getString("sectioncode");
			}
			else{
			section=rs.getString("sectioncode");
			}
			if(db.operation("select coursename from vignan.course where coursecode='"+cc+"'","select"))
			{
				rs2=db.getResultSet();
				rs2.beforeFirst();
				while(rs2.next())
				{

					course=rs2.getString("coursename");
						
				}
				rs2=null;


			}

			if(db.operation("select shortname from vignan.branch where branchcode='"+bc+"' and coursecode='"+cc+"'","select"))
			{
				rs2=db.getResultSet();
				rs2.beforeFirst();
				while(rs2.next())
				{
					branch=rs2.getString("shortname");
						
				}
				rs2=null;

			}

			if(db.operation("select shortname from vignan.subjects where subjectcode='"+subject+"'","select"))
			{
				rs2=db.getResultSet();
				rs2.beforeFirst();
				while(rs2.next())
				{
					sname=rs2.getString("shortname");
						
				}
				rs2=null;

			}


			if(db.operation("select dayname from vignan.days where dayid='"+rs.getInt("day")+"'","select"))
			{
				rs2=db.getResultSet();
				rs2.beforeFirst();
				while(rs2.next())
				{
					dayname=rs2.getString("dayname");
						
				}
				rs2=null;

			}

			sl++;
				
			try
			 {
				
				// Parse and format the input dates
				Date date1aa = outputFormat.parse(rs.getString("fdate"));

				datedate = inputFormat.format(date1aa);
			} catch (Exception e) 
			{
					e.printStackTrace();
					// Handle parse exception
			}
%>


	
				<tr>
					<td class = "td1" align="center"><%=sl%></td>
					<td class = "td1" align = "center"><%=course%></td>
					<td class = "td1" align="center"><%=branch%></td>
					<td class = "td1" align="center"><%=cyear%></td>
					<td class = "td1" align="center"><%=sem%></td>
					<td class = "td1" align="center"><%=section%></td>
					<td class = "td1" align="center"><%=sname%></td>
					<td class = "td1" style ="width : 100px" align="center"><%= datedate %></td>
					<td class = "td1" align="center"><%=dayname%></td>
					<td class = "td1" align="center"><%=rs.getString("period")%></td>
					<td class = "td1" align="center">


<%
					String qq = "SELECT tt.period, fs.facultyid, tt.fromdate " +
					"FROM " + database + ".timetable tt " +
					"JOIN staffmaster.facultysubjects fs " +
					"ON fs.subjectcode = tt.subjectcode " +
					"AND fs.sectioncode = tt.section " +
					"AND fs.year = tt.cyear " +
					"AND fs.branchcode = tt.branchcode "+
					"WHERE tt.fromDate = '" + rs.getString("fdate") + "' " +
					"AND tt.branchcode = '" + bc + "' and fs.facultyid != '" + emp + "' and fs.sectioncode = '"+section+"' and year ='"+cyear+"'" ;
					if (db.operation(qq, "select"))
					{
						rs2 = db.getResultSet();
						rs2.beforeFirst();

						while (rs2.next())
						{
							String faculty = rs2.getString("facultyid"); // Correct column name
							String period = rs2.getString("period");

							// Check if faculty already has this period
							if (facultyPeriodsMap.containsKey(faculty))
							{
								List<String> periods = facultyPeriodsMap.get(faculty);
								if (!periods.contains(period))
								{
									periods.add(period);
								}
							}
							else
							{
								List<String> periods = new ArrayList<String>();
								periods.add(period);
								facultyPeriodsMap.put(faculty, periods);
							}
						}

						rs2 = null;
					}
%>


	<select name="facid1" id="facultyadj<%= p %>" class="faculty-select" onchange="updateHiddenInput(<%= p %>)">
					<option>select</option>


<% 
							for (Map.Entry<String, List<String>> entry : facultyPeriodsMap.entrySet()) 
							{
								String faculty = entry.getKey();
								List<String> periods = entry.getValue();
								
								if (!periods.contains(rs.getString("period"))) 
								{
									String facultyName = "";
									String query = "SELECT name FROM staffmaster.facultydetails WHERE empcode = '" + faculty + "'";
									if (db.operation(query, "select")) 
									{
										ResultSet rs3 = db.getResultSet();
										facultyName = rs3.getString("name");
										rs3.close();
									}
%>
									<option value="<%= faculty %>"><%= faculty %>-<%= facultyName %></option>
<%
								}
							}
							facultyPeriodsMap.clear();


%>


					</select>
					</td>

<%
					String facid = request.getParameter("facid1");
					//out.println("Selected Faculty ID: " + facid);

%>			
					</tr>
					<input type="hidden" name="semester_<%= p %>" value="<%= sem %>">
					<input type="hidden" name="course_<%= p %>" value="<%= cc %>">
					<input type="hidden" name="branch_<%= p %>" value="<%= bc %>">
					<input type="hidden" name="date_<%= p %>" value="<%=rs.getString("fdate")%>">
					<input type="hidden" name="section_<%= p %>" value="<%= section %>">
					<input type="hidden" name="year_<%= p %>" value="<%=cyear%>">
					<input type="hidden" name="subject_<%= p %>" value="<%= subject %>">
					<input type="hidden" name="period_<%= p %>" value="<%=rs.getString("period")%>">
					<input type="hidden" id="facid_<%= p %>" name="facid_<%= p %>" value="<%= facid %>">
							
<%

	p++;
	}
			
			rs=null;
			
}

else{
				
%>

			<center>
			<form method="POST" action="addfacassigns.jsp">

				<table border='1' >
				<tr><th colspan="10" align="center" >Faculty Adjustment</th></tr>
				<tr>
					<th>S.No
					<th>Branch
					<th>year
					<th>Semester
					<th>Section
					<th>Subject
					<th>Date
					<th>Day
					<th>Period
					<th>faculty
				</tr>
				<td colspan=10>
				<center>
<%
				out.println("You Have No Class in This Days");%>
				</center>
				</td>
				</center>
				<%

}
				sl=0;
%>
				<input type="hidden" name="count" value="<%=p%>">
				</table>
<%
for(int desi : designationss)
{
	if(desi <=5 || desi > 273)
	{
		o++;
		String llx ="";
		String rdep = "";
		if(desi == 4)
		{
			llx = "select * from vignan.deans where empcode = '"+emp+"'";
			ll1 = "SELECT empcode FROM vignan.subdeans WHERE deanid IN (SELECT id FROM vignan.deans WHERE empcode = '"+emp+"') union SELECT empcode FROM vignan.hods1 WHERE deanid = '"+emp+"'";
		//out.println(ll1);
		}
		else if(desi ==5)
		{
			llx = "select * from staffmaster.usertypes where id = " + desi+ "";
			ll1 = "SELECT * FROM staffmaster.facultydetails WHERE departmentid IN (SELECT departmentid FROM staffmaster.facultydetails WHERE empcode = '"+emp+"')";
		}
		else
		{
			llx = "select * from staffmaster.usertypes where id = " + desi+ "";
			ll1 = "SELECT * FROM staffmaster.facultydetails WHERE departmentid IN (SELECT departmentid FROM staffmaster.facultydetails WHERE empcode = '"+emp+"')";
		}
		if(db.operation(llx, "select"))
		{
			rs = db.getResultSet();
			desi112 = rs.getString("usertypename");
			//out.println(ll1);
			if(db.operation(ll1, "select"))
			{
				rs11 = db.getResultSet();
				rs11.beforeFirst();
				if(desi == 5){
					rdep = dep1;
				}
				//out.println("okok");
			}
		%>
		<input type = "hidden" name = "role_<%= o %>" value = "<%= desi %>" > 
		<center>
		<h3 style="color: black;">Work Allocation for <%= rdep%> <%= desi112 %> position</h3>
		<table border='1'>
			<tr>
				<th>Role
				<th>Work Allocation
			</tr>
			<tr>
				<td align="center" style="padding:10px;"><%= desi112 %></td> 
				<td>
	<select name="facid1" id="facul1<%= o %>" class="faculty-select" onchange="updateHidden1(<%= o %>)">
				<option value="k">SELECT</option>
<%
			while(rs11.next())
			{
				if(db.operation("select name from staffmaster.facultydetails where empcode = '"+rs11.getString("empcode")+"'" , "select"));
				{
					rs12 = db.getResultSet();
					rs12.beforeFirst();

					if(rs12.next()){
					name11 = rs12.getString("name");
					}

%>
				<option value="<%=rs11.getString("empcode")%>"><%=rs11.getString("empcode")%>-<%=name11%></option>
			<%
				}
			}	
		%>
			</select>
		</td>

		</tr>

		
		<input type = "hidden" name="facid1<%=o%>" id="facid1_<%=o%>" value="<%=request.getParameter("facid1")%>">
	</table>
</center>
		<%
	}
}
%>


<%
if(desi == 0)
{
	o++;
%>	
<input type = "hidden" name = "role_<%= o %>" value = "<%= desi %>" > 
<center>
<%
String ll = "select * from staffmaster.usertypes where id = " + desi+ "";
rs11=null;
rs12=null;
name11="";
if(db.operation(ll, "select")) {
    rs = db.getResultSet();
    desi112 = rs.getString("usertypename");
	ll1 = "select * from fleavesauto.adean where id = " + desi + "";
	//out.println(ll1);
	if(db.operation(ll1, "select"))
	{
		rs11 = db.getResultSet();
		rs11.beforeFirst();
	}
%>
<h3 style="color: black;">Work Allocation for <%= desi112 %> position</h3>
<table border='1'>
    <tr>
        <th>Role
        <th>Work Allocation
    </tr>
    <tr>
        <td align="center" style="padding:10px;"><%= desi112 %></td> 
        <td>
	<select name="facid1" id="facul1<%= o %>" class="faculty-select" onchange="updateHidden1(<%= o %>)">
			<option value="">SELECT</option>
<%
while(rs11.next())
{
	if(db.operation("select name from staffmaster.facultydetails where empcode = '"+rs11.getString("empcode")+"'" , "select"));
	{
		rs12 = db.getResultSet();
		rs12.beforeFirst();

		if(rs12.next()){
		name11 = rs12.getString("name");
        }
%>
                <option value="<%=rs11.getString("empcode")%>"><%=rs11.getString("empcode")%>-<%=name11%></option>
<%
	}
}
%>
            </select>
        </td>
    </tr>
</table>
	<input type = "hidden" name="facid1<%=o%>" id="facid1_<%=o%>" value="<%=request.getParameter("facid1")%>">
<%
}
}
}
%>
<input type="hidden" name="count1" value="<%=o%>">
<input type ="hidden" name = "pid" value = <%=pid %>>

</center>
<br>
<br>
<br>
	<center><input type="submit" name="subtoadd" value="submit"></center>
</form>
</div>
<script>
    function updateHiddenInput(p) {
    // Alert p for debugging
    //alert(p);

    // Get the select element by its dynamic ID
    var selectElement = document.getElementById('facultyadj' + p);

    // Get the selected value
    var selectedValue = selectElement.value;

    // Set the selected value in the corresponding hidden input field
    var hiddenInput = document.getElementById('facid_' + p);
    if (hiddenInput) {
        hiddenInput.value = selectedValue;
    }
	
}
function updateHidden1(o) {
    // Alert p for debugging
    //alert(p);

    // Get the select element by its dynamic ID
    var selectElement1 = document.getElementById('facul1' + o);

    // Get the selected value
    var selectedValue1 = selectElement1.value;

    // Set the selected value in the corresponding hidden input field
    var hiddenInput1 = document.getElementById('facid1_' + o);
    if (hiddenInput1) {
        hiddenInput1.value = selectedValue1;
    }
	
}

</script>
</body>
	<%
	}
	 else
	 {
		 //out.println(jj);
out.println("<b><center>Not Added Check It Once</center></b>");
	 }
 %>

<%

if(usertypeid==1)
{

	%>
	

	%>
		<jsp:include page="vcleaveFooter.jsp"/>
	<%
}
else if(usertypeid==2)
{
	%>
		<jsp:include page="regaccept.jsp"/>
	<%
}
else if(usertypeid==3)
{
	%>
<jsp:include page="detleavefooter.jsp"/>
	<%
}
else if(usertypeid==4)
{
	%>
	<jsp:include page="deanleaveFooter.jsp"/>
	<%
}
else if(usertypeid==5)
{
	%>
	<jsp:include page="hodleavefooter.jsp"/>
	<%
}
else if(usertypeid==6 || usertypeid==7 || usertypeid==8)
{
	%>
	<jsp:include page="staffLeaveFooter.jsp"/>
	<%
}
else if(usertypeid==9||usertypeid==11)
{
	%>
		<jsp:include page="programerLeaveFooter.jsp"/>
	<%
}

else if(usertypeid==10)
{
	%>
	<jsp:include page="deoleavefooter.jsp"/>
	<%
}
else if(usertypeid==12)
{
	%>

	<%
}

%>
