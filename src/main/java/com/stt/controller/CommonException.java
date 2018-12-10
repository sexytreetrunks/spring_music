package com.stt.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonException {
	@ExceptionHandler(Exception.class)
	public String handler(Exception ex, Model model) {
		//개발 다 한 후에는 여기 에러메세지 안보이게 수정할것!
		model.addAttribute("exception", ex);
		System.out.println(ex.getMessage());
		return "common_error";
	}
}
