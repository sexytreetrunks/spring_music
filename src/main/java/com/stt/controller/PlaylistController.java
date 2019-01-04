package com.stt.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stt.domain.AuthVO;
import com.stt.domain.PlaylistVO;
import com.stt.domain.SongVO;
import com.stt.service.PLSongService;
import com.stt.service.PlaylistService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/playlist/*")
public class PlaylistController {
	private final static Logger logger = LoggerFactory.getLogger(PlaylistController.class);

	@Inject
	private PlaylistService plservice;
	@Inject
	private PLSongService plsongservice;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="/new")
	public int createPlaylist(HttpServletRequest req, @RequestBody Map<String,Object> payload) {//title, songid or playlistid, songid
		logger.info("add to playlist");
		int result = 0;
		HttpSession session = req.getSession();
		AuthVO user = (AuthVO)session.getAttribute("user");
		if(user==null)
			return result;
		
		boolean hasplaylist = (Boolean) payload.get("hasplaylist");
		String songid = (String)payload.get("songid");
		if(!hasplaylist) {
			PlaylistVO vo = new PlaylistVO();
			vo.setOwner(user.getId());
			vo.setTitle((String)payload.get("title"));
			vo.setCover((String)payload.get("cover"));
			try {
				result = plservice.create(vo, songid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			int playlistid = Integer.parseInt((String)payload.get("playlistid"));
			try {
				result = plsongservice.add(playlistid, songid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<PlaylistVO>> getPlaylists(HttpServletRequest req) {
		logger.info("get playlist");
		List<PlaylistVO> list = null;
		HttpSession session = req.getSession();
		AuthVO user = (AuthVO)session.getAttribute("user");
		if(user==null)
			return new ResponseEntity<List<PlaylistVO>>(HttpStatus.UNAUTHORIZED);
		try {
			list = plservice.getAll(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<PlaylistVO>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value="/{playlistid}")
	public ResponseEntity<List<SongVO>> getPlaylistSongs(HttpServletRequest req, @PathVariable int playlistid) {
		logger.info("get songs");
		List<SongVO> list = null;
		HttpSession session = req.getSession();
		AuthVO user = (AuthVO)session.getAttribute("user");
		if(user==null)
			return new ResponseEntity<List<SongVO>>(HttpStatus.UNAUTHORIZED);
		try {
			list = plsongservice.getPLSongs(playlistid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<SongVO>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{playlistid}")
	public int deletePlaylist(@PathVariable int playlistid) {
		logger.info("delete playlist: "+playlistid);
		int result = 0;
		try {
			result = plservice.remove(playlistid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@DeleteMapping(value="/{playlistid}/{songid}")
	public int deletePLSong(@PathVariable int playlistid, @PathVariable String songid) {
		logger.info("delete playlist");
		int result = 0;
		try {
			result = plsongservice.remove(playlistid, songid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
