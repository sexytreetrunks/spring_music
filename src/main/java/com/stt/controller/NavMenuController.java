package com.stt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stt.domain.AuthVO;
import com.stt.domain.Criteria;
import com.stt.domain.PlaylistVO;
import com.stt.domain.SongVO;
import com.stt.domain.UploadDTO;
import com.stt.service.PLSongService;
import com.stt.service.PlaylistService;
import com.stt.service.SongService;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class NavMenuController {
	private static final Logger logger = LoggerFactory.getLogger(NavMenuController.class);
	private static final String UPLOADPATH = "d:/upload";
	
	@Inject
	private SongService service;
	@Inject
	private PlaylistService plservice;
	@Inject
	private PLSongService plsongservice;
	
	@GetMapping("/upload")
	public String uploadGET() {
		logger.info("upload GET");
		return "navmenu/upload";
	}
	
	@PostMapping("/upload")
	public String uploadPOST(UploadDTO upload, RedirectAttributes attr) {
		logger.info("upload POST: " + upload.toString());
		UUID uuid = UUID.randomUUID();
		SongVO vo = new SongVO();
		vo.setUuid(uuid.toString());
		vo.setTitle(upload.getTitle());
		vo.setArtist(upload.getArtist());
		vo.setLength(upload.getLength());
		vo.setTags(upload.getTags());
		
		String filename = uuid.toString()+"_"+upload.getArtist()+"_"+upload.getTitle();
		try {
			File file = new File(UPLOADPATH+"/song",filename+".mp3");
			upload.getSongfile().transferTo(file);
			if(upload.getCover()!=null) {
				FileOutputStream out = new FileOutputStream(new File(UPLOADPATH+"/cover",filename+".jpg"));
				Thumbnailator.createThumbnail(upload.getCover().getInputStream(),out,200,200);
				out.close();
			}
			service.upload(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attr.addFlashAttribute("result", "success");
		return "redirect:/upload";
	}
	
	@GetMapping("/new")
	public String newGET(Model model,@ModelAttribute("cri")Criteria cri) {
		logger.info("new GET");
		List<SongVO> list;
		try {
			cri.setOrderby(Criteria.ORDERBY.NEW);
			list = service.getSongList(cri);
			for(SongVO s:list) {
				logger.info(s.getTitle()+","+s.getArtist());
			}
			model.addAttribute("list",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "navmenu/new";
	}
	
	@GetMapping("/chart")
	public String chartGET(Model model, @ModelAttribute("cri")Criteria cri) {
		logger.info("chart GET");
		List<SongVO> list;
		try {
			cri.setOrderby(Criteria.ORDERBY.CHART);
			logger.info(cri.toString());
			list = service.getSongList(cri);
			model.addAttribute("list",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "navmenu/chart";
	}
	
	@GetMapping("/collection")
	public String collectionGET(HttpServletRequest req, Model model) {
		logger.info("collection GET");
		List<PlaylistVO> list = null;
		HttpSession session = req.getSession();
		AuthVO user = (AuthVO)session.getAttribute("user");
		try {
			list = plservice.getAll(user.getId());
			model.addAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "navmenu/collection";
	}
	
	@GetMapping("/plsongs/{playlistId}")
	public String plsongsGET(Model model, @PathVariable int playlistId) {
		logger.info("playlist songs GET");
		List<SongVO> list = null;
		PlaylistVO pl = null;
		try {
			list = plsongservice.getPLSongs(playlistId);
			pl = plservice.getOne(playlistId);
			model.addAttribute("pl",pl);
			model.addAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/plsongs";
	}
}
