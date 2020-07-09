
  //去掉字串左边的空格
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

  //验证表单域
  function MyCheck() {
    var userName = document.getElementById("login_username").value;
    userName = trim(userName);
    if (userName == "") {
      alert("请输入用户名!");
      return false;
    }

    var password = document.getElementById("login_password").value;
    password = trim(password);
    if (password == "") {
      alert("请输入密码!");
      return false;
    }


  /* var xmlHttp=new XMLHttpRequest();
    var url = "login.do?"+"username="+userName+"&password="+password;
    xmlHttp.onreadystatechange=function() {
      if (xmlHttp.readyState==4) {
        var result=xmlHttp.responseText;
        if(result!=null) {
          alert(result);
          return false;
        }else {
          return true;
        }
      }
    }

    xmlHttp.open("post", url, false);
    xmlHttp.send(null);*/
    return true;
  }