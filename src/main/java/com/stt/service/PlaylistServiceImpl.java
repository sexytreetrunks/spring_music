package com.stt.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stt.domain.PlaylistVO;
import com.stt.persistance.PLSongDAO;
import com.stt.persistance.PlaylistDAO;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Inject
	private PlaylistDAO dao;
	@Inject
	private PLSongDAO plsdao;
	
	@Override
	@Transactional
	public int create(PlaylistVO vo, String songId) throws Exception {
		int result = 0;
		result = dao.insert(vo);
		int id = dao.lastInsertId();
		result = result & plsdao.insert(id, songId);
		return result;
	}

	@Override
	@Transactional
	public int remove(int id) throws Exception {
		plsdao.deleteAllInPlaylist(id);
		return dao.delete(id);
	}

	@Override
	public List<PlaylistVO> getAll(int owner) throws Exception {
		return dao.getAll(owner);
	}

	@Override
	public PlaylistVO getOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

}
