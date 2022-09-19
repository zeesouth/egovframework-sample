<%@page import="egovframework.sample.service.impl.SampleDAOJDBC" %>
<%@page import="egovframework.sample.service.SampleVO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SAMPLE 목록</title>
</head>
<body>
<center>
<h1>SAMPLE 목록</h1>
<form action="selectSampleList.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="800">
	<tr>
		<td align="right">
			<select name="searchCondition">
				<c:forEach items="${conditionMap}" var="option">
					<option value="${option.value}">${option.key}
				</c:forEach>
			</select>
			<input name="searchKeyword" type="text"/>
			<input type="submit" value="검색"/>
		</td>
	</tr>
</table>
</form>
<table border="1" cellpadding="0" cellspacing="0" width="800">

	<tr>
		<th bgcolor="orange" width="60">아이디</th>
		<th bgcolor="orange" width="240">제목</th>
		<th bgcolor="orange" width="40">작성자</th>
		<th bgcolor="orange" width="60">등록일</th>
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
<a href="insertSample.do">샘플 등록</a>
</center>

</body>
</html>