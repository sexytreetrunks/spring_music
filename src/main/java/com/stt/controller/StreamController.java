package com.stt.controller;

import java.io.File;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StreamController {
	private static final Logger logger = LoggerFactory.getLogger(NavMenuController.class);
	private static final String UPLOADPATH = "d:/upload";
	
	@GetMapping("/cover")
	@ResponseBody
	public ResponseEntity<byte[]> getCoverImg(String filename) {
		logger.info("cover get: " + filename);
		File file = new File(UPLOADPATH+"/cover/"+filename+".jpg");
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),headers,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
