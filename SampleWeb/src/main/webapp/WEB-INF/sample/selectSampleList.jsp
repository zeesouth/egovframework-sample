<%@page import="egovframework.sample.service.impl.SampleDAOJDBC" %>
<%@page import="egovframework.sample.service.SampleVO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="list.mainTitle"/></title>
</head>
<body>
<center>
<h1><spring:message code="list.mainTitle"/></h1>
<a href="selectSampleList.do?lang=en"><spring:message code="list.link.locale.en"/></a>
<a href="selectSampleList.do?lang=ko"><spring:message code="list.link.locale.ko"/></a>

<!-- 검색 시작 -->
<form action="selectSampleList.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="800">
	<tr>
		<td align="right">
			<select name="searchCondition">
				<option value="TITLE">
					<spring:message code="list.search.title"/>
				<option value="CONTENT">
					<spring:message code="list.search.condition"/>
			<input name="searchKeyword" type="text"/>
			<input type="submit" value="<spring:message code="list.search.button"/>"/>
		</td>
	</tr>
</table>
</form>
<table border="1" cellpadding="0" cellspacing="0" width="800">

	<tr>
		<th bgcolor="orange" width="60"><spring:message code="list.list.table.id"/></th>
		<th bgcolor="orange" width="240"><spring:message code="list.list.table.title"/></th>
		<th bgcolor="orange" width="40"><spring:message code="list.list.table.regUser"/></th>
		<th bgcolor="orange" width="60"><spring:message code="list.list.table.regDate"/></th>
	</tr>
	
	<c:forEach var="sample" items="${sampleList}">
	<tr>
		<td align="center"><a href="selectSample.do?id=${sample.id}">
			${sample.id}</a></td>
		<td>${sample.title}</td>
		<td align="center">${sample.regUser}</td>
		<td align="center">${sample.regDate}</td>
	</tr>
	</c:forEach>
</table>
<br/>
<a href="insertSample.do"><spring:message code="list.link.create"/></a>
</center>

</body>
</html>