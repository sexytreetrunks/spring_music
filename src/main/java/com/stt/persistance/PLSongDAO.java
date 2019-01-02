package com.stt.persistance;

import java.util.List;

import com.stt.domain.SongVO;

public interface PLSongDAO {
	public int insert(int playlistId, String songId) throws Exception;
	public int deleteOne(int playlistId, String songId) throws Exception;
	public int deleteAllInPlaylist(int playlistId) throws Exception;
	public List<SongVO> getPLSongs(int playlistId) throws Exception;
}
