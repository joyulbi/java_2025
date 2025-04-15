package com.thejoa.boot005.board;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PagingDto {
	private int listtotal; 	 // #1)전체글 123
	private int onepagelist; // #2)한페이지에 보여줄 게시물의 수 10
	private int pagetotal;   // #3)총페이지수 243/10=25 24페이지 + 3글
	private int bottomlist;  // #4)하단의 페이지 나누기 이전 11 12 13 ...몇개??
	
	private int pstartno;    // #5)페이지의 스타트번호 [1]: 최신글 0~10개
	
	private int current;     // #6)현재 페이지 번호
	private int start;     	 // #7)시작 페이지 번호
	private int end;     	 // #8)끝 페이지 번호
	
	public PagingDto(int listtotal, int pstartno) { // pstartno 0 1 2 3
		super();
		this.listtotal = listtotal; //전체 계산한 값
		this.pstartno = pstartno*10; // 시작번호 넘겨받은 값 limit 0, 10/ 10,10,/20,10
		
	    this.onepagelist = 10;     
	    this.bottomlist = 10;      

	    if(this.listtotal<=0) {this.listtotal=1;}
	    
	    //총페이지
	    this.pagetotal = (int)Math.ceil((double)listtotal / onepagelist);
	    //현재페이지
	    this.current = (this.pstartno / this.onepagelist) + 1;
	    //시작페이지
	    this.start = ((this.current - 1) / this.bottomlist) * this.bottomlist + 1;
	    //끝페이지
	    this.end = this.start + this.bottomlist - 1;
	    if(pagetotal<end) {this.end=pagetotal;}
	}
	
	
	
}
