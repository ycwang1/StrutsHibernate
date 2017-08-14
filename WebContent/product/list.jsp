<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>产品列表页面</title>
</head>
<body>
	<%@include file="../include/navigator.jsp" %>

	<table align="center" border="1" cellspacing="0" width="500px">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>price</td>
			<td>category</td>
			<td>edit</td>
			<td>delete</td>
		</tr>
		<s:iterator value="products" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td>${p.category.name}</td>
				<td><a href="editProduct?product.id=${p.id}">edit</a></td>
				<td><a href="deleteProduct?product.id=${p.id}">delete</a></td>
			</tr>
		</s:iterator>
	</table>
	<br>
	<form action="addProduct" method="post">
		<table align="center" border="1" cellspacing="0">
		<s:select label="categorys"
		       name="product.category.id"
		       list="categorys"
		       listKey="id"
		       listValue="name"
		       multiple="false"
		/>
			<tr>
				<td>name</td>
				<td><input type="text" name="product.name" value=""></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="product.price" value=""></td>
			</tr>
			<tr>
				<td>submit</td>
				<td colspan="2" align="center"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>