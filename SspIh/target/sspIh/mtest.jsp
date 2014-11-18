<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MOBILE_TEST_PAGE</title>
<style type="text/css">
body		{margin:0px; padding:0px; background:#fff; font:14px sans-serif bold;}
input		{outline:none; text-decoration:none;}

#main		{margin: 0px; padding: 0px;min-height: 500px;}
#content	{margin-left: 5%;margin-top: 10px; width: 90%; vertical-align: middle;}
#header		{padding: 0px;vertical-align: bottom;text-align: center;}
#body		{padding: 10px;vertical-align: top;}

#comboBox, #inputBox {vertical-align:middle;}
#service	{width: 380px;margin: 15px 0 10px 0;border: 1px solid #999;background-color: #eee;}
#testBtn	{width: 50px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;}
#domain		{width: 400px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;padding-left: 2px;}
#pad		{padding-right: 10px;padding-left: 10px;}
#version	{width: 25px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;padding-left: 2px;}
#imgUrl		{width: 355px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;padding-left: 2px;}
#authkey	{width: 300px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;padding-left: 2px;}

#dataTable	{ width:100%;padding:0px;margin:0px;}
#dataTable tr { width:100%;padding:0px;margin:0px;}
#dataTable td { width:33%;padding:0px;margin:0px;}
#reqText, #resText {width:96%;min-height:350px;border: 1px #999 solid;padding: 5px;display:block;}
.topContent{min-height: 300px;vertical-align:top;}

/* choi */
#requestHeader { padding: 0 0 0 10px; }
#tbl tbody tr td { padding-right: 20px; }
.table_indent { text-indent: 30px; }
</style>
<script src="js/jquery-1.5.2.min.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		
		$('#testBtn').click(function(){
			
			$('#imgTemp').html('');
			$('#imageDiv').html('');
			$('#resText').text('');
			
			var contentType = 'text/xml; charset=utf8';
			
			$('#testBtn').attr('disabled',true);
			$('#procMsg').text('처리중 입니다. 기다려주세요.');

			$.ajax({
				url: $('#domain').val() + $('#service').val(),
				type: 'POST',
				contentType: contentType,
				timeout: 1000*60*60,
				cache: false,
				data: $('#reqText').val(),
				dataType: 'text',
				success: function(data) {

					$('#resText').text(data);
					
					var xmlDoc = $.parseXML( data );
					var $xml = $( xmlDoc );
					
					$xml.find( "imgUrl" ).each(function(idx){
						$('#imgTemp').append( $( '<input>', { 'type' : 'hidden', 'value' : $(this).text()} ) ).append('<br>');
					});
					
					setTimeout("imgTest()", 1000);
					
					$('#testBtn').attr('disabled',false);
					$('#procMsg').text('');
					
				},
				error: function(x, s, e) {
					if(x.status == 0) {
						$('#resText').html('Error. : Please Check Your Network.');

					} else if(x.status == 404) {
						$('#resText').html('Error. : Page not found.');

					} else if(x.status == 500) {
						$('#resText').html('Error. : Internel Server Error.');

					} else if(e == 'parsererror') {
						$('#resText').html('Error. : Parsing Request failed.');

					} else if(e == 'timeout') {
						$('#resText').html('Error. : Request Time out.');

					} else {
						$('#resText').html('Unknow Error. : ' + x.responseText);

					}
					$('#testBtn').attr('disabled',false);
					$('#procMsg').text('');
				}
			});
		});

	});
	
	function imgTest() {
		$('#imgTemp').find('input').each(function(idx){
			$('#imageDiv').append( $('<img>', { 'src' : $(this).val() }) ).append('<br>').append('<br>');
		});
	}
	
	function change_url(val) {
		if(val != "") {
			if(val == "IF-IH-001") {
				$('#reqText').val("<Request>\n" +
						"<body>\n" +
						"<adminCode>designfd</adminCode>\n" +
						"<userId>designfd</userId>\n" +
						"<convReqSysCd>DBP</convReqSysCd>\n" +
						"<convReqDt>2011-10-21 15:48:20</convReqDt>\n" +
						"<sizeList>\n" +
						"<sizes>\n" +
						"<reqDevCd>AND</reqDevCd>\n" +
						"<imgSize>144x144</imgSize>\n" +
						"</sizes>\n" +
						"<sizes>\n" +
						"<reqDevCd>IOS</reqDevCd>\n" +
						"<imgSize>108x108</imgSize>\n" +
						"</sizes>\n" +
						"</sizeList>\n" +
						"<fileList>\n" +
						"<files>\n" +
						"<keyVal>0003_00064</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0008_00026</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"</fileList>\n" +
						"</body>\n" +
						"</Request>");

			} else if(val == "IF-IH-002") {
				/*$('#reqText').val("<Request>\n" +
						"<body>\n" +
						"<transactionId>12345</transactionId>\n" +
						"<adminCode>designfd</adminCode>\n" +
						"<convReqSysCd>DBP</convReqSysCd>\n" +
						"<convReqDt>2011-10-21 15:48:20</convReqDt>\n" +
						"<sizeList>\n" +
						"<sizes>\n" +
						"<reqDevCd>AND</reqDevCd>\n" +
						"<imgSize>144x144</imgSize>\n" +
						"</sizes>\n" +
						"<sizes>\n" +
						"<reqDevCd>IOS</reqDevCd>\n" +
						"<imgSize>108x108</imgSize>\n" +
						"</sizes>\n" +
						"</sizeList>\n" +
						"<fileList>\n" +
						"<files>\n" +
						"<keyVal>0003_00064</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0008_00026</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0008_00057</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0013_00009</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0014_00086</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0028_00024</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0029_00014</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0030_00018</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0043_00195</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"<files>\n" +
						"<keyVal>0046_00007</keyVal>\n" +
						"<imgUrl>http://www.bydigital.co.kr/bemarket/goods/9279_imgl1</imgUrl>\n" +
						"</files>\n" +
						"</fileList>\n" +
						"</body>\n" +
						"</Request>");*/
				
				$('#reqText').val("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><body><transactionId>20111106221537</transactionId><adminCode>exsnow</adminCode><convReqSysCd>DBP</convReqSysCd><convReqDt>2011-11-06 10:15:45</convReqDt><sizeList><sizes><reqDevCd>AND</reqDevCd><imgSize>144x144</imgSize></sizes><sizes><reqDevCd>IOS</reqDevCd><imgSize>108x108</imgSize></sizes></sizeList>" +
					"<fileList>" +
						"<files>" +
							"<keyVal>CT3005683</keyVal>" +
							"<imgUrl>http://image.11st.co.kr/g/2/6/6/7/4/1/5266741_B_4.gif" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005686</keyVal>" +
							"<imgUrl>http://image.11st.co.kr/i/0/4/6/5/9/0/59046590_B_5.gif" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005720</keyVal>" +
							"<imgUrl>http://gdimg3.gmarket.co.kr/goods_image2/middle_img/125/756/125756246.jpg" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005721</keyVal>" +
							"<imgUrl>http://image.11st.co.kr/h/0/9/0/8/8/9/42090889_B_1.gif" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005722</keyVal>" +
							"<imgUrl>http://image.11st.co.kr/g/5/0/6/3/7/4/33506374_B.gif" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005758</keyVal>" +
							"<imgUrl>http://gdimg5.gmarket.co.kr/goods_image2/middle_img/201/072/201072976.jpg" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005775</keyVal>" +
							"<imgUrl>http://gdimg5.gmarket.co.kr/goods_image2/middle_img/199/191/199191826.jpg" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005776</keyVal>" +
							"<imgUrl>http://gdimg5.gmarket.co.kr/goods_image2/middle_img/199/173/199173198.jpg" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005777</keyVal>" +
							"<imgUrl>http://gdimg5.gmarket.co.kr/goods_image2/middle_img/199/192/199192848.jpg" +
							"</imgUrl>" +
						"</files>" +
						"<files>" +
							"<keyVal>CT3005778</keyVal>" +
							"<imgUrl>http://gdimg5.gmarket.co.kr/goods_image2/middle_img/199/565/199565107.jpg" +
							"</imgUrl>" +
						"</files>" +
					"</fileList>" +
				"</body>" +
			"</Request>");

			}
		}
	}
</script>
</head>
<body>

<div id="main">

	<div id="content">

		<div id="header">

			<div id="titleText">
				<h2>Image Convert Test Page</h2>
			</div>

			<hr>

			<div id="inputBox">
				<span><b>Domain : </b></span>
				<!-- <input type="text" id="domain" name="domain" value="http://localhost:8080/sspIh/mobileIh/mobileInterface/"/> -->
				<input type="text" id="domain" name="domain" value="http://1.234.6.241:8080/sspIh/mobileIh/mobileInterface/"/>
				<span id="pad"></span>
				<input type="button" id="testBtn" name="testBtn" value="TEST" />
				<div id="procMsg"></div>
			</div>
			
			<hr>
			
			<div id="comboBox">
				<span><b>Sevice : </b></span>
				  <select id="service" onChange="javascript:change_url(this.value);">
				  	<option value="">=================== 선택 =======================</option>

				  	<option value="IF-IH-001">(IF-IH-001)</option>
				  	<option value="IF-IH-002">(IF-IH-002)</option>
				  	
					<option value="">===============================================</option>

				  </select>
			</div>

		</div>

		<hr>

		<div id="body">

			<table id="dataTable">
				<tr>
					<td><b>Request Body : </b></td>
					<td><b>Response Body : </b></td>
					<td><b>Image : </b></td>
				</tr>
				<tr>
					<td class="topContent">
						<textarea id="reqText" style="height:50px;width:90%;"></textarea>
					</td>
					<td class="topContent">
						<textarea id="resText" style="height:50px;width:90%;" readonly="readonly"></textarea>
				    </td>
				    <td class="topContent">
						<div id="imageDiv" style="overflow: auto;width: 365px;height: 360px;"></div>
				    </td>
				</tr>
			</table>

		</div>
		
		<div id="imgTemp"></div>

	</div>

</div>
</body>
</html>