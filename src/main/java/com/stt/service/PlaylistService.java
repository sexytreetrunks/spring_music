package com.stt.service;

import java.util.List;

import com.stt.domain.PlaylistVO;

public interface PlaylistService {
	public int create(PlaylistVO vo, String songId) throws Exception;
	public int remove(int id) throws Exception;
	public List<PlaylistVO> getAll(int owner) throws Exception;
	public PlaylistVO getOne(int id) throws Exception;
}
