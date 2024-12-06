<?php
session_start();
//error_reporting(0);
include('include/config.php');
include('include/checklogin.php');
check_login();



?>
<!DOCTYPE html>
<html lang="en">
	<head>
	<script type="text/javascript">

	</script>
	<link rel="stylesheet" type="text/css" href="./cal/epoch_styles.css" />
	<script type="text/javascript" src="./cal/epoch_classes.js"></script>
<script type="text/javascript">
var xmlhttp,xmlhttp1,xmlhttp2;
var cal1,cal2;      
window.onload = function ()
{	
	cal1  = new Epoch('epoch_popup','popup',document.getElementById('dt1'));
	cal2  = new Epoch('epoch_popup','popup',document.getElementById('dt2'));
};
</script>
		<title>Admin | Staff Subjects Report</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta content="" name="description" />
		<meta content="" name="author" />
		<link href="http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="vendor/themify-icons/themify-icons.min.css">
		<link href="vendor/animate.css/animate.min.css" rel="stylesheet" media="screen">
		<link href="vendor/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" media="screen">
		<link href="vendor/switchery/switchery.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-touchspin/jquery.bootstrap-touchspin.min.css" rel="stylesheet" media="screen">
		<link href="vendor/select2/select2.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-datepicker/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-timepicker/bootstrap-timepicker.min.css" rel="stylesheet" media="screen">
		<link rel="stylesheet" href="assets/css/styles.css">
		<link rel="stylesheet" href="assets/css/plugins.css">
		<link rel="stylesheet" href="assets/css/themes/theme-1.css" id="skin_color" />
	</head>
	<body>
		<div id="app">		
<?php include('include/sidebar.php');?>
			<div class="app-content">
				
						<?php include('include/header.php');?>
					
				<!-- end: TOP NAVBAR -->
				<div class="main-content" >
			
			
						
									
									
												<div class="panel-heading">
													<h5 class="panel-title"><font color='red'>Questions Module </font></h5>
												</div>
											
								<p style="color:red;"><?php echo htmlentities($_SESSION['msg']);?>
								<?php echo htmlentities($_SESSION['msg']="");?></p>	
													
														<?php 
														$examname='';$subjectcode='';$db='';





	


														?>
														<div class="panel-heading">
													
												</div>

														<table border=1 width='100%' class="table table-hover" id="sample-table-1">
<?php
$sql1=mysqli_query($cn,"select * from honors.course where coursecode='".$_POST['program']."'");
$cname='';
while($row11=mysqli_fetch_array($sql1))
{
$cname=$row11['coursename'];
}
?>

<tr><th colspan=11>Exam Name : <?php echo $_POST['examname']?>, Year :  <?php echo $_POST['year']?>, Semester: <?php echo $_POST['sem']?>, Program Name : <?php echo $cname?></th></tr>
<tr><th><font color='blue'>S.No</font></th><th><font color='blue'>Subjectcode</font></th><th><font color='blue'>Sub.Name</font></th>
<th><font color='blue'>Section</font></th><th><font color='blue'>Branch</font></th><th><font color='blue'>Details</font></th><th><font color='blue'>Status</font></th>

<th><font color='blue'>Empcode</font></th>
<th><font color='blue'>Name</font></th>
<th><font color='blue'>Phone No</th>
<th><font color='blue'>Print</font></th></tr>

<?php


$sql=mysqli_query($cn,"select group_concat(a.empcode SEPARATOR '<br>') as empcode,group_concat(a.name SEPARATOR '<br>') as name,group_concat(a.phoneno SEPARATOR '<br>') as phoneno,a.mailid,a.subcode,a.subname,a.cyear,a.semester,b.coursename,c.deptshortname,a.sectioncode,d.shortname,a.examname,a.coursecode,a.branchcode from 
honors.staffdata a,vignan.course b,vignan.department c,vignan.branch d where (a.coursecode=b.coursecode) and (a.branchcode=d.branchcode) and 
(b.coursecode=d.coursecode)  and (a.deptid=c.deptid) and a.examname='".$_POST['examname']."' and a.coursecode='".$_POST['program']."' and a.cyear='".$_POST['year']."' and a.semester='".$_POST['sem']."' group by a.coursecode,a.branchcode,a.cyear,a.semester,a.sectioncode,a.subcode,a.examname");

	

$cnt=1;
while($row1=mysqli_fetch_array($sql))
{
?>
<tr><td><?php echo $cnt?></td><td align='center'><?php echo $row1['subcode']?></td><td><?php echo $row1['subname']?></td><td><?php echo $row1['sectioncode']?></td><td><?php echo $row1['shortname']?></td>
<?php

$noq=0;

//echo "select count(*) as cc from honors.questionnos where coursecode='".$row1['coursecode']."' and branchcode='".$row1['branchcode']."' and cyear='".$row1['cyear']."' and semester='".$row1['semester']."' and sectioncode='".$row1['sectioncode']."' and subjectcode='".$row1['subcode']."' and examname='".$row1['examname']."' group by subjectcode ";
	$sq3l=mysqli_query($cn,"select count(*) as cc from honors.questionnos where coursecode='".$row1['coursecode']."' and branchcode='".$row1['branchcode']."' and cyear='".$row1['cyear']."' and semester='".$row1['semester']."' and sectioncode='".$row1['sectioncode']."' and subjectcode='".$row1['subcode']."' and examname='".$row1['examname']."' group by subjectcode ");
while($row31=mysqli_fetch_array($sq3l))
{
$noq=$row31['cc'];
}

$noqa=0;
$status="";
$sq3l=mysqli_query($cn,"select count(*) as cc,status from honors.subjectquestions where coursecode='".$row1['coursecode']."' and branchcode='".$row1['branchcode']."' and cyear='".$row1['cyear']."' and semester='".$row1['semester']."' and sectioncode='".$row1['sectioncode']."' and subjectcode='".$row1['subcode']."' and examname='".$row1['examname']."' and qno>0 group by subjectcode ");
while($row31=mysqli_fetch_array($sq3l))
{
$noqa=$row31['cc'];
$status=$row31['status'];
}


	?>

<td><?php echo $noqa?> out of <?php echo $noq?></td>
<td>
<?php
if($status=='Y')
	{
	echo "<font color='green'><b>Locked</b></font>";
	}
	else
	{
		echo "<font color='red'>Not<br> Locked</font>";
	}
	?>

</td>
<td><?php echo $row1['empcode']?>
<td><?php echo $row1['name']?>
<td ><?php echo $row1['phoneno']?>

<td>
<?php
if($status=='Y')
	{
	?>

<a href="viewquestion.php?examname=<?php echo $row1['examname']?>&coursecode=<?php echo $row1['coursecode']?>&branchcode=<?php echo $row1['branchcode']?>&cyear=<?php echo $row1['cyear']?>&semester=<?php echo $row1['semester']?>&sectioncode=<?php echo $row1['sectioncode']?>&coursename=<?php echo $row1['coursename']?>&branchname=<?php echo $row1['shortname']?>&subjectcode=<?php echo $row1['subcode']?>&subjectname=<?php echo $row1['subname']?>">Print</td>

<?php
	}
	?>

</tr>
	<?php
	$cnt++;
}

?>

<tr><td colspan=14>&nbsp;</td></tr>

														</table>

														<!-- 	<div class="form-group">
															<label for="exampleInputEmail1">
																Name of Person
															</label>
							<input type="text" name="personaname" class="form-control"  placeholder="Enter Person Name" required>
														</div>

														<div class="form-group">
															<label for="exampleInputEmail1">
																Addressed to
															</label>
							<input type="text" name="addressto" class="form-control"  placeholder="Enter Addressed to" required>
														</div>

															<div class="form-group">
															<label for="exampleInputEmail1">
																Description
															</label>
							<textarea name="complaint" class="form-control"  placeholder="Enter Description" rows=5 cols=50 required="required"></textarea>
														</div>
														 -->
														
												
														
														
														
												
											
						
					
								
						</div>
						<!-- end: BASIC EXAMPLE -->
						<!-- end: SELECT BOXES -->
				
			</div>
			<!-- start: FOOTER -->
	<?php include('include/footer.php');?>
			<!-- end: FOOTER -->
		
			<!-- start: SETTINGS -->
	<?php include('include/setting.php');?>
			
			<!-- end: SETTINGS -->
		</div>
		<!-- start: MAIN JAVASCRIPTS -->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="vendor/modernizr/modernizr.js"></script>
		<script src="vendor/jquery-cookie/jquery.cookie.js"></script>
		<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script src="vendor/switchery/switchery.min.js"></script>
		<!-- end: MAIN JAVASCRIPTS -->
		<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script src="vendor/maskedinput/jquery.maskedinput.min.js"></script>
		<script src="vendor/bootstrap-touchspin/jquery.bootstrap-touchspin.min.js"></script>
		<script src="vendor/autosize/autosize.min.js"></script>
		<script src="vendor/selectFx/classie.js"></script>
		<script src="vendor/selectFx/selectFx.js"></script>
		<script src="vendor/select2/select2.min.js"></script>
		<script src="vendor/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
		<script src="vendor/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<!-- start: CLIP-TWO JAVASCRIPTS -->
		<script src="assets/js/main.js"></script>
		<!-- start: JavaScript Event Handlers for this page -->
		<script src="assets/js/form-elements.js"></script>
		<script>
			jQuery(document).ready(function() {
				Main.init();
				FormElements.init();
			});
		</script>
		<!-- end: JavaScript Event Handlers for this page -->
		<!-- end: CLIP-TWO JAVASCRIPTS -->
	</body>
</html>
