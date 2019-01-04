package com.stt.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.stt.domain.PlaylistVO;

@Repository
public class PlaylistDAOImpl implements PlaylistDAO{
	@Inject
	private SqlSession session;
	
	private static final String namespace = "mappers.playlistMapper";
	
	@Override
	public int insert(PlaylistVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.insert(namespace+".insert", vo);
	}

	@Override
	public List<PlaylistVO> getAll(int owner) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getAll",owner);
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace+".delete", id);
	}

	@Override
	public int lastInsertId() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getLastId");
	}

	@Override
	public PlaylistVO getOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getOne",id);
	}

}
