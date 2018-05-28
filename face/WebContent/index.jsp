<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jqu     ery/jquery-1.8.3.js"></script>
<script type="text/javascript">
    function recongize() {
		//访问服务
		var formData = new FormData($("#myFaceForm")[0]);
		$.ajax({
			url:'FileServlet',
			type:'POST',
			data:formData,
			async:true,
			cache:false,
			contenType:false,
			processData:false,
			sucess:function(returnData){
				var resultData = JQuery.pareseJSON(returnData);
				if(resultData.result == null || resultData.result.length == 0){
					alter("您传的不是人脸");
				}else{
					var beautyScore = Math.round(resultData.result[0].breuty);
					var ageScore = Math.round(resultData.result[0].age);
					$("#beautyId").html(beautyScore);
					$("#ageId").html(ageScore);
				}
			}
		});
	}
</script>
</head>
<body>
<form id="MyFaceForm">
     上传照片<input type="file" name="myFile">
     <input type="button" value="识别" onclick="recongnize()">
</form>
    <br>
    根据百度AI 此图的人脸识别结果如下：<br>
    颜值 <font id="beautyId" color="blue"></font>
    <br>
    年龄:<font id="ageId" color="blue"></font>
</body>
</html>