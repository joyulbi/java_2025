package com.company.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;

@Service //component-scan
public class BoardServiceImpl implements BoardService {
	@Autowired BoardDao dao;

	@Override public int insert(BoardDto dto) {

			try {
				dto.setBip(InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				
				e.printStackTrace();
			}
		
		return dao.insert(dto); }//글쓰기 기능
	@Override public int update(BoardDto dto) {  return dao.update(dto); }// 수정기능 (해당 글 번호보기)
	@Override public BoardDto updateForm(int bno) {  return dao.select(bno); }// 해당번호 글 수정 폼
	@Override public int delete(BoardDto dto) {  return dao.delete(dto); }// 글 삭제기능
	
	@Override public BoardDto detail(int bno) { dao.updateHit(bno); return dao.select(bno); }// 상세보기(조회수 올리기 + 해당 글 번호 가져오기)
	@Override public List<BoardDto> selectAll() {  return dao.selectAll(); }// 전체 데이터 가져오기

}
