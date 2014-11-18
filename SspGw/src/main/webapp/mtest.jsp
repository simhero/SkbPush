<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MOBILE_TEST_PAGE</title>
<style type="text/css">
body		{margin:0px; padding:0px; background:#fff; font:14px sans-serif bold;}
input		{outline:none; text-decoration:none;}

#main		{margin: 0px; padding: 0px;min-height: 750px;}
#content	{margin-left: 5%;margin-top: 10px; width: 90%; vertical-align: middle;}
#header		{padding: 0px;vertical-align: bottom;text-align: center;}
#body		{padding: 10px;vertical-align: top;}

#comboBox, #inputBox {vertical-align:middle;}
#service	{width: 380px;margin: 15px 0 10px 0;border: 1px solid #999;background-color: #eee;}
#testBtn, #Upload	{width: 50px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;}
#domain		{width: 400px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;padding-left: 2px;}
#pad		{padding-right: 10px;padding-left: 10px;}
#version	{width: 25px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;padding-left: 2px;}
#imgUrl		{width: 355px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;padding-left: 2px;}
#authkey	{width: 300px;margin: 10px 0 10px 0;border: 1px solid #999;background-color: #eee;padding-left: 2px;}

#dataTable	{ width:100%;padding:0px;margin:0px;}
#dataTable tr { width:100%;padding:0px;margin:0px;}
#dataTable td { width:50%;padding:0px;margin:0px;}
#reqText, #resText {width:96%;min-height:350px;border: 1px #999 solid;padding: 5px;display:block;}
.topContent{min-height: 400px;vertical-align:top;}

/* choi */
#requestHeader { padding: 0 0 0 10px; }
#tbl tbody tr td { padding-right: 20px; }
.table_indent { text-indent: 30px; }
</style>
<script src="js/jquery-1.6.2.min.js" language="javascript" type="text/javascript"></script>
<script src="js/jquery.form.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript">

	$(function(){
		
		$('#Upload').click(function(){
			if($('#appFile').val() == '') {
				alert('파일을 선택해주세요.');
				return;
			}
			$('#frm').ajaxSubmit({
				dataType: 'json',
				resetForm: true,
				success :function(data){
					if(data.result == '10') {
						alert('파일 업로드 성공');
						$('#fileUrl').text(data.url);
					} else {
						alert('파일 업로드 실패');
					}
				}
			});
		});

		// 숫자값만 허용
		$('.numeric').blur(function() { 

			var _this = $(this);
			var regexp = /\D/gi;
			if ( regexp.test( _this.val() ) ) {
				alert('allow only number.');
				_this.val( _this.val().replace(/\D/gi, '') ).focus();
			}
		});

		$('#testBtn').click(function(){

			if ( $('#service').val() == '' ) {
				alert('please choice Service');
				return false;
			}

			var params = $('#reqText').val();
			
			var contentType = 'application/json; charset=utf8';
			if( $('#service').val() == 'PU-003') {
				contentType = 'text/xml; charset=utf8';
			}

			$.ajax({
				beforeSend: function(xhr) {
					xhr.setRequestHeader("User-Agent", "iPhone; 640x480; SSP-SVC/1.0");
				},
				url: $('#domain').val() + $('#service').val(),
				type: $('#sendType').val(),
				contentType: contentType,
				timeout: 60000,
				cache: false,
				data: params,
				dataType: 'text',
				success: function(data) {
					
					$('#resText').html(data);
					
					var jsonObj = jQuery.parseJSON(data);
					if(jsonObj.response.header.comResultCode != null  
							&& jsonObj.response.header.comResultCode == '0000000' 
							&& jsonObj.response.header.comAuthKey != null 
							&& jsonObj.response.header.comAuthKey != '') {
						
						$('#authkey').val(jsonObj.response.header.comAuthKey);
					}
					
				},
				complete: function() {
					//alert('complete');
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
				}
			});
		});

	});

	function change_url(val) {
		var reqText = document.getElementById('reqText');

		$('#sendType').val('POST');
		
		var authkey = $('#authkey').val();
		var adminCode = $('#adminCode').val();
		var userId = $('#userId').val();
		var userPw = $('#userPw').val();
		
		if(val == "IF-CU-001") {
			authkey = '';
		}
		
		reqText.value = '';
		var header = "{\"request\":" +
			"{\"header\":{\"comAuthKey\" : \""+authkey+"\", " +
			"\"comInterfaceId\" : \""+val+"\"," +
			"\"comAppVersion\" : \"1.0\", " +
			"\"comTrId\" : \"A0123456789B0123456789C012345678\"," +
			"\"comReqDevCd\" : \"AND\"," +
			"\"comResolution\" : \"640X480\"," +
			"\"comCc\" : \"kr\"," +
			"\"comPhoneNum\" : \"1054005038\"," +
			"\"comModel\" : \"HTC DESIRE\"," +
			"\"comManufacturer\" : \"SAMSUNG\"," +
			"\"comRequestDate\" : \"2011-09-16 11:14:30\"," +
			"\"comDataType\" : \"JSON\"},";

		if(val != "") {
			if(val == "IF-TE-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"out\":\"testout\"," +
					"\"orderList\":[{\"orderId\":\"order1\"},{\"orderId\":\"order2\"},{\"orderId\":\"order3\"}]" +
					"}}}";

			} else if(val == "IF-IN-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"mainCode\" : \"ALL\"" +
					"}}}";

			} else if(val == "IF-IN-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"cName\" : \"이용현\"," +
					"\"cQcontents\" : \"연락주세요!!\"," +
					"\"cHp\" : \"010-6353-2043\"" +
					"}}}";

			} else if(val == "IF-CU-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"userPW\" : \""+userPw+"\"," +
					"\"pushID\" : \"\"" +
					"}}}";

			} else if(val == "IF-CU-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"authValue\" : \"364202\"," +
					"\"cmd\" : \"101\"," +
					"\"cmdValue\" : \"PASS\"" +
					"}}}";

			} else if(val == "IF-CU-003") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"cmd\" : \"001\"," +
					"\"cmdValue\" : \"01063532043\"," + 
					"\"phoneNum\" : \"01063532043\"" +
					"}}}";

			} else if(val == "IF-CU-004") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," + 
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"\"" +
					"}}}";

			} else if(val == "IF-CU-005") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"dateFrom\" : \"2011-07-05 12:17:23\"," +
					"\"dateTo\" : \"2011-09-16 12:17:23\"" +
					"}}}";

			} else if(val == "IF-CU-006") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pushID\" : \"ASDFA1213\"" +
					"}}}";

			} else if(val == "IF-CU-007") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"dateFrom\" : \"2011-07-05 12:17:23\"," +
					"\"dateTo\" : \"2011-09-16 12:17:23\"" +
					"}}}";
	
			} else if(val == "IF-CU-008") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"userPw\" : \""+userPw+"\"," +
					"\"newUserPw\" : \"a\"" +
					"}}}";

			} else if(val == "IF-GO-001") {
				reqText.value = header +
	                "\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
	                "\"mainCode\" : \"ALL\"," +
	                "\"uidList\" : [{\"uid\":\"zzata\"}]," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
	                "\"searchGubun\" : \"gname\"," +
					"\"searchWord\" : \"\"," +
					"\"reSearchGubun\" : \"\"," +
					"\"reSearchWord\" : \"\"," +
					"\"stts\" : \"01\"," +
					"\"gPqtyGubun\" : \"A\"," +
					"\"termGubun\":\"all\"," +
	                "\"dateFrom\" : \"2011-09-01 00:00:00\"," +
					"\"dateTo\" : \"2011-09-11 00:00:00\"," +
	                "\"safetyQtyYn\" : \"A\"," +
					"\"useWpriceYn\" : \"Y\"," +
					"\"orderBy\" : \"gjcode\"" +
					"}}}";

			} else if(val == "IF-GO-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"gJcode\" : \"CT2002577@1\"" +
					"}}}";

			} else if(val == "IF-GO-003") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"goodsList\" : [{\"gJcode\" : \"0008_00057\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"cmd\" : \"001\"," +
					"\"useWpriceYn\" : \"Y\"," +
					"\"gWprice\" : \"10000000\"," +
					"\"gQty\" : \"500\"," +
					"\"safetyQtyYn\" : \"Y\"," +
					"\"safetyQty\" : \"2000\"," +
					"\"gPriceBatchUpdateYn\" : \"Y\"," +
					"\"gPrice\" : \"139000\"," +
					"\"stts\" : \"01\"}," +
					"{\"gJcode\" : \"0008_00057\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"cmd\" : \"001\"," +
					"\"useWpriceYn\" : \"Y\"," +
					"\"gWprice\" : \"10000000\"," +
					"\"gQty\" : \"500\"," +
					"\"safetyQtyYn\" : \"N\"," +
					"\"safetyQty\" : \"2000\"," +
					"\"gPriceBatchUpdateYn\" : \"Y\"," +
					"\"gPrice\" : \"139000\"," +
					"\"stts\" : \"01\"}]" +
					"}}}";

			} else if(val == "IF-GO-004") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"gJcode\" : \"156997\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"" +
					"}}}";

			} else if(val == "IF-GO-005") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"groupCode\" : \"\"," +
					"\"cmd\" : \"001\"," +
					"\"cmdValue\" : \"테스트그룹12\"" +
					"}}}";

			} else if(val == "IF-GO-0051") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"cmd\" : \"001\"," +
					"\"targetGroupCode\" : \"\"," +
					"\"dataList\" : [" +
					"{\"groupCode\" : \"\",\"cmdValue\" : \"테스트그룹12\"}" +
					"]" +
					"}}}";
	
			} else if(val == "IF-GO-006") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"cmd\" : \"ALL\"," +
					"\"cmdValue\" : \"\"" +
					"}}}";

			} else if(val == "IF-GO-007") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"searchGubun\" : \"000\"," +
					"\"searchWord\" : \"\"," +
					"\"orderBy\" : \"001\"" +
					"}}}";

			} else if(val == "IF-GO-008") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"gJcode\" : \"CT2002577@1\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"gB2bcode\" : \"\"," +
					"\"cmd\" : \"001\"," +
					"\"keyWord\" : \"NIKE\"" +
					"}}}";

			} else if(val == "IF-GO-009") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"gJcode\" : \"CT2002577@1\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"orderBy\" : \"001\"" +
					"}}}";

			} else if(val == "IF-GO-010") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"gJcode\" : \"CT2002577@1\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"gB2bcode\" : \"123123\"," +
					"\"idxList\" : [{\"idx\":\"1\"}]" +
					"}}}";

			} else if(val == "IF-GO-011") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"gJcode\" : \"CT2002577@1\"" +
					"}}}";

			} else if(val == "IF-GO-012") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"searchGubun\" : \"001\"," +
					"\"searchWord\" : \"\"," +
					"\"orderBy\" : \"001\"" +
					"}}}";

			} else if(val == "IF-OR-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"ALL\"," +
					"\"uidList\" : [{\"uid\":\"zzata\"}]," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"searchGubun\" : \"000\"," +
					"\"searchWord\" : \"\"," +
					"\"oState\" : \"G00\"," +
					"\"termGubun\" : \"001\"," +
					"\"dateFrom\" : \"2011-09-01 00:00:00\"," +
					"\"dateTo\" : \"2011-09-25 00:00:00\"" +
					"}}}";
	
			} else if(val == "IF-OR-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"SKE\"," +
					"\"uid\" : \"zzata10\"," +
					"\"jumunNo\" : \"201001250126086\"" +
					"}}}";
	
			} else if(val == "IF-OR-003") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"orderList\" : [" +
					"{\"mainCode\":\"SKE\", \"uid\":\"designfd\", \"jumunNo\":\"201001270367127\", \"cmd\":\"002\", \"oState\":\"03\", \"tagcom\":\"DEA\", \"songjangNo\":\"78979894\"}" +
					"]" +
					"}}}";
	
			} else if(val == "IF-SE-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"SKE\"," +
					"\"uidList\" : [{\"uid\":\"zzata\"}]," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"termGubun\" : \"001\"," +
					"\"dateFrom\" : \"2008-01-01 00:00:00\"," +
					"\"dateTo\" : \"2011-09-25 00:00:00\"" +
					"}}}";
	
			} else if(val == "IF-SE-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"SKE\"," +
					"\"uid\" : \"zzata\"," +
					"\"jumunNo\" : \"200808222214667\"" +
					"}}}";
	
			} else if(val == "IF-CS-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"ALL\"," +
					"\"uidList\" : [{\"uid\":\"zzata\"}]," +
					"\"csKind\" : \"00\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"searchGubun\" : \"000\"," +
					"\"searchWord\" : \"\"," +
					"\"csState\" : \"00\"," +
					"\"termGubun\" : \"000\"," +
					"\"dateFrom\" : \"2011-01-01 00:00:00\"," +
					"\"dateTo\" : \"2011-09-29 00:00:00\"" +
					"}}}";

			} else if(val == "IF-CS-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"csNo\" : \"CS201109070017\"" +
					"}}}";

			} else if(val == "IF-CS-003") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"csNo\" : \"CS201109070002\"," +
					"\"cmd\" : \"002\"," +
					"\"csState\" : \"01\"," +
					"\"aSubject\" : \"TEST\"," +
					"\"aContents\" : \"TESTED\"" +
					"}}}";

			} else if(val == "IF-CS-004") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"ALL\"," +
					"\"uidList\" : [{\"uid\":\"zzata\"}]," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"," +
					"\"searchGubun\" : \"000\"," +
					"\"searchWord\" : \"\"," +
					"\"csState\" : \"00\"," +
					"\"termGubun\" : \"000\"," +
					"\"dateFrom\" : \"2011-01-01 00:00:00\"," +
					"\"dateTo\" : \"2011-09-29 00:00:00\"" +
					"}}}";

			} else if(val == "IF-CS-005") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"csNo\" : \"CS201109070005\"" +
					"}}}";

			} else if(val == "IF-CS-006") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"" +
					"}}}";

			} else if(val == "IF-CS-007") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"cmd\" : \"002\"," +
					"\"csNo\" : \"CS201109070002\"," +
					"\"aSubject\" : \"답변수정\"," +
					"\"aContents\" : \"수정합니다.\"" +
					"}}}";

			} else if(val == "IF-CS-008") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"" +
					"}}}";

			} else if(val == "IF-CS-009") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"" +
					"}}}";

			} else if(val == "IF-CS-010") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"csNo\" : \"QNA20110928000000001\"" +
					"}}}";

			} else if(val == "IF-CS-011") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"cmd\" : \"001\"," +
					"\"csList\" : [{" +
					"\"csNo\" : \"\"," +
					"\"aSubject\" : \"문의등록 1\"," +
					"\"aContents\" : \"문의등록 합니다.\"" +
					"},{" +
					"\"csNo\" : \"\"," +
					"\"aSubject\" : \"문의등록 2\"," +
					"\"aContents\" : \"문의등록 합니다.\"" +
					"}]" +
					"}}}";

			} else if(val == "IF-CS-012") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"" +
					"}}}";

			} else if(val == "IF-CS-013") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"csNo\" : \"998949485\"" +
					"}}}";

			} else if(val == "IF-CS-014") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"csNo\" : \"998949485\"," +
					"\"cmd\" : \"002\"," +
					"\"csState\" : \"02\"," +
					"\"aSubject\" : \"답변등록\"," +
					"\"aContents\" : \"등록합니다.\"" +
					"}}}";

			} else if(val == "IF-CS-015") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"zzata\"," +
					"\"csNo\" : \"CS201109070001\"," +
					"\"cmd\" : \"001\"," +
					"\"receiveYn\" : \"Y\"" +
					"}}}";
	
			} else if(val == "IF-ST-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uidList\" : [{\"uid\":\"zzata\"}]," +
					"\"searchGubun\" : \"001\"," +
					"\"gName\" : \"\"," +
					"\"dateFrom\" : \"2011-09-12 00:00:00\"," +
					"\"dateTo\" : \"2011-10-24 00:00:00\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"" +
					"}}}";
				
			} else if(val == "IF-ST-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uidList\" : [{\"uid\":\"zzata\"}]," +
					"\"searchGubun\" : \"001\"," +
					"\"gJcode\" : \"\"," +
					"\"gName\" : \"\"," +
					"\"dateFrom\" : \"2011-09-12 00:00:00\"," +
					"\"dateTo\" : \"2011-10-24 00:00:00\"," +
					"\"orderBy\" : \"001\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"" +
					"}}}";
					
			} else if(val == "IF-PU-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"ALL\"," +
					"\"uidList\" : []," +
					"\"pushId\" : \"pushid11\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"" +
					"}}}";
					
			} else if(val == "IF-PU-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"ALL\"," +
					"\"uidList\" : []," +
					"\"pushId\" : \"pushid11\"," +
					"\"transferGroupIdx\" : \"OR20111024000001\"," +
					"\"pageCnt\" : \"10\"," +
					"\"pageNo\" : \"1\"" +
					"}}}";
					
			} else if(val == "IF-PU-003") {
				reqText.value = "<Request>\n" +
					"<body>\n" +
						"<adminCode>"+adminCode+"</adminCode>\n" +
						"<transferGroupList>\n" +
							"<transferGroups>\n" +
								"<transferGroupIdx>001</transferGroupIdx>\n" +
								"<mainCode>AUC</mainCode>\n" +
								"<uid>zzata</uid>\n" +
								"<pushMsg>TEST PUSH MSG</pushMsg>\n" +
								"<requestDate>2011-10-10 13:29:00</requestDate>\n" +
							"</transferGroups>\n" +
						"</transferGroupList>\n" +
						"<pushIdList>\n" +
							"<pushIds>\n" +
								"<pushId>16516511615611</pushId>\n" +
								"<reqDevCd>IOS</reqDevCd>\n" +
								"<phoneNum>011)432-0123</phoneNum>\n" +
							"</pushIds>\n" +
						"</pushIdList>\n" +
					"</body>\n" +
					"</Request>";
					
			} else if(val == "IF-PU-004") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"mainCode\" : \"AUC\"," +
					"\"uid\" : \"btmok\"," +
					"\"pushId\" : \"pushid11\"," +
					"\"cmd\" : \"01\"," +
					"\"csNew\" : \"Y\"," +
					"\"pushInfoList\" : [" +
					"{\"transferGroupIdx\" : \"OR20111024000001\", \"idx\" : \"1\"}" +
					"]" +
					"}}}";
					
			} else if(val == "IF-CF-001") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"" +
					"}}}";
					
			} else if(val == "IF-CF-002") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"alarmYn\" : \"Y\"," +
					"\"newOrderAlarmYn\" : \"Y\"," +
					"\"cancelOrderAlarmYn\" : \"Y\"," +
					"\"returnOrderAlarmYn\" : \"Y\"," +
					"\"exchangeOrderAlarmYn\" : \"Y\"," +
					"\"goodsProcAlarmYn\" : \"Y\"," +
					"\"csAlarmYn\" : \"Y\"," +
					"\"safetyQtyYn\" : \"Y\"," +
					"\"urgencyYn\" : \"Y\"," +
					"\"alarmStartPeriod\" : \"06:30\"," +
					"\"alarmEndPeriod\" : \"23:00\"," +
					"\"alarmInterval\" : \"00\"" +
					"}}}";
					
			} else if(val == "IF-CF-003") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"" +
					"}}}";
					
			} else if(val == "IF-CF-004") {
				reqText.value = header +
					"\"body\":" +
					"{" +
					"\"adminCode\" : \""+adminCode+"\"," +
					"\"userId\" : \""+userId+"\"," +
					"\"useGlobalWpriceYn\" : \"Y\"" +
					"}}}";
					
			}
			// TO DO
		}
	}
</script>
</head>
<body>

<input type="hidden" id="sendType" value="POST" />

<div id="main">

	<div id="content">

		<div id="header">

			<div id="titleText">
				<h2>Mobile Test Page</h2>
			</div>

			<hr>

			<div id="comboBox">
				<span><b>Sevice : </b></span>
				  <select id="service" onChange="change_url(this.value);">
				  	<option value="">=================== 선택 =======================</option>
				  	<!-- <option value="IF-TE-001">테스트 (IF-TE-001)</option> -->

				  	<option value="IF-IN-001">인트로 (IF-IN-001)</option>
				  	<option value="IF-IN-002">고객상담 신청 (IF-IN-002)</option>
				  	
					<option value="">===============================================</option>

					<option value="IF-CU-001">로그인 (IF-CU-001)</option>
					<option value="IF-CU-002">회원 정보 변경 (IF-CU-002)</option>
					<option value="IF-CU-003">인증 번호 전송 (IF-CU-003)</option>
					<option value="IF-CU-004">마켓 계정 정보 (IF-CU-004)</option>
					<option value="IF-CU-005">초기 페이지 - Summery (IF-CU-005)</option>
					<option value="IF-CU-006">Push ID 변경 (IF-CU-006)</option>
					<option value="IF-CU-007">통합 로그인 정보 (IF-CU-007)</option>
					<option value="IF-CU-008">비밀번호 변경 (IF-CU-008)</option>

					<option value="">===============================================</option>

					<option value="IF-GO-001">상품 목록 조회 (IF-GO-001)</option>
					<option value="IF-GO-002">상품 상세 조회 (IF-GO-002)</option>
					<option value="IF-GO-003">상품 정보 변경 (IF-GO-003)</option>
					<option value="IF-GO-004">상품 이력 정보 (IF-GO-004)</option>
					<option value="IF-GO-005">MyPrice 그룹 C,U,D, 상품 C,D (IF-GO-005)</option>
					<option value="IF-GO-0051">MyPrice 그룹 C,U,D, 상품 C,D (IF-GO-0051)</option>
					<option value="IF-GO-006">MyPrice 그룹 조회 (IF-GO-006)</option>
					<option value="IF-GO-007">MyPrice 그룹에 해당상품목록 조회 (IF-GO-007)</option>
					<option value="IF-GO-008">MyPrice 가격비교 문자열  C,U,D (IF-GO-008)</option>
					<option value="IF-GO-009">MyPrice 가격비교/상품별가격변동 이력조회 (IF-GO-009)</option>
					<option value="IF-GO-010">MyPrice 가격비교 수집상품 삭제 (IF-GO-010)</option>
					<option value="IF-GO-011">MyPrice 가격비교/상품별가격변동 그래프 조회 (IF-GO-011)</option>
					<option value="IF-GO-012">MyPrice 가격비교 목록 (IF-GO-012)</option>
					
					<option value="">===============================================</option>
					
					<option value="IF-OR-001">주문 목록 조회 (IF-OR-001)</option>
					<option value="IF-OR-002">주문 상세목록 조회 (IF-OR-002)</option>
					<option value="IF-OR-003">주문 정보 변경 (IF-OR-003)</option>
					
					<option value="">===============================================</option>

					<option value="IF-SE-001">정산 목록 조회 (IF-SE-001)</option>
					<option value="IF-SE-002">정산 상세목록 조회 (IF-SE-002)</option>
					
					<option value="">===============================================</option>
					
					<option value="IF-CS-001">상품Q&#38;A 목록 조회 (IF-CS-001)</option>
					<option value="IF-CS-002">상품Q&#38;A 상세정보 조회 (IF-CS-002)</option>
					<option value="IF-CS-003">상품Q&#38;A 정보 변경 (IF-CS-003)</option>
					<option value="IF-CS-004">긴급알림 목록 조회 (IF-CS-004)</option>
					<option value="IF-CS-005">긴급알리 상세정보 조회 (IF-CS-005)</option>
					<option value="IF-CS-006">상품 Q&#38;A - 최근답변목록 (총갯수) (IF-CS-006)</option>
					<option value="IF-CS-007">상품 Q&#38;A - 자주하는 답변등록/삭제/수정 (IF-CS-007)</option>
					<option value="IF-CS-008">상품 Q&#38;A - 자주하는 답변목록 (총갯수) (IF-CS-008)</option>
					<option value="IF-CS-009">1:1 문의목록 조회 (IF-CS-009)</option>
					<option value="IF-CS-010">1:1 문의 상세 조회 (IF-CS-010)</option>
					<option value="IF-CS-011">1:1 문의 등록/삭제/수정 (IF-CS-011)</option>
					<option value="IF-CS-012">FAQ 목록 조회 (총갯수 포함) (IF-CS-012)</option>
					<option value="IF-CS-013">상품 Q&#38;A - 최근답변목록 삭제 (IF-CS-013)</option>
					<option value="IF-CS-014">긴급알리미  답변처리 (IF-CS-014)</option>
					<option value="IF-CS-015">긴급알리미 수신상태변경 (IF-CS-015)</option>
					
					<option value="">===============================================</option>
					
					<option value="IF-ST-001">매출 통계 조회 (IF-ST-001)</option>
					<option value="IF-ST-002">로그 통계 조회 (IF-ST-002)</option>
					 
					<option value="">===============================================</option>
					
					<option value="IF-PU-001">Push Message 목록 (IF-PU-001)</option>
					<option value="IF-PU-002">Push Message 목록 상세 (IF-PU-002)</option>
					<option value="IF-PU-003">Push Message 전송 (IF-PU-003)</option>
					<option value="IF-PU-004">Push Message 수신 상태 변경 (IF-PU-004)</option>

					<option value="">===============================================</option>

					<option value="IF-CF-001">설정 정보 조회 (IF-CF-001)</option>
					<option value="IF-CF-002">설정 정보 변경 (IF-CF-002)</option>
					<option value="IF-CF-003">전체 지도가 설정 정보 조회 (IF-CF-003)</option>
					<option value="IF-CF-004">전체 지도가 설정 정보 변경 (IF-CF-004)</option>
					
					<option value="">===============================================</option>
					<!-- TO DO -->

				  </select>
				<input type="button" id="testBtn" name="testBtn" value="TEST" />
			</div>

			<hr>

			<div id="inputBox">
				<span><b>Domain : </b></span>
				<input type="text" id="domain" name="domain" value="http://1.234.6.184:8080/sspGw/mobileGw/mobileInterface/"/>
				<!-- <input type="text" id="domain" name="domain" value="http://localhost:8080/SspGw/mobileGw/mobileInterface/"/> -->
				<span id="pad"></span>
				<span><b>Client Ver : </b></span>
				<input type="text" id="version" name="version" value="1.0"/>
			</div>
			
			<hr>

			<div id="inputBox">
				<span><b>ADMIN CODE : </b></span>
				<input type="text" id="adminCode" name="adminCode" value="designfd" />
				<span><b>USER ID : </b></span>
				<input type="text" id="userId" name="userId" value="designfd" />
				<span><b>USER PW : </b></span>
				<input type="text" id="userPw" name="userPw" value="a" />
				<span><b>Auth Key : </b></span>
				<input type="text" id="authkey" name="authkey" value="" readonly="readonly"/>
			</div>

		</div>

		<hr>

		<div id="body">

			<table id="dataTable">
				<tr>
					<td><b>Request Body : </b></td>
					<td><b>Response Body : </b></td>
				</tr>
				<tr>
					<td class="topContent">
						<textarea id="reqText" style="height:125px;width:550px;"></textarea>
					</td>
					<td class="topContent">
						<textarea id="resText" style="height:125px;width:550px;" readonly="readonly"></textarea>
				  </td>
				</tr>
			</table>

		</div>
		
		<hr>
		
		<div id="header">
			<div id="inputBox">
				<form id="frm" action="appUpload.do" method="post" enctype="multipart/form-data">
					<span><b>APP UPLOAD : </b></span>
					<input type="file" id="appFile" name="appFile" />
					<input type="button" id="Upload" name="Upload" value="Upload" />
				</form>
				<div id="fileUrl"></div>
			</div>
		</div>
		
		<hr>
		
	</div>

</div>
</body>
</html>