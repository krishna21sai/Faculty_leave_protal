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
#wa, #ka {
        width: 100%;
        border-collapse: collapse;
        table-layout: auto; /* Allows cells to adjust width based on content */
    }
    #wa th, #wa td, #ka th, #ka td {
        border: 1px solid #000;
        padding: 8px;
        text-align: center;
        white-space: nowrap; /* Prevents text from wrapping to the next line */
    }
    #wa th, #ka th {
        background-color: #f2f2f2;
    }
</style>

    <script>
        function toggleCheckbox(id, decision) {
        const checkboxes = document.getElementsByName("decision_" + id);
        const acceptCheckbox = checkboxes[0];
        const denyCheckbox = checkboxes[1];
        const hiddenDecisionInput = document.getElementsByName("kdecision_" + id)[0];

        if (decision === "accept") {
            denyCheckbox.checked = false;
            if (acceptCheckbox.checked) {
                hiddenDecisionInput.value = "accepted";  // Set to accepted if checked
            } else {
                hiddenDecisionInput.value = "";  // Set to empty if unchecked
            }
        } else {
            acceptCheckbox.checked = false;
            if (denyCheckbox.checked) {
                hiddenDecisionInput.value = "denied";  // Set to denied if checked
            } else {
                hiddenDecisionInput.value = "";  // Set to empty if unchecked
            }
        }
    }


        function handleSubmit() {
            const form = document.forms[0];  // Get the form
            let accepted = false, denied = false;

            // Get all hidden decision inputs and check their values
            const decisions = form.querySelectorAll('input[name^="kdecision_"]');

            decisions.forEach(decision => {
                if (decision.value === "accepted") {
                    accepted = true;
                } else if (decision.value === "denied") {
                    denied = true;
                }
            });

                alert("submitted successfully");
                setTimeout(() => {
                        window.location.reload();
                    }, 100000); // 10000 milliseconds = 10 seconds

        }
    </script>
</head>

<body>
<%
String emp = null;
if (session.getAttribute("who") != null)
{
    emp = (String) session.getAttribute("who");
}
ResultSet pk = null, pk1 = null,pk2 = null;
int rdep = 0;
List<Integer> ls = new ArrayList<Integer>();
if (db.operation("select * from vignan.hods1 where empcode = '"+emp+"'", "select")) {
    pk = db.getResultSet();
    rdep = pk.getInt("deptcode");
    if(db.operation("select * from staffmaster.facultydetails where empcode = '"+emp+"'","select"))
    {
        pk2 = db.getResultSet();
        rdep = pk2.getInt("departmentid");
    }
    if (db.operation("select * from staffmaster.leavedetails where empcode In (select empcode from staffmaster.facultydetails where departmentid = '"+rdep+"' and designation != 5 ) and empcode != '"+emp+"' and status = 0", "select")) {
        pk1 = db.getResultSet();
        if (pk1 != null) {
            pk1.beforeFirst();
%>
<form action = "dtstore.jsp" method="POST" >
<table id="ka">
    <thead>
        <tr>
            <th> SNO. </th>
            <th>Emp Code</th>
            <th>Emp Name </th>
            <th>From Date</th>
            <th>To Date</th>
            <th>leavetype</th>
            <th>leaves as on date</th>
            <th> leaves Balance </th>
            <th>adjustments</th>
            <th style = "padding :25px;">Status</th>
        </tr>
    </thead>
    <tbody>
<%
int x = 0;
            while (pk1.next()) {
                x++;
                int m = pk1.getInt("Id");
                //out.println(m);
                ls.add(m);
                String empcode = pk1.getString("empcode");
                String ename = "";
                String ltype1 = pk1.getString("leavetype");
                int asondate = pk1.getInt("asondate");
                int b = pk1.getInt("balance");
                if(db.operation("select * from staffmaster.facultydetails where empcode = '"+empcode+"'","select"))
                {
                    pk2 = db.getResultSet();
                    ename = pk2.getString("name");
                }
                String fromd = pk1.getString("fromdat");
                String tod = pk1.getString("todat");

                String[] fromdParts = fromd.split("-");
                String[] todParts = tod.split("-");

                // Reversing the date format
                String reversedFromd = fromdParts[2] + "-" + fromdParts[1] + "-" + fromdParts[0];
                String reversedTod = todParts[2] + "-" + todParts[1] + "-" + todParts[0];


%>
        <tr>
            <td><%= x%> </td>
            <td><%= empcode %></td>
            <td><%= ename%></td>
            <td><%= reversedFromd %></td>
            <td><%= reversedTod %></td>
            <td><%= ltype1 %></td>
            <td><%= asondate %></td>
            <td><%= b%></td>
            <td>
            <% 
                ResultSet pl = null,p2= null;
                String acc ="",pname = "";
                if(db.operation("select * from fleavesauto.facassign where Id = '"+m+"'","select")){
                   pl = db.getResultSet();
                   pl.beforeFirst();
                   while(pl.next())
                   {
                    if(pl.getInt("status") == 1)
                    {
                        acc = "accpted";
                    }
                    else{
                        acc = "pending";
                    }
                    if(db.operation("select name from staffmaster.facultydetails where empcode = '"+pl.getString("faculty")+"'","select"))
                    {
                        p2 = db.getResultSet();
                        pname = p2.getString("name");
                    }
                    %>  
                    date:<%= pl.getString("Date")%> ,
                    period:<%= pl.getInt("Period")%>
                    <br>
                    faculty:<%= pl.getString("faculty")%>,
                    facultyName:<%= pname %>
                    <br>
                    status:<%= acc %>
                    <br>
                    .......................................
                    <br>
                    <%
                   }
                }
            %>
            </td>
            <td>
                <label>
                    <input type="checkbox" name="decision_<%=m%>" value="accept" checked onclick="toggleCheckbox(<%=m%>, 'accept')"> Accept
                </label><br/>
                <label>
                    <input type="checkbox" name="decision_<%=m%>" value="deny" onclick="toggleCheckbox(<%=m%>, 'deny')"> Deny
                </label>
                
            </td>
            
        </tr>
        
        <!-- Hidden input to store decision -->
        <input type="hidden" name="kdecision_<%=m%>" value="accepted">
<%
            }
%>
    </tbody>
</table>
<br><br>
<center>
    <button type="submit" name = "sub" value = "sub" onClick="handleSubmit()">Submit</button>
</center>
</form>
<%
        }
    }
    else{
        %>
    <center><h2>leave approvals empty</h2></center>
    <%
}
}
session.setAttribute("listAttribute", ls);

%>
</body>
</html>




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



