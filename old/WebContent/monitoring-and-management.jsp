<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<style>
			#app #head-nav{
				height: 60px;
				background: #ABE3FF;
			}
			#app #head-nav ul{
				margin: 10px auto;
			}
			#app #head-nav ul li{
				margin: 0 10px;
				
			}
			#app #head-nav ul li select{
				line-height: 26px;
				height: 26px;
			}
			#app #center-nav{
				height: 60px;
				background: #738FFF;
			}
			#app #center-nav ul{
				margin: 10px auto;
			}
			#app #center-nav ul li{
				margin: 0 10px;
				
			}
			#app #content-table #table-div{
			}
			#app #content-table table thead tr th{
				text-align: center;
			}
			#app #content-table table thead tr{
				background: #D2D2D2;
				height: 45px;
			}
			#app #table-bottom-nav{
				height: 50px;
				background: #D2D2D2;
				/*position: relative;
				bottom: -168px;*/
			}
			#app #table-bottom-nav div{
				margin: 10px auto;
			}
			#app #table-bottom-nav ul li{
				margin: 0 5px;
			}
			#app #table-bottom-nav ul li input{
				width: 50px;
				height: 34px;
			}
			#app  table tbody tr td input{
				display: inline-block;
			}
		</style>
	</head>
	<body>
		<div id="app">
			<div id="head-nav">
				<ul class="nav navbar-nav">
					<li>查询内容：</li>
					<li>
						<select id="sickType">
							<option value="all">所有疾病</option>
							<option value="mz">麻疹</option>
							<option value="gm">流行性感冒</option>
							<option value="xzb">先天性心脏病</option>
							<option value="bcb">包虫病</option>
							<option value="bnz">白内障</option>
						</select>
					</li>
					<li>
						<select id="scopeType">
							<option value="all">所有区域</option>
							<option value="cgq">城关区</option>
							<option value="dlx">堆龙县</option>
							<option value="xsq">西山区</option>
							<option value="whq">五华区</option>
							<option value="lwxq">柳梧新区</option>
						</select>
					</li>
					<li>
						<input type="radio" name="selType" value="info" id="info" checked="ckecked" /><label for="info"> 查询详细信息</label>
						<input type="radio" name="selType" value="count" id="count" /><label for="count"> 查询统计结果</label>
					</li>
					<li><button class="btn btn-primary selectBtn" onclick="selectInfo()">查询</button></li>
					<li><button class="btn btn-primary flushBtn" onclick="window.location.href='/sickness-system/monitoringManagement'">刷新</button></li>
				</ul>
			</div>

			<div id="content-table">
				<div id="table-div">
					<table class="table table-striped text-center table-bordered table-hover table-condensed">
						<thead>
							<!--病人编号、姓名、年龄、家庭住址、所患疾病、联系方式、工作地点、活动范围-->
							<tr>
								<th>病人编号</th>
								<th>姓名</th>
								<th>年龄</th>
								<th>家庭住址</th>
								<th>所患疾病</th>
								<th>联系方式</th>
								<th>工作地点</th>
								<th>区域</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${infos}" begin="0" var="info">
								<tr>
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
	</body>
	<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script>
		var msg='${msg}';
		if(msg){
			alert(msg)
			<c:remove  var="msg"  scope="session"  />
		}
		$('#selectAll').change(function() {
			if($(this).is(':checked')) {
				$('.checkbox').each(function(){
					$(this).prop('checked',true);
				});
				console.log('selected');
			} else {
				$('.checkbox').each(function(){
					$(this).prop('checked',false);
				});
				console.log('cancel');
			}
		});
		
		function selectInfo(){
			var type = $("input[name='selType']:checked").val();
			console.log(type);
			
			// 创建Form
		    var form = $('<form></form>');
			if(type=='info'){
				form.attr('action', "/sickness-system/monitoringManagement");
			} else if(type=='count'){
				// 设置属性
		    	form.attr('action', "/sickness-system/monitoringManagement/count");
			}
		    form.attr('method', 'post');
		    // 创建Input
		    form.css('opcity', '0');
		    var my_input1 = $('<input  name="sick" type="text" />');
		    my_input1.attr('value',  $('#sickType').val());
		    // 附加到Form
		    form.append(my_input1);
		     // 创建Input
		    var my_input2 = $('<input  name="scope" type="text" />');
		    my_input2.attr('value',  $('#scopeType').val());
		    // 附加到Form
		    form.append(my_input2);
		    $(document.body).append(form);
		    // 提交表单
		    form.submit();
			
			
		}
	</script>
</html>
