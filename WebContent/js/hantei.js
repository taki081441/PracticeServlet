
console.log("aaaabbb");
const spacecheck = document.getElementById('submit');
spacecheck.addEventListener('click', function(event) {
	if(document.getElementById('name').value === ""){
		alert("氏名を入力してください。");
		event.preventDefault();
	}else if(document.getElementById('pass').value === ""){
		alert("パスワードを入力してください。");
		event.preventDefault();
	}else if(document.getElementById('cnfpass').value === ""){
		alert("パスワード(確認)を入力してください。");
		event.preventDefault();
	}
});