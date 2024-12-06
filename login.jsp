<!DOCTYPE html>
<%@ page import="java.sql.*,model.DataManager,java.security.MessageDigest"%>
<%@ include file="smscodeNew4.jsp"%>

<%
DataManager db=(DataManager)pageContext.getAttribute("db",PageContext.APPLICATION_SCOPE);

if(db.getErrorMessage().contains("connection closed")||db.getErrorMessage().contains("Communication")||db.getErrorMessage().contains("Not connected")||db.getErrorMessage().contains("Connection was implicitly closed by the driver"))
{
	db.connect();
}

String iip = request.getHeader("X-Forwarded-For");  

        if (iip == null || iip.length() == 0 || "unknown".equalsIgnoreCase(iip)) {  
            iip = request.getHeader("Proxy-Client-ip");  
        }  
        if (iip == null || iip.length() == 0 || "unknown".equalsIgnoreCase(iip)) {  
            iip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (iip == null || iip.length() == 0 || "unknown".equalsIgnoreCase(iip)) {  
            iip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (iip == null || iip.length() == 0 || "unknown".equalsIgnoreCase(iip)) {   
            iip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (iip == null || iip.length() == 0 || "unknown".equalsIgnoreCase(iip)) {  
            iip = request.getRemoteAddr();  
        } 

		session.setAttribute("iip",iip);

//out.println(iip);



//out.println("select ip from vignan.ipmatching where ip like '"+iip1+"%'");
		
String addr = request.getRemoteAddr();

session.setAttribute("addr",addr);

String user = request.getParameter("user");
String passwd = request.getParameter("pwd");
boolean userFound=false;
String msg="",phno="";
int datediff=0;
//out.println(user+"<br>"+passwd);

if(request.getParameter("re")!=null)
{
String data1="VIG"+(int) (Math.random() * 10000);
String data23="Your Password is : "+data1+" -VFSTR";

						//out.println(data1);
						
			String password2="";
			StringBuffer sb2 = new StringBuffer();
			try
			{
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
				messageDigest.update(data1.getBytes("UTF-8"));
				byte[] digestBytes = messageDigest.digest();


				String hex2 = null;

				for (int i = 0; i < digestBytes.length; i++)
				{
					//Convert it to positive integer and then to Hex String

					hex2 = Integer.toHexString(0xFF & digestBytes[i]);

					//Append "0" to the String to made it exactly 128 length (SHA-512 alogithm)
					if (hex2.length() < 2)
						sb2.append("0");
					sb2.append(hex2);
				}
			}
			catch (Exception e)
			{
				out.println(""+e);
			}
			password2=sb2.toString();
			//out.println(password2);
			if(db.operation("select * from staffmaster.facultydetails where empcode='"+user+"'","select"))
					{
						ResultSet rs8818=db.getResultSet();
						rs8818.beforeFirst();
						if(rs8818.next())
						{
							phno=rs8818.getString("phoneno");
						}
					}
					int ret=0;

				ret=sendSMS(phno,data23,user,user,addr);
db.operation("delete from vignan.logincount where usercode='"+user+"'","delete");
						db.operation("update vignan.login set passcode='"+password2+"',pwd_date=CURRENT_DATE where usercode='"+user+"'","update");
						msg="Password sent to your mobile";

}
if(request.getParameter("log")!=null)
{

if(user!=null && passwd!=null)
{
	user=user.replace("'","");

	db.operation("update vignan.login set cur_date = (select CURRENT_DATE) where usercode='"+user+"'","update");
	if(db.operation("select * from vignan.login where usercode='"+user+"' and usercode not in (select empcode from fin.relievers)","select"))
	{
		ResultSet rs=db.getResultSet();
		rs.beforeFirst();
		if(rs.next())
		{
			String pwddate=rs.getString("pwd_date");
			String curdate=rs.getString("cur_date");
			
            if(db.operation("SELECT DATEDIFF('"+curdate+"','"+pwddate+"') AS DiffDate","select"))
			{
             ResultSet rs2=db.getResultSet();
			 rs2.beforeFirst();
			 while(rs2.next())
				{
				 datediff=rs2.getInt("DiffDate");
				}
			}
			
			db.operation("update vignan.login set count = "+datediff+" where usercode='"+user+"'","update");
			//out.println(datediff);
			session.setAttribute("count",rs.getInt("count"));

			String data=passwd;
			String password="";
			StringBuffer sb = new StringBuffer();
			try
			{
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
				messageDigest.update(data.getBytes("UTF-8"));
				byte[] digestBytes = messageDigest.digest();


				String hex = null;

				for (int i = 0; i < digestBytes.length; i++)
				{
					//Convert it to positive integer and then to Hex String

					hex = Integer.toHexString(0xFF & digestBytes[i]);

					//Append "0" to the String to made it exactly 128 length (SHA-512 alogithm)
					if (hex.length() < 2)
						sb.append("0");
					sb.append(hex);
				}
			}
			catch (Exception e)
			{
				out.println(""+e);
			}
			password=sb.toString();

			if(user.equals("00170"))
			{

			if(user.equals(rs.getString("usercode")) && password.equals(rs.getString("passcode")))
			{
				//modules=rs.getString("module");
				session.setAttribute("who",user);
				
				session.setAttribute("usertypeid",rs.getInt("usertypeid"));
				session.setAttribute("deptid",rs.getInt("deptid"));
				session.setAttribute("moduleid",rs.getInt("moduleid"));
				session.setAttribute("what",rs.getInt("usertypeid"));
				
				session.setAttribute("passwd",passwd);
				userFound=true;
				//session.setMaxInactiveInterval(5*60);
				String college_name="";	
				ResultSet rscdb=null;
				if(db.operation("select * from vignan.college","select"))
					{
						rscdb=db.getResultSet();
						rscdb.beforeFirst();
						if(rscdb.next())
						{
							
							//session.setAttribute("college_location",rscdb.getString("location"));
							college_name = rscdb.getString("collegename") + " :: "+rscdb.getString("location");
							session.setAttribute("college_name",college_name);
						}
					}




					String data1="VIG"+(int) (Math.random() * 10000);
String data23=data1;
						//out.println(data1);
						
			String password2="";
			StringBuffer sb2 = new StringBuffer();
			try
			{
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
				messageDigest.update(data1.getBytes("UTF-8"));
				byte[] digestBytes = messageDigest.digest();


				String hex2 = null;

				for (int i = 0; i < digestBytes.length; i++)
				{
					//Convert it to positive integer and then to Hex String

					hex2 = Integer.toHexString(0xFF & digestBytes[i]);

					//Append "0" to the String to made it exactly 128 length (SHA-512 alogithm)
					if (hex2.length() < 2)
						sb2.append("0");
					sb2.append(hex2);
				}
			}
			catch (Exception e)
			{
				out.println(""+e);
			}
			password2=sb2.toString();
			//out.println(password2);
			if(db.operation("select * from staffmaster.facultydetails where empcode='"+user+"'","select"))
					{
						ResultSet rs8818=db.getResultSet();
						rs8818.beforeFirst();
						if(rs8818.next())
						{
							phno=rs8818.getString("phoneno");
						}
					}
					int ret=0;

				ret=sendSMS(phno,data23,user,user,addr);
db.operation("delete from vignan.logincount where usercode='"+user+"'","delete");
						db.operation("update vignan.login set passcode='"+password2+"' where usercode='"+user+"'","update");
						msg="Password sent to your mobile";

			}
			else
			{
				msg="Wrong  Password";
				int count=0;
					ResultSet rs881=null;
				if(db.operation("select count from vignan.logincount where usercode='"+user+"'","select"))
					{
						rs881=db.getResultSet();
						rs881.beforeFirst();
						if(rs881.next())
						{
							count=rs881.getInt("count");
						}
					}
					
					if(count==2)
				{
						//out.println("sdf");
						msg=msg+"<br><font colos='red'>Your Login is Expired, please contact DEO</font>";
				db.operation("update vignan.login set passcode='07c274f730baf18bde72ff82e1a5e71b884125f966c44433c43b4d766ea48c2068dc451f2f0770c7d378a8de59f1079cf2e7e40ea9526e7bc68b992ce7d48f16' where usercode='"+user+"'","update");
				}

				if(count==1)
				{
						msg=msg+"<br><font colos='red'>This is your Last chance to Login</font> ";
				}

				if(count>=3)
				{
						msg=msg+"<br><font colos='red'>Your Login is already Expired, Reset your password.</font>";


						
				}

				if(count<=2)
				{

					ResultSet rs88=null;
				if(db.operation("select * from vignan.logincount where usercode='"+user+"'","select"))
					{
						rs88=db.getResultSet();
						rs88.beforeFirst();
						if(rs88.next())
						{
					db.operation("update vignan.logincount set count=count+1 where usercode='"+user+"'","update");
						}
					}
					else
				{
					db.operation("insert into vignan.logincount values('"+user+"',1)","insert");
				}
				}
	


			}
			}
			else
				{

			if(user.equals(rs.getString("usercode")) && password.equals(rs.getString("passcode")))
			{
				//modules=rs.getString("module");
				session.setAttribute("who",user);
				session.setAttribute("usertypeid",rs.getInt("usertypeid"));
				session.setAttribute("deptid",rs.getInt("deptid"));
				session.setAttribute("moduleid",rs.getInt("moduleid"));
				session.setAttribute("what",rs.getInt("usertypeid"));
				session.setAttribute("passwd",passwd);
				userFound=true;
				//session.setMaxInactiveInterval(5*60);
				String college_name="";	
				ResultSet rscdb=null;
				if(db.operation("select * from vignan.college","select"))
					{
						rscdb=db.getResultSet();
						rscdb.beforeFirst();
						if(rscdb.next())
						{
							
							//session.setAttribute("college_location",rscdb.getString("location"));
							college_name = rscdb.getString("collegename") + " :: "+rscdb.getString("location");
							session.setAttribute("college_name",college_name);
						}
					}

			}
			else
			{
				msg="Wrong  Password";
				int count=0;
					ResultSet rs881=null;
				if(db.operation("select count from vignan.logincount where usercode='"+user+"'","select"))
					{
						rs881=db.getResultSet();
						rs881.beforeFirst();
						if(rs881.next())
						{
							count=rs881.getInt("count");
						}
					}
					
					if(count==2)
				{
						//out.println("sdf");
						msg=msg+"<br><font colos='red'>Your Login is Expired, please reset your password</font>";
				db.operation("update vignan.login set passcode='07c274f730baf18bde72ff82e1a5e71b884125f966c44433c43b4d766ea48c2068dc451f2f0770c7d378a8de59f1079cf2e7e40ea9526e7bc68b992ce7d48f16' where usercode='"+user+"'","update");
				}

				if(count==1)
				{
						msg=msg+"<br><font colos='red'>This is your Last chance to Login</font> ";
				}

				if(count>=3)
				{
						msg=msg+"<br><font colos='red'>Your Login is already Expired, Please reset your password.</font>";


						
				}

				if(count<=2)
				{

					ResultSet rs88=null;
				if(db.operation("select * from vignan.logincount where usercode='"+user+"'","select"))
					{
						rs88=db.getResultSet();
						rs88.beforeFirst();
						if(rs88.next())
						{
					db.operation("update vignan.logincount set count=count+1 where usercode='"+user+"'","update");
						}
					}
					else
				{
					db.operation("insert into vignan.logincount values('"+user+"',1)","insert");
				}
				}
	


			}
			}

		}
		else
		{
			msg="Invalid User ";
			int count=0;
					ResultSet rs881=null;
				if(db.operation("select count from vignan.logincount where usercode='"+user+"'","select"))
					{
						rs881=db.getResultSet();
						rs881.beforeFirst();
						if(rs881.next())
						{
							count=rs881.getInt("count");
						}
					}
					
					if(count==2)
				{
						//out.println("sdf");
						msg=msg+"<br><font colos='red'>Your Login is Expired, please contact DEO</font>";
				db.operation("update vignan.login set passcode='07c274f730baf18bde72ff82e1a5e71b884125f966c44433c43b4d766ea48c2068dc451f2f0770c7d378a8de59f1079cf2e7e40ea9526e7bc68b992ce7d48f16' where usercode='"+user+"'","update");
				}

				if(count==1)
				{
						msg=msg+"<br><font colos='red'>This is your Last chance to Login</font> ";
				}

				if(count>=3)
				{
						msg=msg+"<br><font colos='red'>Your Login is already Expired, Please Contact DEO.</font> "+(int) (Math.random() * 1000);
				}

				if(count<=2)
				{

					ResultSet rs88=null;
				if(db.operation("select * from vignan.logincount where usercode='"+user+"'","select"))
					{
						rs88=db.getResultSet();
						rs88.beforeFirst();
						if(rs88.next())
						{
					db.operation("update vignan.logincount set count=count+1 where usercode='"+user+"'","update");
						}
					}
					else
				{
					db.operation("insert into vignan.logincount values('"+user+"',1)","insert");
				}
				}
		}
		rs.close();
		
		if(userFound)
		{
db.operation("delete from vignan.logincount where usercode='"+user+"'","delete");
db.operation("delete from vignan.loginsession where empcode='"+user+"'","delete");

String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }
db.operation("insert into vignan.loginsession values('"+user+"',ADDTIME(CURRENT_TIMESTAMP, '00:15:00'))","insert");
db.operation("insert into transaction.logindetails values('"+user+"',0,0,'"+ip+"',CURRENT_DATE,CURRENT_TIME)","insert");
session.setAttribute("ip",ip);


			%>
			<jsp:forward page="controller.jsp"/>
			<%
		}
	}
	else
	{
		msg="Invalid User ";

		int count=0;
					ResultSet rs881=null;
				if(db.operation("select count from vignan.logincount where usercode='"+user+"'","select"))
					{
						rs881=db.getResultSet();
						rs881.beforeFirst();
						if(rs881.next())
						{
							count=rs881.getInt("count");
						}
					}
					
					if(count==2)
				{
						//out.println("sdf");
						msg=msg+"<br><font colos='red'>Your Login is Expired, please contact DEO</font>";
				db.operation("update vignan.login set passcode='07c274f730baf18bde72ff82e1a5e71b884125f966c44433c43b4d766ea48c2068dc451f2f0770c7d378a8de59f1079cf2e7e40ea9526e7bc68b992ce7d48f16' where usercode='"+user+"'","update");
				 out.println((int) (Math.random() * 100));
				}

				if(count==1)
				{
						msg=msg+"<br><font colos='red'>This is your Last chance to Login</font> ";
				}

				if(count>=3)
				{
						msg=msg+"<br><font colos='red'>Your Login is already Expired, Please Contact DEO.</font> "+(int) (Math.random() * 100);
				}

				if(count<=2)
				{

					ResultSet rs88=null;
				if(db.operation("select * from vignan.logincount where usercode='"+user+"'","select"))
					{
						rs88=db.getResultSet();
						rs88.beforeFirst();
						if(rs88.next())
						{
					db.operation("update vignan.logincount set count=count+1 where usercode='"+user+"'","update");
						}
					}
					else
				{
					db.operation("insert into vignan.logincount values('"+user+"',1)","insert");
				}
				}
	}
}
}
%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>VIMS Logins</title>
	<link rel="stylesheet" type="text/css" href="chris2.css"> 

	<link rel="stylesheet" href="form2.css">
	
<script type="text/javascript">
function v()
{
	if(document.form1.user.value=="")
	{
		alert("Enter User name");
		document.form1.user.focus();
		return false;
	}
	else if(document.form1.pwd.value=="")
	{
		alert("Enter Password");
		document.form1.pwd.focus();
		return false;
	}
}

function v1()
{
	if(document.form1.user.value=="")
	{
		alert("Enter User name");
		document.form1.user.focus();
		return false;
	}
	
}
</script>

</head>

<body>

<header>
	<main>
		<section>
			<div class="container">
				<div class="head">
					<h1>Login Here</h1>
				</div>
				<br><strong><font color='#000'><%=msg%></font></strong>
				<form name="form1" method="post" action="login.jsp">
				<div class="form-section">
				<div class="user-box">
						<input type="text"  name="user" id="uid" >
						<span><label for="uid"><b>Login Id</b></label></span>
					</div>
				<div class="user-box">
						<input type="password"  name="pwd" id="psw">
						<span><label for="psw"><b>Password</b></label></span>
				</div>
				
				<div class="">
					<input id="bt" type="submit" class="submit" value="LOGIN"  name='log' onClick="return v()">
				</div>
				<div class="two-col">
					<div class="one"></div>
					<div class="two">
						<input id="bt1" type="submit" class="submit" value="Reset Password&nbsp;?"   name='re' onClick="return v1()">					
					</div>
				</div>
			</div>
				</form>
			</div>
		</section>
	</main>
	
	
	
</header>

</body>
</html>