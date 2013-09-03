package com.vaps.dao;

// 주의!!!! insert할때는 insert!!!
// selectlist => 레코드가 여러개일때
// selectone => 레코드가 한개일때~

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

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
	public BoardList getContents(int B_NUM) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("MembersInterface.getContents", B_NUM);
	}
	//아이디 중복
	public int confirmId(String id){
		return getSqlSession().selectOne("MembersInterface.confirmId", id);
	}
	
	

}