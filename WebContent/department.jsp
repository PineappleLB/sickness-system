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
			<div id="head-nav">
				<ul class="nav navbar-nav">
					<li>查询内容：<input type="text" id="date-prev" /> </li>
					<li>
						<select id="game-type-sel">
							<option value="all">按病人编号</option>
							<option value="ddz1">按病人姓名</option>
							<option value="ddz2">按疾病类型</option>
						</select>
					</li>
					<li><button class="btn btn-primary">查询</button></li>
					<li><button class="btn btn-primary" onclick="window.location.href='/sickness-system/department'">刷新</button></li>
				</ul>
			</div>
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
								<th>部门编号</th>
								<th>部门名称</th>
								<th>部门类型</th>
								<th>部门地址</th>
								<th>联系电话</th>
								<th>邮箱</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${infos}" begin="0" var="info">
								<tr>
									<td><input type="checkbox" class="checkbox" /></td>
									<td>${info.department_id }</td>
									<td>${info.department_name }</td>
									<td>${info.department_type }</td>
									<td>${info.department_address }</td>
									<td>${info.phone }</td>
									<td>${info.email }</td>
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
					<form id="addForm" action="/sickness-system/monitoringManagement/add" method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">新增部门信息</h4>
						</div>
						<div class="modal-body" style="text-align:center;">
							<div class="form-group">
								<input type="hidden" id="id" name="id" />
							</div>
							<div class="form-group">
								<label for="name">部门名称：</label>
								<input type="text" id="name" name="name" />
							</div>
							<div class="form-group">
								<label for="type">部门类型：</label>
								<select name="type" id="type">
									<option value="private">私人</option>
									<option value="public">公立</option>
								</select>
							</div>
							<div class="form-group">
								<label for="phone">联系电话：</label>
								<input type="text" id="phone" name="phone" />
							</div>
							<div class="form-group">
								<label for="address">部门地址：</label>
								<input type="text" id="address" name="address" />
							</div>
							<div class="form-group">
								<label for="email">邮箱：</label>
								<input type="email" id="email" name="email" />
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
	<script type="text/javascript" src="js/jquery.validate.min.js" ></script>
	<script type="text/javascript" src="js/messages_zh.min.js" ></script>
	<script>
		var msg = "${msg}"
		if(msg){
			alert(msg);
			<c:remove  var="msg"  scope="session"  />
		}
		$('#selectAll').change(function() {
			if($(this).is(':checked')) {
				$('.checkbox').each(function() {
					$(this).prop('checked', true);
				});
				console.log('selected');
			} else {
				$('.checkbox').each(function() {
					$(this).prop('checked', false);
				});
				console.log('cancel');
			}
		});

		
		$("#addForm").validate({
			rules: {
				name: {
					required: true
				},
				phone: {
					required: true
				},
				address: {
					required: true
				}
			}
		});
		
		
		$("#myModal").on("show.bs.modal",function(e){
			var source = $(e.relatedTarget);
			if(source.attr('id')=='updBtn') {
				$('#addForm').attr('action','/sickness-system/department/upd');
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
				var type = tds.eq(3).html();
				$('#type').val(type=='私立'?'private':'public');
				$('#address').val(tds.eq(4).html());
				$('#phone').val(tds.eq(5).html());
				$('#email').val(tds.eq(6).html());
			} else {
				$('#addForm').attr('action','/sickness-system/department/add');
				$('#id').val('');
				$('#name').val('');
				$('#type').val('public');
				$('#address').val('');
				$('#phone').val('');
				$('#email').val('');
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
				    form.attr('action', "/sickness-system/department/del");
				    form.attr('method', 'post');
				    form.css('opcity', '0');
//				    // 创建Input
				    var my_input = $('<input  name="ids" type="text" />');
				    my_input.attr('value',  ids);
//				    // 附加到Form
				    form.append(my_input);
				    $(document.body).append(form);
//				    // 提交表单
				    form.submit();
				}
			}
		}
		
	</script>

</html>