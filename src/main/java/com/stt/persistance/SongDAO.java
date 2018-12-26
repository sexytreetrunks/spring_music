package com.stt.persistance;

import java.util.List;

import com.stt.domain.SongVO;

public interface SongDAO {
	public int insert(SongVO vo) throws Exception;
	public List<SongVO> getList(String orderby) throws Exception;
}
