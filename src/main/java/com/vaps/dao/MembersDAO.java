package com.vaps.dao;

// 주의!!!! insert할때는 insert!!!
// selectlist => 레코드가 여러개일때
// selectone => 레코드가 한개일때~

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.vaps.bean.BoardList;
import com.vaps.bean.BoardWrite;
import com.vaps.bean.Members;

public class MembersDAO extends SqlSessionDaoSupport implements MemberInterface {
	
	// 회원가입 sql
	@Override
	public int memInsert(Members mb) {
		return getSqlSession().insert("MembersInterface.memInsert", mb);
	}
		
	//login
	public boolean accessMember(Members members){
		boolean result=false;
		int count=getSqlSession().selectOne("MembersInterface.getLoginResult", members);
		if(count != 0){
			result=true;
		}
		System.out.println(result);
		return result;
	}
	
	@Override
	public int getLoginResult(Map<String, String> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("MembersInterface.getLoginResult", map);
	}

	@Override
	public Members getMemberInfo(String id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("MembersInterface.getMemberInfo", id);
	}
	//login - end

	
	
	
	//-----------------------------
	// 게시판 관련 로직 sql 문장을 요청한다 sqlMapper.xml 으로...
	@Override
	public List<BoardList> getBoardList(int pageNum) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("MembersInterface.getBoardList", pageNum);
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("MembersInterface.getPageCount");
	}

	@Override
	public BoardList getContents(int b_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("MembersInterface.getContents", b_num);
	}

	@Override
	public int wrBoard(BoardWrite wr) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("MembersInterface.setContents", wr);
	}

	


}