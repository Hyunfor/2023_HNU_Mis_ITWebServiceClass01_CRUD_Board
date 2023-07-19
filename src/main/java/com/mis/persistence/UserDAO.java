package com.mis.persistence;

import com.mis.DTO.LoginDTO;
import com.mis.domain.UserVO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto) throws Exception;

}
