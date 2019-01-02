package com.stt.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.stt.domain.SongVO;
import com.stt.persistance.PLSongDAO;

@Service
public class PLSongServiceImpl implements PLSongService{
	@Inject
	private PLSongDAO dao;
	
	@Override
	public int add(int playlistId, String songId) throws Exception {
		// TODO Auto-generated method stub
		return dao.insert(playlistId, songId);
	}

	@Override
	public int remove(int playlistId, String songId) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteOne(playlistId, songId);
	}

	@Override
	public List<SongVO> getPLSongs(int playlistId) throws Exception {
		// TODO Auto-generated method stub
		return dao.getPLSongs(playlistId);
	}

}
