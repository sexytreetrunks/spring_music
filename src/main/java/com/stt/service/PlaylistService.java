package com.stt.service;

import java.util.List;

import com.stt.domain.PlaylistVO;

public interface PlaylistService {
	public int create(PlaylistVO vo, String songId) throws Exception;
	public int remove(int id) throws Exception;
	public List<PlaylistVO> getPlaylists(int owner) throws Exception;
}
