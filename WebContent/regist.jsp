<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>居民注册</title>
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
		</style>
	</head>
	<body>
		<div id="app">
			<div class="col-lg-4 col-md-4"></div>
			<div id="registModel" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
				<div id="form-title">
					<h2> 区域疾病监控系统注册 </h2>
				</div>
				<form id="registForm" action="/sickness-system/regist" method="post">
					
					<div class="form-group">
						<label for="accout">姓名：</label>
						<input id="accout" name="accout" type="text" placeholder="请输入姓名" />
					</div>
					<div class="form-group">
						<label for="password">密码：</label>
						<input id="password" type="password" name="password" placeholder="请输入密码" />
					</div>
					<div class="form-group">
						<label for="repassword">再次输入密码：</label>
						<input id="repassword" type="password" name="repassword" placeholder="请再次输入密码" />
					</div>
					<div class="form-group">
						<label >性别：</label>
						<input id="man" type="radio" value="man" name="sex" checked="checked" /><span for="man"> 男</span>
						<input id="woman" type="radio" value="woman" name="sex" /><span for="woman"> 女</span>
					</div>
					<div class="form-group">
						<label for="age">年龄：</label>
						<input id="age" type="number" name="age" placeholder="请输入您的年龄" maxlength="3" />
					</div>
					<div class="form-group">
						<label for="email">邮箱：</label>
						<input id="email" type="email" name="email" placeholder="请输入您的邮箱" />
					</div>
					<div class="form-group">
						<label for="phone">联系电话：</label>
						<input id="phone" type="text" name="phone" placeholder="请输入手机号码" />
					</div>
					<div class="form-group">
						<label for="home_addr">家庭住址：</label>
						<input id="home_addr" type="text" name="home_addr" placeholder="请输入家庭住址" />
					</div>
					<div class="form-group">
						<label for="work_addr">工作地点：</label>
						<input id="work_addr" type="text" name="work_addr" placeholder="请输入工作住址" />
					</div>
					<div class="form-group">
						<input type="submit" id="regist" value="注册" class="btn btn-success" />
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
		$("#registForm").validate({
			rules:{
				accout:{
					required:true
				},
				password:{
					required:true
				},
				repassword:{
					required:true,
					equalTo:"#password"
				},
				sex:{
					required:true
				},
				age:{
					required:true
				},
				email:{
					email:true
				},
				phone:{
					maxlength:11
				}
			}
		});
	</script>
</html>
