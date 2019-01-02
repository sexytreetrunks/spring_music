package com.stt.service;

import java.util.List;

import com.stt.domain.SongVO;

public interface PLSongService {
	public int add(int playlistId, String songId) throws Exception;
	public int remove(int playlistId, String songId) throws Exception;
	public List<SongVO> getPLSongs(int playlistId) throws Exception;
}
