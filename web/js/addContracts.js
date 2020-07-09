function lTrim(str) {
	if (str.charAt(0) == " " || str.charAt(0) == "　") {
		str = str.slice(1);
		str = lTrim(str);
	}
	return str;
}

//去掉字串右边的空格
function rTrim(str) {
	var iLength;
	iLength = str.length;
	if (str.charAt(iLength - 1) == " " || str.charAt(iLength - 1) == "　") {
		str = str.slice(0, iLength - 1);
		str = rTrim(str);
	}
	return str;
}

//去掉字串两边的空格
function trim(str) {
	return lTrim(rTrim(str));
}


function MyCheck() {
	var name = document.getElementById("name").value;
	name = trim(name);
	if (name == "") {
		alert("请输入姓名!");
	   return false;
	}
	var phone=document.getElementById("phone").value;
	phone = trim(phone);
	if (phone == "") {
		alert("请输入电话号码!");
		return false;
	}
	return true;
}