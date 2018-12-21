package com.stt.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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

}
