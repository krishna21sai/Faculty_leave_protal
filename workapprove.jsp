<%@ include file="includingfile.jsp" %>
<%@ include file="getdate.jsp" %>
<%@ page import="java.sql.*,model.DataManager,java.security.MessageDigest"%>
<%@ include file="smscodeNew4.jsp"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="./cal/epoch_styles.css" />
    <script type="text/javascript" src="./cal/epoch_classes.js"></script>

    <style>
        #wa {
            width: 100%;
            border-collapse: collapse;
        }
        #wa th, #wa td {
            border: 1px solid #000;
            padding: 8px;
            text-align: left;
        }
        #wa th {
            background-color: #f2f2f2;
        }
    </style>
	<script>
	function toggleCheckbox(checkbox) {
            const row = checkbox.closest('tr');
            const acceptCheckbox = row.querySelector('input[name="decision1"][value="accept"]');
            const denyCheckbox = row.querySelector('input[name="decision2"][value="deny"]');

            if (checkbox.value === "accept") {
                denyCheckbox.checked = false;
            } else {
                acceptCheckbox.checked = false;
            }
        }
    function handleSubmit() {
    const acceptCheckboxes = document.querySelectorAll('input[name="decision1"]');
    const denyCheckboxes = document.querySelectorAll('input[name="decision2"]');

    let accepted = false;
    let denied = false;

    // Check if any of the accept checkboxes are checked
    acceptCheckboxes.forEach(checkbox => {
        if (checkbox.checked) {
            accepted = true;
        }
    });

    // Check if any of the deny checkboxes are checked
    denyCheckboxes.forEach(checkbox => {
        if (checkbox.checked) {
            denied = true;
        }
    });

    if (accepted) {
        alert("You have accepted the work adjustment");
    } else if (denied) {
        alert("You have denied the work adjustment");
    } else {
        alert("Please select any status");
    }
}

	</script>
</head>
<body>
<%
String emp = null;
if (session.getAttribute("who") != null) {
    emp = (String) session.getAttribute("who");
}

String k = "SELECT * FROM fleaveauto.facassign WHERE faculty = '" + emp + "' and status = 0";
//out.println(k);
ResultSet rs = null;
if (db.operation("SELECT * FROM fleavesauto.facassign WHERE faculty = '" + emp + "' and status = 0" , "select")) {
    rs = db.getResultSet();
    // Display the table if there are results
    if (rs != null) {
		rs.beforeFirst();
%>
<h2>Work Adjustment Form</h2>

<form method = "POST">
<table id = "wa">
    <thead>
        <tr>
            <th>Year</th>
            <th>Section</th>
            <th>Semester</th>
            <th>Branch</th>
            <th>Period</th>
            <th>Subject</th>
            <th>Date</th>
			<th style="padding-left:25px; padding-right:25px;">Status</th>
			<th>comments</th>
        </tr>
    </thead>
    <tbody>
<%
        // Loop through the ResultSet and display each row
        ResultSet rss = null;
        int cp = 0;
        while (rs.next()) {
            cp++;
            int year = rs.getInt("year");
            String section = rs.getString("Section"); // Assuming 'section' exists
            String semester = rs.getString("Semester"); //  Assuming 'semester' exists
            String course = rs.getString("Coursecode");
            String branch = rs.getString("Branchcode"); // Assuming 'branch' exists
            String period = rs.getString("Period"); // Assuming 'work_adjustment_period' exists
            String subject = rs.getString("Subject"); // Assuming 'subject' exists
            Date date = rs.getDate("Date"); // Assuming 'date' exists
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            String branch11 = " ";
            if(db.operation("select * from vignan.branch where coursecode = '"+course+"' and    branchcode = "+branch+"","select"))
            {
                rss = db.getResultSet();
                branch11 = rss.getString("shortname");
            }
%>
        <tr>
            <td><%= year %></td>
            <td><%= section %></td>
            <td><%= semester %></td>
            <td><%= branch11 %></td>
            <td><%= period %></td>
            <td><%= subject %></td>
            <td><%= formattedDate %></td>
			<td>
				<label>
					<input type="checkbox" name="decision_"+<%= cp %> id="decision1"  value="accept" onclick ="toggleCheckbox(this)"> Accept
				</label></br>
				<label>
					<input type="checkbox" name="decision_"+<%= cp %> id="decision2"  value="deny" onclick = "toggleCheckbox(this)"> Deny
				</label>
			</td>
			<td>
				<textarea id="comments" name="comments" rows="4" cols="20" placeholder="Enter your comments here..."></textarea>
			</td>
        </tr>

		<input name = "year" value= <%=year%> id="year" hidden>
		<input name = "section" value= <%=section%> id="section" hidden>
		<input name = "semester" value= <%=semester%> id="semester" hidden>
		<input name = "branch" value= <%=branch%> id="branch" hidden>
		<input name = "period" value= <%=period%> id="period" hidden>
		<input name = "date" value= <%=formattedDate%> id="date" hidden>

<%

        } // End of while loop
%>
    </tbody>

</table>
<br>
<br>
<center>
<button name = "sub" type = "submit" id ="sub" onClick = "handleSubmit()">submit</button>
</center>
</form>
<%
if(request.getParameter("sub") != null)
{
		if(request.getParameter("decision1") != null){
		String year = request.getParameter("year");
		String section = request.getParameter("section");
		String semester = request.getParameter("semester");
		String branch = request.getParameter("branch");
		String period = request.getParameter("period");
		String date = request.getParameter("date");
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = "";

        try {
            // Parse the date string into a Date object
            Date parsedDate = inputFormat.parse(date);

            // Format the parsed Date object into the desired format
            formattedDate = outputFormat.format(parsedDate);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parse exception
        }

        // Output the formatted date
        out.println(date);

		String sc = "UPDATE fleavesauto.facassign SET status = 1 WHERE year = '" + year +
                "' AND Section = '" + section +
                "' AND Semester = '" + semester +
                "' AND Period = '" + period +
                "' AND Date = '" + formattedDate + "'";
		//out.println(sc);
		//out.println(year);
		if(db.operation(sc,"update")){
			//out.println("okkok");
		}
                if(usertypeid == 5)
                {
                    response.sendRedirect("hoindex.jsp");
                }
                else
                {
                response.sendRedirect("asstprofindex.jsp");
                }

		}
        else if(request.getParameter("decision2") != null){
                response.sendRedirect("asstprofindex.jsp");

        }
        else{

        }
}
    } // End of if (rs != null)
} // End of if (db.operation)
else{
%>
<center><h1 style="color:black;">
<%
    out.println("No Work Adjustments");
} // End of if (db.operation)
%>
</h1></center>

<!-- Additional usertypeid content -->
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



