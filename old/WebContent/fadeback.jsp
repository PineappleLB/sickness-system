<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<style>
			#app #head-nav {
				height: 60px;
				background: #ABE3FF;
			}
			
			#app #head-nav ul,
			#app #center-nav ul {
				margin: 10px auto;
			}
			
			#app #head-nav ul li,
			#app #center-nav ul li {
				margin: 0 10px;
			}
			
			#app #head-nav ul li select {
				line-height: 26px;
				height: 26px;
			}
			
			#app #center-nav {
				height: 60px;
				background: #738FFF;
			}
			
			#app #content-table #table-div {
				height: 610px;
			}
			
			#app #content-table #table-div table tbody tr td input {
				display: inline-block;
			}
			
			#app #content-table table thead tr th {
				text-align: center;
			}
			
			#app #content-table table thead tr {
				background: #D2D2D2;
				height: 45px;
			}
			
			#app #content-table table tbody tr td {
				/*padding: 3px;*/
			}
			
			#app #table-bottom-nav {
				height: 50px;
				background: #D2D2D2;
				position: relative;
				bottom: -108px;
			}
			
			#app #table-bottom-nav div {
				margin: 10px auto;
			}
			
			#app #table-bottom-nav ul li {
				margin: 0 5px;
			}
			
			#app #table-bottom-nav ul li input {
				width: 50px;
				height: 34px;
			}
			#myModal form div label{
				display: inline-block;
				width: 90px;
				text-align: right;
			}
		</style>
	</head>
	<body>
		<div id="app">
			<div id="center-nav">
				<ul class="nav navbar-nav">
					<li><button class="btn btn-success" data-toggle="modal" data-target="#myModal">新增</button></li>
					<li><button id="updBtn" class="btn btn-info" data-toggle="modal" data-target="#myModal">修改</button></li>
					<li><button class="btn btn-danger" onclick="delete0()">删除</button></li>
				</ul>
			</div>
			<div id="content-table">
				<div id="table-div">
					<table class="table table-striped text-center table-bordered table-hover table-condensed">
						<thead>
							<tr>
								<th><input type="checkbox" id="selectAll" /> 全选</th>
								<th>编号</th>
								<th>用户名</th>
								<th>反馈内容</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${infos}" begin="0" var="info">
								<tr>
									<td><input type="checkbox" class="checkbox" /></td>
									<td>${info.id }</td>
									<td>${info.name }</td>
									<td>${info.fadeback }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>-->
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<form id="addForm" action="/sickness-system/user/fadeback/add" method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">反馈信息</h4>
						</div>
						<div class="modal-body" style="text-align:center;">
							<div class="form-group">
								<input type="hidden" id="id" name="id" />
							</div>
							<div class="form-group">
								<label for="name">用户名：</label>
								<input type="text" id="name" name="name" />
							</div>
							
							<div class="form-group">
								<label for="fadeback">反馈内容：</label>
								<textarea rows="5" cols="30" name="fadeback" id="fadeback"></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">提交更改</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript">
	var msg = "${msg}";
	if(msg){
		alert(msg);
		<c:remove  var="msg"  scope="session"  />
	}
	
	$("#myModal").on("show.bs.modal",function(e){
		var source = $(e.relatedTarget);
		if(source.attr('id')=='updBtn') {
			$('#addForm').attr('action','/sickness-system/user/fadeback/upd');
			var input = $('#table-div table tbody input[type=checkbox]:checked');
			if(input.length > 1){
				alert('不能同时对多个项进行更新！');
				return;
			}
			if(input.length < 1){
				alert('没有选中任何选项！');
				return;
			}
			var tds = input.parent().parent().children('td');
			$('#id').val(tds.eq(1).html());
			$('#name').val(tds.eq(2).html());
			$('#fadeback').html(tds.eq(3).html());
		} else {
			$('#addForm').attr('action','/sickness-system/user/fadeback/add');
			$('#name').val('');
			$('#fadeback').html('');
		}
		
	});
	
	function delete0(){
		var input = $('#table-div table tbody input[type=checkbox]:checked');
		if(input.length<=0){
			alert("您没有选中任何选项！");
		}
		else{
			var b = confirm('您确认要删除这几条信息吗？');
			if(b){
				var ids = '';
				input.each(function(e){
					ids += $(input[e]).parent().next().html() + ",";
				});
				console.log(ids);
				 // 创建Form
			    var form = $('<form></form>');
			    // 设置属性
			    form.attr('action', "/sickness-system/user/fadeback/del");
			    form.attr('method', 'post');
			    form.css('opcity', '0');
//			    // 创建Input
			    var my_input = $('<input  name="ids" type="text" />');
			    my_input.attr('value',  ids);
//			    // 附加到Form
			    form.append(my_input);
			    $(document.body).append(form);
//			    // 提交表单
			    form.submit();
			}
		}
	}
	</script>
</html>