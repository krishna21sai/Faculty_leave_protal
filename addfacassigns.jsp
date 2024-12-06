<%@ include file="includingfile.jsp" %>
<%@ page import="java.sql.*,model.DataManager,java.security.MessageDigest"%>
<%@ include file="smscodeNew4.jsp"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="javax.mail.*" %>
<%@ page import="javax.mail.internet.*" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.mail.Authenticator" %>
<%@ page import="javax.mail.PasswordAuthentication" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Work adjustment</title>
    <style>
        #facultyadj {
            width: 300px; /* Adjust the width as needed */
            padding: 5px;
            font-size: 16px;
        }
    </style>
</head>
<body>

<%
    // Fetch parameters and initialize variables
    String countStr = request.getParameter("count");
   // out.println(countStr); 
    String countStr2 = request.getParameter("counter");
    String pid = request.getParameter("pid");
    ResultSet rs = null;
    int p = 0;
    String lcourse = "";
    String lofaculty = "";
    String lbranch = "";
    String lsemester = "";
    String lsection = "";
    String lsubject = "";
    String lyear = "";
    String lperiod = "";
    String lfacid = "";
    String lldate = "";
	String bcode = "";
    if (countStr != null && !countStr.isEmpty())
    {
        try
        {
            p = Integer.parseInt(countStr);
        } catch (NumberFormatException e)
        {
            out.println("Invalid number format for 'count': " + e.getMessage());
        }
    }
    String kk;
    if(usertypeid == 10)
    {
       kk = (String)session.getAttribute("emp2");
    }
    else
    {
	    kk = (String)session.getAttribute("who");
    }
    out.println(kk);
    ResultSet rss = null;
    out.println(kk);
    for (int i = 0; i < p; i++)
    {
        lofaculty = kk;
        lcourse = request.getParameter("course_" + i);
        lbranch = request.getParameter("branch_" + i);
        lsemester = request.getParameter("semester_" + i);
        lsection = request.getParameter("section_" + i);
        lsubject = request.getParameter("subject_" + i);
        lyear = request.getParameter("year_" + i);
        lperiod = request.getParameter("period_" + i);
        lfacid = request.getParameter("facid_" + i);
        lldate = request.getParameter("date_" + i);
		
        String insertQuery = "INSERT INTO fleavesauto.facassign (id,Coursecode,Branchcode, year, Semester, Section, Subject, Date, Period, faculty, orgfaculty,status,entereddate,enteredtime) VALUES ("+pid+",'"+lcourse+"','"+ lbranch + "','" + lyear + "', '" + lsemester + "', '" + lsection + "', '" + lsubject + "','" + lldate + "', '" + lperiod + "','" + lfacid + "','" + lofaculty + "',0,Current_date,Current_time)";
        String branch11 = " ",namee = " ";
        //out.println("select * from vignan.branch where branchcode = "+lbranch+" and coursecode = "+lcourse+"");
        if(db.operation("select * from vignan.branch where branchcode = "+lbranch+" and coursecode = '"+lcourse+"' ","select"))
        {
            rss = db.getResultSet();
            branch11 = rss.getString("shortname");
        }
        if (db.operation(insertQuery, "insert"))
        {
            // Data inserted successfully
        } else
        {
            out.println("Failed to insert data for record " + i + ".<br>");
        }
        //out.println("select name from staffmaster.facultydetails where empcode = '"+lofaculty+"'");
        if(db.operation("select name from staffmaster.facultydetails where empcode = '"+lofaculty+"'","select"))
        {
            rss = db.getResultSet();
            namee = rss.getString("name");
        }
        if (db.operation("select email from mydb.verify where empcode = '" + lfacid + "'", "select"))
        {
			rs = db.getResultSet();
			//String email = rs.getString("email");

			//out.println(email1);
            String email = "211FA04021@vignan.ac.in"; // Correct email fetching
            final String subject = "Work Adjustment Notice";
            String body = "Dear Faculty,\n\n"
            + "You have been assigned to cover the following class:\n\n"
            + "Faculty Member (Empcode): " + lofaculty +"-"+ namee + "\n"
            + "Branch: " + branch11 + "\n"
            + "Semester: " + lsemester + "\n"
            + "Section: " + lsection + "\n"
            + "Subject: " + lsubject + "\n"
            + "Year: " + lyear + "\n"
            + "Period: " + lperiod + "\n"
            + "Date: " + lldate + "\n\n"
            + "Regards,\n"
            + "Admin";


            // Email properties
            String host = "smtp.office365.com";
            String port = "587";
            final String mailFrom = "software_td@vignan.ac.in";
            final String password = "A123B456C789*";

            Properties properties = new Properties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // Create mail session
            Session mailSession = Session.getInstance(properties, new Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(mailFrom, password);
                }
            });

            try {
                // Create the email message
                MimeMessage message = new MimeMessage(mailSession);
                message.setFrom(new InternetAddress(mailFrom));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                message.setSubject(subject);
                message.setText(body);

                // Send the email
                Transport.send(message);
                out.println("Email sent successfully to " + email);

                // Store email in session for verification
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("email", email);
            } catch (MessagingException e) {
                out.println("Error occurred while sending email: " + e.getMessage());
            }
    }
    if(db.operation("select phoneno from staffmaster.facultydetails where empcode = '" + lfacid + "'", "select"))
    {
        out.println("select phoneno from staffmaster.facultydetails where empcode = '" + lfacid + "'");
        String addr = (String) session.getAttribute("addr");
            out.println(addr);
            String data23="Dear Faculty,\n\n"
            + "You have been assigned to cover the following class:\n\n"
            + "Faculty Member (Empcode): " + lofaculty +"-"+ namee + "\n"
            + "Branch: " + branch11 + "\n"
            + "Semester: " + lsemester + "\n"
            + "Section: " + lsection + "\n"
            + "Subject: " + lsubject + "\n"
            + "Year: " + lyear + "\n"
            + "Period: " + lperiod + "\n"
            + "Date: " + lldate + "\n\n"
            + "Regards,\n"
            + "Admin";
            String phno = "";
            if(db.operation("select * from staffmaster.facultydetails where empcode='"+lfacid +"'","select"))
            {
                ResultSet rs8818=db.getResultSet();
                rs8818.beforeFirst();
                if(rs8818.next())
                {
                    phno = rs8818.getString("phoneno");
                }
                out.println(phno);
            }
            int ret=0;
            ret=sendSMS(phno,data23,lfacid,lfacid,addr);
            out.println(ret);

        }
            }

    String llp = request.getParameter("count1");
    int llp1 = Integer.parseInt(llp);
    if(llp1>0)
    {
        //out.println("facid1" + llp1);
        int m = 1;
        ResultSet rs11  = null;
        while(m <= llp1){
        int role = Integer.parseInt(request.getParameter("role_" + m));
        String rolename = "";
        //out.println("select * from vignan.usertypes where Id = "+role+" ");
        if(db.operation("select * from vignan.usertypes where Id = "+role+" ","select"))
        {
			rs11 = db.getResultSet();
            rolename = rs11.getString("usertypename");
        }
        String fac1 = request.getParameter("facid1" + m);
        ResultSet op = null;
        String op1 = "";
        String op2 = "";
        if(db.operation("select * from staffmaster.leavedetails where Id = '"+pid+"'","select"))
        {
            op = db.getResultSet();
            op1 = op.getString("fromdat");
            op2 = op.getString("todat");

        }
        if(db.operation("insert into fleavesauto.adminadjustment values ("+pid+",'"+kk+"','"+role+"','"+fac1+"','"+op1+"','"+op2+"',0)","insert"))
        {
            //out.println("kk");
        }
        if (db.operation("select email from mydb.verify where empcode = '" + fac1 + "'", "select")) {
			rs = db.getResultSet();

			//String email = rs.getString("email");
			//out.println("email1");
            String email = "krishna.11.kunche@gmail.com"; // Correct email fetching
            String subject = "Work Adjustment Notice";
            String body = "Dear Faculty,\n\nYou have been assigned to cover for the role of "+rolename+"";

            // Email properties
            String host = "smtp.office365.com";
            String port = "587";
            final String mailFrom = "software_td@vignan.ac.in";
            final String password = "A123B456C789*";

            Properties properties = new Properties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // Create mail session
            Session mailSession = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailFrom, password);
                }
            });

            try {
                // Create the email message
                MimeMessage message = new MimeMessage(mailSession);
                message.setFrom(new InternetAddress(mailFrom));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                message.setSubject(subject);
                message.setText(body);

                // Send the email
                Transport.send(message);
                out.println("Email sent successfully to " + email);

                // Store email in session for verification
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("email", email);
            } catch (MessagingException e) {
                out.println("Error occurred while sending email: " + e.getMessage());
            }
            }
        m ++;
    }
}

%>
</body>
<%
    if (usertypeid == 1) {
        %>
        <!-- Include content based on usertypeid -->
        <%
    } else if (usertypeid == 2) {
        %>
        <!-- Include content based on usertypeid -->
        <%
    } else if (usertypeid == 3) {
        %>
        <jsp:include page="detaccept.jsp"/>
        <%
    } else if (usertypeid == 4) {
        %>
        <!-- Include content based on usertypeid -->
        <%
    } else if (usertypeid == 5) {
        %>
        <jsp:include page="hodleavefooter.jsp"/>
        <%
    } else if (usertypeid == 6 || usertypeid == 7 || usertypeid == 8) {
        %>
        <jsp:include page="staffLeaveFooter.jsp"/>
        <%
    } else if (usertypeid == 10) {
        %>
        <jsp:include page="deoleavefooter.jsp"/>
        <%
    } else if (usertypeid == 9 || usertypeid == 11) {
        %>
        <jsp:include page="programerLeaveFooter.jsp"/>
        <%
    } else if (usertypeid == 12) {
        %>
        <jsp:include page="deostafffooter.jsp"/>
        <%
    }
%>
</html>
