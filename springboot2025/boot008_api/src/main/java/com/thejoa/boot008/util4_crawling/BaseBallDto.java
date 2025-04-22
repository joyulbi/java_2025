package com.thejoa.boot008.util4_crawling;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
/*
public class BaseBallDto {
	private String rank;  
	private String name;  
	private String war;  
	private String starter;  
	private String relief;  
	private String batting;  
	private String steals;
	private String baseRunning;
	private String defense;
	private String replacement;
	private String position;
}
*/
class BaseBallDto {
    private List<String> tdTexts;

    public List<String> getTdTexts() {
        return tdTexts;
    }

    public void setTdTexts(List<String> tdTexts) {
        this.tdTexts = tdTexts;
    }

    @Override
    public String toString() {
        return "BaseBallDto{" +
                "tdTexts=" + tdTexts +
                '}';
    }
}
