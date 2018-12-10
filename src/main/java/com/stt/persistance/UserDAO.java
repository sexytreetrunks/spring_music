package com.stt.persistance;

import com.stt.domain.AuthVO;
import com.stt.domain.LoginDTO;
import com.stt.domain.SignupDTO;

public interface UserDAO {
	public int insert(SignupDTO dto) throws Exception;
	public AuthVO getUser(LoginDTO dto) throws Exception;
	public int getRegistedEmailNums(String email) throws Exception;
	
}
