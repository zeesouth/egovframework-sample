<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SAMPLE 등록</title>
</head>
<body>
<center>
	<h1>SAMPLE 등록</h1>
	<form action="insertSample.do" method="post">
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input name="title" type="text" size="52" value="${sampleVO.title}"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><input name="regUser" type="text" size="10" value="${sampleVO.regUser}"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="5">value="${sampleVO.content}"</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="INSERT"/>
				</td>
				
			</tr>
		</table>
	
	</form>
	<br/>
	<a href="selectSampleList.do">LIST</a>
</center>

</body>
</html>