<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<style>
			#app #head-nav{
				height: 60px;
				background: #ABE3FF;
			}
			#app #head-nav ul, #app #center-nav ul{
				margin: 10px auto;
			}
			#app #head-nav ul li, #app #center-nav ul li{
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
			#app #content-table #table-div{
				height: 610px;
			}
			#app #content-table #table-div table tbody tr td input{
				display: inline-block;
			}
			#app #content-table table thead tr th{
				text-align: center;
			}
			#app #content-table table thead tr{
				background: #D2D2D2;
				height: 45px;
			}

			#app #content-table table tbody tr td{
				/*padding: 3px;*/
			}
			#app #table-bottom-nav{
				height: 50px;
				background: #D2D2D2;
				position: relative;
				bottom: -108px;
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
		</style>
	</head>
	<body>
		<div id="app">
			<div id="head-nav">
				<ul class="nav navbar-nav">
					<li>查询内容：<input type="text" id="date-prev"/> </li>
					<li>
						<select id="game-type-sel">
							<option value="all">按病人编号</option>
							<option value="ddz1">按病人姓名</option>
							<option value="ddz2">按疾病类型</option>
						</select>
					</li>
					<li><button class="btn btn-primary">查询</button></li>
					<li><button class="btn btn-primary">刷新</button></li>
				</ul>
			</div>
			<div id="center-nav">
				<ul class="nav navbar-nav">
					<li><button class="btn btn-success">新增</button></li>
					<li><button class="btn btn-info">修改</button></li>
					<li><button class="btn btn-danger">删除</button></li>
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
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
	</body>
	<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<script>
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
	</script>
</html>
