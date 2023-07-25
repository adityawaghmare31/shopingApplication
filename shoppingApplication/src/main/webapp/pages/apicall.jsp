<html>
<head>
<style>
	span
	{
	font-size: 30px;
	color:red;
	margin: 400px;
	}
</style>

<script>

	var xmlhttp;
	var buttonClicked;
	var message;

	function sendData(button){
		var cid=document.categoryform.cid.value;
		var name=document.categoryform.name.value;
		
		var javascriptobject={"cid":cid,"name":name}
		
		xmlhttp=new XMLHttpRequest(); //XMLHttpRequest is predefined class
		
		buttonClicked=button.value;
		if(buttonClicked=="post")
			{
			
			message="data is posted successfully";
			xmlhttp.open("post","categoryapi/savaCategory");
			}
		
		else
			{
			
			message="data is updated successfully";
			xmlhttp.open("put","categoryapi/updateCategory")
			}
			
		xmlhttp.onload=displayResponse; // when respone is loaded from API,the call displayResponse
		var jsonstring=JSON.stringify(javascriptobject);
		
		xmlhttp.setRequestHeader('Content-type','application/json');
		
		xmlhttp.send(jsonstring);
		alert("Data is send to API");
	}
	
	function displayResponse(){
		document.getElementById("message").innerHTML=message;

		alert(xmlhttp.responseText);
	}
	
	function getData(button)
	{
		var cid=document.categoryform.cid.value;
		
		xmlhttp=new XMLHttpRequest();
		
		buttonClicked=button.value;
		if(buttonClicked=="get")
			{
				message="data is retrive successfully";
				xmlhttp.open("get","categoryapi/getCategory/"+cid);  //send cid to API method
			}
		else
			{
			
				message="data is delete successfully";
				xmlhttp.open("delete","categoryapi/deleteCategory/"+cid)  //send cid to API method
			}
		
		xmlhttp.onload=displayResponse2; // when respone is loaded from API,the call displayResponse
		
		xmlhttp.send();		
	}
	
	function displayResponse2()
	{
		
		var jsonstring=xmlhttp.responseText;
		
		var obj=JSON.parse(jsonstring);
		
		//obj==>{cid:2,name:"stationary"} if record is found
		//obj==>{message:recodn not found} if record is NOT found
		
		var name=obj.name;
		//name=document.categoryform.name.value;
		//If exception has occured at Server, the server send JSON string where message key is present and it has some value.
		//means message key is defined
		
		//when exception occrs, message variable value will be record not found and below
		//condition will be satisfied
		//javascript's undefined keyword is equivalant to null keyword of java
		
		if(obj.message!=undefined)
			{
			document.categoryform.name.value="";
			
			document.getElementById("message").innerHTML=obj.message;;
			}
		else
			{
			document.categoryform.name.value=name;
				
			document.getElementById("message").innerHTML=obj.message;;
			}
		
		
		
	}
	
	function getAllData(){
		
		xmlhttp=new XMLHttpRequest(); //XMLHttpRequest is predefined class

		xmlhttp.onload=displayResponse3; // when respone is loaded from API,the call displayResponse

		xmlhttp.open("get","categoryapi/getAllCategory/");

		xmlhttp.send();		

	}
	
	function displayResponse3()
	{
		alert(xmlhttp.responseText);
		
		//int[] a={}; java
		
		var allJSONString=xmlhttp.responseText; // allJSONString is a array
		var p1=document.getElementById("p1");
		
		var data=" ";
		/*
		for(var i=0;i<allJSONString.length;i++)
		{
			alert(allJSONString[i]);
			var obj=JSON.parse(allJSONString[i]); // parse() converts JSON String to javascript
			data=data+obj+"<br";
		}
		*/
		
		p1.innerHTML=allJSONString; 
	}
	
	
	
	
</script>


</head>
<body>
<span id="message">waiting</span>

<form name=categoryform>
<input name=cid><br>
<input name=name><br>
<input type=button value=post onclick="sendData(this)">
<input type=button value=get onclick="getData(this)">
<input type=button value=put onclick="sendData(this)">
<input type=button value=delete onclick="getData(this)">
<input type=button value=getall onclick="getAllData(this)">


</form>
<p id="p1"> All Data </p>
</body>
</html>