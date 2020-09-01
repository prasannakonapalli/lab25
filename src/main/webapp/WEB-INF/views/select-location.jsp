<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>

	<div class="container">
		<c:choose>
			<c:when test="${data!=null}">
				<div>

					<h4>
						Forecast for
						<c:out value="${productionCenter}" />
					</h4>
				</div>
				<br>
				<table class="table">

					<tr class="jumbotron">
						<c:forEach items="${data.getTemperature()}" var="header">
							<c:set var="cnt" value="${cnt+1}" />
							<th><c:out value="Day${cnt}" /></th>
						</c:forEach>
					</tr>

					<tr>
						<c:forEach items="${data.getTemperature()}" var="temp">
							<td><c:out value="${temp}" /></td>

						</c:forEach>
					<tr>
					<tr class="jumbotron">
						<c:forEach items="${data.getText()}" var="text">
							<td><c:out value="${text}" /></td>

						</c:forEach>
					<tr>
					<tr>
						<c:forEach items="${data.getIconLink()}" var="icon">
							<td><img alt="" src="<c:out value="${icon}" />"></img></td>

						</c:forEach>
					<tr>
				</table>
				<br>
			</c:when>
			<c:otherwise>
				<h2>No Data Found</h2>
				<br />
			</c:otherwise>
		</c:choose>
	</div>


</body>
</html>
