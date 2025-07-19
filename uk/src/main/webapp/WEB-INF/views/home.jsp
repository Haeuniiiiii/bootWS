<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자, 이제 시작이양!</h1>

    <form id="soForm" method="post" enctype="multipart/form-data">
        타이틀 <input type="text" name="bdTitle" /><br />
        내용 <br />
        <textarea name="bdCont" cols="30" rows="10"></textarea> <br />
        파일첨부 <br />
        <input type="file" name="bdFile" value="" />
        <button type="submit">쩐송</button>
    </form>

    <div id="disp"></div>
    
    <script>

    const disp = document.getElementById("disp");
    // 억지로 head 사이에 코드를 작성해야한다는 압박감은 필요없음!
    // fetch는 디폴트 get
    const SURL = "http://localhost:8080/api";
    const soForm = document.getElementById("soForm");
    soForm.onsubmit = (e) => {
        e.preventDefault();                     
        // 먼저 form 전송 막기, 왜? ajax처리하려고!
        // 보내는 데이터가 간단한 경우, 
        // formData의 매개변수에 form을 주면 form안의 사용자 입력 태그의 name/Value 쌍이 자동으로 들어감!
        // form에서 제공하는 기능들도 많이 있기 때문에, ajax처리 시 form 태그가 필요없지만 굳이 써주는 이유다!
        
        // formData의 content-type는 multipart/form-data!!
        // 실제로는 세팅할 필요가 없음 오히려 세팅하면 오류가 나니 그냥 무조건 multipart/form-data가 대상이다
        let formData = new FormData(soForm);    // ajax로 파일 보내려면 무조건 필요!

        fetch(`\${SURL}/bd`, {
            method: "POST",
            body: formData
        }).then(resp => {
            resp.json().then(rslt => {
                console.log("체킁", rslt);
                if(rslt.path) {
                    let imgT = document.createElement("img");
                    imgT.src = rslt.path;
                    disp.appendChild(imgT);
                }
            });
        });
        // 담긴 값 출력해라
        // for(let ssang of formData.entries()) {
        //     console.log("체킁", ssang);
        // };
    };

    fetch(`\${SURL}/bd`).then((resp) => { // 위에서 리턴하는게 promise다.. 그래서 다시 then!!!
        resp.json().then((rslt) => {
            console.log(rslt);
        });
    });
        
        
    </script>

</body>

</html>