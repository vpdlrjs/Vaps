package com.vaps.dao;

// 주의!!!! insert할때는 insert!!!
// selectlist => 레코드가 여러개일때
// selectone => 레코드가 한개일때~

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.vaps.bean.BoardList;
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

	
	
	
	//---------------아래는 수정해야 할 코드
	@Override
	public List<BoardList> getBoardList(int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardList getContents(int bnum) {
		// TODO Auto-generated method stub
		return null;
	}

	


}