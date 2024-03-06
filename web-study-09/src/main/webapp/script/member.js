function loginCheck() {
	console.log("loginCheck");

	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요.");
		frm.userid.focus();
		return false;
	}

	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck() {
	
	console.log("idCheck");
	if (document.frm.userid.value == "") {
		alert("아이디를 써주세요.");
		document.frm.userid.focus();
		return false;
	}
		    // idCheck.do?userid - user
	let url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "width=450, heigth=200");
}