<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<style type="text/css">
			#app {
				width: 1000px;
				margin: 0 auto;
			}
			#app #content .media{
				margin-top: 20px;
			}
		</style>
	</head>

	<body>
		<div id="app">

			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="img/1.jpg" width="100%" alt="First slide">
					</div>
					<div class="item">
						<img src="img/2.jpg" width="100%" alt="Second slide">
					</div>
					<div class="item">
						<img src="img/3.jpg" width="100%" alt="Third slide">
					</div>
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			<div id="content">
				<div class="media">
					<a class="media-left" href="#">
						<img class="media-object" src="img/pic1.jpg" alt="媒体对象">
					</a>
					<div class="media-body">
						<h4 class="media-heading">牙齿变白</h4>刷牙时在牙膏上加上一点小苏达，刷三次后牙齿洁白如玉，牙锈自然脱落。
       牙痛绝招：用桃仁放在火上烧热以后放在牙痛上咬，如此几次永不牙痛。
					</div>
				</div>
				<div class="media">
					<a class="media-left" href="#">
						<img class="media-object" src="img/pic2.jpg" alt="媒体对象">
					</a>
					<div class="media-body">
						<h4 class="media-heading">防蚊虫</h4>可以在垃圾桶的垃圾上撒点洗衣粉，这样也是可以防治滋生蚊虫的；同样，可以把茶叶渣倒在垃圾上来防蚊虫；垃圾桶底部放一层不用的纸，用来防治垃圾底部的水渍。
					</div>
				</div>
				<div class="media">
					<a class="media-left" href="#">
						<img class="media-object" src="img/pic3.jpg" alt="媒体对象">
					</a>
					<div class="media-body">
						<h4 class="media-heading">清洁厨房</h4> 厨房油烟比较多，一般清洁厨房最头疼的就是清洁油渍。可以用面包擦拭瓷砖上的油渍；可以用热盐水来疏通堵塞的下水道。
					</div>
				</div>
				<div class="media">
					<a class="media-left" href="#">
						<img class="media-object" src="img/pic4.jpg" alt="媒体对象">
					</a>
					<div class="media-body">
						<h4 class="media-heading">清洗喷头</h4> 常用洗澡喷头的朋友会发现，喷头会被水垢堵塞。可以在喷头上喷点白醋，然后用塑料袋包住喷头，隔一晚，第二天用清水冲洗即可。
					</div>
				</div>
				<div class="media">
					<a class="media-left" href="#">
						<img class="media-object" src="img/pic5.jpg" alt="媒体对象">
					</a>
					<div class="media-body">
						<h4 class="media-heading">保鲜肉</h4> 为了吃到新鲜的肉肉，可以将买回来的肉用被醋浸泡过的布子包住放在冰箱里，这样可以保鲜一夜。
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>

</html>