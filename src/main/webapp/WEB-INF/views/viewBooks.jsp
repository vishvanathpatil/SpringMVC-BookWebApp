<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


	<h3>View Books</h3>
	
	<a href="bookForm">+ Add Book</a> <a href="advBookSearchForm">Advanced Search</a>

	<form action="search">
		<input type="text" name="isbn" /> <input type="submit"
			value="Search By ISBN" />
	</form>


	<table>
		<thead>
			<tr>
				<th>Book ISBN</th>
				<th>Book Name</th>
				<th>Book Price</th>
				<th>Author Name</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${books eq null }">
				<tr>
					<td colspan="4">No Records Found</td>
				</tr>
			</c:if>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.bookIsbn}" /></td>
					<td><c:out value="${book.bookName}" /></td>
					<td><c:out value="${book.bookPrice}" /></td>
					<td><c:out value="${book.authorName}" /></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>