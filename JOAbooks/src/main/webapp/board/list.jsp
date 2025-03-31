<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

<div class="container my-5">
	<h3>NAVER BOOK</h3>
	<div class="result">
	</div>
	
	<script>
	//window.onload=function(){}; 브라우저 로딩되면 동작
	//$$() jquery 
	$(function(){
		alert("test");
		
		$.ajax({
			url:"${pageContext.request.contextPath}/books",
			dataType:"json",
			type:"GET",
			success:function(json){
				//console.log(json);
				let items =json.items;
				console.log(items[0]);
				
				for(let i=0; i<items.length; i++){
					var div12=$('<div class="row my-3">');
					var div4=$('<div class="col-sm-4 naverimg">').html(
								'<img src="'+items[i].image+'"style="width:100%" alt=""/>');
					var div8 = $('<div class="col-sm-8">').html(
								'<a href="'+items[i].link+'"><p>'+items[i].title
										+'</p><p>'+items[i].author
										+'</p><p>'+items[i].pubdate
										+'</p><p>'+items[i].price
										+'</p></a>');
					div12.append(div4).append(div8);
					$(".result").append(div12);
										
					
					
					
					let div = $('<div class="card my-3 bg-warning">'); //<div></div>
					let p1 = $('<div class="card-body>').html('<img src="'+items[i].image+'"/>');
					let p2 = $('<div class="card-body">').html(items[i].title); //html reset해서 넣기
					div.append(p1).append(p2); //div태그안에 p1추가하고 p2추가
					$(".result").append(div)
				}
				
			},error:function(xhr,textStatus,errorThrown){
				$(".result").html(textStatus + "(HTTP-"+xhr.status+"/"+errorThrown);
			} // $(".result") document.querySelector(".result")
		});
	});
	</script>
</div>


	<h3>NAVER NEWS</h3>
	<div class="news-result"></div>

	<script>
	// 뉴스 데이터 불러오기
	$.ajax({
		url: "${pageContext.request.contextPath}/news",
		dataType: "json",
		type: "GET",
		success: function(json) {
			let items = json.items;

			for(let i = 0; i < items.length; i++) {
				let div = $('<div class="card my-3">');
				let cardBody = $('<div class="card-body">');

				let title = $('<h5>').html('<a href="' + items[i].link + '" target="_blank">' + items[i].title.replace(/<[^>]*>/g, '') + '</a>');
				let desc = $('<p>').html(items[i].description.replace(/<[^>]*>/g, ''));
				let origin = $('<p class="text-muted small">').text("출처: " + items[i].originallink);

				cardBody.append(title).append(desc).append(origin);
				div.append(cardBody);
				$(".news-result").append(div);
			}
		},
		error: function(xhr, textStatus, errorThrown) {
			$(".news-result").html(textStatus + " (HTTP-" + xhr.status + "/" + errorThrown + ")");
		}
	});
	</script>

<div class="container my-5">
	<h3>MULTIBOARD</h3>
	<%-- <%=request.getAttribute("list") %> --%>
	<table  class="table table-striped  table-bordered table-hover text-center">
		<caption>MULTIBOARD-LIST</caption>
		<thead>
			<tr><th scope="col">NO</th><th scope="col">TITLE</th>
			      <th scope="col">WRITER</th><th scope="col">DATE</th><th scope="col">HIT</th></tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${list}"  varStatus="status">
			<tr>
				<td>${list.size()-status.index}</td>
				<td><a href="detail.do?bno=${dto.bno}">${dto.btitle}</a></td>
				<td>${dto.bname}</td>
				<td>${dto.bdate}</td>
				<td>${dto.bhit}</td>
			</tr>
		</c:forEach>
		</tbody>

		<tbody>
 			<tr><td>1</td><td><a href="detail.do?bno=">첫번재 글쓰기입니다.</a></td>
				  <td>ADMIN</td><td>2020-01-02 13:14:30</td><td>1</td></tr>  
	
		</tbody>
	</table>
	<p  class="text-end"><a href="write_view.do" class="btn btn-primary">글쓰기</a></p>
</div>

<%@ include file="../inc/footer.jsp" %>