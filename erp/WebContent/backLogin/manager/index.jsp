<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%@ include file="header.jsp" %>

<script type="text/javascript">   
    $(function(){
    	var newsTreeData=[
    	   {
    		 "id":1,
    		 "text":"新闻上架",
    		 "attributes":{
    			 "url":"backLogin/manager/news/newsAdd.jsp"
                          } 
    	   },           
      	 {
      		 "id":2,
      		 "text":"新闻浏览",
      		 "attributes":{
      		 "url":"backLogin/manager/news/newsShow.jsp"
                           } 
      	   },             
      	 {
      		 "id":3,
      		 "text":"新闻排行榜",
      		 "attributes":{
      		 "url":"backLogin/manager/news/newsRank.jsp"
                           } 
      	   }, 
    	];
    	showTree("newsTree",newsTreeData);
    });
    
    $(function(){
    	var productTreeData=[
    	   {
    		 "id":1,
    		 "text":"产品上架",
    		 "attributes":{
    			 "url":"backLogin/manager/news/productAdd.jsp"
                          } 
    	   },           
      	 {
      		 "id":2,
      		 "text":"产品浏览",
      		 "attributes":{
      		 "url":"backLogin/manager/news/productShow.jsp"
                           } 
      	   },             
      	 {
      		 "id":3,
      		 "text":"产品排行榜",
      		 "attributes":{
      		 "url":"backLogin/manager/news/productRank.jsp"
                           } 
      	   }, 
    	];
    	showTree("productTree",productTreeData);
    });
    
    $(function(){
    	var productTreeData=[
    	   {
    		 "id":1,
    		 "text":"产品上架",
    		 "attributes":{
    			 "url":"backLogin/manager/news/productAdd.jsp"
                          } 
    	   },           
      	 {
      		 "id":2,
      		 "text":"产品浏览",
      		 "attributes":{
      		 	"url":"<iframe width='100%' height='100%' src='backLogin/manager/product/productList.jsp'/>"
             } 
      	   },             
      	 {
      		 "id":3,
      		 "text":"产品排行榜",
      		 "attributes":{
      		 "url":"backLogin/manager/news/productRank.jsp"
                           } 
      	   }, 
    	];
    	showTree("productTree",productTreeData);
    });
    
    
    $(function(){
    	var AdministerTreeData=[
    	   {
    		 "id":1,
    		 "text":"管理员列表",
    		 "attributes":{
    			 "url":"<iframe width='100%' height='100%' src='backLogin/manager/admin/AdminList.jsp'/>"
              } 
    	   },           
		  {
      		 "id":2,
      		 "text":"管理员注册",
      		 "attributes":{
      		 "url":"<iframe width='100%' height='100%' src='backLogin/manager/admin/AdminReg.jsp'/>"
                           } 
      	   },             
      	 
    	];
    	showTree("AdministerTree",AdministerTreeData);
    });
    
    $(function(){
    	var messagesTreeData=[
    	   {
    		 "id":1,
    		 "text":"信息上架",
    		 "attributes":{
    			 "url":"backLogin/manager/news/messagesAdd.jsp"
                          } 
    	   },           
      	 {
      		 "id":2,
      		 "text":"信息浏览",
      		 "attributes":{
      		 "url":"backLogin/manager/news/messagesShow.jsp"
                           } 
      	   },             
      	 {
      		 "id":3,
      		 "text":"信息排行榜",
      		 "attributes":{
      		 "url":"backLogin/manager/news/messagesRank.jsp"
                           } 
      	   }, 
    	];
    	showTree("messagesTree",messagesTreeData);
    });
    
    
    $(function(){
    	var jobsTreeData=[
    	   {
    		 "id":1,
    		 "text":"职位上架",
    		 "attributes":{
    			 "url":"backLogin/manager/news/jobsAdd.jsp"
                          } 
    	   },           
      	 {
      		 "id":2,
      		 "text":"职位浏览",
      		 "attributes":{
      		 "url":"backLogin/manager/news/jobsShow.jsp"
                           } 
      	   },             
      	 {
      		 "id":3,
      		 "text":"职位排行榜",
      		 "attributes":{
      		 "url":"backLogin/manager/news/jobsRank.jsp"
                           } 
      	   }, 
    	];
    	showTree("jobsTree",jobsTreeData);
    });
    
    
    function showTree(treeId,treeData){
	     $("#"+treeId).tree({
	    	data:treeData,
	    	onClick:function(node){//node上有什么:id text attributes
	    		//alert(node.txt);
	     		if(node&&node.attributes){
	     			openTab(node);
	     		}
	    	}
	     });
    }
	
    function openTab(node){
    	if($("#mainTabs").tabs("exists",node.text)){
    		$("#mainTabs").tabs("select",node.text);
    	}else{
    		$("#mainTabs").tabs("add",{
    			title:node.text,
    			selected:true,
    			closable:true,
    			content:node.attributes.url
    		})
    	}
    }
</script>


</head>
<body class="easyui-layout">
		<div data-options="region:'north'" style="height:50px">north</div>
		<div data-options="region:'south',split:true" style="height:50px;">south</div>
		<div data-options="region:'east',split:true" title="East" style="width:100px;">east</div>
		<div data-options="region:'west',split:true" title="menus" style="width:100px;">
		
		<div class="easyui-accordion" style="width:400px;height:300px;">
		        <div title="新闻" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			   		<ul id="newsTree" class="easyui-tree">
			   		</ul>
				</div>
		
		
				<div title="产品" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
					<ul id="productTree" class="easyui-tree">
			   		</ul>
				</div>
				
				<div title="管理员" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
					<ul id="AdministerTree" class="easyui-tree">
			   		</ul>
				</div>
		
				<div title="信息" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
					<ul id="messagesTree" class="easyui-tree">
			    	</ul>
				</div>
		
		
				<div title="工作" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
					<ul id="jobsTree" class="easyui-tree">
			    	</ul>
				</div>
		
				<div title="configuration" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			
				</div>
				<div title="dataDict" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			
				</div>
		</div>
		
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<div class="easyui-tabs"  id="mainTabs" style="fit:true;width:100%;height:100%;">
				<div title="欢迎面板" style="padding:10px">
					源辰信息欢迎您，今天是:
					<%
						Date d= new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
						
					%>
					<%=sdf.format(d) %>
				</div>
			</div>
		</div>

</body>
</html>