package com.stt.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.stt.domain.AuthVO;
import com.stt.domain.LoginDTO;
import com.stt.domain.SignupDTO;
import com.stt.persistance.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	@Inject
	private UserDAO dao;
	
	@Override
	public int regist(SignupDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public AuthVO getUser(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.getUser(dto);
	}

	@Override
	public boolean isUsingEmail(String email) throws Exception {
		return dao.getRegistedEmailNums(email)>0? true:false;
	}

}
