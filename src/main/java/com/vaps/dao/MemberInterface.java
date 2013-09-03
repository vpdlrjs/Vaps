package com.vaps.dao;

import java.util.List;
import java.util.Map;
import com.vaps.bean.BoardList;
import com.vaps.bean.Members;


public interface MemberInterface {
	public int getLoginResult(Map<String, String> map);
	public Members getMemberInfo(String id);
	public List<BoardList> getBoardList(int pageNum);
	public int getPageCount();
	public BoardList getContents(int b_num);
	public int memInsert(Members mb);
	public int wrBoard(BoardList wr);
	public int delContents(int b_num);
	public BoardList getContentsModi(int b_num);
	public int setContentsModi(BoardList wr);
}
