<%@ page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>Login</title>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<style type="text/css">
			.middle {
				width: 200px;
				margin-top: 100px;
				margin-left: 50%;
				padding-left: -100px;
			}
			.error {
				color: red;
			}
		</style>
	</head>
	<body>
		<div class="middle">
			<div class="error">${ err }</div>
			<form method="post" action="/login">
				<label>Username: </label><input type="text" name="username">
				<label>Password: </label><input type="password" name="password">
				<br>
				<input type="submit" value="Login">
			</form>
		</div>
	</body>
</html>