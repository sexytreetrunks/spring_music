package com.stt.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.stt.domain.Criteria;
import com.stt.domain.SongVO;
import com.stt.persistance.SongDAO;

@Service
public class SongServiceImpl implements SongService{
	@Inject
	private SongDAO dao;
	
	@Override
	public void upload(SongVO vo) throws Exception {
		dao.insert(vo);
	}

	@Override
	public List<SongVO> getSongList(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.getList(cri);
	}

}
