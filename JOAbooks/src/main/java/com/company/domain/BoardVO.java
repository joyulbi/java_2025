package com.company.domain;

public class BoardVO {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bname;
	private int bhit;
	private String bdate;
	private String bip;
	
	public BoardVO() { super();  }
	
	public BoardVO(int bno, String btitle, String bcontent, String bname, int bhit, String bdate, String bip) { super(); this.bno = bno; this.btitle = btitle; this.bcontent = bcontent; this.bname = bname; this.bhit = bhit; this.bdate = bdate; this.bip = bip; }
	
	@Override
	public String toString() { return "BoardVO [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bname=" + bname + ", bhit=" + bhit + ", bdate=" + bdate + ", bip=" + bip + "]"; }
	
	public int getBno() { return bno; } public void setBno(int bno) { this.bno = bno; }
	public String getBtitle() { return btitle; } public void setBtitle(String btitle) { this.btitle = btitle; }
	public String getBcontent() { return bcontent; } public void setBcontent(String bcontent) { this.bcontent = bcontent; }
	public String getBname() { return bname; } public void setBname(String bname) { this.bname = bname; }
	public int getBit() { return bhit; } public void setBit(int bhit) { this.bhit = bhit; }
	public String getBdate() { return bdate; } public void setBdate(String bdate) { this.bdate = bdate; }
	public String getBip() { return bip; } public void setBip(String bip) { this.bip = bip; }

}
