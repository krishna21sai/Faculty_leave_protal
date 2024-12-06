<%@ page buffer="512kb" autoFlush="false" %>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<link rel="stylesheet" type="text/css" href="./cal/epoch_styles.css" />
<script type="text/javascript" src="./cal/epoch_classes.js"></script>
<script type="text/javascript">

		var cal1,cal2;
		window.onload = function ()
		{
			//cal1  = new Epoch('epoch_popup','popup',document.getElementById('dt1'));
			cal2  = new Epoch('epoch_popup','popup',document.getElementById('dt2'));
			cal3  = new Epoch('epoch_popup','popup',document.getElementById('dt3'));
		}




		function days() {
			// The number of milliseconds in one day
			var ONE_DAY = 1000 * 60 * 60 * 24;
			var str= new Array(3);
			var strrr= new Array(3);
			var st2=document.f.date1.value;
			var st3=document.f.date2.value;
			var ltype=document.f.leavetype.value;

			//alert("sdf");
			str=st2.split("-");
			var strr=new Date(str[2]+"/"+str[1]+"/"+str[0]);

			strrr=st3.split("-");
			var strrrr=new Date(strrr[2]+"/"+strrr[1]+"/"+strrr[0]);


			// Convert both dates to milliseconds
			var date1_ms=strr.getTime();


			var date2_ms = strrrr.getTime();


			if(date1_ms>date2_ms)
			{
				alert("Please enter Valid Dates");
				document.leaves.date2.value="0";
				return false;
			}


			// Calculate the difference in milliseconds
			var difference_ms = Math.abs(date1_ms - date2_ms)
			
			// Convert back to days and return
			if(ltype=="HPL")
			{
				document.f.nod1.value=Math.round((difference_ms/ONE_DAY)+1)*2;
			}
			else
			{
				document.f.nod1.value=Math.round((difference_ms/ONE_DAY)+1);
			}


			var st4=document.f.nod.value;
			var st44=document.f.nod1.value;


			var st5=parseInt(document.f.nod.value)-document.f.nod1.value;

			if(ltype=="HPL")
			{

			document.f.bal.value=document.f.nod.value-document.f.nod1.value;
			
			}
			else
			{
			document.f.bal.value=st5;
			}
			if(st5<0 && ltype!="QIP")
			{
				alert(st5);
				alert("Leaves not available");
				
				document.f.leavetype.value="";
				return false;

			}
			if(document.f.nod1.value<3 && ltype=="Vacation")
			{
				alert("Vacation days must be minimum 3 days");
				document.f.leavetype.value="";
				return false;
			}

		}

		function days1()
		{

		if(document.f.nod1.value>0.0)
		{
			var st5=document.f.nod.value-document.f.nod1.value;
			document.f.bal.value=st5;

		if(st5<0.0)
		{
				alert("Leaves not available");

				document.f.leavetype.value="";
				return false;

		}

		}
		else
		{
		alert("Enter no of days Correctly");
		return false;
		}//alert("sdf");
		}
		function days2()
		{
				// The number of milliseconds in one day
		var st5=0;
		document.f.bal.value=st5;
		}
		function ff2()
		{
			alert("hi");
		}

</script>

<%@ include file="includingfile.jsp" %>
<%@ include file="getdate.jsp" %>
 
 <table width="100%" cellpadding="0" cellspacing="0" border="0" align="center" class='table'>
  <tr>
    <td align="left" class="ListingHead">Leave Entry<hr noShade size="1"></td>
  </tr>
  <tr>
 <td>
 <!-- MAIN CONTENT START -->
 <%
		int dept=0,exp=0,days=0,nleave=0;
		Double nod1=0.0;
		String date="",gender="",date1="",empcode="",date2="",fromdate="",doj="",date3="";
		ResultSet rs=null;
		int desg=0;
		String dt[]=new String[20];
		String dt1[]=new String[20];
		if(session.getAttribute("deptid")!=null)
		{
			dept=Integer.parseInt(""+session.getAttribute("deptid"));
		}
		String de=""+session.getAttribute("who");
		String emp= de ;
		String cc="",check="Invalid Id",empid="",leavetype="";

		if(request.getParameter("date")!=null && request.getParameter("date").trim().length()>0)
		{
			date = request.getParameter("date");
		}
		if(request.getParameter("date1")!=null && request.getParameter("date1").trim().length()>0)
		{
			date1 = request.getParameter("date1");
			fromdate=date1;

			dt=date1.split("-");
			date1=dt[2]+"-"+dt[1]+"-"+dt[0];

			//out.println(date1);
		}
		if(request.getParameter("date2")!=null && request.getParameter("date2").trim().length()>0)
		{
			date2 = request.getParameter("date2");
			date3=date2;

			dt1=date3.split("-");
			date3=dt1[2]+"-"+dt1[1]+"-"+dt1[0];

		}
		if(request.getParameter("leavetype")!=null && request.getParameter("leavetype").trim().length()>0)
		{
			leavetype = request.getParameter("leavetype");



			empcode = request.getParameter("empcode");
			//out.println("select empcode,doj,timestampdiff(year,doj,'"+date1+"') as exp from staffmaster.facultydetails where empcode='"+empcode+"' and empcode not in (select empcode from staffmaster.specialcategory)");
			if(db.operation("select empcode,doj,timestampdiff(year,doj,'"+date1+"') as exp,designation from staffmaster.facultydetails where empcode='"+empcode+"' and empcode not in (select empcode from staffmaster.specialcategory) and empcode not in (select empcode from fin.relievers)","select"))
			{
				rs=db.getResultSet();
				rs.beforeFirst();
				while(rs.next())
				{
					exp=rs.getInt("exp");
					doj=rs.getString("doj");
					desg=rs.getInt("designation");
					// out.println(exp);

					if(exp<2)
					{
						//	out.println("select empcode,gender,doj,timestampdiff(day,'2015-01-01','"+date1+"') as days from staffmaster.facultydetails where empcode='"+empcode+"'");
						if(db.operation("select empcode from staffmaster.facultydetails where doj>'2023-01-01' and empcode='"+empcode+"'","select"))
						{

							if(db.operation("select empcode,gender,designation,doj,timestampdiff(day,doj,'"+date1+"') as days from staffmaster.facultydetails where empcode='"+empcode+"'","select"))	
							{
								ResultSet rs1=db.getResultSet();
								rs1.beforeFirst();
								while(rs1.next())
								{
									gender=rs1.getString("gender");
									desg=rs1.getInt("designation");
									if(gender.equalsIgnoreCase("M") && desg!=92)
									{
										days=rs1.getInt("days");
										nleave=days/45;
										//out.println(days);
										//out.println(nleave);

									}
									else if(gender.equalsIgnoreCase("F") && desg!=92)
									{
										days=rs1.getInt("days");
										nleave=days/33;
										//out.println(nleave);

									}

									else if(desg==92)
									{
										days=rs1.getInt("days");
										nleave=days/24;
										//out.println(nleave);

									}
									//out.println("update staffmaster.fleaves set nleaves="+nleave+" where empcode='"+empcode+"' and ltype='Casual'");
									db.operation("update staffmaster.fleaves set nleaves="+nleave+" where empcode='"+empcode+"' and ltype='Casual'","update");


								}
								rs1=null;
							}	
						}
						else
						{
							if(db.operation("select empcode,gender,designation,doj,timestampdiff(day,'2023-01-01','"+date1+"') as days from staffmaster.facultydetails where empcode='"+empcode+"'  and empcode not in (select empcode from fin.relievers)","select"))
							{
								ResultSet rs1=db.getResultSet();
								rs1.beforeFirst();
								while(rs1.next())
								{
									gender=rs1.getString("gender");
									desg=rs1.getInt("designation");
									if(gender.equalsIgnoreCase("M") && desg!=92)
									{
										days=rs1.getInt("days");
										nleave=days/45;
									  	//out.println(days);
									 	//out.println(nleave);
									}
									else if(gender.equalsIgnoreCase("F") && desg!=92)
									{
										days=rs1.getInt("days");
										nleave=days/33;
									  //out.println(nleave);
									}
									else if(desg==92)
									{
										days=rs1.getInt("days");
										nleave=days/24;
										out.println(nleave);
									}
									//out.println("update staffmaster.fleaves set nleaves="+nleave+" where empcode='"+empcode+"' and ltype='Casual'");
									db.operation("update staffmaster.fleaves set nleaves="+nleave+" where empcode='"+empcode+"' and ltype='Casual'","update");

								}
								rs1=null;
							}

						}

					}
					else
					{
						if(desg!=92)
						{
							db.operation("update staffmaster.fleaves set nleaves=8 where empcode='"+empcode+"' and gender='M' and ltype='Casual'","update");
							db.operation("update staffmaster.fleaves set nleaves=11 where empcode='"+empcode+"' and gender='F' and ltype='Casual'","update");
						}
						else
						{
							//out.println(daysn);
							db.operation("update staffmaster.fleaves set nleaves=15 where empcode='"+empcode+"' and gender='M' and ltype='Casual'","update");
							db.operation("update staffmaster.fleaves set nleaves=15 where empcode='"+empcode+"' and gender='F' and ltype='Casual'","update");
						}
					}

				}
			}

			if(db.operation("select empcode,doj,timestampdiff(year,doj,'"+date1+"') as exp from staffmaster.facultydetails where empcode='"+empcode+"' and empcode in (select empcode from staffmaster.specialcategory)","select"))
			{
				rs=db.getResultSet();
				rs.beforeFirst();
				while(rs.next())
				{
		  			//out.println("select empcode,doj,timestampdiff(year,doj,'"+date1+"') as exp from staffmaster.facultydetails where empcode='"+empcode+"' and empcode in (select empcode from staffmaster.specialcategory)");
					db.operation("update staffmaster.fleaves set nleaves=8 where empcode='"+empcode+"' and gender='M' and ltype='Casual'","update");
					db.operation("update staffmaster.fleaves set nleaves=11 where empcode='"+empcode+"' and gender='F' and ltype='Casual'","update");
				}

			}

		}

		if(request.getParameter("nod1")!=null && request.getParameter("nod1").trim().length()>0)
		{
			nod1 = Double.parseDouble(request.getParameter("nod1"));

		}
		//out.println("sdf"+date1);
		if(request.getParameter("Next")!=null && leavetype.length()>0 && emp.length()>0 && nod1>0 )
		{
			int diff=0;
			out.println("select datediff(CURRENT_DATE,'"+date1+"') as diff ");
			if(db.operation("select datediff(CURRENT_DATE,'"+date3+"') as diff ","select"))
			{
				ResultSet r4r=db.getResultSet();
				r4r.beforeFirst();
				while(r4r.next())
				{
					diff=r4r.getInt("diff");
				}
			}
			diff = 0;
			if(diff<=0)
			{
%>
				<jsp:forward page="workadjust.jsp"/>
<%
			}
			else
			{
				
				out.println("<b><font color='red'>Leave should be entered on that Day only</font></b>");
			}
		}
		else
		{

		}

		java.util.Date d=new java.util.Date();

%>
	<FORM NAME="f" action="leaveform.jsp" method="post"  >

	<table width='100%'  align="center" cellspacing="0" cellpadding="5" border="0">
<%

	Date today = new Date();

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	String ttdate = sdf.format(today);
%>
	<tr>
		<td align="right" >Date</th><td align="left" ><input type="text" name="date" size="20" value="<%=ttdate%>" readonly id="dt1"/></td>
	</tr>
	<tr>
<%
	String empname = "";
	int desi = 0;
	String design = "",department = "";
	int dep =0;
	if(db.operation("select * from staffmaster.facultydetails where empcode = '"+de+"'","select"))
	{
		ResultSet rs1 = null;
		rs1 = db.getResultSet();
		empname = rs1.getString("name");
		desi = rs1.getInt("designation");
		dep = rs1.getInt("departmentId");
   		if(db.operation("select * from staffmaster.usertypes where Id = '"+desi+"' ","select"))
		{
			ResultSet rs11 = null;
			rs11 = db.getResultSet();
			design = rs11.getString("usertypename");
		}
		String query1 = "SELECT deptname FROM vignan.department WHERE deptid = " + dep;
    	//out.println(query1);
		boolean t11 = db.operation(query1, "select");
		if (t11) 
		{
			rs = db.getResultSet();
            department = rs.getString("deptname");
        }
	}
%>
	<tr>
		<td align='right'>Emp Code</td>
		<td align="left"> <input type="text" name="empcode" value="<%=de%>" readonly></td>
	</tr>
	<tr>
		<td align='right'>Emp Name</td>
		<td align="left"> <input type="text" name="empname" value="<%=empname%>" readonly></td>
	</tr>
	<tr>
		<td align='right'>Designation</td>
		<td align="left"> <input type="text" name="designation" value="<%= design%>" readonly></td>
	</tr>
	<tr>
		<td align='right'>Department</td>
		<td align="left"> <input type="text" name="department" value="<%= department%>" readonly></td>
	</tr>
	<tr>
	<td align="right">From &nbsp;<input type=text size=10 name="date1" value="<%=fromdate%>" id="dt2" readonly onblur='ff2()'>&nbsp;</td><td>To&nbsp;&nbsp;&nbsp;<input type=text size=10 name="date2" readonly id="dt3" value="<%=date2%>">
	<tr>
		<td align='right'>Leave Type</td>
		<td align="left"> <select  name="leavetype" onChange="f.submit();">
		<option Value="">Select</option>
<%
		if(leavetype.equals("Casual"))
		{
%>
			<option Value="Casual" selected>Casual Leave</option>
			<option Value="Earned">Earned Leave</option>
			<option Value="HPL">Half Pay Leave</option>
			<option Value="Compensatory">Compensatory Leave</option>
			<option Value="Academic">Academic Leave</option>
			<option Value="OD">On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>
<%
		}
		else if(leavetype.equals("Earned"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" selected>Earned Leave</option>
			<option Value="HPL">Half Pay Leave</option>
			<option Value="Compensatory">Compensatory Leave</option>
			<option Value="Academic">Academic Leave</option>
			<option Value="OD">On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>
<%
		}
		else if(leavetype.equals("HPL"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" selected>Half Pay Leave</option>
			<option Value="Compensatory">Compensatory Leave</option>
			<option Value="Academic">Academic Leave</option>
			<option Value="OD">On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>
<%
		}
		else if(leavetype.equals("Compensatory"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" selected>Compensatory Leave</option>
			<option Value="Academic">Academic Leave</option>
			<option Value="OD">On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>

<%
		}
		else if(leavetype.equals("Academic"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" selected>Academic Leave</option>
			<option Value="OD">On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>
<%
		}
		else if(leavetype.equals("OD"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" selected>On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>
<%
		}
		else if(leavetype.equals("Marriage"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" >On Duty Leave</option>
			<option Value="Marriage" selected>Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>

<%
		}
		else if(leavetype.equals("Meternity"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" >On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity" selected>Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>
<%
		}

		else if(leavetype.equals("Vacation"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" >On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation" selected>Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>

<%
		}
		else if(leavetype.equals("QIP"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" >On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP" selected>QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>
<%
		}

		else if(leavetype.equals("Study"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" >On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study" selected>Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>
<%
		}
		else if(leavetype.equals("Special"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" >On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special" selected>Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>


<%
		}
		else if(leavetype.equals("Compensatory-Reward"))
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" >On Duty Leave</option>
			<option Value="Marriage">Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special" >Special Leave</option>
			<option Value="Compensatory-Reward" selected>Compensatory-Reward</option>


<%
		}
		else
		{
%>
			<option Value="Casual" >Casual Leave</option>
			<option Value="Earned" >Earned Leave</option>
			<option Value="HPL" >Half Pay Leave</option>
			<option Value="Compensatory" >Compensatory Leave</option>
			<option Value="Academic" >Academic Leave</option>
			<option Value="OD" >On Duty Leave</option>
			<option Value="Marriage" >Marriage Leave</option>
			<option Value="Meternity">Meternity Leave</option>
			<option Value="Vacation">Vacation</option>
			<option Value="QIP">QIP Leave</option>
			<option Value="Study">Study Leave</option>
			<option Value="Special">Special Leave</option>
			<option Value="Compensatory-Reward">Compensatory-Reward</option>

<%
		}

%>
		</select></td>
	</tr>
	<tr>
		<td align='right'>No of Leaves as on Date:</th></td>
<%
		Float nod=0.0f;
		nod=0.0f;
		if(db.operation("select * from staffmaster.fleaves where empcode='"+emp+"' and ltype='"+leavetype+"'","select"))
		{
			ResultSet rr=db.getResultSet();
			rr.beforeFirst();
			while(rr.next())
			{
				nod=rr.getFloat("nleaves")-rr.getFloat("rleaves");
				//out.println(nod);
			}
		}
		//out.println(nod);
%>
		<td><input type="text" name="nod" value="<%=nod%>" readonly></td>
	</tr>
	<tr>
		<td align='right'>
		<%if(leavetype.equalsIgnoreCase("Earned") 	|| leavetype.equalsIgnoreCase("Marriage") || leavetype.equalsIgnoreCase("HPL") || leavetype.equalsIgnoreCase("Meternity") || leavetype.equalsIgnoreCase("Vacation"))
		{
%>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No of Days Applied&nbsp;<td><input type=text size=10 name="nod1" onblur="return days()" readonly></td>
<%
		}
		else if(leavetype.equalsIgnoreCase("Casual") || leavetype.equalsIgnoreCase("Compensatory")|| leavetype.equalsIgnoreCase("QIP") || leavetype.equalsIgnoreCase("Study") || leavetype.equalsIgnoreCase("Special") || leavetype.equalsIgnoreCase("Compensatory-Reward"))
		{
%>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No of Days Applied&nbsp;<td><input type=text size=10 onblur="return days1()" name="nod1"></td>
<%
		}
		else if(leavetype.equalsIgnoreCase("OD") || leavetype.equalsIgnoreCase("Academic"))
		{
%>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No of Days Applied&nbsp;<td><input type=text size=10 onblur="return days2()" name="nod1"></td>
<%
		}
%>
		</td>
	</tr>

	<tr>
		<td align='right'>Balance</td>
		<td align="left"> <input type="text" name="bal" readonly></td>
	</tr>	
	<tr>
		<td align='right'>Purpose Of Leave</td>
		<td><textarea name="description"cols="40" rows="4"></textarea>
	</tr>
	<tr>
		<td  align="center" colspan="2"><input type="Submit" name="Next" value="Submit"></tD>
	</tr>
<!-- MAIN CONTENT END -->
</table>

</form>

	</td>
</tr>
</table>

<%
if(usertypeid==1)
{
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
