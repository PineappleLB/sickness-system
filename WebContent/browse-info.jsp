<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
		<style>
			#app #left #pic img{
				margin: 15px;
			}
			#app #left #pic img:hover{
				box-shadow: 0 0 10px 5px lightgray;
			}
			.active{
				border: 2px green solid;
				box-shadow: 0 0 10px 5px lightgray;
			}
			#content{
				
			}
		</style>
	</head>
	<body>
		
		<div id="app">
			<div id="left" class="col-lg-6">
				<div id="pic">
					<img src="img/4.jpg" class="img-circle active" srcIndex='0' />
					<img src="img/5.jpg" class="img-circle" srcIndex='1' />
					<img src="img/6.jpg" class="img-circle" srcIndex='2' />
					<img src="img/7.jpg" class="img-circle" srcIndex='3' />
					<img src="img/8.jpg" class="img-circle" srcIndex='4' />
					<img src="img/9.jpg" class="img-circle" srcIndex='5' />
					<img src="img/10.jpg" class="img-circle" srcIndex='6' />
					<img src="img/11.jpg" class="img-circle" srcIndex='7' />
					<img src="img/12.jpg" class="img-circle" srcIndex='8' />
				</div>
			</div>
			<div id="right" class="col-lg-6">
				<div id="content">
					<div class="media">
						<a class="media-left" href="#">
							<img class="media-object img-circle active" src="img/4.jpg" alt="媒体对象">
						</a>
						<div class="media-body">
							世界卫生组织会徽是由1948年第一届世界卫生大会选定的。该会徽由一条蛇盘绕的权杖所覆盖的联合国标志组成。长期以来，由蛇盘绕的权杖系医学及医学界的标志。它起源于埃斯科拉庇俄斯的故事，古希腊人将其尊崇为医神，并且其崇拜涉及蛇的使用。（随便提及，埃斯科拉庇俄斯如此成功地拯救生命，以致传说地狱阎王哈德斯向至高无上的神宙斯抱怨他，由于害怕医者可能使人永生，宙斯用雷电杀死了埃斯科拉庇俄斯。）
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</body>
	<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<script>
		
		var imgBody = [{
			imgsrc:'img/4.jpg',
			imgbody:'世界卫生组织会徽是由1948年第一届世界卫生大会选定的。该会徽由一条蛇盘绕的权杖所覆盖的联合国标志组成。长期以来，由蛇盘绕的权杖系医学及医学界的标志。它起源于埃斯科拉庇俄斯的故事，古希腊人将其尊崇为医神，并且其崇拜涉及蛇的使用。（随便提及，埃斯科拉庇俄斯如此成功地拯救生命，以致传说地狱阎王哈德斯向至高无上的神宙斯抱怨他，由于害怕医者可能使人永生，宙斯用雷电杀死了埃斯科拉庇俄斯。）'
		},{
			imgsrc:'img/5.jpg',
			imgbody:'红十字标志，由五人委员会成立，后由白底红十字作为识别标志，采用了倒转的瑞士联邦国旗的颜色，改成红新月标志，再后来改成了红水晶标志。859年6月，有个名叫 亨利·杜南的 瑞士商人，亲眼目睹了 拿破仑皇帝率法军和撒丁军与 奥地利陆军为争 夺伦巴第地区，在马根塔和索尔 费里诺两地血战的过程。索尔费里诺之战，双方伤亡4万多人。大批伤兵被遗弃在战场上，在烈日蒸晒下无人救护，状况十分凄惨。杜南出于同情和怜悯，当即出钱购买药品，号召该地居民同他一道不分国籍地抢救和看护被遗弃的伤兵。回到日内瓦后，1863年2月9日，杜南和瑞士陆军总司令杜甫尔将军、莫瓦尼埃律师、阿皮亚和莫诺瓦两位医生等一道，组成了伤兵救护国际委员会，被后人称为“五人委员会”。到1876年，五人委员会正式易名为“红十字国际委员会”。'
		},{
			imgsrc:'img/6.jpg',
			imgbody:'国际罕见病日由欧洲罕见病组织（EURODIS）发起，于2008年2月29日组织第一届国际罕见病日。首届国际罕见病日纪念活动在欧洲各国成功举行，通过各种活动促进了社会对罕见病的认识。2009年2月28日，欧洲、北美、拉丁美洲等30多个国家的罕见病组织参加了第二个国际罕见病日的活动，其后在各国的一致拥护下，将每年二月的最后一天定为国际罕见病日。'
		},{
			imgsrc:'img/7.jpg',
			imgbody:'世界艾滋病日的标志是红绸带。红绸带标志的意义：红绸带像一条纽带，将世界人民紧紧联系在一起，共同抗击艾滋病，它象征着我们对艾滋病病人和感染者的关心与支持；象征着我们对生命的热爱和对和平的渴望；象征着我们要用“心”来参与预防艾滋病的工作。'
		},{
			imgsrc:'img/8.jpg',
			imgbody:'中国疾病预防控制中心其使命是通过对疾病、残疾和伤害的预防控制，创造健康环境，维护社会稳定，保障国家安全，促进人民健康；其宗旨是以科研为依托、以人才为根本、以疾控为中心。在 国家卫生和计划生育委员会领导下，发挥技术管理及技术服务职能，围绕国家疾病预防控制重点任务，加强对疾病预防控制策略与措施的研究，做好各类疾病预防控制工作规划的组织实施；开展食品安全、职业安全、健康相关产品安全、放射卫生、环境卫生、妇女儿童保健等各项公共卫生业务管理工作，大力开展应用性科学研究，加强对全国疾病预防控制和公共卫生服务的技术指导、培训和质量控制，在防病、应急、公共卫生信息能力的建设等方面发挥国家队的作用。'
		},{
			imgsrc:'img/9.jpg',
			imgbody:'中国疾病预防控制中心（简称中国疾控中心）是由政府举办的实施国家级疾病预防控制与公共卫生技术管理和服务的公益事业单位。其宗旨是以科研为依托、以人才为根本、以疾控为中心。中国疾病预防控制中心，是政府设立的从事全国疾病预防控制与公共卫生技术管理和服务的公益性事业单位，肩负起促进公众健康、保障 公共卫生安全的神圣使命。在北京市北六环外这片近一平方公里绿荫环抱的园区，就是位于 昌平区孟祖山前的中国疾病预防控制中心。'
		},{
			imgsrc:'img/10.jpg',
			imgbody:'医疗卫生机构统一标志为带有白边的四颗红心围绕着白十字。四颗红心分别代表卫生人员对病人、对服务对象的爱心、耐心、细心、责任心。总体图形在医疗机构表示以病人为中心，在其他卫生机构表示以保护和增进人民健康为中心。'
		},{
			imgsrc:'img/11.jpg',
			imgbody:'禁止吸烟标志属于我国安全标志中的一种，而安全标志又分为禁止标志警告标志、指令标志、提示标志四类，其中当属禁止标志是强制性的。禁止标志的含义是不准或者制止人们的某些行动，常见的禁止标志的几何图形是带斜杠的圆环，其中圆环与斜杠相连，用红色；图形符号用黑色，背景用白色。而我们今天所说的禁止吸烟标志正式采用这一格式设计，加入点燃的香烟符号，当然同类的还有禁止通行标志等28种禁止类标志。'
		},{
			imgsrc:'img/12.jpg',
			imgbody:'红丝带像一条纽带将世界人民紧紧联系在一起，共同抗击艾滋病，象征着人们对艾滋病病毒感染者和病人的关心与支持；象征着人们对生命的热爱和对和平等的渴望；象征着人们用“心”来参与预防艾滋病的工作。'
		}
		]
		
		$(function(){
			$('#right').height($('#left').height());
			$('.media').css('margin-top',($('#left').height() - $('.media').height()) / 2 + 'px')
		});
		$('#pic img').click(function(){
			console.log(this);
			$('.active').removeClass('active');
			$(this).addClass('active');
			activeChange($(this).attr('srcIndex'));
		});
		/*点击不同的图片触发切换*/
		function activeChange(srcIndex){
			$('.media .media-object').attr('src', imgBody[srcIndex].imgsrc).addClass('active');
			$('.media .media-body').html(imgBody[srcIndex].imgbody);
		}
	</script>
</html>
