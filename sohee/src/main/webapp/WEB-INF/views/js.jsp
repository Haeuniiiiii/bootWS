<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작 페이지</title>
</head>
<body>
	<h1>Restful SPA</h1>
    <div>
        <form id="idolForm">
            아이디 <input type="text"  name="sid" value=""><br>
            이름  <input type="text"  name="name" value="" required><br>
            나이  <input type="text"  name="age" value="" required><br>
            <button type="submit">등록</button>
        </form>
    </div>
    <div id="list"></div>
<script>
 const idolForm = document.querySelector("#idolForm");
 idolForm.onsubmit = function(){
    event.preventDefault();    
 }


  const list = document.querySelector("#list");
 // 먼저 리스트 가져오기 get , 지금 상황은 same-origin (Not CrossOrigin)이라 제약사항 없음  
 fetch("/api/idols").then(resp =>{
    resp.json().then(idolList=>{
        console.log("결광:",idolList);
        let tblStr = "<table border=1 width=400>";
            tblStr += "<tr><th>ID</th><th>이름</th><th>나이</th></tr>";

        for(let i=0; i< idolList.length; i++){
            let idol = idolList[i];
            tblStr += `
                <tr>
                    <td>\${idol.sid}</td>
                    <td>\${idol.name}</td>
                    <td>\${idol.age}</td>
                </tr>    
            `;
        }

        tblStr += "</table>";
        list.innerHTML = tblStr;
    })


 })
</script>
</body>
</html>