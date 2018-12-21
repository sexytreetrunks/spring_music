package com.stt.persistance;

import com.stt.domain.SongVO;

public interface SongDAO {
	public int insert(SongVO vo) throws Exception;
}
