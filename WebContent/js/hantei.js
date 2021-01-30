
console.log("aaaa");
let spacecheck = document.getElementById('submit');
spacecheck.addEventListener('click',() => {
	if(document.getElementById('name').value === null){
		alert("氏名を入寮してください。");
		return false;
	}else if(document.getElementById('pass').value === null){
		alert("パスワードを入力してください。");
		return false;
	}else if(document.getElementById('cnfpass').value === null){
		alert("パスワード(確認)を入力してください。");
		return false;
	}
});