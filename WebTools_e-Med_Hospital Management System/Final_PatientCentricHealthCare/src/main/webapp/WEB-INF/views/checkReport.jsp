<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>People's Welfare Hospital</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://bootstraptaste.com" />

<link href="<c:url value="/resources/bootstrap.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/flexslider.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/style.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/default.css"/>" rel="stylesheet" />


<!-- Theme skin -->
<link href="skins/default.css" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>
<div id="wrapper">
	<!-- start header -->
	<header>
			<div id="header">
		<div class="row"></div>
		<div class="row">
	   				<div class="col-lg-4">
	   				</div>
	   				<div class="col-lg-4" style="color:#fff; font-family: Zapf Chancery, cursive; font-style: italic; font-weight: 800; font-size: 30px;">
	   				People's Welfare
	   				</div>
	   				<div class="col-lg-4">
	   				</div>
	   				</div>
	   				</div>
	 <div class="container">
                
                </div>
                
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="patientLogin">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="sendComplaint"><span class="glyphicon glyphicon-user"></span> Send Complaint</a></li>
        <li><a href="checkReport"><span class="glyphicon glyphicon-log-in"></span> Check Report</a></li>
      	<li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
      </ul>
    </div>
  </div>
</nav>

	</header>
	<!-- end header -->
	<section id="featured">
	<!-- start slider -->
	<div class="container">
		<div class="row">
			<div class=".col-lg-offset-2 col-lg-10">
	<h1 class="text-muted">Hello ${sessionScope.userAccount.username}: </h1>
	<h3></h3>
	<hr/>

<!-- Encounter Details -->
		
		<div class="row">
			<div class=".col-lg-offset-2 col-lg-7">
	<h1 class="text-muted">Patient Encounter Details</h1>
	<hr/>
    <table class="table">
    <thead>
      <tr class="danger">
      <th>Encounter ID</th>
        <th>Complaint</th>      
      	  <th>Body Temperature</th>
        <th>Blood Pressure</th>
        <th>Pulse</th>
        <th>Respiratory Rate</th>
      </tr>
    </thead>
    <tbody>
         <c:forEach items="${encounterList}" var="vital" varStatus="count">
         <tr class="success">
         <td>${vital.encounterId}</td>
         <td>${vital.chiefComplaint}</td>
         <td>${vital.vitalSign.bodyTemperature}</td>
         <td>${vital.vitalSign.bloodPressure}</td>
         <td>${vital.vitalSign.pulse}</td>
         <td>${vital.vitalSign.repiratoryRate}</td>
           
         </tr>	
        </c:forEach> 
         
    </tbody>
  </table>
</div>
		</div>
		
		<!-- Assessment deatails -->
		
		
		<div class="row">
			<div class=".col-lg-offset-2 col-lg-7">
	<h1 class="text-muted">Patient Assessment Details</h1>
	<hr/>
    <table class="table">
    <thead>
      <tr  class="danger">
        <th>Complaint</th>      
      	  <th>Assistant Doctor Notes</th>
        <th>Pregnancy</th>
        <th>Symptoms</th>
        <th>Occurence</th>
        <th>Std</th>
      </tr>
    </thead>
    <tbody>
         <c:forEach items="${encounterList}" var="assess" varStatus="count">
         <tr class="success">
         <td>${assess.chiefComplaint}</td>
         <td>${assess.assessment.assNotes}</td>
         <td>${assess.assessment.pregnancy}</td>
         <td>${assess.assessment.symptoms}</td>
         <td>${assess.assessment.occurence}</td>
         <td>${assess.assessment.std}</td>
         </tr>	
        </c:forEach> 
         
    </tbody>
  </table>
</div>
		</div>
		
		<!-- Medication Drugs -->
 <div class="row">
			<div class=".col-lg-offset-2 col-lg-7">
	<h1 class="text-muted">Medication Drug Details</h1>
	<hr/>
    <table class="table">
    <thead>
      <tr class="danger">
      	<th>Complaint</th>
      	<th>Instructions</th>
      	<th>Drug ID</th>
        <th>Drug Name</th>
        <th>Composition</th>
        <th>Dosage</th>
        <th>Exp Date</th>
        <th>Do's</th>
        <th>Dont's</th>
        <th>Side effects</th>
        <th>Communication Plan</th>
      </tr>
    </thead>
    <tbody>
         <c:forEach items="${encounterList}" var="drugLi" varStatus="count">
         <tr class="success"><td rowspan="${fn:length(drugLi.medDetails.drugList)+1}">${drugLi.chiefComplaint}</td>
         <td rowspan="${fn:length(drugLi.medDetails.drugList)+1}">${drugLi.medDetails.instructions}</td>
         <td>
         <c:forEach items="${drugLi.medDetails.drugList}" var="med" step="1">
         <tr class="success">
         <td>${med.drugId}</td>
         <td>${med.drugName}</td>
         <td>${med.composition}</td>
         <td>${med.dosage}</td>
         <td>${med.expDate}</td>
         <td>${med.medicationGuide.dos}</td>
         <td>${med.medicationGuide.donts}</td>
         <td>${med.medicationGuide.sideEffects}</td>
         <td>${med.communicationPlan.communicationPlan}</td>
         </tr>	
         </c:forEach>
         </td>
         </tr>
        </c:forEach> 
         
    </tbody>
  </table>
</div>
		</div>
    </div>
</div>

</div>
		</div>
</section>


	<footer>
		<div class="row">
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">Get in touch with us</h5>
					<address>
					<strong>Moderna company Inc</strong><br>
					 Modernbuilding suite V124, AB 01<br>
					 Someplace 16425 Earth </address>
					<p>
						<i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891 <br>
						<i class="icon-envelope-alt"></i> email@domainname.com
					</p>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">Pages</h5>
					<ul class="link-list">
						<li><a href="#">Press release</a></li>
						<li><a href="#">Terms and conditions</a></li>
						<li><a href="#">Privacy policy</a></li>
						<li><a href="#">Career center</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">Latest posts</h5>
					<ul class="link-list">
						<li><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></li>
						<li><a href="#">Pellentesque et pulvinar enim. Quisque at tempor ligula</a></li>
						<li><a href="#">Natus error sit voluptatem accusantium doloremque</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">Flickr photostream</h5>
					<div class="flickr_badge">
						<script type="text/javascript" src="http://www.flickr.com/badge_code_v2.gne?count=8&amp;display=random&amp;size=s&amp;layout=x&amp;source=user&amp;user=34178660@N03"></script>
					</div>
					<div class="clear">
					</div>
				</div>
			</div>
		</div>
	</footer>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
</body>
</html>