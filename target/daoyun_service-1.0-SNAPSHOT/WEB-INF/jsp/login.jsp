<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form action="/daoyun_service_war_exploded/userVerification/login.do" method="post" enctype="application/json">
		<table>
			<tr>
				<td><label>登录类型: </label></td>
				<td><input type="text" id="loginType" name="loginType"></td>
			</tr>
			<tr>
				<td><label>账号: </label></td>
				<td><input type="text" id="loginToken" name="loginToken"></td>
			</tr>
			<tr>
				<td><label>密码: </label></td>
				<td><input type="text" id="passwordToken" name="passwordToken"></td>
			</tr>

			<tr>
				<td><input id="submit" type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
