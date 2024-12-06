<%@include file='includingfile.jsp' %>
 <%String message=(String)request.getAttribute("message");%>
<html>
<head>
<style>
table
{
border-collapse:collapse;
} 

</style>
</head>
 <table width="100%" cellpadding="5" cellspacing="0" border="0" align="center">
  <tr>
    <td align="left" class="ListingHead">Leave Details Apply / Status / Cancel<hr noShade size="1"></td>
  </tr>
  <tr>
  <td>
  <table width="100%" cellpadding="0" cellspacing="0" border="1" align="center">
   <tr>
  <th align="center">Leave Type</th>
  <th align="center">No of Leaves</th>
  <th align="center">Leaves Used</th>
  <th align="center">Remaining Leaves</th>


   </tr>

   <%
   String lid=(String)session.getAttribute("who");
   ResultSet rs=null;
   int nleaves=0;
   double rleaves=0.0,remleaves=0.0;


if(message!=null)
	  {
		  out.println("<p align='center' style='color:blue'>"+message+"</p>");
	  }

if(db.operation("select * from staffmaster.fleaves where empcode='"+lid+"'","select"))
{
rs=db.getResultSet();
rs.beforeFirst();
while(rs.next())
	{
        nleaves=rs.getInt("nleaves");
		rleaves=rs.getDouble("rleaves");
		remleaves=nleaves-rleaves;

       
	  
      %>
       <tr>
	   <td align="center"><%=rs.getString("ltype")%></td>
	    <td align="center"><%=nleaves%></td>
		 <td align="center"><%=rleaves%></td>
		  <td align="center"><%=remleaves%></td>
		 </tr>



	  <%
    


	}

}





	  %>
 <!-- MAIN CONTENT START -->
</table>
</td>
</tr>
<!-- MAIN CONTENT END -->
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
		<jsp:include page="regLeaveFooter.jsp"/>
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
	<jsp:include page="staffLeaveFooter.jsp"/>
	<%
}
else if(usertypeid==12)
{
	%>

	<%
}
	else if(usertypeid==15)
{
	%>
	<jsp:include page="chancellorleaveFooter.jsp"/>
	<%
}

%>
