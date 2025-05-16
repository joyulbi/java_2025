package com.thejoa.boot3.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PagingDto {
	private int listtotal; //#1)전체글 123
	private int onepagelist; //#2) 한페이지에 보여줄 게시물의 수 10
	private int pagetotal; //#3)총페이지수 123/10=13
	private int bottomlist; //#4) 하단페이지 나누기 이전 11 12 13 ... 몇개
	
	private int pstartno; //#5) 페이지의 스타트 번호 [1]: 최신글 0~10개
	
	private int current; //#6) 현재페이지번호
	private int start; //#7) 시작페이지번호
	private int end; //#8) 끝페이지번호
	
	public PagingDto(int listtotal, int pstartno) { // pstartno 0 1 2 3
		super();
		this.listtotal = listtotal; //전체계산한 값 123
		this.onepagelist = 10;
		
		if(this.listtotal <=0) {this.listtotal=1;}
		//this.pagetotal = listtotal/10+1;
		this.pagetotal = (int) Math.ceil(listtotal/(double)onepagelist);
		
		this.bottomlist=10;
		
		this.pstartno = pstartno*10; // 시작번호 넘겨받은 값 limit 0,10
		
		
		//		1(0) 2(10) 3(20) 4(30) 5(40) 6 7 8 9 10 다음
		// 이전 11 12 13 14 [15] 16 17 18 19 20 다음
		// pstartno=10 이라고하면 현재페이지 번호는 2
		// pstartno=40 이라고하면 현재페이지 번호는 5
		this.current=(this.pstartno/this.onepagelist)+1;
		
		this.start=(this.current-1)/this.bottomlist*this.bottomlist+1;
		
		this.end=start+this.bottomlist-1;
		if(this.pagetotal<this.end) { this.end = this.pagetotal; }
		
	}
	
	
	
}
