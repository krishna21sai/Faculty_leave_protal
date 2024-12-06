
<%@ include file="teachingheader.jsp" %>
  <%@ page import="java.io.*,java.text.*"%>
  <%
  String dname="";
  int deptid=0;
  String lid=(String)session.getAttribute("who");
   String user=(String)session.getAttribute("who");
  if(db.operation("select deptid,deptshortname from vignan.department where deptid in (select deptid from vignan.login where usercode='"+lid+"')","select"))
{
ResultSet rsd=db.getResultSet();
rsd.beforeFirst();
if(rsd.next())
{
	dname=rsd.getString("deptshortname");
	deptid=rsd.getInt("deptid");
}
rsd=null;
}
%>
<table>


<tr><td align="left" class="ListingHead"><a href="/formats/Circular - Implementation of VFSTR VII Pay Scale to all faculty.pdf" target="_blank">Circular - Implementation of VFSTR VII Pay Scale to all faculty</a></td></tr>
<tr><td align="left" class="ListingHead"><a href="/formats/7th pay book (Updated).pdf" target="_blank">7th pay book</a></td></tr>
<tr><td align="left" class="ListingHead"><a href="/formats/Professors Details for Dean Faculty Office - 11-01-2023.pdf" target="_blank">7th pay - Professors </a></td></tr>
<tr><td align="left" class="ListingHead"><a href="/formats/Associate Professors Details for Dean Faculty Office - 11-01-2023.pdf" target="_blank">7th pay - Associate Professors </a></td></tr>
<tr><td align="left" class="ListingHead"><a href="/formats/Assistant Professors Details for Dean Faculty Office - 11-01-2023.pdf" target="_blank">7th pay - Assistant Professors </a></td></tr>
</table>
<br>
 <table width="100%" cellpadding="0" cellspacing="0" border="0" align="center">
  <tr>
    <td align="left" class="ListingHead"><%=dname%> - Dash Board<hr noShade size="1"></td>
  </tr>
  <tr>
  <td>
<table width="100%" cellpadding="0" cellspacing="0" border="1" align="center">

<%
if(deptid==1 || deptid==3 || deptid==4 || deptid==5 || deptid==6 || deptid==7 || deptid==8 || deptid==11 || deptid==36)
{
int stc[]=new int[10];
String stt[]=new String[10];
int stc7[]=new int[10];
String stt7[]=new String[10];
int j1=0,tj1=0,j7=0,tj7=0;




//out.println("select cyear,count(*) as cc from student_master.financestudent where status1 in (2,3) and cyear not in (0,1) and semester!=0 and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+") group by cyear");

if(db.operation("select cyear,count(*) as cc from student_master.financestudent where status1 in (2,3)  and cyear not in (0,1) and semester!=0 and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+") group by cyear","select"))
							{
								ResultSet r1=db.getResultSet();
								r1.beforeFirst();
								while(r1.next())
								{
									j1++;

									stt[j1]=r1.getString("cyear").toUpperCase();
									stc[j1]=r1.getInt("cc");
									tj1=tj1+stc[j1];


								}
							}


							if(db.operation("select coursename,count(*) as cc from student_master.financestudent f,vignan.course c where (f.coursecode=c.coursecode) and status1 in (2,3) and cyear not in (0,1) and semester!=0 and f.coursecode='A' and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+") group by f.coursecode order by f.coursecode","select"))
							{
								ResultSet r17=db.getResultSet();
								r17.beforeFirst();
								while(r17.next())
								{
									j7++;

									stt7[j7]=r17.getString("coursename").toUpperCase();
									stc7[j7]=r17.getInt("cc");
									tj7=tj7+stc7[j7];


								}
							}

String std1[]=new String[100];
Double stc1[]=new Double[100];
int mn10=0;
//out.println("select year,attpercent from dashboarddata.perioadattbranch where cyear!=1 and period=1 and date=current_date and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+")");
if(db.operation("select year,attpercent from dashboarddata.perioadattbranchyear where year!=1 and period=1 and date=(select date from dashboarddata.perioadattbranch order by date desc LIMIT 1) and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+")","select"))
							{
								ResultSet r1=db.getResultSet();
								r1.beforeFirst();
								while(r1.next())
								{
									mn10++;
									stc1[mn10]=r1.getDouble("attpercent");
									std1[mn10]=r1.getString("year");

								}
							}




int tot=0;
int teac=0,nont=0;
if(db.operation("select teaching,count(*) as count from staffmaster.facultydetails where departmentid="+deptid+" and status=1 and empcode not in (select empcode from fin.relievers)  and teaching in ('teaching') and gender in ('M','F') group by teaching","select"))
							{
								ResultSet r1=db.getResultSet();
								r1.beforeFirst();
								while(r1.next())
								{
									tot=tot+r1.getInt("count");
									teac=r1.getInt("count");

								}
							}

							if(db.operation("select teaching,count(*) as count from staffmaster.facultydetails where departmentid="+deptid+" and status=1 and empcode not in (select empcode from fin.relievers)  and teaching in ('nonteaching') and gender in ('M','F') group by teaching","select"))
							{
								ResultSet r1=db.getResultSet();
								r1.beforeFirst();
								while(r1.next())
								{
									tot=tot+r1.getInt("count");
									nont=r1.getInt("count");

								}
							}

%>



<%
int tot1=0;
if(db.operation("select gender,count(*) as cc from hostel_2021_2022.student s,hostel_2021_2022.studentrooms1 r where (s.registerno=r.registerno) and s.registerno in (select registerno from student_master.financestudent where status1=2 and cyear!=1 and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+")) group by gender","select"))
							{
								ResultSet r1=db.getResultSet();
								r1.beforeFirst();
								while(r1.next())
								{
									tot1=tot1+r1.getInt("cc");

								}
							}

%>


 





<%





	int lat=0;
	int latbe=0;
	int latbb=0;
	int lats2=0;
	int latbes2=0;
	int latbbs2=0;
	int lcount=0,ocount=0,lopcount=0,abcount=0,lcount2=0,ocount2=0,lopcount2=0,abcount2=0,attended1=0,leave1=0,od1=0;
String college="",msg="";
ResultSet rs4s=null,rs4sn=null;
String dt[]=new String[10];
//String slot=request.getParameter("slot");
String date="";
String date1=date;
Double a1=0.0;
String subject="";
int tots1=0,tots2=0,totall=0,notattended=0,lop=0,od=0,attended=0,leave=0;


NumberFormat nf = new DecimalFormat("0.00");

if(db.operation("select * from vignan.college","select"))
{
ResultSet rs=db.getResultSet();
rs.beforeFirst();
if(rs.next())
{
	college=rs.getString("collegename")+"::"+rs.getString("location");
}
rs=null;
}

if(db.operation("select current_date as dd from dual","select"))
{
ResultSet rs=db.getResultSet();
rs.beforeFirst();
if(rs.next())
{
	date=rs.getString("dd");
}
rs=null;
}



%>
<title><%=college%></title>
<style type="text/css">
td	{font-size:9pt;font-family: Arial, Verdana; font-weight:normal;}
</style>
</head>





<%

//out.println("select sum(tottalstaff) as tottal,sum(attended) as attended,sum(leave) as leave,sum(OD) as od,sum(lop) as lop,sum(notattended) as not attended from dashboarddata.staffattendance where date='2020-01-27'");
if(db.operation("select sum(totalstaff) as tottal,sum(attended) as attended,sum(leavecount) as leave1,sum(OD) as od,sum(lop) as lop,sum(notattended) as notattended from dashboarddata.staffattendance where date=current_date","select"))
{
ResultSet rs=db.getResultSet();
rs.beforeFirst();
if(rs.next())
{
	attended=rs.getInt("attended");
	leave=rs.getInt("leave1");
	od=rs.getInt("od");
	lop=rs.getInt("lop");
	notattended=rs.getInt("notattended");
	//out.println(rs.getInt("cc"));
}
rs=null;
}

//out.println("select sum(totalstaff) as tottal,sum(before8or9) as attended,sum(8to8.15or9to9.15) as leave1,sum(after8.15or9.15) as od from dashboarddata.staffregularity where date=current_date");
if(db.operation("select sum(totalstaff) as tottal,sum(before8or9) as attended,sum(8to815or9to915) as leave1,sum(after815or915) as od from dashboarddata.staffregularity where date=current_date","select"))
{
ResultSet rss=db.getResultSet();
rss.beforeFirst();
if(rss.next())
{
	attended1=rss.getInt("attended");
	leave1=rss.getInt("leave1");
	od1=rss.getInt("od");
	
	//out.println(rs.getInt("cc"));
}
rss=null;
}



%>






<table>
<tr bgcolor='#FFCC99'><th colspan=3 align='center'>Attendance Analysis Report</th></th>
<tr>
<td>

<%
double m1=0;
String dd1="";
//out.println("select date_format(date,'%d-%m-%Y') as date1,ceil(avg(attpercent)) as perc from dashboarddata.perioadattbranch where date=current_date and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+")");
if(db.operation("select date_format(date,'%d-%m-%Y') as date1,ceil(avg(attpercent)) as perc from dashboarddata.perioadattbranch where date=(select date from dashboarddata.perioadattbranch order by date desc LIMIT 1) and period=1 and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+")","select"))
{
ResultSet rss=db.getResultSet();
rss.beforeFirst();
if(rss.next())
{
m1=rss.getDouble("perc");
dd1=rss.getString("date1");
}
}
%>

<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    <!--Load the AJAX API-->
    <script type="text/javascript" src="google.jsp_files/google.js"></script>
	<script type="text/javascript" src="googleinclude.js"></script>


   <script type="text/javascript">



      google.load('visualization', '1.0', {'packages':['corechart']});
      
	  google.setOnLoadCallback(drawChart8);
	  	    
	    function drawChart8() 
		  {
		//alert("hi");
		var i = 1;
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
		
          ['Pres(<%=m1%>)', <%=m1%>],
			  ['Abs (or) Att yet to be Marked(<%=nf.format(100-m1)%>)', <%=(100-m1)%>],
         
			
          //['Zucchini', 1],
         // ['Pepperoni', 2]
        ]);

      var options = {'title':'<%=dd1%> (Only Period-1)',
                       'width':370,
                       'height':250};

        var chart = new google.visualization.PieChart(document.getElementById('chart_div21'));
        chart.draw(data, options);
      }
	  </script>
<%
int ii21=21;
%>
<div  id="chart_div<%=ii21%>"></div>

	


</td>
<td>



<%
double m2=0;
String dd2="";
//out.println("select date_format(date,'%d-%m-%Y') as date1,ceil(avg(attpercent)) as perc from dashboarddata.perioadattbranch where date=current_date and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+") order by date desc limit 1,1");
if(db.operation("select date from dashboarddata.perioadattbranch where period=1 GROUP BY DATE order by date desc limit 1,1","select"))
{
ResultSet rssy=db.getResultSet();
rssy.beforeFirst();
if(rssy.next())
{
	//out.println("select date_format(date,'%d-%m-%Y') as date1,ceil(avg(attpercent)) as perc from dashboarddata.perioadattbranch where date='"+rssy.getString("date")+"' and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+") order by date desc limit 1,1");
if(db.operation("select date_format(date,'%d-%m-%Y') as date1,ceil(avg(attpercent)) as perc from dashboarddata.perioadattbranch where date='"+rssy.getString("date")+"' and period=1 and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+")","select"))
{
ResultSet rss=db.getResultSet();
rss.beforeFirst();
if(rss.next())
{
m2=rss.getDouble("perc");
dd2=rss.getString("date1");
}
}
}
}
%>




<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    <!--Load the AJAX API-->
    <script type="text/javascript" src="google.jsp_files/google.js"></script>
	<script type="text/javascript" src="googleinclude.js"></script>


   <script type="text/javascript">



      google.load('visualization', '1.0', {'packages':['corechart']});
      
	  google.setOnLoadCallback(drawChart2);
	  	    
	    function drawChart2() 
		  {
		//alert("hi");
		var i = 1;
        var data2 = new google.visualization.DataTable();
        data2.addColumn('string', 'Topping');
        data2.addColumn('number', 'Slices');
        data2.addRows([
		
       ['Pres(<%=m2%>)', <%=m2%>],
			  ['Abs(<%=nf.format(100-m2)%>)', <%=(100-m2)%>],
			
          //['Zucchini', 1],
         // ['Pepperoni', 2]
        ]);

      var options = {'title':'<%=dd2%>',
                       'width':370,
                       'height':250};

        var chart2 = new google.visualization.PieChart(document.getElementById('chart_div22'));
        chart2.draw(data2, options);
      }
	  </script>
<%
int iii22=22;
%>
<div  id="chart_div<%=iii22%>"></div>


	<%@ include file = "googleinclude.jsp"%>




</tr>
</table>















<table>
<tr><td>




<head>
<script type="text/javascript">
      google.load("visualization", "1.0", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart21);
      function drawChart21() {
		

var data21 = google.visualization.arrayToDataTable([
					  ['Type', ''],
				
					  ['<%=std1[1]%>', <%=stc1[1]%>,    ],						  
  ['<%=std1[2]%>', <%=stc1[2]%>,    ],				  
						    ['<%=std1[3]%>', <%=stc1[3]%>,    ],

					]);


        var options = {
          title: 'Year wise 1st period Att% on <%=dd1%>',
          hAxis: {title: ' Year', titleTextStyle: {color: 'red'}}
        };

        var chart21 = new google.visualization.ColumnChart(document.getElementById('chart_div28'));
        chart21.draw(data21, options);
      }
    </script>
</head>

 <div id="chart_div28" style="width: 740px; height: 300px;"></div>



</td></tr>

</table>

<br>

<table>

<tr><td>
<%

int im=0;
double a111=0,a2=0,a3=0,a4=0,a5=0,a6=0,a7=0,a8=0,a9=0,a10=0,a11=0,a12=0,a13=0,a14=0,a15=0,a16=0,a17=0,a18=0,a19=0,a20=0,a21=0,a22=0,a23=0,a24=0,a25=0,a26=0,a27=0,a28=0;
String dbc="";



if(db.operation("select * from dashboarddata.periodattbranch where  year=2 order by date desc limit 1","select"))
{
ResultSet rss8=db.getResultSet();
rss8.beforeFirst();
while(rss8.next())
{
a8=rss8.getDouble("period1");
a9=rss8.getDouble("period2");
a10=rss8.getDouble("period3");
a11=rss8.getDouble("period4");
a12=rss8.getDouble("period5");
a13=rss8.getDouble("period6");
a14=rss8.getDouble("period7");

}
}


if(db.operation("select * from dashboarddata.periodattbranch where  year=3 order by date desc limit 1","select"))
{
ResultSet rss8=db.getResultSet();
rss8.beforeFirst();
while(rss8.next())
{
a15=rss8.getDouble("period1");
a16=rss8.getDouble("period2");
a17=rss8.getDouble("period3");
a18=rss8.getDouble("period4");
a19=rss8.getDouble("period5");
a20=rss8.getDouble("period6");
a21=rss8.getDouble("period7");

}
}

if(db.operation("select * from dashboarddata.periodattbranch where  year=4 order by date desc limit 1","select"))
{
ResultSet rss8=db.getResultSet();
rss8.beforeFirst();
while(rss8.next())
{
a22=rss8.getDouble("period1");
a23=rss8.getDouble("period2");
a24=rss8.getDouble("period3");
a25=rss8.getDouble("period4");
a26=rss8.getDouble("period5");
a27=rss8.getDouble("period6");
a28=rss8.getDouble("period7");

}
}
%>




 


</table>
<br>
<table>
<tr bgcolor='#FFCC99'><th colspan=2 align='center'>Today Staff Regularity Analysis</th></th>
<tr>
<td>



<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    <!--Load the AJAX API-->
    <script type="text/javascript" src="google.jsp_files/google.js"></script>
	<script type="text/javascript" src="googleinclude.js"></script>


   <script type="text/javascript">



      google.load('visualization', '1.0', {'packages':['corechart']});
      
	  google.setOnLoadCallback(drawChart8);
	  	    
	    function drawChart8() 
		  {
		//alert("hi");
		var i = 1;
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
		
          ['Attended(<%=attended%>)', <%=attended%>],
			  ['Not Attended(<%=notattended%>)', <%=notattended%>],
           ['Leave(<%=leave%>)', <%=leave%>],
			['OD(<%=od%>)', <%=od%>],
			['lop(<%=lop%>)', <%=lop%>],
			
          //['Zucchini', 1],
         // ['Pepperoni', 2]
        ]);

      var options = {'title':'Staff Attendance Analysis',
                       'width':370,
                       'height':250};

        var chart = new google.visualization.PieChart(document.getElementById('chart_div8'));
        chart.draw(data, options);
      }
	  </script>
<%
int ii7=8;
%>
<div  id="chart_div<%=ii7%>"></div>

	


</td>
<td>








<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    <!--Load the AJAX API-->
    <script type="text/javascript" src="google.jsp_files/google.js"></script>
	<script type="text/javascript" src="googleinclude.js"></script>


   <script type="text/javascript">



      google.load('visualization', '1.0', {'packages':['corechart']});
      
	  google.setOnLoadCallback(drawChart2);
	  	    
	    function drawChart2() 
		  {
		//alert("hi");
		var i = 1;
        var data2 = new google.visualization.DataTable();
        data2.addColumn('string', 'Topping');
        data2.addColumn('number', 'Slices');
        data2.addRows([
		
          ['Before 8/9(<%=attended1%>)', <%=attended1%>],
			 
           ['8 to 8.15 / 9 to 9.15(<%=leave1%>)', <%=leave1%>],
			['After 8.15/9.15(<%=od1%>)', <%=od1%>],
			
			
          //['Zucchini', 1],
         // ['Pepperoni', 2]
        ]);

      var options = {'title':'Staff Regularity Analysis',
                       'width':370,
                       'height':250};

        var chart2 = new google.visualization.PieChart(document.getElementById('chart_div2'));
        chart2.draw(data2, options);
      }
	  </script>
<%
int iii=2;
%>
<div  id="chart_div<%=iii%>"></div>



</tr>
</table>

<br>
<table align='center' >
<tr bgcolor='#FFCC99' align='center'><th colspan=2 align='center'>STUDENT STRENGTH</th></tr>
<tr bgcolor='#FFCC99'><th>Year</th><th>COUNT</th><th>GRAPH</th></tr>
<tr bgcolor='#FFFFFF'><th><%=stt[1]%></th><th><%=stc[1]%></th>

<th rowspan=<%=j1%>>


<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    <!--Load the AJAX API-->
    <script type="text/javascript" src="google.jsp_files/google.js"></script>
	<script type="text/javascript" src="googleinclude.js"></script>


   <script type="text/javascript">



      google.load('visualization', '1.0', {'packages':['corechart']});
      
	  google.setOnLoadCallback(drawChart1);
	  	    
	    function drawChart1() 
		  {
		//alert("hi");
		var i = 1;
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
		['2nd Year (<%=stc[1]%>)', <%=stc[1]%>],
          ['3rd Year (<%=stc[2]%>)', <%=stc[2]%>],
           ['4th Year (<%=stc[3]%>)', <%=stc[3]%>],
			
          //['Zucchini', 1],
         // ['Pepperoni', 2]
        ]);

       var options = {'title':'Student Strength Analysis',
                       'width':570,
                       'height':250};

        var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
        chart.draw(data, options);
      }
	  </script>
<%
int ii4=1;
%>
<div  id="chart_div<%=ii4%>"></div>

	
</th>

</tr>
<tr  bgcolor='#FFFFFF'><th><%=stt[2]%></th><th><%=stc[2]%></th></tr>
<tr bgcolor='#FFFFFF'><th><%=stt[3]%></th><th><%=stc[3]%></th></tr>


<tr bgcolor='#FFCC99'><th>Total</th><th><%=tj1%></th><th>
<%
if(db.operation("select gender,count(*) as cc from student_master.financestudent where status1 in (2,3)  and cyear in (2,3,4) and semester!=0  and gender in ('M','F') and  branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+") group by gender","select"))
							{
								ResultSet r1=db.getResultSet();
								r1.beforeFirst();
								while(r1.next())
								{
%>

<%=r1.getString("gender").toUpperCase()%> : <%=r1.getInt("cc")%>
<%
								}
							}

%>


</th></tr>
</table>

<br>

<table>
<tr bgcolor='#FFCC99'><th>Staff Strength</th><th>Days Scholar / Hostel Strength</th></th>
<tr><td>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <title>Graph</title> 
		
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="oes.css"/>
   <script type="text/javascript" src="google.jsp_files/google.js"></script>
	<script type="text/javascript" src="googleinclude.js"></script>

	

<script type = "text/javascript" >

   function preventBack(){window.history.forward();}

    setTimeout("preventBack()", 0);

    window.onunload=function(){null};



    document.onkeydown = function (e) {
            if(e.which == 65){
                    return false;
            }
			if(e.which == 116)
				{
                    return false;
            }

    }


</script>



    <script language="javascript">
    document.onmousedown=disableclick;
    status="Right Click Disabled";
    Function disableclick(e)
    {
      if(event.button==2)
       {
         alert(status);
         return false;    
       }
    }




	
		 
    </script>


   
    </head>

<head>
<script type="text/javascript">
      google.load("visualization", "1.0", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart3);
      function drawChart3() {
		

var data = google.visualization.arrayToDataTable([
					  ['Type', ''],
				
					  ['Teaching', <%=teac%>,    ],						  
  ['Non Teaching', <%=nont%>,    ],						  

				

				          
                                         
				   
					]);


        var options = {
          title: 'Staff Strength',
          hAxis: {title: 'Staff Type', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div3'));
        chart.draw(data, options);
      }
    </script>
</head>

 <div id="chart_div3" style="width: 370px; height: 200px;"></div>


</td><td>
<script type="text/javascript">
      google.load("visualization", "1.0", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart4);
      function drawChart4() {
		

var data = google.visualization.arrayToDataTable([
					  ['Type', ''],
				
					  ['Days Scholar', <%=(tj7-tot1)%>,    ],						  
  ['Hosteler', <%=tot1%>,    ],						  

				

				          
                                         
				   
					]);


        var options = {
          title: 'Student Strength',
          hAxis: {title: ' Type', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div4'));
        chart.draw(data, options);
      }
    </script>
</head>

 <div id="chart_div4" style="width: 370px; height: 200px;"></div>

</td></tr>
<tr bgcolor='#FFCC99'><th>
<%
if(db.operation("select gender,count(*) as count from staffmaster.facultydetails where departmentid="+deptid+" and status=1 and empcode not in (select empcode from fin.relievers)   and teaching in ('teaching','nonteaching')  and gender in ('M','F')  group by gender","select"))
							{
								ResultSet r1=db.getResultSet();
								r1.beforeFirst();
								while(r1.next())
								{
%>

<%=r1.getString("gender").toUpperCase()%> : <%=r1.getInt("count")%>
<%
								}
							}
							%>
</th>
<th>Hostelers Gender Wise Status = 
<%
if(db.operation("select gender,count(*) as cc from hostel_2021_2022.student s,hostel_2021_2022.studentrooms1 r where (s.registerno=r.registerno) and s.registerno in (select registerno from student_master.financestudent where status1=2 and cyear!=1 and branchcode in (select branchcode from vignan.branchdepartment where coursecode='A' and deptid="+deptid+")) group by gender","select"))
							{
								ResultSet r1=db.getResultSet();
								r1.beforeFirst();
								while(r1.next())
								{
									tot1=tot1+r1.getInt("cc");
%>

<%=r1.getString("gender").toUpperCase()%> : <%=r1.getInt("cc")%>
<%
								}
							}
%>
</th>

</tr>
</table>

 <table width="100%" cellpadding="0" cellspacing="0" border="0" align="center">
 <!-- MAIN CONTENT START -->




<tr><td><a href="rangecounttotal.jsp" style="font-weight:bold" target="_blank">University Students Attendance Analysis Report</a></td></tr>

 <!-- MAIN CONTENT START -->


<%
 

if(db.operation("select count(*) as cc from staffmaster.facultydetails where departmentid="+deptid+" and status=1 and empcode not in (select empcode from fin.relievers) and month(doj)=month(CURRENT_DATE) and year(doj)=year(CURRENT_DATE)","select"))
							{
								ResultSet r31=db.getResultSet();
								r31.beforeFirst();
								while(r31.next())
								{
%>
<tr><td style="font-weight:bold">No of Staff joined in this month : <%=r31.getInt("cc")%></h3></td></tr><br>
<%
								}
							}

							

							if(db.operation("select count(*) as cc from staffmaster.facultydetails where departmentid="+deptid+" and status=1 and empcode in (select empcode from fin.relievers where month(dor)=month(CURRENT_DATE) and year(dor)=year(CURRENT_DATE))","select"))
							{
								ResultSet r31=db.getResultSet();
								r31.beforeFirst();
								while(r31.next())
								{
%>
<tr><td style="font-weight:bold">No of Staff relived in this month : <%=r31.getInt("cc")%></h3></td></tr>
<%
								}
							}
%>


<!--<tr><td><h3><a href="detrepo.jsp">Period Wise All Branches Day Attendance Report</a></td></tr>

 <!-- MAIN CONTENT START -->





<br><br>

<tr>
<!--<tr><td><h3><a href="dethos.jsp">Hostel Students Period Wise All Branches Day Attendance Report</a></td></tr>

 <!-- MAIN CONTENT START -->

<tr><td>
<br><br>
</td></tr>
</table>
<%
}
%>

<br>

 <table>
 

	
<tr><a href="detrepommm.jsp" style="font-weight:bold">Period Wise All Branches Day Attendance Report</a><br><br>
<tr><a href="detrepomm.jsp" style="font-weight:bold">Period Wise All Branches Day Attendance Report-Hostel(New)</a><br><br>

<tr><a href="SectionAtt.jsp" style="font-weight:bold">Section Wise Attendance Consolidate Report</a><br><br>
 <!-- MAIN CONTENT START -->







<tr><a href="absenthostel.jsp" style="font-weight:bold">Hostel Students Period Wise Absenties Report</a><br><br>


<tr><a href="rangecounttotal.jsp" style="font-weight:bold">VFSTR Overall Percentage (Will be updated every monday)</a><br><br>
 <!-- MAIN CONTENT START -->




<table>
<tr>
  <table width="100%" cellpadding="0" cellspacing="0" border="0" align="center">
 <!-- MAIN CONTENT START -->

 <tr>
  <td align="centre" class="ListingHead">Notice Board<hr noShade size="1"></td>
   
  </tr>
<tr>
  <td align="centre" class="ListingHead"><!DOCTYPE html>
<html>
<head>
    <title>Tabbed Content</title>
    <script src="tabcontent.js" type="text/javascript"></script>
    <link href="template1/tabcontent.css" rel="stylesheet" type="text/css" />
</head>
<body >
    <div style="width: auto; margin: 0 auto; ">
        <ul class="tabs" data-persist="true">
            <li><a href="#view1">R&D</a></li>
            <li><a href="#view2">Academics</a></li>

			<li><a href="#view3">Registrar Office</a></li>
			<li><a href="#view4">Exam Cell</a></li>
			<li><a href="#view5">IT Services</a></li>
			<li><a href="#view6">IQAC Office</a></li>
        </ul>
        <!--<div class="tabcontents">
            <div id="view1">
                <a style="text-decoration: none;" href="./noticeboard/Ad_Summer-Training-Program-2017.pdf"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">Summer Training Program</font></a>
				<br>
				
				<a style="text-decoration: none;" href="./noticeboard/Waste management technologies-proposals-DST.pdf"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">Waste management technologies-proposals-DST</font></a>
				<br>
				<a style="text-decoration: none;" href="./noticeboard/AMT programme - proposals called for DST.pdf"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">AMT programme - proposals called for DST</font></a>
				<br>
				<a style="text-decoration: none;" href="./noticeboard/DHI-DST Technology Platform for Electric Mobility (TPEM).pdf"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">DHI-DST Technology Platform for Electric Mobility (TPEM)</font></a>
				<br>
				<a style="text-decoration: none;" href="./noticeboard/Board of Research Meeting Minutes-03.12.2016.pdf"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">Board of Research Meeting Minutes-03.12.2016</font></a>
				

                
            </div>-->
			<div id="view1">
             <a style="text-decoration: none;" href="./noticeboard/Faculty seed grant annexures.docx"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">Faculty seed grant annexures</font></a>
			 <br>
			 <a style="text-decoration: none;" href="./noticeboard/Student research grant annexures.docx"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">Student research grant annexures</font></a>
			<br>
			  <a style="text-decoration: none;" href="./noticeboard/Faculty seed grant policy.pdf"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">Faculty seed grant policy</font></a>
					<br>
			   <a style="text-decoration: none;" href="./noticeboard/Student research grant policy.pdf"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">Student research grant policy</font></a>

            </div>
            <div id="view2">
                               
            </div>
            <div id="view3">
                
            </div>
			<div id="view4">
                             
            </div>
			<div id="view5">
                             
            </div>
			<!--<div id="view5">
                <a style="text-decoration: none;" href="./noticeboard/Checklist for DEOs-modified  kvk.pdf"  onclick="window.open(this.href); return false;" title="VFSTR" style="font-family:verdana;font-size:11px;" >&raquo;&nbsp;<font size="2" color="#006699">Check List for DEO's for semester preparation</font></a>               
            </div>-->
			<div id="view6">
			<font size="2" color="#006699">All faculty suggested to register their profiles in VIDWAN Site</font>
			<!--<font size="2" color="#006699">Faculty are requested to ensure that you have received the ID card in new tag with the VFSTR (Deemed to be University) logo. If not, please update it immediately.</font>-->
                               
            </div>
        </div>
    </div>
</body>
</html>
</td>
  </tr>


</table>

</tr>



</td>



</head>

<!-- MAIN CONTENT END -->
</table>
 </td>
                        
                        <td style="width:10px; height:10px; background-image: url(Images/R_BG.gif); background-repeat:repeat-y;">
                        <img src="Images/Pixel-2.gif" width="10" height="10" />
                        </td>
                    </tr>
                    
                    
                    
                    <tr>
                        <td style="width:10px; height:10px"><img src="Images/BL.gif" width="10" height="10" /></td>
                        <td style="width:690px; height:10px; background-image: url(Images/B_BG.gif); background-repeat:repeat-x; background-position:top;">
                        <img src="Images/Pixel-2.gif" width="690" height="10" /></td>
                        <td style="width:10px; height:10px"><img src="Images/BR.gif" width="10" height="10" /></td>
                    </tr>
                    
                    <tr>
                        <td colspan="3"><img src="Images/Pixel-2.gif" width="710" height="10" /></td>
                    </tr>
                </table>
            </td>
            <td width="260" valign="top">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="100%">

<table border="0" cellpadding="0" cellspacing="0" width="260">

<tr valign="top">

<td valign="top" style="width: 260px; padding: 0px">
                <table border="0" cellpadding="0" cellspacing="0" width="260">
                    
                    <tr>
                        <td style="width:10px; height:10px"><img alt="" src="Images/Right/TL.gif" width="10" height="10" /></td>
                        <td style="width:240px; height:10px; background-image: url(Images/Right/Top_BG.gif); background-repeat:repeat-x; background-position:top;">
                        <img src="Images/Pixel-2.gif" width="240" height="10" /></td>
                        <td style="width:10px; height:10px"><img src="Images/Right/TR.gif" width="10" height="10" /></td>
                    </tr>
                    
                    
                    
                    
                    <tr>
                        <td style="width:10px; height:10px; background-image: url(Images/Right/Left_BG.gif); background-repeat:repeat-y;">
                        <img src="Images/Pixel-2.gif" width="10" height="10" />
                        </td>
                        
                        <td style="width:240px; background-color:White;">
                            <table border="0" cellpadding="0" cellspacing="0" width="240">
                             
                               
                                <tr class="Mediums">
                                            <td colspan="3" style='padding-bottom:5px;border-bottom: solid 2px darkRed;'>QUICK LINKS</td>
                                </tr>
                                <tr>
									<td width="228" valign="top">
										<ul class="RightLists">
											<li><a href="changePW.jsp">Change Password</a></li>
											<li><a href="workapprove.jsp">Work Adjustment Approval</a></li>				
                      <%
                        int desi = 0;
                        ResultSet rl = null;
                        if(db.operation("select * from vignan.hods1 where deanid = '"+user+"'","select"))
                        {
                           
                          %>
                            				<li><a href="deanworkapprove.jsp">Hod leave Approval</a></li>				
                          <%
                        }

                      %>
                      <%
                        
                        if(db.operation("select * from vignan.hods1 where empcode = '"+user+"'","select"))
                        {
                           
                          %>
                            				<li><a href="hodworkapprove.jsp">faculty leave Approval</a></li>				
                          <%
                        }

                      %>
										</ul>
										</td>
										
									</tr>
                                
                            </table>
                        </td>
  <jsp:include page="news.jsp"/>
                        
                        <td style="width:10px; height:10px; background-image: url(Images/Right/Right_BG.gif); background-repeat:repeat-y;">
                        <img src="Images/Pixel-2.gif" width="10" height="10" />
                        </td>
                    </tr>
                    
                    
                    
                    
                    
                </table>
            </td>

</tr>


</table>

 
                   
</td>
                    </tr>
                    
                </table>
            </td>

        </tr>
        </tbody></table>

                </td>
            </tr>
        </table>
    </td>
</tr>

</table>
</div>
</body>
</html>
<head>
<style>
table {
  border-collapse: separate;
}
</style>
</head>
