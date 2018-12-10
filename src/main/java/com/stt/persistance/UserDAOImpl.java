package com.stt.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.stt.domain.AuthVO;
import com.stt.domain.LoginDTO;
import com.stt.domain.SignupDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Inject
	private SqlSession session;
	private final static String namespace= "mapper.userMapper";
	
	@Override
	public int insert(SignupDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.insert(namespace+".insert", dto);
	}

	@Override
	public AuthVO getUser(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getUser",dto);
	}

	@Override
	public int getRegistedEmailNums(String email) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getRegistedEmailNums",email);
	}

}
