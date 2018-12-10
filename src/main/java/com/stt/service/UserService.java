package com.stt.service;

import com.stt.domain.AuthVO;
import com.stt.domain.LoginDTO;
import com.stt.domain.SignupDTO;

public interface UserService {
	public int regist(SignupDTO dto) throws Exception;
	public AuthVO getUser(LoginDTO dto) throws Exception;
	public boolean isUsingEmail(String email) throws Exception;
}
