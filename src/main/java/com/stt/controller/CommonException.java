package com.stt.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonException {
	@ExceptionHandler(Exception.class)
	public String handler(Exception ex, Model model) {
		//���� �� �� �Ŀ��� ���� �����޼��� �Ⱥ��̰� �����Ұ�!
		model.addAttribute("exception", ex);
		System.out.println(ex.getMessage());
		return "common_error";
	}
}
