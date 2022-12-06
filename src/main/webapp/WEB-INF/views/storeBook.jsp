<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<body>

	<h3>Add Book</h3>

	<font color="green">${smsg}</font>
	<font color="red">${emsg}</font>
	<form:form action="saveBook" method="POST" modelAttribute="b">
		<table>
			<tr>
				<td>Book Name:</td>
				<td><form:input path="bookName" /></td>
			</tr>

			<tr>
				<td>Book Price:</td>
				<td><form:input path="bookPrice" /></td>
			</tr>


			<tr>
				<td>Author Name:</td>
				<td><form:input path="authorName" /></td>
			</tr>

			<tr>
				<td>Book ISBN:</td>
				<td><form:input path="bookIsbn" /></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Store" /></td>
			</tr>

			<tr>
				<td></td>
				<td><a href="search">View All Books</a></td>
			</tr>

		</table>
	</form:form>
</body>
</html>