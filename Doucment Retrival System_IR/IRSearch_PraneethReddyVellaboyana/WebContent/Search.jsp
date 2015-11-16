<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/bootstrap.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/style.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/default.css"/>" rel="stylesheet" />
<title>Praneeth Document Retrieval Search</title>
</head>
<body background="<c:url value="/resources/oddc_wordle_2013.04.26.png"/>">
<div class="container" style="background:#E6E6FA">
<form action="search" method="GET">
	<div class="row">
    <div class="form-group">
            <div class="col-md-6">
            <h2 style="color:#1D197B">Enter the search query</h2>
            </div>
    </div>
    </div>
	<div class="row">
    <div class="form-group">
            <div class="col-md-10">
            <input name="searchQuery" id="searchQuery" class="form-control" required placeholder = "Enter your search"/>
            </div>
    </div>
    </div>
<input type="submit" value="Submit" />
</form>
</div>
</body>
</html>