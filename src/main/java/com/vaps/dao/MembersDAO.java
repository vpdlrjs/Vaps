package com.vaps.dao;

// selectlist => 레코드가 여러개일때
// selectone => 레코드가 한개일때~

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
=======

import javax.sql.DataSource;

>>>>>>> a4fd403521f99e9862e5570a2987384377c938cb
import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.vaps.bean.BoardList;
import com.vaps.bean.Members;

public class MembersDAO extends SqlSessionDaoSupport implements MemberInterface {
	private static final Statement ConnUtil = null;
	DataSource ds;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
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
		return getSqlSession().selectOne("MembersInterface.getLoginResult", map);
	}

	@Override
	public Members getMemberInfo(String id) {
		return getSqlSession().selectOne("MembersInterface.getMemberInfo", id);
	}
	//login - end

	
	
	
	//-----------------------------
	// 게시판 관련 로직 sql 문장을 요청한다 sqlMapper.xml 으로...
	@Override
	public List<BoardList> getBoardList(int pageNum) {
		return getSqlSession().selectList("MembersInterface.getBoardList", pageNum);
	}

	@Override
	public int getPageCount() {
		return getSqlSession().selectOne("MembersInterface.getPageCount");
	}

	@Override
	public BoardList getContents(int b_num) {
		return getSqlSession().selectOne("MembersInterface.getContents", b_num);
	}
<<<<<<< HEAD
	
	public BoardList getContentsModi(int b_num) {
		// 게시글 내용 한글 수정폼으로 전달
		return getSqlSession().selectOne("MembersInterface.getContents", b_num);
	}
	
	@Override
	public int setContentsModi(BoardList wr) {
		// 게시글 내용 수정 과정 처리
		return getSqlSession().update("MembersInterface.setContentsModi", wr);
	}

	@Override
	public int wrBoard(BoardList wr) {
		return getSqlSession().insert("MembersInterface.setContents", wr);
	}
=======
	//아이디 중복
	public int confirmId(String id){
		return getSqlSession().selectOne("MembersInterface.confirmId", id);
	}
	
	
>>>>>>> a4fd403521f99e9862e5570a2987384377c938cb

	@Override
	public int delContents(int b_num) {
		// 게시글 삭제
		return getSqlSession().delete("MembersInterface.delContents", b_num);
	}
}