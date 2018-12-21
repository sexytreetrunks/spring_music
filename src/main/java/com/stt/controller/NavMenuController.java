package com.stt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stt.domain.SongVO;
import com.stt.domain.UploadDTO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class NavMenuController {
	private static final Logger logger = LoggerFactory.getLogger(NavMenuController.class);
	private static final String UPLOADPATH = "d:/upload";
	
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "navmenu/upload";
	}
	
}
