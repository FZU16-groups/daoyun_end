<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form action="/pcs/userVerification/login.do" method="post">
		<table>
			<tr>
				<td><label>登录类型: </label></td>
				<td><input type="text" id="logintype" name="logintype"></td>
			</tr>
			<tr>
				<td><label>账号: </label></td>
				<td><input type="text" id="logintoken" name="logintoken"></td>
			</tr>
			<tr>
				<td><label>密码: </label></td>
				<td><input type="text" id="passwordtoken" name="passwordtoken"></td>
			</tr>

			<tr>
				<td><input id="submit" type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
