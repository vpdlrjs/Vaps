package com.vaps.action;

import java.util.List;
import com.vaps.bean.BoardList;
import com.vaps.dao.MembersDAO;
import com.vaps.userclass.Paging;

public class BoardListAction {
	MembersDAO dao;
	
	public BoardListAction(MembersDAO membersDao){
		this.dao = membersDao;
	}
	
	public List<BoardList> getBoardList(int pageNum){
		return dao.getBoardList(pageNum); //sqlMapper.xml 갔다옴
	}
	
	public String getPaging(int pagenum){
		//전체 글의 갯수 파악
		int maxNum=dao.getPageCount(); //전체 글의 숫자
		int pageNum=pagenum; //현재페이지
		int listCount= 10; // 한화면에 게시글 수
		int pageCount= 5; //한 그룹
		String pageName="board"; //게시판의 종류
		
		Paging paging=new Paging(maxNum, pageNum, listCount, pageCount, pageName);
		return paging.makePageGroup();
	}

	public BoardList getContents(int bNum) {
		// 게시판 내용 불러오기
		return dao.getContents(bNum);
	}
	
	public BoardList getContentsModi(int bNum) {
		// 게시판 내용 수정할 내용 (한글깨짐)처리
		return dao.getContentsModi(bNum);
	}
	
	public int setContentsModi(BoardList wr) {
		// 게시판 내용 수정처리
		return dao.setContentsModi(wr);
	}
	
	
	public int writeBoard(BoardList wr) {
		// 게시글 등록
		return dao.wrBoard(wr);
	}
	
	public int delContents(int bNum) {
		// 게시글 번호 지우기
		return dao.delContents(bNum);
	}
}
