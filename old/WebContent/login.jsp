<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>区域疾病监控系统登录</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<style>
			body{
				background: url(img/back.jpg);
				background-size: cover;
				background-repeat: no-repeat;
				 background-position: center 0;
			}
			#registModel #form-title{
				text-align: center;
			}
			#registModel #registForm .form-group {
				/*display: inline-block;
				width: 105px;*/
				text-align: center;
			}#registModel #registForm .form-group label{
				display: inline-block;
				width: 105px;
				text-align: right;
			}
			#registModel #registForm .form-group:last-child{
				text-align: center;
			}
			#registModel #registForm .form-group:nth-child(3) label{
				display: inline;
			}
		</style>
	</head>
	<body>
		<div id="app">
			<div class="col-lg-4 col-md-4"></div>
			<div id="registModel" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
				<div id="form-title">
					<h2> 区域疾病监控系统登录 </h2>
				</div>
				<form id="registForm" action="/sickness-system/userLogin" method="post">
					
					<div class="form-group">
						<label for="accout">姓名：</label>
						<input id="accout" name="accout" type="text" placeholder="请输入姓名" />
					</div>
					<div class="form-group">
						<label for="password">密码：</label>
						<input id="password" type="password" name="password" placeholder="请输入密码" />
					</div>
					<div class="form-group">
						<input type="radio" name="login_type" value="user" checked id="user" /><label for="user"> 用户登录</label>
						<input type="radio" name="login_type" value="admin" id="admin" /><label for="admin"> 管理员登录</label>
					</div>
					<div class="form-group">
						<a href="regist.jsp">没有账号？点击此处立即注册</a>
					</div>
					<div class="form-group">
						<input type="submit" id="regist" value="登录" class="btn btn-success" />
						<input type="reset" id="regist" value="取消" class="btn btn-info" />
					</div>
				</form>
			</div>
			<div class="col-lg-4 col-md-4"></div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<script type="text/javascript" src="js/jquery.validate.min.js" ></script>
	<script type="text/javascript" src="js/messages_zh.min.js" ></script>
	<script type="text/javascript">
		var msg = "${msg}";
		if(msg){
			alert(msg);
			<c:remove  var="msg"  scope="session"  />
		}
	
		$("#registForm").validate({
			rules:{
				accout:{
					required:true
				},
				password:{
					required:true
				}
			}
		});
	</script>
</html>
