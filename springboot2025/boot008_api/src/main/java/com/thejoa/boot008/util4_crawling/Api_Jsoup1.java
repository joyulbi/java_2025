package com.thejoa.boot008.util4_crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component 
public class Api_Jsoup1 {
	
	// https://statiz.sporki.com/player/?m=playerinfo&p_no=
	//int [] player = {16044 , , , , , , , ,};
	
    public List<String> jsoup1() {
    	 String url = "https://statiz.sporki.com/player/?m=playerinfo&p_no=16044";
    	 List<String> list = new ArrayList<>();
         try {
             // #1 Document 객체 생성
             Document doc = Jsoup.connect(url).get();

             // #2 특정 CSS 선택자를 통해 <tr> 태그 선택
             Elements lis = doc.select(".man_info  li");

             for (Element li : lis) {
               list.add(li.text());
             }

         } catch (IOException e) {
             e.printStackTrace(); // 예외 처리
         }
         return list;
    }
	
	
	public String jsoup2() {
		String result="";
		String url = "https://www.kofic.or.kr/kofic/business/main/main.do";

		try {
			Document doc = Jsoup.connect(url).get();         //#1 
			Elements imgs = doc.select(".btn_top_etc  img");  //#2 
			
			for(Element i	 : imgs ) {
				result += "<tr><td>"+i.tagName()+"</td>"
						+ "<td>"+i.attr("abs:src")+"</td>"   //"abs:src"
						+ "<td><img src='"+i.attr("abs:src")+"'/></td></tr>";
			}
			
		} catch (IOException e) { e.printStackTrace(); }
		//1. jsoup - docment 객체 생성
		//2. css이용해서 태그선택 #
		//3. 값저장
		return result;
	}
	
    public List<BaseBallDto> jsoup3() {
        String url = "https://statiz.sporki.com"; // URL 지정
        List<BaseBallDto> list = new ArrayList<>(); // 결과 저장 리스트 생성

        try {
            // #1 Document 객체 생성
            Document doc = Jsoup.connect(url).get();

            // #2 특정 CSS 선택자를 통해 <tr> 태그 선택
            Elements trs = doc.select(".item_box table tbody tr");

            for (Element tr : trs) {
                // #3 각 <tr> 내 모든 <td> 태그 선택
                Elements tds = tr.getElementsByTag("td");

                // <td> 텍스트 추출
                List<String> tdTexts = new ArrayList<>();
                for (Element td : tds) {
                    tdTexts.add(td.text()); // <td>의 텍스트를 리스트에 추가
                }

                // 필요한 경우 BaseBallDto에 데이터 매핑
                BaseBallDto dto = new BaseBallDto();
                dto.setTdTexts(tdTexts); // BaseBallDto에 저장된 텍스트 리스트 설정
                list.add(dto);
            }

        } catch (IOException e) {
            e.printStackTrace(); // 예외 처리
        }

        return list; // 최종 리스트 반환
    }

}
