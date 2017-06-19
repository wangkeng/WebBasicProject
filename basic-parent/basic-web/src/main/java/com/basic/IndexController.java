package com.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("index")
public class IndexController {

	@RequestMapping("goPage.view")
	public Object goPage(@RequestParam String pathName){
		return pathName ;
	}
}
