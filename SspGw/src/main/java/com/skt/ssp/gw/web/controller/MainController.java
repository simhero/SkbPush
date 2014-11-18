package com.skt.ssp.gw.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MainController (MainController)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MainController.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Controller
public class MainController {

	@RequestMapping("/index.do")
	public void index(Model model) {
	}

}