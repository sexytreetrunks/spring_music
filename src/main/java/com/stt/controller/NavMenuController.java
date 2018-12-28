package com.stt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stt.domain.Criteria;
import com.stt.domain.SongVO;
import com.stt.domain.UploadDTO;
import com.stt.service.SongService;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class NavMenuController {
	private static final Logger logger = LoggerFactory.getLogger(NavMenuController.class);
	private static final String UPLOADPATH = "d:/upload";
	
	@Inject
	private SongService service;
	
	@GetMapping("/upload")
	public String uploadGET() {
		logger.info("upload GET");
		return "navmenu/upload";
	}
	
	@PostMapping("/upload")
	public String uploadPOST(UploadDTO upload) {
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
		
		return "navmenu/upload";
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
}
