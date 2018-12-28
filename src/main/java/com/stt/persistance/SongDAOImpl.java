package com.stt.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.stt.domain.Criteria;
import com.stt.domain.SongVO;

@Repository
public class SongDAOImpl implements SongDAO{
	private static final String namespace = "mappers.songMapper";
	@Inject
	private SqlSession session;
		
	@Override
	public int insert(SongVO vo) throws Exception{
		// TODO Auto-generated method stub
		return session.insert(namespace+".insert",vo);
	}

	@Override
	public List<SongVO> getList(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getList", cri);
	}
}
