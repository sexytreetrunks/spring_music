package com.stt.persistance;

import java.util.List;

import com.stt.domain.PlaylistVO;

public interface PlaylistDAO {
	public int insert(PlaylistVO vo) throws Exception;
	public int delete(int id) throws Exception;
	public List<PlaylistVO> getAll(int owner) throws Exception;
	public int lastInsertId() throws Exception;
	public PlaylistVO getOne(int id) throws Exception;
}
