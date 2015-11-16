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
<title>Praneeth Search</title>
</head>
<body>
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
<br/>
<br/>
<div class="container" style="background:#AAAAAA">
<div class="row">
			<div class=".col-lg-offset-2 col-lg-7">
	<h1 class="text-muted">Search</h1>
	<hr/>
	<c:if test="${empty queryRes}">
	<h1>No Search Results</h1>
	</c:if>
    <table class="table">
    <thead>
      <tr class="danger">
      	  <th>Search Results</th>
      </tr>
    </thead>
    <tbody>
         <c:forEach items="${queryRes}" var="res" varStatus="count">
         <tr class="success">
         <td><a href="<c:out value='searchDoc?resDoc=${res}'/>">${res}</a></td>
         </tr>	
        </c:forEach> 
         
    </tbody>
  </table>
</div>
</div>
</div>
</body>
</html>