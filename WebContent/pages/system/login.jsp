<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="application/x-javascript">addEventListener("load", function() {setTimeout(hideURLbar, 0);}, false); function hideURLbar(){ window.scrollTo(0, 1);}
	</script>
	<link href="css/login/style.css" rel='stylesheet' type='text/css' />
 	<script type="text/javascript" src="plug-in/jquery/jquery-1.11.2.min.js"></script>
 	<script type="text/javascript" src="js/system/login.js"></script>
</head>
<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
	  				$('.login-form').remove();
				});
			});
		});
	</script>
	<section class="login-form-wrap">
		<h1>学生成绩管理系统</h1>
		<div class="login-form">
			<div class="head-info">
				<label class="lbl-1"> </label>
				<label class="lbl-2"> </label>
				<label class="lbl-3"> </label>
			</div>
			<div class="avtar">
				<img src="image/login/avtar.png" />
			</div>
			<form action="loginController.do?doLogin" method="post" check="loginController.do?doCheck">
				<div>
					<input type="text" id="username" name="username" placeholder="用户名">
				</div>
				<div>
					<input type="password" id="password" name="password" placeholder="密码">
				</div>
				<div>
					<input type="text" id="captcha" name="captcha" placeholder="验证码">
					<img style="float:right;" title="点击更换" id="img_captcha" onclick="javascript:refreshCaptcha();" src="captchaCode">
		        </div>
		        <br/>
		        <div id="errormsg" style="color: red"></div>  		
			</form>
			<div class="signin">
				<input id="login" type="button" value="登陆">
			</div>
		</div>
	</section>
</body>
</html>