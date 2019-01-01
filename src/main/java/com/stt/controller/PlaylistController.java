package com.stt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/playlist/*")//---url--- /playlist/owner/playlistId
public class PlaylistController {
	private final static Logger logger = LoggerFactory.getLogger(PlaylistController.class);

	
}
