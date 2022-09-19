<%@page import="egovframework.sample.service.impl.SampleDAOJDBC" %>
<%@page import="egovframework.sample.service.SampleVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 검색할 아이디 추출
	String id = request.getParameter("id");

	// 2. DB연동 처리
	SampleVO vo = new SampleVO();
	vo.setId(id);
	
	SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
	SampleVO sample = sampleDAO.selectSample(vo);
	
	// 3. 응답 화면 구성
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SAMPLE 상세</title>
</head>
<body>
<center>
	<h1>SAMPLE 상세</h1>
	<form action="updateSample_proc.jsp" method="post">
		<input name="id" type="hidden" value="<%=sample.getId() %>"/>
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="orange" width="70">아이디</td>
				<td align="left"><input name="id" type="text" value="<%=sample.getId()%>" disabled="disabled"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">제목</td>
				<td align="left"><input name="title" type="text" value="<%=sample.getTitle()%>" size="52"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><input name="regUser" type="text" value="<%=sample.getRegUser()%>"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="5"><%=sample.getContent()%></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left"><%=sample.getRegDate() %></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="UPDATE"/>
				</td>
			</tr>
			
			
		</table>
	
	</form>
	<br/>
	<a href="insertSample.jsp">INSERT</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteSample_proc?id=<%=sample.getId()%>">DELETE</a>&nbsp;&nbsp;&nbsp;
	<a href="selectSampleList.jsp">LIST</a>&nbsp;&nbsp;&nbsp;
</center>

</body>
</html>