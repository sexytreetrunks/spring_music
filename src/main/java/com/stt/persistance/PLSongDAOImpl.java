package com.stt.persistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.stt.domain.SongVO;

@Repository
public class PLSongDAOImpl implements PLSongDAO{
	@Inject
	private SqlSession session;
	
	private static final String namespace = "mappers.plsongMapper";
	
	@Override
	public int insert(int playlistId, String songId) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("playlistId", playlistId);
		map.put("songId", songId);
		return session.insert(namespace+".insert",map);
	}

	@Override
	public int deleteOne(int playlistId, String songId) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("playlistId", playlistId);
		map.put("songId", songId);
		return session.delete(namespace+".deleteOne", map);
	}

	@Override
	public int deleteAllInPlaylist(int playlistId) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace+".deleteAll", playlistId);
	}

	@Override
	public List<SongVO> getPLSongs(int playlistId) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".get",playlistId);
	}

}
