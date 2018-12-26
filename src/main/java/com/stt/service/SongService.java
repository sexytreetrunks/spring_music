package com.stt.service;

import java.util.List;

import com.stt.domain.SongVO;

public interface SongService {
	public void upload(SongVO vo) throws Exception;
	public List<SongVO> getSongList(String orderby) throws Exception;
}
