<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编辑jsp</title>
</head>
<body>
	<form action="updateProduct" method="post">
		<table align="center" border="1" cellspacing="0">
		<s:select label="categorys"
		       name="product.category.id"
		       list="categorys"
		       listKey="id"
		       listValue="name"
		       multiple="false"
		/>
			<tr>
				<td>name:</td>
				<td><input type="text" value="${product.name}" name="product.name"/></td>
			</tr>
			<tr>
				<td>price:</td>
				<td><input type="text" value="${product.price}" name="product.price"/></td>
			</tr>
			 <tr>
			    <td colspan="2" align="center">
			        <input type="hidden" name="product.id" value="${product.id}"> 
			        <input type="submit" value="submit">
			    </td>
			 </tr>
		</table>
	</form>
</body>
</html>