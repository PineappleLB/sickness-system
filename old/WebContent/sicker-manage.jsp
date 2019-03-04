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
					<li>查询内容：<input type="text" id="sel_content" /> </li>
					<li>
						<select id="sel_type">
							<option value="id">按病人编号</option>
							<option value="name">按病人姓名</option>
						</select>
					</li>
					<li><button class="btn btn-primary" onclick="select()">查询</button></li>
					<li><button class="btn btn-primary" onclick="window.location.href='/sickness-system/sicker'">刷新</button></li>
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
								<th>病人编号</th>
								<th>病人姓名</th>
								<th>年龄</th>
								<th>家庭地址</th>
								<th>疾病类型</th>
								<th>联系电话</th>
								<th>工作地址</th>
								<th>区域</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${infos}" begin="0" var="info">
								<tr>
									<td><input type="checkbox" class="checkbox" /></td>
									<td>${info.id }</td>
									<td>${info.name }</td>
									<td>${info.age }</td>
									<td>${info.home_address }</td>
									<td>${info.sick }</td>
									<td>${info.phone }</td>
									<td>${info.work_address }</td>
									<td>${info.scope }</td>
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
							<h4 class="modal-title" id="myModalLabel">新增病人信息</h4>
						</div>
						<div class="modal-body" style="text-align:center;">
							<div class="form-group">
								<input type="hidden" id="id" name="id" />
							</div>
							<div class="form-group">
								<label for="name">姓名：</label>
								<input type="text" id="name" name="name" />
							</div>
							<div class="form-group">
								<label for="age">年龄：</label>
								<input type="number" id="age" name="age" maxlength="3" />
							</div>
							<div class="form-group">
								<label for="home_address">家庭地址：</label>
								<input type="text" id="home_address" name="home_address" />
							</div>
							<div class="form-group">
								<label for="sick">疾病类型：</label>
								<select name="sick" id="sick">
									<option value="mz">麻疹</option>
									<option value="gm">流行性感冒</option>
									<option value="xzb">先天性心脏病</option>
									<option value="bcb">包虫病</option>
									<option value="bnz">白内障</option>
								</select>
							</div>
							<div class="form-group">
								<label for="phone">联系电话：</label>
								<input type="text" id="phone" name="phone" />
							</div>
							<div class="form-group">
								<label for="work_address">工作地址：</label>
								<input type="text" id="work_address" name="work_address" />
							</div>
							<div class="form-group">
								<label for="scope">区域:</label>
								<select name="scope" id="scope">
									<option value="cgq">城关区</option>
									<option value="dlx">堆龙县</option>
									<option value="xsq">西山区</option>
									<option value="whq">五华区</option>
									<option value="lwxq">柳梧新区</option>
								</select>
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
		var msg = "${msg}";
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
				age: {
					required: true
				},
				sick: {
					required: true
				}
			}
		});
		
		
		$("#myModal").on("show.bs.modal",function(e){
			var source = $(e.relatedTarget);
			if(source.attr('id')=='updBtn') {
				$('#addForm #name').attr('disabled',true);
				$('#addForm').attr('action','/sickness-system/monitoringManagement/upd');
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
				$('#age').val(tds.eq(3).html());
				var sick = tds.eq(5).html();
				$('#sick').val(sick=='麻疹'?'mz':sick=='流行性感冒'?'gm':sick=='先天性心脏病'?'xzb':sick=='包虫病'?'bcb':'bnz');
				$('#home_address').val(tds.eq(4).html());
				$('#phone').val(tds.eq(6).html());
				$('#work_address').val(tds.eq(7).html());
				var scope = tds.eq(8).html();
				$('#scope').val(scope=='城关区'?'cgq':scope=='堆龙县'?'dlx':scope=='西山区'?'xsq':scope=='五华区'?'whq':'lwxq');
				
			} else {
				$('#addForm #name').attr('disabled',false);
				$('#addForm').attr('action','/sickness-system/monitoringManagement/add');
				$('#name').val('');
				$('#age').val('');
				$('#sick').val('mz');
				$('#home_address').val('');
				$('#phone').val('');
				$('#work_address').val('');
				$('#scope').val('cgq');
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
				    form.attr('action', "/sickness-system/monitoringManagement/del");
				    form.attr('method', 'post');
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
		
		function select(){
			var text = $('#sel_content').val();
			var sel_type = $('#sel_type').val();
			// 创建Form
		    var form = $('<form></form>');
			// 设置属性
	    	form.attr('action', "/sickness-system/sickerManager/sel");
		    form.attr('method', 'post');
		    // 创建Input
		    var my_input1 = $('<input  name="sel_text" type="text" />');
		    my_input1.attr('value',  text);
		    // 附加到Form
		    form.append(my_input1);
		     // 创建Input
		    var my_input2 = $('<input  name="sel_type" type="text" />');
		    my_input2.attr('value',  sel_type);
		    // 附加到Form
		    form.append(my_input2);
		    $(document.body).append(form);
		    // 提交表单
		    form.submit();
		}
		
	</script>

</html>