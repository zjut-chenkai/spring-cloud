package org.com.ck.controller;

import javax.validation.Valid;

import org.com.ck.dto.voicebox.BoxInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/index")
	public String index(@RequestBody @Valid BoxInfo boxInfo) {
		return "chenkai";
	}
}
