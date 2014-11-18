<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/info/css/info.css" />
<!-- script type="text/javascript" src="js/jquery-1.5.2.min.js"></script -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	
	$('#d3').html($('#t1').val());
	
	$('#btn1').click(function() {
		// Ajax Post Test
		$.post( "/wowComm/menu/menuList.do", { currentPage: '1', pageSize: '10', menuId:'10' }, function(data){
			//alert(data);
			$('#d1').html(data);
			$('#d1').show();
		});
		
	});
	
	$('#btn5').click(function() {
		// Ajax Get Test
		$.get( "/wowComm/menu/menuForm.do", function(data){
			//alert(data);
			$('#d5').html(data);
			$('#d5').show();
		});
		
	});
	
	$('#btn7').click(function() {
		// hide test
		$('#d1').hide();
		
	});
	
	$('#btn8').click(function() {
		// hide test
		$('#d5').hide();
		
	});
	
	$('#btn2').click(function() {
		// hide test
		$('#d2').hide();
		
	});
	
	$('#btn3').click(function() {
		// show test
		$('#d2').show();
		
	});
	
	$('input[name=t1]').focus(function() {
		// change test
		$('#d3').html('');
		
	});
	
	$('input[name=t1]').change(function() {
		// change test
		$('#d3').html($('input[name=t1]').val());
		
	});
	
});


</script>
</head>
<body>
<h2>JQeury Sample</h2>
<b>Ajax Test : </b> 
	<input type="button" name="btn1" id="btn1" value="Post Ajax" /><input type="button" name="btn7" id="btn7" value="Post Ajax Hide" />
<br />
	<div id="d1" name="d1"></div>
<br /> 
<b>Ajax Test : </b> 
	<input type="button" name="btn5" id="btn5" value="Get Ajax" /><input type="button" name="btn8" id="btn8" value="Get Ajax Hide" />
<br />
	<div id="d5" name="d5"></div>
<br />
<b>Hide & Show Test : </b>
	<input type="button" name="btn2" id="btn2" value="Hide" /><input type="button" name="btn3" id="btn3" value="Show" />
<br />
	<div id="d2" name="d2">Hello~~</div>
<br />
<b>Focus & Change Test : </b> 
	<input type="text" id="t1" name="t1" value="Text Change" />
<br />
	<div id="d3" name="d3"></div>
</body>
</html>