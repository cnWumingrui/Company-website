	var xmlHttp;
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) { // 如果可以取得XMLHttpRequest
			xmlHttp = new XMLHttpRequest(); // Mozilla、Firefox、Safari 
		} else if (window.ActiveXObject) { // 如果可以取得ActiveXObject
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer
		}
	}

	function ajaxSend(url, params,func) {
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = func; //回调函数
		xmlHttp.open("POST", url);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttp.send(params);
	}