<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script type="text/javascript">
	$(function(){
		$('#regbtn').click(function(){
			$.ajax({
				url:'backLogin/admin.action?op=reg',
				type:'POST',
				dataType:'JSON',
				data:$("#myform").serialize(),
				success:function(data){
					//data -> 一个json对象 -> {code:1/0,msg:'',obj:[]}
					if(data.code==1){
						alert('注册成功');
						clearAll();
					}else{
						alert('注册失败,原因:'+data.msg);
					}
				}
			});
		});
		
		function clearAll(){
			$("#username").val('');
			$("#userpassword").val('');
		}
	});
</script>
</head>
<body>
	<FORM id="myform" action="backLogin/admin.action?op=reg" method="post">
	    	用户名 &nbsp;<INPUT type="text"  name="username" id="username"> <br />
			密 码 &nbsp;<INPUT type="password" name="userpassword" id="userpassword"> <br />
		<INPUT id="regbtn" type="button" value="注册">
	</FORM>
</body>
</html>