<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>居民首页</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<style>
			#app #head_nav .navbar {
				margin-bottom: 0;
			}
		</style>
	</head>

	<body>
		<div id="app">
			<div id="head_nav">
				<div>
					<nav class="navbar navbar-default" role="navigation">
						<div class="navbar-header">
							<a class="navbar-brand" href="home-frame.jsp" target="inframe">首页</a>
						</div>
						<ul class="nav navbar-nav">
							<li class="hospital_manage">
								<a href="sicker-manage.jsp" target="inframe" class="hospital-manage">医院等相关部门管理</a>
							</li>
							<li class="sicker-manage">
								<a href="sicker-manage.jsp" target="inframe" class="sicker-manage">病人信息管理</a>
							</li>
							<li class="watch-manage">
								<a href="monitoring-and-management.jsp" target="inframe" class="watch-manage">监控管理</a>
							</li>
							<li class="">
								<a href="regist.jsp" target="_blank">用户注册</a>
							</li>
							<li class="">
								<a href="login.jsp" target="_blank">用户登录</a>
							</li>
							<li class="">
								<a href="browse-info.jsp" target="inframe">浏览信息</a>
							</li>
							<li class="">
								<a href="#">留言反馈</a>
							</li>
							<li class="">
								<a href="#">关于我们</a>
							</li>
						</ul>
					</nav>
				</div>
			</div>

			<div id="center-frame">
				<iframe src="home-frame.jsp" name="inframe" frameborder="0" scrolling="yes" width="100%" height="100%"></iframe>
			</div>

		</div>

		<!--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>-->
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
					</div>
					<div class="modal-body">在这里添加一些文本</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">提交更改</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

	</body>
	<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script>
		$(function() {
			var navHeight = $(window).height() - 55;
			$('#center-frame').height(navHeight);
		});
	</script>

</html>




<!--<div id="pic">
	<div class="col-lg-1"></div>
	<div class="col-lg-2">
		<img src="img/a.jpg" width="100%" />
	</div>
	<div class="col-lg-2">
		<img src="img/a.jpg" width="100%" />
	</div>
	<div class="col-lg-2">
		<img src="img/a.jpg" width="100%" />
	</div>
	<div class="col-lg-2">
		<img src="img/a.jpg" width="100%" />
	</div>
	<div class="col-lg-2">
		<img src="img/a.jpg" width="100%" />
	</div>
	<div class="col-lg-1"></div>
</div>-->